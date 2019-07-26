package com.hubio.example.dto;

import lombok.Data;

@Data
public class EntityExampleDTO {
	
	private Long id;
	
	/**
	 * The name of the person who has a role in the project HUBIO
	 */
	private String name;
	
	/**
	 * The main skills of the person 
	 */
	private String description;

}
