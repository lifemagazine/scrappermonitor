package com.lifemagazine.scrappermonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifemagazine.scrappermonitor.domain.CheckSchedLog;

public interface CheckSchedLogRepository extends JpaRepository<CheckSchedLog, Integer> {

}
