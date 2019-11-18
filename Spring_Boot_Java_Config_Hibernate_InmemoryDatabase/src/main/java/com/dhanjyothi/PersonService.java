package com.dhanjyothi;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class PersonService {
@Autowired
PersonDao dao;
	public void savePerson(Person person) {
		
		dao.savePerson(person);
	}

	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	public List<Person> FetchPerson() {
		
		return dao.FetchPerson();
	}

	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deletePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

}
