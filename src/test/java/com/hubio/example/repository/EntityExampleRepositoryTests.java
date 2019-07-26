package com.hubio.example.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.hubio.example.entity.EntityExample;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("development")
public class EntityExampleRepositoryTests {
	
	@Autowired
	private EntityExampleRepository eer;

	@Test
	public void findAll() {
		 
		 List<EntityExample> entities = eer.findAll();
		 
		 assertTrue(entities.size() > 0);
	}
	
	@Test
	public void createEntity() {
		 EntityExample entityExample = new EntityExample();
		 
		 entityExample.setName("Carlos");
		 entityExample.setDescription("java programmer");
		 entityExample.setCreatedAt(new Date());
	}
	
	@Test
	public void findById() {
		 Optional<EntityExample> optionalEntity = eer.findById(1l);
		 
		 EntityExample entity = new EntityExample();
		 
		 entity.setName("Daniel");
		 entity.setDescription("Scrum Owner");
		 
		 
		 EntityExample entityExample = optionalEntity.get();
		 
		 entityExample.getId();
		 entityExample.getName();
		 entityExample.getDescription();
		 entityExample.getCreatedAt();
		 
		 entity.setId(entityExample.getId());
		 entity.setCreatedAt(entityExample.getCreatedAt());
		 
		 assertTrue(entity.equals(entityExample));
		 assertEquals(entity, entityExample);
		 assertTrue(entity.hashCode() == entityExample.hashCode());
		 assertNotNull(entityExample);
		 assertNotNull(entityExample.toString());
	}

}
