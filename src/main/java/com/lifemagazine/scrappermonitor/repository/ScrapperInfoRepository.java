package com.lifemagazine.scrappermonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifemagazine.scrappermonitor.domain.ScrapperInfo;

public interface ScrapperInfoRepository extends JpaRepository<ScrapperInfo, Integer> {

}
