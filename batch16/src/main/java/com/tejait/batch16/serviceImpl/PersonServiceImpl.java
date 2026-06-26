package com.tejait.batch16.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tejait.batch16.dto.PersonItemsDto;
import com.tejait.batch16.exceptions.IdNotFoundException;
import com.tejait.batch16.model.Items;
import com.tejait.batch16.model.Person;
import com.tejait.batch16.repository.ItemsRepository;
import com.tejait.batch16.repository.PersonRepository;
import com.tejait.batch16.service.PersonService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PersonServiceImpl implements PersonService{

	PersonRepository repository;//Here we created constructor using the 
	//@AllArgsConstructor annotation
	
	ItemsRepository itemsRepository;

	@Override
	public Person savePersonPan(Person person) {
	
		if(person.getPan()!=null) {
			person.getPan().setPerPan(person);//This statement will creates the forignkey
			//In our Pan entity 
		}
		return repository.save(person);
	}

	@Override
	public Person mapPersonToItems(PersonItemsDto dto) {
		//Person by id - 1
		Person itmPerson=repository.findById(dto.getPersonId()).orElseThrow(IdNotFoundException::new);
		
		List<Items> itemsList=itemsRepository.findAllById(dto.getItems());//1,3,5
		
		itmPerson.setItems(itemsList);
		return repository.save(itmPerson);
	}
	
	
}
