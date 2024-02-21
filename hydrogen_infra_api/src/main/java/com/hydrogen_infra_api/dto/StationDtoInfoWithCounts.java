package com.hydrogen_infra_api.dto;

import java.util.Date;

public class StationDtoInfoWithCounts {

	private Long id;
	private StationDto station_info;
	private Long totalEquipments;
	private Long productionEquipments;
	private Long storageEquipments;
	private Long chargingEquipments;

	public StationDtoInfoWithCounts(Long id, Long group, Date autharization_date, Date start_date, String district,
			String phoneNumber, String name, String address, Double address_lat, Double address_lng, String regist_num,
			Long totalEquipments, Long productionEquipments, Long storageEquipments, Long chargingEquipments) {
		this.id = id;
		this.station_info = new StationDto(group, autharization_date, start_date, district, phoneNumber, name, address,
				address_lat, address_lng, regist_num);
		this.totalEquipments = totalEquipments;
		this.productionEquipments = productionEquipments;
		this.storageEquipments = storageEquipments;
		this.chargingEquipments = chargingEquipments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StationDto getstation_info() {
		return station_info;
	}

	public void setStationInfo(StationDto station_info) {
		this.station_info = station_info;
	}

	public Long getTotalEquipments() {
		return totalEquipments;
	}

	public void setTotalEquipments(Long totalEquipments) {
		this.totalEquipments = totalEquipments;
	}

	public Long getProductionEquipments() {
		return productionEquipments;
	}

	public void setProductionEquipments(Long productionEquipments) {
		this.productionEquipments = productionEquipments;
	}

	public Long getStorageEquipments() {
		return storageEquipments;
	}

	public void setStorageEquipments(Long storageEquipments) {
		this.storageEquipments = storageEquipments;
	}

	public Long getChargingEquipments() {
		return chargingEquipments;
	}

	public void setChargingEquipments(Long chargingEquipments) {
		this.chargingEquipments = chargingEquipments;
	}

}
