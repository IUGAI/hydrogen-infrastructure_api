package com.hydrogen_infra_api.dto;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class EquipmentsDto {
	
	private Long id;
	private String name;
	private int group;
	private int importance;
	private String manufacturer;
	private Date manufacturer_date;
	
	private Double limited_capacity;
	
	private Double max_temperature;
	private Double min_temperature;
	private Double min_presure;
	private Double max_presure;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Date getManufacturer_date() {
		return manufacturer_date;
	}
	public void setManufacturer_date(Date manufacturer_date) {
		this.manufacturer_date = manufacturer_date;
	}
	public Double getLimited_capacity() {
		return limited_capacity;
	}
	public void setLimited_capacity(Double limited_capacity) {
		this.limited_capacity = limited_capacity;
	}
	public Double getMax_temperature() {
		return max_temperature;
	}
	public void setMax_temperature(Double max_temperature) {
		this.max_temperature = max_temperature;
	}
	public Double getMin_temperature() {
		return min_temperature;
	}
	public void setMin_temperature(Double min_temperature) {
		this.min_temperature = min_temperature;
	}
	public Double getMin_presure() {
		return min_presure;
	}
	public void setMin_presure(Double min_presure) {
		this.min_presure = min_presure;
	}
	public Double getMax_presure() {
		return max_presure;
	}
	public void setMax_presure(Double max_presure) {
		this.max_presure = max_presure;
	}
	
	

}
