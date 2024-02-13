package com.hydrogen_infra_api.hydrogen_infra_api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hydrogen_infra_api.hydrogen_infra_api.domain.Stations;
import com.hydrogen_infra_api.hydrogen_infra_api.dto.StationDtoInfoWithCounts;
import com.hydrogen_infra_api.hydrogen_infra_api.dto.StationDto;

public interface StationRepo extends JpaRepository<Stations, Long> {

	@Query("SELECT NEW com.hydrogen_infra_api.hydrogen_infra_api.dto.StationDtoInfoWithCounts(s.id,s.group,  s.autharization_date,  s.start_date, s.district,"
			+ " s.phoneNumber,  s.name, s.address, s.address_lat, s.address_lng, s.regist_num," + "COUNT(fc) as total, "
			+ "SUM(CASE WHEN fc.group = 1 THEN 1 ELSE 0 END), " + "SUM(CASE WHEN fc.group = 2 THEN 1 ELSE 0 END), "
			+ "SUM(CASE WHEN fc.group = 3 THEN 1 ELSE 0 END)) " + "FROM Stations s "
			+ "LEFT JOIN Equipments fc ON s.id = fc.station.id "
			+ "GROUP BY s.id, s.name, s.address, s.address_lat, s.address_lng, s.regist_num")
	List<StationDtoInfoWithCounts> findAllWithFuelColumnCount();

}
