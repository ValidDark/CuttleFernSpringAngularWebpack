package com.cooksys.cuttlefern.ws.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.cuttlefern.ws.domain.interest.Interest;
import com.cooksys.cuttlefern.ws.domain.interest.InterestService;
import com.cooksys.cuttlefern.ws.domain.location.State;
import com.cooksys.cuttlefern.ws.domain.location.StateService;

@RestController
@RequestMapping("api/states")
public class StateController {


private final StateService service;
	
@Autowired
public StateController(StateService service) {
	super();
	this.service = service;
}

///////////////////////////////////////////////////////////////////////////////

	@RequestMapping (method = RequestMethod.GET)
	public List<State> index() {
		return this.service.index();
	}

	@RequestMapping (method = RequestMethod.POST)
	public State Create(@RequestBody State state) {
		return this.service.create(state);
	}
	
///////////////////////////////////////////////////////////////////////////////

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public State read(@PathVariable Integer id) {
		return this.service.read(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public State update(@PathVariable Integer id, @RequestBody State stateToUpdate) {
		return this.service.update(id, stateToUpdate);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public State delete(@PathVariable Integer id) {
		return this.service.delete(id);
	}

}
