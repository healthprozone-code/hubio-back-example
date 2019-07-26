package com.hubio.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hubio.example.dto.EntityExampleDTO;
import com.hubio.example.entity.EntityExample;
import com.hubio.example.service.ExampleService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(value = "/example")
public class ExampleController {
	
	private static final String LABEL_RE_TRACE = "ResponseEntity : {}";
	
	@Autowired
	private ExampleService exampleService; 
	
	@ApiOperation(value = "View a record of example", response = EntityExample.class)
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<EntityExample> getExampleById(@PathVariable(value = "id") Long id) {
		
		log.info("Getting an example with the id : {}", id);
		
		EntityExample entityExample = exampleService.getEntityExampleById(id);
		
		log.debug("{}", entityExample);
	
		ResponseEntity<EntityExample> responseEntity = new ResponseEntity<>(entityExample, HttpStatus.OK);
		
		log.trace(LABEL_RE_TRACE, responseEntity);
		
		return responseEntity;
	}
	
	@ApiOperation(value = "View examples", response = ResponseEntity.class)
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<EntityExample>> getExamples() {
		
		log.info("Getting all the examples");
		
		List<EntityExample> examples = exampleService.getAllExamples();
		
		log.debug("{}", examples);
	
		ResponseEntity<List<EntityExample>> responseEntity = new ResponseEntity<>(examples, HttpStatus.OK);
		
		log.trace(LABEL_RE_TRACE, responseEntity);
		
		return responseEntity;
	}
	
	@ApiOperation(value = "Add an example", response = EntityExample.class)
	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<EntityExample> addExample(@RequestBody EntityExampleDTO entityExampleDTO) {
		
		log.info("Adding the example : {}", entityExampleDTO);
		
		EntityExample entityExample = exampleService.addExample(entityExampleDTO);
		
		log.debug("{}", entityExample);
	
		ResponseEntity<EntityExample> responseEntity = new ResponseEntity<>(entityExample, HttpStatus.OK);
		
		log.trace(LABEL_RE_TRACE, responseEntity);
		
		return responseEntity;
	}
	
	@ApiOperation(value = "Update an example", response = EntityExample.class)
	@PutMapping(value = "/", produces = "application/json")
	public ResponseEntity<EntityExample> updateExample(@RequestBody EntityExampleDTO entityExampleDTO) {
		
		log.info("Updateing the example : {}", entityExampleDTO);
		
		EntityExample entityExample = exampleService.updateExample(entityExampleDTO);
		
		log.debug("{}", entityExample);
	
		ResponseEntity<EntityExample> responseEntity = new ResponseEntity<>(entityExample, HttpStatus.OK);
		
		log.trace(LABEL_RE_TRACE, responseEntity);
		
		return responseEntity;
	}
	
	@ApiOperation(value = "Delete the record of example specified by the identifier", response = String.class)
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<String> deleteExample(@PathVariable(value = "id") Long id) {
		
		log.info("Deleting the example with id: {}", id);
		
		exampleService.deleteById(id);
	
		ResponseEntity<String> responseEntity = new ResponseEntity<>("example deleted successfully", HttpStatus.OK);
		
		log.trace(LABEL_RE_TRACE, responseEntity);
		
		return responseEntity;
	}

}
