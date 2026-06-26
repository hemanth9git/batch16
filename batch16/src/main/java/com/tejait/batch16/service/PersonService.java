package com.tejait.batch16.service;

import com.tejait.batch16.dto.PersonItemsDto;
import com.tejait.batch16.model.Person;

public interface PersonService {

	Person savePersonPan(Person person);

	Person mapPersonToItems(PersonItemsDto dto);

}
