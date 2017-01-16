package com.lifemagazine.scrappermonitor.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lifemagazine.scrappermonitor.domain.CheckSchedInfo;
import com.lifemagazine.scrappermonitor.domain.CheckSchedLog;
import com.lifemagazine.scrappermonitor.service.CheckSchedInfoService;
import com.lifemagazine.scrappermonitor.util.Utility;

@Component
public class MessageReceiver implements MessageListener {

	private static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);
	
	private CheckSchedInfoService checkSchedInfoService;
	
	public MessageReceiver(CheckSchedInfoService checkSchedInfoService) {
		this.checkSchedInfoService = checkSchedInfoService;
	}
	
	@Override
    public void onMessage(Message message) {
		String str = new String(message.getBody());
		LOG.debug("Received <" + str + ">");
		int scrapperId = 0;
		String modifyDate = null;
		String[] temp = str.replaceAll("\"", "").split(",");
		for (int i=0; i<temp.length; i++) {
			if (temp[i].startsWith("scrapperId")) {
				String[] tmp = temp[i].split(":");
				scrapperId = Integer.parseInt(tmp[1]);
			} else if (temp[i].startsWith("modifyDate")) {
				int pos = temp[i].indexOf(":");
				modifyDate = temp[i].substring(pos + 1, 30);
			}
		}
		
		if (scrapperId <= 0) {
			LOG.debug("extracted scrapperId is invalid: " + scrapperId);
			return;
		}
		
		List<CheckSchedInfo> list = checkSchedInfoService.findAll();
		for (CheckSchedInfo checkSchedInfo: list) {
			if (checkSchedInfo.getScrapperId() == scrapperId) {
				LOG.debug(checkSchedInfo.toString());
				checkSchedInfo.setBeforeLastCheckDate(checkSchedInfo.getLastCheckDate());
				checkSchedInfo.setLastCheckDate(modifyDate);
				checkSchedInfo.setModifyDate(Utility.getCurrentTime(null));
				checkSchedInfoService.update(checkSchedInfo.getCheckSchedSeq(), checkSchedInfo);
			}
		}
    }

}
