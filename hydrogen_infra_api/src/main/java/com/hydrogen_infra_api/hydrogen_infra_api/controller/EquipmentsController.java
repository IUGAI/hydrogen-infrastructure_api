package com.hydrogen_infra_api.hydrogen_infra_api.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hydrogen_infra_api.hydrogen_infra_api.domain.Equipments;
import com.hydrogen_infra_api.hydrogen_infra_api.dto.EquipmentsDto;
import com.hydrogen_infra_api.hydrogen_infra_api.service.EquipmentsService;

@RestController
@RequestMapping("/api/equipments")
public class EquipmentsController {
	
	private EquipmentsService service;
	
	

	public EquipmentsController(EquipmentsService service) {
		super();
		this.service = service;
	}



	@GetMapping
	public  ResponseEntity<List<EquipmentsDto>> getEquipment() {
		List<EquipmentsDto> equipments = service.getAllList();
		return new ResponseEntity<>(equipments, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EquipmentsDto> getEquipmentbyid(@PathVariable Long id){
		EquipmentsDto entity = service.getEquipmentByid(id);
		if (entity != null) {
			return new ResponseEntity(entity, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<EquipmentsDto> createEquipment(@RequestBody EquipmentsDto equipment){
		EquipmentsDto createdEquipment = service.createEquipment(equipment);
		return  new ResponseEntity(createdEquipment, HttpStatus.CREATED);
	}
}





