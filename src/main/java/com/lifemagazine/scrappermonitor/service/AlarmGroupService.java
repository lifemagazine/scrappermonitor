package com.lifemagazine.scrappermonitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.lifemagazine.scrappermonitor.domain.AlarmGroup;
import com.lifemagazine.scrappermonitor.repository.AlarmGroupRepository;
import com.lifemagazine.scrappermonitor.util.Utility;


@Component
public class AlarmGroupService {

	@Autowired(required=true)
	AlarmGroupRepository service;
	
	public List<AlarmGroup> findAll() {
		// TODO Auto-generated method stub
		return (List<AlarmGroup>) service.findAll();
	}
	
	public Page<AlarmGroup> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return service.findAll(pageable);
	}
	
	public AlarmGroup findOne(Integer id) {
        return service.findOne(id);
    }
	
	public AlarmGroup save(AlarmGroup alarmGroup) {
		return service.save(alarmGroup);
	}
	
	public void delete(Integer alarmGrpSeq) {
		service.delete(alarmGrpSeq);
	}
	
	public AlarmGroup update(Integer alarmGrpSeq, AlarmGroup alarmGroup) {
		AlarmGroup update = service.findOne(alarmGrpSeq);
		update.setGroupName(alarmGroup.getGroupName());
		update.setUserId(alarmGroup.getUserId());
		update.setStatus(alarmGroup.getStatus());
		update.setModifyUser(alarmGroup.getModifyUser());
		update.setModifyDate(Utility.getCurrentTime(null));
		return service.save(update);
	}
}
