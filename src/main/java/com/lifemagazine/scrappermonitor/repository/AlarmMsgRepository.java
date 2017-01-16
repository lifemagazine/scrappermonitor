package com.lifemagazine.scrappermonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifemagazine.scrappermonitor.domain.AlarmMsg;

public interface AlarmMsgRepository extends JpaRepository<AlarmMsg, Integer> {

}
