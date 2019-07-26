package com.hubio.example.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubio.example.dto.EntityExampleDTO;
import com.hubio.example.entity.EntityExample;
import com.hubio.example.repository.EntityExampleRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ExampleService {
	
	@Autowired
	private EntityExampleRepository entityExampleRepository;
	
	public EntityExample getEntityExampleById(Long id) {
		
		log.info("finding an example with the id: {}", id);
		
		Optional<EntityExample> optionalEntity = entityExampleRepository.findById(id);
		log.trace("{}", optionalEntity);
		
		EntityExample entityExample = new EntityExample();
		
		if (optionalEntity.isPresent()) {
			entityExample = optionalEntity.get();
		}
		
		log.debug("{}", entityExample);
		 
		return entityExample;
		
	}
	
	public List<EntityExample> getAllExamples() {
		
		List<EntityExample> examples = entityExampleRepository.findAll();
		
		log.trace("{}", examples);
				 
		return examples;
	}
	
	public EntityExample addExample(EntityExampleDTO entityExampleDTO) {
		
		EntityExample entityExample = new EntityExample();
		
		entityExample.setName(entityExampleDTO.getName());
		entityExample.setDescription(entityExampleDTO.getDescription());
		entityExample.setCreatedAt(new Date());
		
		return entityExampleRepository.save(entityExample);
	}
	
	public EntityExample updateExample(EntityExampleDTO entityExampleDTO) {
			
		Optional<EntityExample> optionalEntity = entityExampleRepository.findById(entityExampleDTO.getId()); 
		
		EntityExample entityExample = new EntityExample();
		
		if (optionalEntity.isPresent()) {
			entityExample = optionalEntity.get();
		}
		
		entityExample.setName(entityExampleDTO.getName());
		entityExample.setDescription(entityExampleDTO.getDescription());
		
		return entityExampleRepository.save(entityExample);
	}
	
	public void deleteById(Long id) {
		
		entityExampleRepository.deleteById(id); 
		
	}

}
