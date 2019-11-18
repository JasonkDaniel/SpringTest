package com.dhanjyothi.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dhanjyothi.Person;
import com.dhanjyothi.PersonService;

import org.junit.Before;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
//@ComponentScan(basePackages = "com.dhanjyothi")
@ContextConfiguration(classes = { TestBeanConfig.class })
public class ServiceTest {

	@Autowired
	PersonService ser;
	private Person p;
	@Before
	public void setup() {
		System.out.println(" Before method..");
		p=new Person();
	}
	 @Test
	   public void testGet() {
		 p.setId(1);
		 p.setName("revathi");
		 p.setPhone("120");
		 p.setCity("chennai");
		 ser.savePerson(p);
		List<Person> p=ser.FetchPerson();
		for (Person personObj : p) {
		       assertEquals("revathi",personObj.getName() );
	    }

	 }
}
