package com.hydrogen_infra_api.repository;

import com.hydrogen_infra_api.domain.Equipments;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



public interface EquipmentsRepo extends JpaRepository<Equipments, Long>{

}
