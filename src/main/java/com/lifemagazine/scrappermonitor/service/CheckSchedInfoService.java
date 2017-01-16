package com.lifemagazine.scrappermonitor.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.lifemagazine.scrappermonitor.amqp.MessageReceiver;
import com.lifemagazine.scrappermonitor.domain.CheckSchedInfo;
import com.lifemagazine.scrappermonitor.repository.CheckSchedInfoRepository;
import com.lifemagazine.scrappermonitor.util.Utility;

@Component
public class CheckSchedInfoService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CheckSchedInfoService.class);
	
	@Autowired(required=true)
	CheckSchedInfoRepository service;
	
	public List<CheckSchedInfo> findAll() {
		// TODO Auto-generated method stub
		return (List<CheckSchedInfo>) service.findAll();
	}
	
	public Page<CheckSchedInfo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return service.findAll(pageable);
	}
	
	public CheckSchedInfo findOne(Integer id) {
        return service.findOne(id);
    }
	
	public CheckSchedInfo save(CheckSchedInfo checkSchedInfo) {
		return service.save(checkSchedInfo);
	}
	
	public void delete(Integer checkSchedSeq) {
		service.delete(checkSchedSeq);
	}
	
	public CheckSchedInfo update(Integer checkSchedSeq, CheckSchedInfo checkSchedInfo) {
		CheckSchedInfo update = service.findOne(checkSchedSeq);
		LOG.debug(update.toString());
		update.setCheckSchedName(checkSchedInfo.getCheckSchedName());
		update.setCheckSchedDesc(checkSchedInfo.getCheckSchedDesc());
		update.setScrapperId(checkSchedInfo.getScrapperId());
		update.setCheckCycle(checkSchedInfo.getCheckCycle());
		update.setValidYn(checkSchedInfo.getValidYn());
		update.setBeforeLastCheckDate(checkSchedInfo.getBeforeLastCheckDate());
		update.setLastCheckDate(checkSchedInfo.getLastCheckDate());
		update.setModifyUser(checkSchedInfo.getModifyUser());
		update.setModifyDate(Utility.getCurrentTime(null));
		CheckSchedInfo result = service.save(update);
		LOG.debug(result.toString());
		return result;
	}
}
