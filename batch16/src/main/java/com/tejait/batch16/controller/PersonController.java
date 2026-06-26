package com.tejait.batch16.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch16.model.Person;
import com.tejait.batch16.service.PersonService;

@RestController
@RequestMapping("person")
public class PersonController {
	
	PersonService service;
//We can write the constructor instead of the @Autowired annotation for better usability
	public PersonController(PersonService service) {
		super();
		this.service = service;
	}//And no need of inserting the annotation for the PersonService interface
	//Just arguemented constructor is enough to inject into our controller..
	
	@GetMapping("savePersonPan")
	public ResponseEntity<Person> savePersonPan(@RequestBody Person person){
		Person savedPerson=service.savePersonPan(person);
		return new ResponseEntity<Person>(savedPerson, HttpStatus.OK);
	}

}
