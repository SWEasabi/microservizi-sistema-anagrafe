package com.SWEasabi.gestione.repositories;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.SWEasabi.gestione.entities.Area;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class AreaRepositoryTest {
	
	@Autowired
	private TestEntityManager em;
	
	@Autowired
	AreaRepository areaRepo;

	@Test
	void injectedComponentsAreNotNull() {
		assertThat(em).isNotNull();
		assertThat(areaRepo).isNotNull();
	}
	
	@Test
	void IdZeroBeforeSaveTest() {
		Area area = new Area("testArea",true,1,2);
		assertEquals(area.getId(),0);
	}
	
	@Test
	void IdNotZeroAfterSaveTest() {
		Area area = new Area("testArea",true,1,2);
		Area resArea = areaRepo.save(area);
		assertNotEquals(resArea.getId(),0);
	}
	
	@Test
	void nonExistentAreaIsNull() {
		assertNull(areaRepo.findById(100));
	}
	
	@Test
	void ExistentAreaIsNotNull() {
		areaRepo.save(new Area("testArea",true,1,2));
		Area resArea = areaRepo.findById(2);
		
		assertNotNull(resArea);
	}
	
	@Test
	void areaInsertedHasCorrectData() {
		
		Area area = new Area("testArea",true,1,2);
		Area resArea = areaRepo.save(new Area("testArea",true,1,2));
		area.setId(resArea.getId());
		
		assertTrue(area.equals(resArea));
	}
	
	@Test
	void deletedAreaIsNoLongerPresent() {
		Area resArea = areaRepo.save(new Area("testArea",true,1,2));
		areaRepo.deleteById(resArea.getId());
		Area deletedArea = areaRepo.findById(resArea.getId());
		assertNull(deletedArea);
	}
}
