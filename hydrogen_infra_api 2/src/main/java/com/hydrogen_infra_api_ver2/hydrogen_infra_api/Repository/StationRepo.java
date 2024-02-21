package com.hydrogen_infra_api_ver2.hydrogen_infra_api.Repository;

import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Domain.Stations;
import com.hydrogen_infra_api_ver2.hydrogen_infra_api.Dto.StationDtoInfoWithCounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface StationRepo extends JpaRepository<Stations, Long> {
//    @Query("SELECT NEW com.hydrogen_infra_api_ver2.hydrogen_infra_api.Dto.StationsWithEqipmentsDto("
//            + "s.id, s.group, s.autharization_date, s.start_date, s.district, "
//            + "s.phoneNumber, s.name, s.address, s.address_lat, s.address_lng, s.regist_num, "
//            + "COUNT(fc) as total, "
//            + "SUM(CASE WHEN fc.group = 1 THEN 1 ELSE 0 END) as group1Count, "
//            + "SUM(CASE WHEN fc.group = 2 THEN 1 ELSE 0 END) as group2Count, "
//            + "SUM(CASE WHEN fc.group = 3 THEN 1 ELSE 0 END) as group3Count) "
//            + "FROM Stations s "
//            + "LEFT JOIN Equipments fc ON s.id = fc.station.id "
//            + "GROUP BY s.id, s.name, s.address, s.address_lat, s.address_lng, s.regist_num")
//    List<StationDtoInfoWithCounts> findAllWithFuelColumnCount();


    @Query("SELECT s, " +
            "COUNT(e.id) AS totalEquipment, " +
            "SUM(CASE WHEN e.group = 1 THEN 1 ELSE 0 END) AS group_1_count," +
            "SUM(CASE WHEN e.group = 2 THEN 1 ELSE 0 END) AS group_2_count," +
            "SUM(CASE WHEN e.group = 3 THEN 1 ELSE 0 END) AS group_3_count " +
            "FROM Stations s " +
            "LEFT JOIN Equipments e ON s.id = e.station.id " +
            "GROUP BY s.id")
    List<Object[]> findAllStationsWithTotalEquipment();


}
