package com.lifemagazine.scrappermonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifemagazine.scrappermonitor.domain.AlarmGroup;


public interface AlarmGroupRepository extends JpaRepository<AlarmGroup, Integer> {

}
