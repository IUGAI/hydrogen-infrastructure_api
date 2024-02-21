package com.hydrogen_infra_api_ver2.hydrogen_infra_api.Service;

import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Domain.Stations;
import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Dto.StationDto;
import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Dto.StationDtoInfoWithCounts;
import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Dto.StationsWithEqipmentsDto;
import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Repository.StationRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class StationSerivce {



    private StationRepo repo;

    public StationSerivce(StationRepo repo) {
        super();
        this.repo = repo;
    }

    @Transactional(readOnly = true)
    public List<StationDto> getAllStations() {
//		List<StationDto> stations = repo.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
        List<Object[]> stations = repo.findAllStationsWithTotalEquipment();
        return  convertToDto(stations);

    }


    private List<StationDto> convertToDto(List<Object[]> results) {
        return results.stream()
                .map(this::mapToStationDto)
                .toList();
    }
    private StationDto mapToStationDto(Object[] result) {
        Stations station = (Stations) result[0];
        Long totalEquipment = (Long) result[1];
        Long productionEquipments = (Long) result[2];
        Long storageEquipments = (Long) result[3];
        Long chargingEquipments = (Long) result[4];


        StationDto stationDto = new StationDto(
                station.getId(),
                station.getGroup(),
                station.getAutharization_date(),
                station.getStart_date(),
                station.getDistrict(),
                station.getPhoneNumber(),
                station.getName(),
                station.getAddress(),
                station.getAddress_lat(),
                station.getAddress_lng(),
                station.getRegist_num()
        );

        stationDto.setTotalEquipemnts(totalEquipment);
        stationDto.setEquipmentsProduction(productionEquipments);
        stationDto.setEquipmentsStrorage(storageEquipments);
        stationDto.setEquipmentsCharging(chargingEquipments);
        return stationDto;
    }


    @Transactional(readOnly = true)
    public StationsWithEqipmentsDto getStationByid(Long id) {
        Optional<StationsWithEqipmentsDto> station = repo.findById(id).map(this::converToStationsWithEquipmentsDto);
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

    private StationsWithEqipmentsDto converToStationsWithEquipmentsDto(Stations entity) {
        StationsWithEqipmentsDto dto = new StationsWithEqipmentsDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    private Stations convertToEntity(StationDto dto) {
        Stations entity = new Stations();

        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

}
