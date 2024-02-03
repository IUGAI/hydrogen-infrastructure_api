package com.hydrogen_infra_api.hydrogen_infra_api.Jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.hydrogen_infra_api.hydrogen_infra_api.domain.Equipments;
import com.hydrogen_infra_api.hydrogen_infra_api.repository.EquipmentsRepo;

@DisplayName("JPA 연결 테스트")
@DataJpaTest
public class EquipmentsJpaTest {
	
	private final EquipmentsRepo repo ;
	
	
	public EquipmentsJpaTest(EquipmentsRepo repo) {
		super();
		this.repo = repo;
	}




	void givenTest_whenSelecting() {
		List<Equipments>  equipments = repo.findAll();
		
		assertThat(equipments).isNull();
	}
}
