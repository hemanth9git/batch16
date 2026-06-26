package com.tejait.batch16.serviceImpl;

import org.springframework.stereotype.Service;

import com.tejait.batch16.model.Person;
import com.tejait.batch16.repository.PersonRepository;
import com.tejait.batch16.service.PersonService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PersonServiceImpl implements PersonService{

	PersonRepository repository;//Here we created constructor using the 
	//@AllArgsConstructor annotation

	@Override
	public Person savePersonPan(Person person) {
	
		if(person.getPan()!=null) {
			person.getPan().setPerPan(person);//This statement will creates the forignkey
			//In our Pan entity 
		}
		return repository.save(person);
	}
	
	
}
