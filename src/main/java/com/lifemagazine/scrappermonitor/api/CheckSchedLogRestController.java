package com.lifemagazine.scrappermonitor.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifemagazine.scrappermonitor.domain.AlarmGroup;
import com.lifemagazine.scrappermonitor.service.AlarmGroupService;

@RestController
@RequestMapping("api/checkschedlog")
public class CheckSchedLogRestController {

	@Autowired
	private AlarmGroupService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public AlarmGroup create(@RequestBody AlarmGroup alarmGroup) {
		return service.save(alarmGroup);
	}
	
}
