package com.cooksys.cuttlefern.ws.domain.social;

import java.util.List;
import java.util.Set;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.location.City;

public interface PersonService {

	List<Person> index();

	Person create(Person person);

///////////////////////////////////////////////////////////////////////////////

	Person read(Integer id);

	Person update(Integer id, Person personToUpdate);

	Person delete(Integer id);

///////////////////////////////////////////////////////////////////////////////

	City readCity(Integer id);

	Person updateCity(Integer id, City city);

///////////////////////////////////////////////////////////////////////////////

	Set<Interest> readInterests(Integer id);

	Person newInterest(Integer id, Interest interest);

	Person removeInterest(Integer id, Integer id2);

///////////////////////////////////////////////////////////////////////////////

	Set<Group> readGroups(Integer id);

	Person removeGroup(Integer id, Integer id2);

	Person addToGroup(Person id, Group groupId);


}
