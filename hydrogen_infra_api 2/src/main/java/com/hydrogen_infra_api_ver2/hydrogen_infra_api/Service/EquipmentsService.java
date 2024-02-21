package com.hydrogen_infra_api_ver2.hydrogen_infra_api.Service;

import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Domain.Equipments;
import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Domain.Stations;
import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Dto.EquipmentsDto;
import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Repository.EquipmentsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EquipmentsService {
;


    private EquipmentsRepo repo;


    public EquipmentsService(EquipmentsRepo repo) {
        super();
        this.repo = repo;
    }

    @Transactional
    public List<EquipmentsDto> getAllList() {
        List<EquipmentsDto> equipments = repo.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
        return equipments;
    }


    public EquipmentsDto getEquipmentByid(Long id){
        Optional<EquipmentsDto> optionalvalue = repo.findById(id).map(this::convertToDTO);
//		   if (optionalvalue.isPresent()) {
//	            logger.info("Equipment found: {}", optionalvalue.get());
//	        } else {
//	            logger.warn("Equipment not found for ID: {}", id);
//	        }
        return optionalvalue.orElse(null);
    }

    public EquipmentsDto createEquipment(EquipmentsDto equipmentsdto) {
        Equipments equipment = convertToEntity(equipmentsdto);
        Equipments savedEquipment = repo.save(equipment);
        return convertToDTO(savedEquipment);
    }




    private EquipmentsDto convertToDTO(Equipments entity) {
        EquipmentsDto dto = new EquipmentsDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setGroup(entity.getGroup());
        dto.setImportance(entity.getImportance());
        dto.setManufacturer(entity.getManufacturer());
        dto.setManufacturer_date(entity.getManufacturer_date());
        dto.setLimited_capacity(entity.getLimited_capacity());
        dto.setMax_temperature(entity.getMax_temperature());
        dto.setMin_temperature(entity.getMin_temperature());
        dto.setMin_presure(entity.getMin_presure());
        dto.setMax_presure(entity.getMax_presure());

        return dto;
    }

    private Equipments convertToEntity(EquipmentsDto dto) {
        Equipments entity = new Equipments();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setGroup(dto.getGroup());
        entity.setImportance(dto.getImportance());
        entity.setManufacturer(dto.getManufacturer());
        entity.setManufacturer_date(dto.getManufacturer_date());
        entity.setLimited_capacity(dto.getLimited_capacity());
        entity.setMax_temperature(dto.getMax_temperature());
        entity.setMin_temperature(dto.getMin_temperature());
        entity.setMin_presure(dto.getMin_presure());
        entity.setMax_presure(dto.getMax_presure());
        return entity;
    }

    public EquipmentsDto updateByid(Long id, EquipmentsDto equipmentDto) {
        Optional<Equipments> currentEquipmen = repo.findById(id);
        if (currentEquipmen.isPresent()) {
            Equipments equipments = currentEquipmen.get();
            BeanUtils.copyProperties(convertToEntity(equipmentDto), equipments, "id");
            return convertToDTO(repo.save(equipments));
        }
        else {
            throw new RuntimeException("Station not found with id: " + id);
        }
    }

    public boolean deletebyid(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
