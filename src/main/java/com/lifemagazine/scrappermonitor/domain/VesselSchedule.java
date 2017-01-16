package com.lifemagazine.scrappermonitor.domain;

import java.util.Calendar;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TX_VESSEL_SCHEDULE")
public class VesselSchedule {
	public static final String TABLE_NAME = "TX_VESSEL_SCHEDULE";
	
	@Id
	@Column(name = "SCH_ID")
	private String schId;
	
	@Column(name = "SHPR_CD")
	private String shprCd;
	
	@Column(name = "VESSEL_ID")
	private Integer vesselId;
	
	@Column(name = "VESSEL_NM")
	private String vesselNm;
	
	@Column(name = "IN_VOYAGE")
	private String inVoyage;
	
	@Column(name = "OUT_VOYAGE")
	private String outVoyage;
	
	@Column(name = "LOCATION_ID")
	private Integer locationId;
	
	@Column(name = "PORT_NM")
	private String portNm;
	
	@Column(name = "TMNL_NM")
	private String tmnlNm;
	
	@Column(name = "ARR_DTM")
	private String arrDtm;
	
	@Column(name = "BERTHN_DTM")
	private String berthnDtm;
	
	@Column(name = "DEP_DTM")
	private String depDtm;
	
	@Column(name = "REG_DATE")
	private Calendar regDate;
	
	public VesselSchedule() {}

	public String getSchId() {
		return schId;
	}

	public void setSchId(String schId) {
		this.schId = schId;
	}

	public String getShprCd() {
		return shprCd;
	}

	public void setShprCd(String shprCd) {
		this.shprCd = shprCd;
	}

	public Integer getVesselId() {
		return vesselId;
	}

	public void setVesselId(Integer vesselId) {
		this.vesselId = vesselId;
	}

	public String getVesselNm() {
		return vesselNm;
	}

	public void setVesselNm(String vesselNm) {
		this.vesselNm = vesselNm;
	}

	public String getInVoyage() {
		return inVoyage;
	}

	public void setInVoyage(String inVoyage) {
		this.inVoyage = inVoyage;
	}

	public String getOutVoyage() {
		return outVoyage;
	}

	public void setOutVoyage(String outVoyage) {
		this.outVoyage = outVoyage;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getPortNm() {
		return portNm;
	}

	public void setPortNm(String portNm) {
		this.portNm = portNm;
	}

	public String getTmnlNm() {
		return tmnlNm;
	}

	public void setTmnlNm(String tmnlNm) {
		this.tmnlNm = tmnlNm;
	}

	public String getArrDtm() {
		return arrDtm;
	}

	public void setArrDtm(String arrDtm) {
		this.arrDtm = arrDtm;
	}

	public String getBerthnDtm() {
		return berthnDtm;
	}

	public void setBerthnDtm(String berthnDtm) {
		this.berthnDtm = berthnDtm;
	}

	public String getDepDtm() {
		return depDtm;
	}

	public void setDepDtm(String depDtm) {
		this.depDtm = depDtm;
	}

	public void setRegDate(Calendar regDate) {
		this.regDate = regDate;
	}
	
	public void setRegDate(String s) {
		
	}
	
	public Calendar getRegDate() {
		return Calendar.getInstance(TimeZone.getTimeZone("UTC"));
	}
	
}
