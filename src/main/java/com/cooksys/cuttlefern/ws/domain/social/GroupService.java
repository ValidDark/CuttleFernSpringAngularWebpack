package com.cooksys.cuttlefern.ws.domain.social;

import java.util.List;
import java.util.Set;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.location.City;

public interface GroupService {

	List<Group> index();

	Group create(Group group);

///////////////////////////////////////////////////////////////////////////////

	Group read(Integer id);

	Group update(Integer id, Group groupToUpdate);

	Group delete(Integer id);

///////////////////////////////////////////////////////////////////////////////

	City readCity(Integer id);

	Group updateCity(Integer id, City city);

///////////////////////////////////////////////////////////////////////////////

	Interest readInterest(Integer id);

	Group updateInterest(Integer id, Interest interest);

///////////////////////////////////////////////////////////////////////////////

	Set<Person> readMembers(Integer id);

	Group newMember(Integer id, Person member);

	Group removeMember(Integer id, Integer id2);

}
