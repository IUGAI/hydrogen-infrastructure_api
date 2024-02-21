package com.hydrogen_infra_api_ver2.hydrogen_infra_api.Controller;


import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Dto.EquipmentsDto;
import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Service.EquipmentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipments")
public class EquipmentsController {


    private EquipmentsService service;
    public EquipmentsController(EquipmentsService service) {
        super();
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EquipmentsDto>> getEquipment() {
        List<EquipmentsDto> equipments = service.getAllList();
        return new ResponseEntity<>(equipments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentsDto> getEquipmentbyid(@PathVariable Long id) {
        EquipmentsDto entity = service.getEquipmentByid(id);
        if (entity != null) {
            return new ResponseEntity(entity, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipmentsDto> update(@PathVariable Long id, @RequestBody EquipmentsDto equipment) {
        EquipmentsDto entity = service.updateByid(id, equipment);
        return new ResponseEntity(entity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EquipmentsDto> createEquipment(@RequestBody EquipmentsDto equipment) {
        EquipmentsDto createdEquipment = service.createEquipment(equipment);
        return new ResponseEntity(createdEquipment, HttpStatus.CREATED);
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
