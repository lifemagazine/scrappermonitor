package com.lifemagazine.scrappermonitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.lifemagazine.scrappermonitor.domain.CheckSchedLog;
import com.lifemagazine.scrappermonitor.repository.CheckSchedLogRepository;
import com.lifemagazine.scrappermonitor.util.Utility;

@Component
public class CheckSchedLogService {
	
	@Autowired(required=true)
	CheckSchedLogRepository service;
	
	public List<CheckSchedLog> findAll() {
		// TODO Auto-generated method stub
		return (List<CheckSchedLog>) service.findAll();
	}
	
	public Page<CheckSchedLog> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return service.findAll(pageable);
	}
	
	public CheckSchedLog findOne(Integer id) {
        return service.findOne(id);
    }
	
	public CheckSchedLog save(CheckSchedLog checkSchedLog) {
		return service.save(checkSchedLog);
	}
	
	public void delete(Integer checkSchedSeq) {
		service.delete(checkSchedSeq);
	}
	
	public CheckSchedLog update(Integer checkSchedSeq, CheckSchedLog checkSchedLog) {
		CheckSchedLog update = service.findOne(checkSchedSeq);
		update.setScrapperId(checkSchedLog.getScrapperId());
		update.setErrorMsg(checkSchedLog.getErrorMsg());
		update.setResultYn(checkSchedLog.getResultYn());
		update.setModifyUser(checkSchedLog.getModifyUser());
		update.setModifyDate(Utility.getCurrentTime(null));
		return service.save(update);
	}
}
