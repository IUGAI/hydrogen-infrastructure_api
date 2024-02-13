package com.hydrogen_infra_api.hydrogen_infra_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hydrogen_infra_api.hydrogen_infra_api.dto.StationDto;
import com.hydrogen_infra_api.hydrogen_infra_api.dto.StationDtoInfoWithCounts;
import com.hydrogen_infra_api.hydrogen_infra_api.dto.StationsWithEquipmentsDto;
import com.hydrogen_infra_api.hydrogen_infra_api.service.StationService;



@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/stations")
public class StationsController {
	
	private StationService  service;

	public StationsController(StationService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping
	public ResponseEntity<List<StationDtoInfoWithCounts>> getAllStation(){
		List<StationDtoInfoWithCounts> stations = service.getAllStations();
		return new ResponseEntity<>(stations,  HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StationsWithEquipmentsDto> getstationbyid(@PathVariable Long id){
		StationsWithEquipmentsDto station = service.getStationByid(id);
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
	public ResponseEntity<Void> deleteEntity(@PathVariable Long id) {
		service.deletebyid(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

}
