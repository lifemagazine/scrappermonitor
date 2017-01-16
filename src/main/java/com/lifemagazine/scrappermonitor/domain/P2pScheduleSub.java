package com.lifemagazine.scrappermonitor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor
@Entity @Table(name="TX_P2P_SCHEDULE_SUB")
public class P2pScheduleSub {
	public static final String TABLE_NAME = "TX_P2P_SCHEDULE_SUB";
	
	@Id
	@Column(name = "SCH_SUB_ID")
	private String schSubId;
	
	@Column(name = "SCH_ID")
	private String schId;
	
	@Column(name = "SEQ")
	private Integer seq;
	
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
	private Integer depLocationId;
	
	@Column(name = "DEP_PORT_NM")
	private String depPortNm;
	
	@Column(name = "DEP_TMNL_NM")
	private String depTmnlNm;
	
	@Column(name = "DEP_ETA")
	private String depEta;
	
	@Column(name = "DEP_ETD")
	private String depEtd;
	
	@Column(name = "ARR_LOCATION_ID")
	private Integer arrLocationId;
	
	@Column(name = "ARR_PORT_NM")
	private String arrPortNm;
	
	@Column(name = "ARR_TMNL_NM")
	private String arrTmnlNm;
	
	@Column(name = "ARR_ETA")
	private String arrEta;
	
	@Column(name = "ARR_ETD")
	private String arrEtd;
	
}
