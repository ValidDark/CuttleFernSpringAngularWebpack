package com.cooksys.cuttlefern.ws.domain.social.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.interest.InterestRepository;
import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.social.Group;
import com.cooksys.cuttlefern.ws.domain.social.GroupRepository;
import com.cooksys.cuttlefern.ws.domain.social.Person;
import com.cooksys.cuttlefern.ws.domain.social.PersonRepository;
import com.cooksys.cuttlefern.ws.domain.social.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	private final PersonRepository repo;
	private final InterestRepository interestRepo;
	private final GroupRepository groupRepo;

	@Autowired
	public PersonServiceImpl(PersonRepository repo, InterestRepository interestRepo, GroupRepository groupRepo) {
		super();
		this.repo = repo;
		this.interestRepo = interestRepo;
		this.groupRepo = groupRepo;
	}

///////////////////////////////////////////////////////////////////////////////

	@Override
	public List<Person> index() {
		return this.repo.findAll();
	}

	@Override
	public Person create(Person person) {
		return this.repo.save(person);
	}

///////////////////////////////////////////////////////////////////////////////

	@Override
	public Person read(Integer id) {
		return this.repo.findOne(id);
	}

	@Override
	public Person update(Integer id, Person personToUpdate) {
		personToUpdate.setId(id);
		return this.repo.save(personToUpdate);
	}

	@Override
	public Person delete(Integer id) {
		Person result = this.read(id);
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
	public Person updateCity(Integer id, City city) {
		this.repo.findOne(id).setCity(city);
		repo.saveAndFlush(this.repo.findOne(id));
		return this.repo.findOne(id);
	}

///////////////////////////////////////////////////////////////////////////////

	@Override
	public Set<Interest> readInterests(Integer id) {
		return this.repo.findOne(id).getInterests();
	}

	@Override
	public Person newInterest(Integer id, Interest interest) {
		this.repo.findOne(id).getInterests().add(interest);
		this.repo.saveAndFlush(this.repo.findOne(id));
		return this.repo.findOne(id);
	}

	@Override
	public Person removeInterest(Integer id, Integer id2) {
		this.repo.findOne(id).getInterests().remove(this.interestRepo.findOne(id2));
		interestRepo.findOne(id2).getPeople().remove(repo.findOne(id));
		interestRepo.saveAndFlush(interestRepo.findOne(id2));
		return this.repo.findOne(id);
	}

///////////////////////////////////////////////////////////////////////////////

	@Override
	public Set<Group> readGroups(Integer id) {
		return this.repo.findOne(id).getGroups();

	}


	@Override
	public Person removeGroup(Integer id, Integer id2) {
		this.repo.findOne(id).getGroups().remove(this.groupRepo.findOne(id2));
		groupRepo.findOne(id2).getMembers().remove(repo.findOne(id));
		groupRepo.saveAndFlush(groupRepo.findOne(id2));
		return this.repo.findOne(id);
	}

	@Override
	public Person addToGroup(Person id, Group groupId) {
		id.getGroups().add(groupId);
		groupId.getMembers().add(id);
		groupRepo.saveAndFlush(groupId);
		return id;
	}
}
