package com.hydrogen_infra_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hydrogen_infra_api.domain.Stations;
import com.hydrogen_infra_api.dto.StationDto;
import com.hydrogen_infra_api.dto.StationDtoInfoWithCounts;
import com.hydrogen_infra_api.dto.StationsWithEquipmentsDto;
import com.hydrogen_infra_api.repository.StationRepo;

@Service
@Transactional
public class StationService {

	@Autowired
	private StationRepo repo;

	public StationService(StationRepo repo) {
		super();
		this.repo = repo;
	}

	@Transactional(readOnly = true)
	public List<StationDtoInfoWithCounts> getAllStations() {
//		List<StationDto> stations = repo.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
		List<StationDtoInfoWithCounts> stations = repo.findAllWithFuelColumnCount();
		return stations;

	}
	
	@Transactional(readOnly = true)
	public StationsWithEquipmentsDto getStationByid(Long id) {
		Optional<StationsWithEquipmentsDto> station = repo.findById(id).map(this::converToStationsWithEquipmentsDto);
		return station.orElse(null);
	}

	public StationDto createStation(StationDto dto) {
		Stations station = convertToEntity(dto);
		Stations savedstation = repo.save(station);
		return convertToDTO(savedstation);
	}

	public StationDto updateByid(Long id, StationDto dto) {
		Optional<Stations> currentStation = repo.findById(id);
		if (currentStation.isPresent()) {
			Stations station = currentStation.get();
			BeanUtils.copyProperties(convertToEntity(dto), station, "id");
			return convertToDTO(repo.save(station));
		}
		else {
			throw new RuntimeException("Station not found with id: " + id);
		}

	}

	private StationDto convertToDTO(Stations entity) {
		StationDto dto = new StationDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public boolean deletebyid(Long id) {
		if (repo.existsById(id)) {			
			repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	private StationsWithEquipmentsDto converToStationsWithEquipmentsDto(Stations entity) {
		StationsWithEquipmentsDto dto = new StationsWithEquipmentsDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	private Stations convertToEntity(StationDto dto) {
		Stations entity = new Stations();

		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
