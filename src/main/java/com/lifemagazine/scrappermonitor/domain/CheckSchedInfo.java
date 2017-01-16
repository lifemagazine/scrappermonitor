package com.lifemagazine.scrappermonitor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@Table(name = "TX_CHECK_SCHED_INFO")
@ToString
public class CheckSchedInfo {

	@Id
	@Column(name="check_sched_seq")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer checkSchedSeq;
	@Column(name="check_sched_name")
	private String checkSchedName;
	@Column(name="check_sched_desc")
	private String checkSchedDesc;
	@Column(name="scrapper_id")
	private Integer scrapperId;
	@Column(name="check_cycle")
	private String checkCycle;
	@Column(name="last_check_date")
	private String lastCheckDate;
	@Column(name="before_last_check_date")
	private String beforeLastCheckDate;
	@Column(name="valid_yn")
	private String validYn;
	@Column(name="modify_user")
	private String modifyUser;
	@Column(name="modify_date")
	private String modifyDate;
	
	public CheckSchedInfo() {}
}
