package com.lifemagazine.scrappermonitor.domain;

import java.util.Calendar;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor
@Entity 
@Table(name="TX_P2P_SCHEDULE")
public class P2pSchedule {
	
	public static final String TABLE_NAME = "TX_P2P_SCHEDULE";
	
	@Id
	@Column(name = "SCH_ID")
	private String schId;
	
	@Column(name = "SHPR_CD")
	private String shprCd;
	
	@Column(name = "VESSEL_ID")
	private Integer vesselId;
	
	@Column(name = "VESSEL_NM")
	private String vesselNm;
	
	@Column(name = "VESSEL_MAP_YN")
	private String vesselMapYn;
	
	@Column(name = "VOYAGE")
	private String voyage;
	
	@Column(name = "SRVC_CD")
	private String srvcCd;
	
	@Column(name = "DEP_LOCATION_ID")
	private Integer depLocation;
	
	@Column(name = "DEP_ETA")
	private String depEta;
	
	@Column(name = "DEP_ETD")
	private String depEtd;
	
	@Column(name = "ARR_LOCATION_ID")
	private Integer arrLocation;
	
	@Column(name = "ARR_ETA")
	private String arrEta;
	
	@Column(name = "ARR_ETD")
	private String arrEtd;
	
	@Column(name = "TRANS_TP")
	private String transTp;
	
	@Column(name = "TT")
	private Integer tt;
	
	@Column(name = "DOC_CLOSE_DTM")
	private String docCloseDtm;
	
	@Column(name = "CARGO_CLOSE_DTM")
	private String cargoCloseDtm;
	
	@Column(name = "REMARK")
	private String remark;
	
	@Column(name = "REG_DATE")
	private Calendar regDate = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
	
}
