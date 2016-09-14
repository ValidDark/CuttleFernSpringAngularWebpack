package com.cooksys.cuttlefern.ws.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.cuttlefern.ws.domain.location.City;
import com.cooksys.cuttlefern.ws.domain.location.CityService;
import com.cooksys.cuttlefern.ws.domain.location.State;

@RestController
@RequestMapping("api/cities")
public class CityController {


	private final CityService service;
	
	@Autowired
	public CityController(CityService service) {
		super();
		this.service = service;
	}

///////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(method = RequestMethod.GET)
	public List<City> index() {
		return this.service.index();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public City create(@RequestBody City city) {
		return this.service.create(city);
	}
	
///////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public City read(@PathVariable Integer id) {
		return this.service.read(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public City update(@PathVariable Integer id, @RequestBody City cityToUpdate) {
		return this.service.update(id, cityToUpdate);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public City delete(@PathVariable Integer id) {
		return this.service.delete(id);
	}
	
///////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/{id}/state", method = RequestMethod.GET)
	public State getState(@PathVariable Integer id) {
		return this.service.readState(id);
	}

	@RequestMapping(value = "/{id}/state", method = RequestMethod.PUT)
	public City editState(@PathVariable Integer id, @RequestBody State state) {
		return this.service.editState(id, state);
	}
	
}
