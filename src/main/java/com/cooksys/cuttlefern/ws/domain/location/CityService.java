package com.cooksys.cuttlefern.ws.domain.location;

import java.util.List;

public interface CityService {

	List<City> index();

	City create(City city);
	
///////////////////////////////////////////////////////////////////////////////

	City read(Integer id);

	City update(Integer id, City cityToUpdate);

	City delete(Integer id);

///////////////////////////////////////////////////////////////////////////////
	
	State readState(Integer id);

	City editState(Integer id, State state);
	
///////////////////////////////////////////////////////////////////////////////

	

}
