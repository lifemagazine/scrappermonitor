package com.lifemagazine.scrappermonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifemagazine.scrappermonitor.domain.CheckSchedInfo;

public interface CheckSchedInfoRepository extends JpaRepository<CheckSchedInfo, Integer>  {

}
