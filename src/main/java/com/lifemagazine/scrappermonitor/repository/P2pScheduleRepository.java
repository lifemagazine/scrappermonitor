package com.lifemagazine.scrappermonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifemagazine.scrappermonitor.domain.P2pSchedule;


public interface P2pScheduleRepository extends JpaRepository<P2pSchedule, String> {
	
}
