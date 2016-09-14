package com.cooksys.cuttlefern.ws.domain.location;

import java.util.List;

public interface StateService {

	List<State> index();

	State create(State state);

///////////////////////////////////////////////////////////////////////////////

	State read(Integer id);

	State update(Integer id, State stateToUpdate);

	State delete(Integer id);

}
