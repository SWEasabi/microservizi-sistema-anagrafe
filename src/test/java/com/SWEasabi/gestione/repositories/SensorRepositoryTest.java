package com.SWEasabi.gestione.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.SWEasabi.gestione.entities.Sensore;
import com.SWEasabi.gestione.entities.Misuratore;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class SensorRepositoryTest {

	@Autowired
	private TestEntityManager em;
	
	@Autowired
	SensorRepository sensorRepo;
	
	@Autowired
	MisuratoreRepository measurerRepo;
	
	@Test
	void injectedComponentsAreNotNull() {
		assertThat(em).isNotNull();
		assertThat(sensorRepo).isNotNull();
		assertThat(measurerRepo).isNotNull();
	}
	
	@Test
	void MeasurerIdZeroBeforeSaveTest() {
		Misuratore misuratore = new Misuratore(1,"Sensore",1.0,2.0);
		Sensore sensore = new Sensore(10);
		sensore.setMisuratore(misuratore);
		misuratore.setSensore(sensore);
		
		assertEquals(misuratore.getId(),0);
	}
	
	@Test
	void MeasurerIdNotZeroAfterSaveTest() {
		Misuratore misuratore = new Misuratore(1,"Sensore",1.0,2.0);
		Sensore sensore = new Sensore(10);
		sensore.setMisuratore(misuratore);
		misuratore.setSensore(sensore);
		
		Sensore resSensor = sensorRepo.save(sensore);
		assertNotEquals(resSensor.getMisuratore().getId(),0);
	}
	
	@Test
	void sensorIdZeroBeforeSaveTest() {
		Misuratore misuratore = new Misuratore(1,"Sensore",1.0,2.0);
		Sensore sensore = new Sensore(10);
		sensore.setMisuratore(misuratore);
		misuratore.setSensore(sensore);
		
		assertEquals(sensore.getId(),0);
	}
	
	@Test
	void sensorIdNotZeroAfterSaveTest() {
		Misuratore misuratore = new Misuratore(1,"Sensore",1.0,2.0);
		Sensore sensore = new Sensore(10);
		sensore.setMisuratore(misuratore);
		misuratore.setSensore(sensore);
		
		Sensore resSensor = sensorRepo.save(sensore);
		assertNotEquals(resSensor.getId(),0);
	}
	
	@Test
	void NonExistantsensorIsNull() {
		assertNull(sensorRepo.findById(100));
	}
	
	@Test
	void ExistantsensorIsNotNull (){
		Misuratore misuratore = new Misuratore(1,"Sensore",1.0,2.0);
		Sensore sensore = new Sensore(10);
		sensore.setMisuratore(misuratore);
		misuratore.setSensore(sensore);
		
		Sensore sensor = sensorRepo.save(sensore);
		assertNotNull(sensorRepo.findById(sensor.getId()));
	}
	
	@Test
	void sensorInsertedHasSameIdAsMeasurer() {
		Misuratore misuratore = new Misuratore(1,"Sensore",1.0,2.0);
		Sensore sensore = new Sensore(10);
		sensore.setMisuratore(misuratore);
		misuratore.setSensore(sensore);
		
		Sensore resSensor = sensorRepo.save(sensore);
		assertEquals(resSensor.getId(),resSensor.getMisuratore().getId());
	}
	
	@Test
	void sensorInsertedHasCorrectData() {
		Misuratore misuratore = new Misuratore(1,"Sensore",1.0,2.0);
		Sensore sensore = new Sensore(10);
		sensore.setMisuratore(misuratore);
		misuratore.setSensore(sensore);
		
		Sensore resSensor = sensorRepo.save(sensore);
		sensore.getMisuratore().setId(resSensor.getId());
		sensore.setId(resSensor.getId());
		
		assertTrue(sensore.equals(resSensor));
	}
	
	@Test
	void DeletedsensorIsNull() {
		Misuratore misuratore = new Misuratore(1,"sensore",1.0,2.0);
		Sensore sensore = new Sensore(10);
		sensore.setMisuratore(misuratore);
		misuratore.setSensore(sensore);
		
		Sensore resSensor = sensorRepo.save(sensore);
		sensorRepo.deleteById(resSensor.getId());
		
		assertNull(sensorRepo.findById(resSensor.getId()));
	}

}
