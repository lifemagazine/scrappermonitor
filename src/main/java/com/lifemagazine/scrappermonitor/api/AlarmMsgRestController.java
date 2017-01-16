package com.lifemagazine.scrappermonitor.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifemagazine.scrappermonitor.domain.AlarmGroup;
import com.lifemagazine.scrappermonitor.domain.AlarmMsg;
import com.lifemagazine.scrappermonitor.service.AlarmGroupService;
import com.lifemagazine.scrappermonitor.service.AlarmMsgService;

@RestController
@RequestMapping("api/alarmmsg")
public class AlarmMsgRestController {

	@Autowired
	private AlarmMsgService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public Page<AlarmMsg> list(@PageableDefault Pageable pageable) {
		// TODO Auto-generated method stub
		PageRequest pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), new Sort(new Order(Direction.DESC, "modifyUser")));
		return (Page<AlarmMsg>) service.findAll(pageRequest);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	AlarmMsg getAlarmMsg(@PathVariable Integer alarmMsgSeq) {
		AlarmMsg alarmMsg = service.findOne(alarmMsgSeq);
        return alarmMsg;
    }
	
	@RequestMapping(method=RequestMethod.POST)
	public AlarmMsg create(@RequestBody AlarmMsg alarmMsg) {
		return service.save(alarmMsg);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="{alarm_msg_seq}")
	public void delete(@PathVariable Integer alarmMsgSeq) {
		service.delete(alarmMsgSeq);
	}

	@RequestMapping(method=RequestMethod.PUT, value="{alarm_msg_seq}")
	public AlarmMsg update(@PathVariable Integer alarmMsgSeq, @RequestBody AlarmMsg alarmMsg) {
		return service.update(alarmMsgSeq, alarmMsg);
	}
}
