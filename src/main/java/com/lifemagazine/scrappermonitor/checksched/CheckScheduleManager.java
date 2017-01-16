package com.lifemagazine.scrappermonitor.checksched;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lifemagazine.scrappermonitor.domain.AlarmGroup;
import com.lifemagazine.scrappermonitor.domain.CheckSchedInfo;
import com.lifemagazine.scrappermonitor.domain.ScrapperInfo;
import com.lifemagazine.scrappermonitor.service.AlarmGroupService;
import com.lifemagazine.scrappermonitor.service.CheckSchedInfoService;
import com.lifemagazine.scrappermonitor.service.ScrapperInfoService;
import com.lifemagazine.scrappermonitor.util.Utility;


@Component
public class CheckScheduleManager {

	private static final Logger LOG = LoggerFactory.getLogger(CheckScheduleManager.class);
	
	@Autowired
	private ScrapperInfoService scrapperInfoService;
	
	@Autowired
	private CheckSchedInfoService checkSchedInfoService;
	
	@Autowired
	private AlarmGroupService alarmGroupService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private static Integer alarmGroupId;
	private static String mailSubject;
	private static String mailContent;
	
	@Value("${spring.mail.alarmgroupid}")
	public void setAlarmGroupName(Integer id) {
		alarmGroupId = id;
	}
	
	@Value("${spring.mail.subject}")
	public void setMailSubject(String subject) {
		mailSubject = subject;
	}
	
	@Value("${spring.mail.content}")
	public void setMailContent(String content) {
		mailContent = content;
	}
	
	
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    @Scheduled(cron = "${check.schedule.cycle1}")
    public void aJob() {
    	LOG.info(">>>>>>>>>>>>> check Ttx_check_sched_info");
    	
    	Map<Integer, ScrapperInfo> scrapperMap = new HashMap<Integer, ScrapperInfo>();
    	List<ScrapperInfo> scrapperList = scrapperInfoService.findAll();
    	for (ScrapperInfo scrapper: scrapperList) {
    		scrapperMap.put(scrapper.getScrapperId(), scrapper);
    	}
    	
    	List<CheckSchedInfo> checkList = checkSchedInfoService.findAll();
    	for (CheckSchedInfo check: checkList) {
    		if (!check.getValidYn().toUpperCase().equals("Y") || !Utility.isNumeric(check.getCheckCycle())) {
    			LOG.info("skip check - " + check.toString());
    			continue;
    		}
    		
    		ScrapperInfo scrapper = scrapperMap.get(check.getScrapperId());
    		if (scrapper == null) {
    			LOG.error("Invalid CheckSchedInfo. There is no matched ScrapperInfo for " + check.toString());
    			continue;
    		}
    		
    		// unit second
    		int validInterval = -1;
    		Date lastCheckDate = null;
    		try {
    			validInterval = Integer.parseInt(check.getCheckCycle());
    			lastCheckDate = formatter.parse(check.getLastCheckDate());
    			Date currentDate = new Date();
    			long interval = Math.round((currentDate.getTime() - lastCheckDate.getTime()) / (1000 * 60));
    			if (interval > validInterval) {
    				AlarmGroup alarmGroup = alarmGroupService.findOne(alarmGroupId);
    	    		String[] userArray = alarmGroup.getUserId().split(",");
    	    		String tmp = "[" + check.getCheckSchedName() + " / " + scrapper.getScrapperType() + "]";
    	    		String subject = tmp + mailSubject;
    	    		StringBuilder sb = new StringBuilder();
    	    		sb.append("There are some troubles in ").append(tmp).append(".\n");
    	    		sb.append("The valid check interval is ").append(validInterval).append(" munites.\n");
    	    		sb.append("The interval between current time and the last updated time is ").append(interval).append(" munites.\n");
    	    		String content = sb.toString() + "\n" + mailContent;
    				sendMailMessage(userArray, subject, content);
    			}
    		} catch (Exception e) {
    			LOG.error("", e);
    		}
    		
    	}
    }
    
    @Async
    private void sendMailMessage(String[] userArray, String subject, String messageBody) {
    	SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(userArray);
		mail.setFrom("info@tradlinx.com");
		mail.setSubject(subject);
		mail.setText(messageBody);
		javaMailSender.send(mail);
    }
}
