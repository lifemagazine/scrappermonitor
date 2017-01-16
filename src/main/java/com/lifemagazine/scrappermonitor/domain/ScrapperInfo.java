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
@Table(name = "TX_SCRAPPER_INFO")
@ToString
public class ScrapperInfo {

	@Id
	@Column(name="scrapper_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer scrapperId;
	@Column(name="scrapper_name")
	private String scrapperName;
	@Column(name="scrapper_desc")
	private String scrapperDesc;
	@Column(name="scrapper_type")
	private String scrapperType;
	@Column(name="oper_id")
	private Integer operId;
	@Column(name="scrap_cyle")
	private String scrapCyle;
	@Column(name="modify_user")
	private String modifyUser;
	@Column(name="modify_date")
	private String modifyDate;
}
