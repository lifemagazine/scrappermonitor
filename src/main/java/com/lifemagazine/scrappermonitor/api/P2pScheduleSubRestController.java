package com.lifemagazine.scrappermonitor.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifemagazine.scrappermonitor.domain.P2pScheduleSub;
import com.lifemagazine.scrappermonitor.service.P2pScheduleSubService;

@RestController
@RequestMapping("api/p2pschedulesub")
public class P2pScheduleSubRestController {

	@Autowired
	private P2pScheduleSubService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public P2pScheduleSub create(@RequestBody P2pScheduleSub p2pScheduleSub) {
		return service.save(p2pScheduleSub);
	}
}
