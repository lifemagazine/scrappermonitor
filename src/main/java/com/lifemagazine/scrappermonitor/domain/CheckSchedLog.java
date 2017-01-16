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
@Table(name = "TX_CHECK_SCHED_LOG")
@ToString
public class CheckSchedLog {

	@Id
	@Column(name="check_sched_log_seq")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer checkSchedLogSeq;
	@Column(name="scrapper_id")
	private Integer scrapperId;
	@Column(name="error_msg")
	private String errorMsg;
	@Column(name="result_yn")
	private String resultYn;
	@Column(name="modify_user")
	private String modifyUser;
	@Column(name="modify_date")
	private String modifyDate;
	
	public CheckSchedLog() {}
	
}
