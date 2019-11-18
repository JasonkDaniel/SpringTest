package com.dhanjyothi;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class PersonController {
	@Autowired
	PersonService perservice;
	
@RequestMapping("/")
public ModelAndView IndexPage()
{
	return new ModelAndView("index");
	
}

@RequestMapping("empform")
public ModelAndView EmpformPage(@ModelAttribute("person") Person person)
{
	return new ModelAndView("empform");
	
}
@RequestMapping("save")
public ModelAndView SavePage(@ModelAttribute("person") Person person)
{
	if(person.getId()==0)
	{
		perservice.savePerson(person);
	
	}
	else
	{
		perservice.updatePerson(person);
	}
	List<Person> lp=perservice.FetchPerson();
	return new ModelAndView("Success","listperson",lp);
	
}
@RequestMapping("editemployee")
public ModelAndView EditPage(@ModelAttribute("person") Person person,HttpServletRequest req)
{ int id=Integer.parseInt(req.getParameter("id"));
	System.out.println("Id"+id);
	Person pers=perservice.getPersonById(id);
	//List<Person> lp=perdao.FetchPerson();
	return new ModelAndView("empform","person",pers);
	
}
@RequestMapping("deleteemployee")
public ModelAndView DeletePage(@ModelAttribute("person") Person person,HttpServletRequest req)
{ //int id=Integer.parseInt(req.getParameter("id"));
	perservice.deletePerson(person);
	List<Person> lp=perservice.FetchPerson();
	return new ModelAndView("Success","listperson",lp);
	
}
@RequestMapping("viewemp")
public ModelAndView viewPage(@ModelAttribute("person") Person person)
{
	List<Person> lp=perservice.FetchPerson();
	return new ModelAndView("Success","listperson",lp);
	
}
}
