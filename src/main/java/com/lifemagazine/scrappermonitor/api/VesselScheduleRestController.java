package com.lifemagazine.scrappermonitor.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lifemagazine.scrappermonitor.domain.VesselSchedule;
import com.lifemagazine.scrappermonitor.service.VesselScheduleService;

@RestController
@RequestMapping("api/vesselschedule")
public class VesselScheduleRestController {

	@Autowired
	private VesselScheduleService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public VesselSchedule create(@RequestBody VesselSchedule vesselSchedule) {
		return service.save(vesselSchedule);
	}
}
