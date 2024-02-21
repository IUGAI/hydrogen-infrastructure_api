package com.hydrogen_infra_api_ver2.hydrogen_infra_api.Controller;


import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Dto.StationDto;
import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Dto.StationDtoInfoWithCounts;
import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Dto.StationsWithEqipmentsDto;
import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Service.StationSerivce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/stations")
public class StationController {
    private final StationSerivce service;

    public StationController(StationSerivce service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<StationDto>> getAllStation(){
        List<StationDto> stations = service.getAllStations();
        return new ResponseEntity<>(stations,  HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StationsWithEqipmentsDto> getstationbyid(@PathVariable Long id){
        StationsWithEqipmentsDto station = service.getStationByid(id);
        if (station != null) {
            return new ResponseEntity<>(station, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<StationDto> update(@PathVariable Long id, @RequestBody StationDto station) {
        StationDto entity = service.updateByid(id, station);
        return new ResponseEntity(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StationDto> createStation(@RequestBody StationDto stationdto){
        StationDto dto = service.createStation(stationdto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntity(@PathVariable Long id) {
        boolean deletionResult  =  service.deletebyid(id);
        if (deletionResult) {
            return new ResponseEntity<>("Deleted resource with ID: " + id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Resource with ID: " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
