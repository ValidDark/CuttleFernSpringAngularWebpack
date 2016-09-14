package com.cooksys.cuttlefern.ws.api;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.GroupService;
import com.cooksys.cuttlefern.ws.domain.social.Person;
import com.cooksys.cuttlefern.ws.domain.social.PersonService;

@RestController
@RequestMapping("api/people")
public class PersonController {
	
	private final PersonService service;
	
	@Autowired
	public PersonController(PersonService service) {
		super();
		this.service = service;
	}
	
///////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping (method = RequestMethod.GET)
	public List<Person> index() {
		return this.service.index();
	}
	
	@RequestMapping (method = RequestMethod.POST)
	public Person create(@RequestBody Person person) {
		return this.service.create(person);
	}

///////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person read(@PathVariable Integer id) {
		return this.service.read(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public Person update(@PathVariable Integer id, @RequestBody Person personToUpdate) {
		return this.service.update(id, personToUpdate);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Person delete(@PathVariable Integer id) {
		return this.service.delete(id);
	}
	
///////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/{id}/city", method = RequestMethod.GET)
	public City getCity(@PathVariable Integer id) {
		return this.service.readCity(id);
	}
	
	@RequestMapping(value = "/{id}/city", method = RequestMethod.PUT)
	public Person updateCity(@PathVariable Integer id, @RequestBody City city) {
		return this.service.updateCity(id, city);
	}

///////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/{id}/interests", method = RequestMethod.GET)
	public Set<Interest> interest(@PathVariable Integer id) {
		return this.service.readInterests(id);
	}
	
	@RequestMapping(value = "/{id}/interests", method = RequestMethod.PUT)
	public Person updateInterests(@PathVariable Integer id, @RequestBody Interest interest) {
		return this.service.newInterest(id, interest);
	}
	
	@RequestMapping(value = "/{id}/interests/{id2}", method = RequestMethod.DELETE)
	public Person removeInterest(@PathVariable Integer id, @PathVariable Integer id2) {
		return this.service.removeInterest(id, id2);
	}

///////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/{id}/groups", method = RequestMethod.GET)
	public Set<Group> readMembers(@PathVariable Integer id) {
		return this.service.readGroups(id);
	}

	@RequestMapping(value = "/{id}/groups", method = RequestMethod.PUT)
	public Person updateGroups(@PathVariable Person id, @RequestBody Group group) {
		return this.service.addToGroup(id, group);
	}
	
	@RequestMapping(value = "/{id}/groups/{id2}", method = RequestMethod.DELETE)
	public Person removeGroup(@PathVariable Integer id, @PathVariable Integer id2) {
		return this.service.removeGroup(id, id2);
	}
}
