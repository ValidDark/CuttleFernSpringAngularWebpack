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
import com.cooksys.cuttlefern.ws.domain.interest.InterestService;
import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.GroupService;
import com.cooksys.cuttlefern.ws.domain.social.Person;

@RestController
@RequestMapping("api/groups")
public class GroupController {
	
	private final GroupService service;
	
	@Autowired
	public GroupController(GroupService service) {
		super();
		this.service = service;
	}
	
///////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Group> index() {
		return this.service.index();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Group create(@RequestBody Group group) {
	return this.service.create(group);
	}

///////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Group read(@PathVariable Integer id) {
		return this.service.read(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public Group update(@PathVariable Integer id, @RequestBody Group groupToUpdate) {
		return this.service.update(id, groupToUpdate);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Group delete(@PathVariable Integer id) {
		return this.service.delete(id);
	}
	
///////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/{id}/city", method = RequestMethod.GET)
	public City getCity(@PathVariable Integer id) {
		return this.service.readCity(id);
	}
	
	@RequestMapping(value = "/{id}/city", method = RequestMethod.PUT)
	public Group updateCity(@PathVariable Integer id, @RequestBody City city) {
		return this.service.updateCity(id, city);
	}
	
///////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/{id}/interest", method = RequestMethod.GET)
	public Interest getInterest(@PathVariable Integer id) {
		return this.service.readInterest(id);
	}
	
	@RequestMapping(value = "/{id}/interest", method = RequestMethod.PUT)
	public Group updateInterest(@PathVariable Integer id, @RequestBody Interest interest) {
		return this.service.updateInterest(id, interest);
	}
	
///////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/{id}/members", method = RequestMethod.GET)
	public Set<Person> readMembers(@PathVariable Integer id) {
		return this.service.readMembers(id);
	}
	
	@RequestMapping(value = "/{id}/members", method = RequestMethod.PUT)
	public Group updateMembers(@PathVariable Integer id, @RequestBody Person member) {
		return this.service.newMember(id, member);
	}
	
	@RequestMapping(value = "/{id}/members/{id2}", method = RequestMethod.DELETE)
	public Group removeMember(@PathVariable Integer id, @PathVariable Integer id2) {
		return this.service.removeMember(id, id2);
	}
}

