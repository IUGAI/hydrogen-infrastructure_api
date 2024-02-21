package com.hydrogen_infra_api_ver2.hydrogen_infra_api.Repository;

import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Domain.Equipments;
import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Domain.Stations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipmentsRepo extends JpaRepository<Equipments, Long> {

}
