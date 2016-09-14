package com.cooksys.cuttlefern.ws.domain.social.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.GroupRepository;
import com.cooksys.cuttlefern.ws.domain.social.GroupService;
import com.cooksys.cuttlefern.ws.domain.social.Person;
import com.cooksys.cuttlefern.ws.domain.social.PersonRepository;

@Service
public class GroupServiceImpl implements GroupService {
	
	private final GroupRepository repo;
	private final PersonRepository personRepo;
	
	@Autowired
	public GroupServiceImpl(GroupRepository repo, PersonRepository personRepo) {
		super();
		this.repo = repo;
		this.personRepo = personRepo;
	}


///////////////////////////////////////////////////////////////////////////////

	@Override
	public List<Group> index() {
		return this.repo.findAll();
	}

	@Override
	public Group create(Group group) {
		return this.repo.save(group);
	}

///////////////////////////////////////////////////////////////////////////////

	@Override
	public Group read(Integer id) {
		return this.repo.findOne(id);
	}

	@Override
	public Group update(Integer id, Group groupToUpdate) {
		groupToUpdate.setId(id);
		return this.repo.save(groupToUpdate);
	}

	@Override
	public Group delete(Integer id) {
		Group result = this.read(id);
		this.repo.delete(id);
		this.repo.saveAndFlush(this.read(id));
		return result;
	}

///////////////////////////////////////////////////////////////////////////////

	@Override
	public City readCity(Integer id) {
		return this.repo.findOne(id).getCity();
	}

	@Override
	public Group updateCity(Integer id, City city) {
		this.repo.findOne(id).setCity(city); 
		this.repo.saveAndFlush(this.repo.findOne(id));
		return this.repo.findOne(id);
	}

///////////////////////////////////////////////////////////////////////////////

	@Override
	public Interest readInterest(Integer id) {
		return this.repo.findOne(id).getInterest();
	}

	@Override
	public Group updateInterest(Integer id, Interest interest) {
		this.repo.findOne(id).setInterest(interest); 
		this.repo.saveAndFlush(this.repo.findOne(id));
		return this.repo.findOne(id);
	}

///////////////////////////////////////////////////////////////////////////////

	@Override
	public Set<Person> readMembers(Integer id) {
		return this.repo.findOne(id).getMembers();
	}

	@Override
	public Group newMember(Integer id, Person member) {
		this.repo.findOne(id).getMembers().add(member);
		this.repo.saveAndFlush(this.repo.findOne(id));
		return this.repo.findOne(id);
	}

	@Override
	public Group removeMember(Integer id, Integer id2) {
		this.repo.findOne(id).getMembers().remove(this.personRepo.findOne(id2));
		this.repo.saveAndFlush(this.repo.findOne(id));
		return this.repo.findOne(id);
	}
}
