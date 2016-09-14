angular.module('app').controller('CityController', ['CityService', 'allStates', 'allCities', '$location', function CityController(CityService, allStates, allCities, $location) {

	var ctrl = this;
	
	ctrl.cities = allCities.data
	
	ctrl.states = allStates.data
	
	ctrl.cityInState = function(city, state){return city.state.id === state.id}
	
	console.dir(ctrl.cities)
	
	ctrl.backButton = function(){window.history.back()}
	
	ctrl.new = function() {

	console.log("going to: create/city")
	$location.path("create/city")
	console.log(location.href)
	}
	
}]);