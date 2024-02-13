package com.hydrogen_infra_api.hydrogen_infra_api.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hydrogen_infra_api.hydrogen_infra_api.domain.Equipments;
import com.hydrogen_infra_api.hydrogen_infra_api.dto.EquipmentsDto;
import com.hydrogen_infra_api.hydrogen_infra_api.repository.EquipmentsRepo;

@Service
@Transactional
public class EquipmentsService {

	private EquipmentsRepo repo;

	@Autowired
	public EquipmentsService(EquipmentsRepo repo) {
		super();
		this.repo = repo;
	}

	@Transactional(readOnly = true)
	public List<EquipmentsDto> getAllList() {
		List<EquipmentsDto> equipments = repo.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
		return equipments;
	}

	@Transactional(readOnly = true)
	public EquipmentsDto getEquipmentByid(Long id) {
		Optional<EquipmentsDto> optionalvalue = repo.findById(id).map(this::convertToDTO);
		return optionalvalue.orElse(null);
	}

	public EquipmentsDto createEquipment(EquipmentsDto equipmentsdto) {
		Equipments equipment = convertToEntity(equipmentsdto);
		Equipments savedEquipment = repo.save(equipment);
		return convertToDTO(savedEquipment);
	}

	public EquipmentsDto updateByid(Long id, EquipmentsDto equipmentsdto) {
		Optional<Equipments> optionalEquipment = repo.findById(id);
		if (optionalEquipment.isPresent()) {
			Equipments equipment = optionalEquipment.get();
			BeanUtils.copyProperties(convertToEntity(equipmentsdto), equipment, "id");
			return convertToDTO(repo.save(equipment));
		} else {
			throw new RuntimeException("Equipment not found with id: " + id);
		}
	}

	public void deletebyid(Long id) {
		repo.deleteById(id);
	}

	private EquipmentsDto convertToDTO(Equipments entity) {
		EquipmentsDto dto = new EquipmentsDto();
//		dto.setId(entity.getId());
//		dto.setName(entity.getName());
//		dto.setGroup(entity.getGroup());
//		dto.setImportance(entity.getImportance());
//		dto.setManufacturer(entity.getManufacturer());
//		dto.setManufacturer_date(entity.getManufacturer_date());
//		dto.setLimited_capacity(entity.getLimited_capacity());
//		dto.setMax_temperature(entity.getMax_temperature());
//		dto.setMin_temperature(entity.getMin_temperature());
//		dto.setMin_presure(entity.getMin_presure());
//		dto.setMax_presure(entity.getMax_presure());

		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	private Equipments convertToEntity(EquipmentsDto dto) {
		Equipments entity = new Equipments();
//		   entity.setId(dto.getId());
//		   entity.setName(dto.getName());
//		   entity.setGroup(dto.getGroup());
//		   entity.setImportance(dto.getImportance());
//		   entity.setManufacturer(dto.getManufacturer());
//		   entity.setManufacturer_date(dto.getManufacturer_date());
//		   entity.setLimited_capacity(dto.getLimited_capacity());
//		   entity.setMax_temperature(dto.getMax_temperature());
//		   entity.setMin_temperature(dto.getMin_temperature());
//		   entity.setMin_presure(dto.getMin_presure());
//		   entity.setMax_presure(dto.getMax_presure());

		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
