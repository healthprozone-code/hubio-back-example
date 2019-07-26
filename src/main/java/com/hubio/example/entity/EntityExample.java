package com.hubio.example.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
* 
* This entity class represents the table example_table.
* Indeed, Lombok is used to avoid to write getters, setters and equals methods
*   
*/
@Data
@Entity
@Table(name = "example_table")
public class EntityExample {
	
	/**
	 * The object identifier for this class with generation type of auto increment  
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * The name of the person who has a role in the project HUBIO
	 */
	private String name;
	
	/**
	 * The main skills of the person 
	 */
	private String description;
	
	/**
	 * The date the person was assigned to the project HUBIO
	 */
	private Date createdAt;
	

}
