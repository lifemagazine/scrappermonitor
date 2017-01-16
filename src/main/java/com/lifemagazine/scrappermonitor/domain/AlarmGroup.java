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
@Table(name = "tx_alarm_group")
@ToString
public class AlarmGroup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="alarm_grp_seq")
	private Integer alarmGrpSeq;
	@Column(name="group_name")
	private String groupName;
	@Column(name="user_id")
	private String userId;
	@Column(name="status")
	private Integer status;
	@Column(name="modify_user")
	private String modifyUser;
	@Column(name="modify_date")
	private String modifyDate;
	
	public AlarmGroup() {}
	
	public AlarmGroup(/*Integer alarmGrpSeq, */String groupName, String userId, int status, String modifyUser, String modifyDate) {
//		this.alarmGrpSeq = alarmGrpSeq;
		this.groupName = groupName;
		this.userId = userId;
		this.status = status;
		this.modifyUser = modifyUser;
		this.modifyDate = modifyDate;
	}
	
}
