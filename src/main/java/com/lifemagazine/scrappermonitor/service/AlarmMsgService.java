package com.lifemagazine.scrappermonitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.lifemagazine.scrappermonitor.domain.AlarmMsg;
import com.lifemagazine.scrappermonitor.repository.AlarmMsgRepository;
import com.lifemagazine.scrappermonitor.util.Utility;

@Component
public class AlarmMsgService {
	
	@Autowired(required=true)
	AlarmMsgRepository service;
	
	public List<AlarmMsg> findAll() {
		// TODO Auto-generated method stub
		return (List<AlarmMsg>) service.findAll();
	}
	
	public Page<AlarmMsg> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return service.findAll(pageable);
	}
	
	public AlarmMsg findOne(Integer id) {
        return service.findOne(id);
    }
	
	public AlarmMsg save(AlarmMsg alarmMsg) {
		return service.save(alarmMsg);
	}
	
	public void delete(Integer alarmMsgSeq) {
		service.delete(alarmMsgSeq);
	}
	
	public AlarmMsg update(Integer alarmMsgSeq, AlarmMsg alarmMsg) {
		AlarmMsg update = service.findOne(alarmMsgSeq);
		update.setScrapperId(alarmMsg.getScrapperId());
		update.setScrapperType(alarmMsg.getScrapperType());
		update.setMessage(alarmMsg.getMessage());
		update.setOccurrenceTime(alarmMsg.getOccurrenceTime());
		update.setAlarmLevel(alarmMsg.getAlarmLevel());
		update.setRecipient(alarmMsg.getRecipient());
		update.setStatus(alarmMsg.getStatus());
		update.setModifyUser(alarmMsg.getModifyUser());
		update.setModifyDate(Utility.getCurrentTime(null));
		return service.save(update);
	}
}
