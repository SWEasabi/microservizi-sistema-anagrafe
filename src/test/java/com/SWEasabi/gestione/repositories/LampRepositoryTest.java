package com.SWEasabi.gestione.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.SWEasabi.gestione.entities.Area;
import com.SWEasabi.gestione.entities.Lampione;
import com.SWEasabi.gestione.entities.Misuratore;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class LampRepositoryTest {

	@Autowired
	private TestEntityManager em;
	
	@Autowired
	LampRepository lampRepo;
	
	@Autowired
	MisuratoreRepository measurerRepo;
	
	@Test
	void injectedComponentsAreNotNull() {
		assertThat(em).isNotNull();
		assertThat(lampRepo).isNotNull();
		assertThat(measurerRepo).isNotNull();
	}
	
	@Test
	void MeasurerIdZeroBeforeSaveTest() {
		Misuratore misuratore = new Misuratore(1,"lampione",1.0,2.0);
		Lampione lampione = new Lampione(10,0);
		lampione.setMisuratore(misuratore);
		misuratore.setLampione(lampione);
		
		assertEquals(misuratore.getId(),0);
	}
	
	@Test
	void MeasurerIdNotZeroAfterSaveTest() {
		Misuratore misuratore = new Misuratore(1,"lampione",1.0,2.0);
		Lampione lampione = new Lampione(10,0);
		lampione.setMisuratore(misuratore);
		misuratore.setLampione(lampione);
		
		Lampione resLamp = lampRepo.save(lampione);
		assertNotEquals(resLamp.getMisuratore().getId(),0);
	}
	
	@Test
	void LampIdZeroBeforeSaveTest() {
		Misuratore misuratore = new Misuratore(1,"lampione",1.0,2.0);
		Lampione lampione = new Lampione(10,0);
		lampione.setMisuratore(misuratore);
		misuratore.setLampione(lampione);
		
		assertEquals(lampione.getId(),0);
	}
	
	@Test
	void lampIdNotZeroAfterSaveTest() {
		Misuratore misuratore = new Misuratore(1,"lampione",1.0,2.0);
		Lampione lampione = new Lampione(10,0);
		lampione.setMisuratore(misuratore);
		misuratore.setLampione(lampione);
		
		Lampione resLamp = lampRepo.save(lampione);
		assertNotEquals(resLamp.getId(),0);
	}
	
	@Test
	void NonExistantLampIsNull() {
		assertNull(lampRepo.findById(100));
	}
	
	@Test
	void ExistantLampIsNotNull (){
		Misuratore misuratore = new Misuratore(1,"lampione",1.0,2.0);
		Lampione lampione = new Lampione(10,0);
		lampione.setMisuratore(misuratore);
		misuratore.setLampione(lampione);
		
		Lampione lamp = lampRepo.save(lampione);
		assertNotNull(lampRepo.findById(lamp.getId()));
	}
	
	@Test
	void LampInsertedHasSameIdAsMeasurer() {
		Misuratore misuratore = new Misuratore(1,"lampione",1.0,2.0);
		Lampione lampione = new Lampione(10,0);
		lampione.setMisuratore(misuratore);
		misuratore.setLampione(lampione);
		
		Lampione resLamp = lampRepo.save(lampione);
		assertEquals(resLamp.getId(),resLamp.getMisuratore().getId());
	}
	
	@Test
	void LampInsertedHasCorrectData() {
		Misuratore misuratore = new Misuratore(1,"lampione",1.0,2.0);
		Lampione lampione = new Lampione(10,0);
		lampione.setMisuratore(misuratore);
		misuratore.setLampione(lampione);
		
		Lampione resLamp = lampRepo.save(lampione);
		lampione.getMisuratore().setId(resLamp.getId());
		lampione.setId(resLamp.getId());
		
		assertTrue(lampione.equals(resLamp));
	}
	
	@Test
	void DeletedLampIsNull() {
		Misuratore misuratore = new Misuratore(1,"lampione",1.0,2.0);
		Lampione lampione = new Lampione(10,0);
		lampione.setMisuratore(misuratore);
		misuratore.setLampione(lampione);
		
		Lampione resLamp = lampRepo.save(lampione);
		lampRepo.deleteById(resLamp.getId());
		
		assertNull(lampRepo.findById(resLamp.getId()));
	}

}
