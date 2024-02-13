package com.hydrogen_infra_api.hydrogen_infra_api.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.hydrogen_infra_api.hydrogen_infra_api.domain.Equipments;

import jakarta.persistence.Column;

public class StationDto {

	private String name;
	private String address;
	private Double address_lat;
	private Double address_lng;
	private String regist_num;
	private Long group;
	private Date autharization_date;
	private Date start_date;
	private String district;
	private String phoneNumber;

	public StationDto() {
		super();
	}



	public StationDto(Long group,
			Date autharization_date, Date start_date, String district, String phoneNumber,String name, String address, Double address_lat, Double address_lng, String regist_num) {
		super();
		this.name = name;
		this.address = address;
		this.address_lat = address_lat;
		this.address_lng = address_lng;
		this.regist_num = regist_num;
		this.group = group;
		this.autharization_date = autharization_date;
		this.start_date = start_date;
		this.district = district;
		this.phoneNumber = phoneNumber;
	}



	public Long getGroup() {
		return group;
	}

	public void setGroup(Long group) {
		this.group = group;
	}

	public Date getAutharization_date() {
		return autharization_date;
	}

	public void setAutharization_date(Date autharization_date) {
		this.autharization_date = autharization_date;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getAddress_lat() {
		return address_lat;
	}

	public void setAddress_lat(Double address_lat) {
		this.address_lat = address_lat;
	}

	public Double getAddress_lng() {
		return address_lng;
	}

	public void setAddress_lng(Double address_lng) {
		this.address_lng = address_lng;
	}

	public String getRegist_num() {
		return regist_num;
	}

	public void setRegist_num(String regist_num) {
		this.regist_num = regist_num;
	}

}
