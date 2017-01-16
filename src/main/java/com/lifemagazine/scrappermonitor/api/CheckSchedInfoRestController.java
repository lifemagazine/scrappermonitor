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
import com.lifemagazine.scrappermonitor.service.AlarmGroupService;

@RestController
@RequestMapping("api/checkschedinfo")
public class CheckSchedInfoRestController {

	@Autowired
	private AlarmGroupService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public Page<AlarmGroup> list(@PageableDefault Pageable pageable) {
		// TODO Auto-generated method stub
		PageRequest pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), new Sort(new Order(Direction.DESC, "modifyUser")));
		return (Page<AlarmGroup>) service.findAll(pageRequest);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	AlarmGroup getCustomer(@PathVariable Integer id) {
		AlarmGroup alarmGroup = service.findOne(id);
        return alarmGroup;
    }
	
	@RequestMapping(method=RequestMethod.POST)
	public AlarmGroup create(@RequestBody AlarmGroup alarmGroup) {
		return service.save(alarmGroup);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="{alarm_grp_seq}")
	public void delete(@PathVariable Integer alarmGrpSeq) {
		service.delete(alarmGrpSeq);
	}

	@RequestMapping(method=RequestMethod.PUT, value="{alarm_grp_seq}")
	public AlarmGroup update(@PathVariable Integer alarmGrpSeq, @RequestBody AlarmGroup alarmGroup) {
		return service.update(alarmGrpSeq, alarmGroup);
	}
}
