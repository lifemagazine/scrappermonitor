package com.lifemagazine.scrappermonitor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lifemagazine.scrappermonitor.domain.VesselSchedule;
import com.lifemagazine.scrappermonitor.repository.VesselScheduleRepository;

@Component
public class VesselScheduleService {

	@Autowired(required=true)
	VesselScheduleRepository service;
	
	public VesselSchedule save(VesselSchedule vesselSchedule) {
		return service.save(vesselSchedule);
	}
}
