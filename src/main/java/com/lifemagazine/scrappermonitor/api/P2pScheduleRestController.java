package com.lifemagazine.scrappermonitor.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifemagazine.scrappermonitor.domain.P2pSchedule;
import com.lifemagazine.scrappermonitor.service.P2pScheduleService;

@RestController
@RequestMapping("api/p2pschedule")
public class P2pScheduleRestController {

	@Autowired
	private P2pScheduleService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public P2pSchedule create(@RequestBody P2pSchedule p2pSchedule) {
		return service.save(p2pSchedule);
	}
}
