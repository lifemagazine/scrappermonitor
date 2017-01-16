package com.lifemagazine.scrappermonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifemagazine.scrappermonitor.domain.VesselSchedule;


public interface VesselScheduleRepository extends JpaRepository<VesselSchedule, String> {
	
}