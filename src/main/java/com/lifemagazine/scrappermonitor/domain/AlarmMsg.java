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
@Table(name = "TX_ALARM_MSG")
@ToString
public class AlarmMsg {

	@Id
	@Column(name="alarm_msg_seq")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer alarmMsgSeq;
	@Column(name="scrapper_id")
	private Integer scrapperId;
	@Column(name="scrapper_type")
	private String scrapperType;
	@Column(name="message")
	private String message;
	@Column(name="occurrence_time")
	private String occurrenceTime;
	@Column(name="alarm_level")
	private Integer alarmLevel;
	@Column(name="recipient")
	private Integer recipient;
	@Column(name="status")
	private Integer status;
	@Column(name="modify_user")
	private String modifyUser;
	@Column(name="modify_date")
	private String modifyDate;
	
	public AlarmMsg() {}
	
	public AlarmMsg(int scrapperId, String scrapperType, String message, int alarmLevel,
			int recipient, String modifyUser, String modifyDate) {
		this.scrapperId = scrapperId;
		this.scrapperType = scrapperType;
		this.message = message;
		this.alarmLevel = alarmLevel;
		this.recipient = recipient;
		this.modifyUser = modifyUser;
		this.modifyDate = modifyDate;
	}
	
}
