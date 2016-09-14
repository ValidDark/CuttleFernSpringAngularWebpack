angular.module('app').controller('StateEditController', ['StateEditService', 'State', 'allCities', '$routeParams', function(StateEditService, State, allCities, $routeParams)
{
	
	var ctrl = this
	
	ctrl.state = State.data
	
	ctrl.cities = allCities.data
	
	ctrl.cityInState = function(city)
	{
		return (city.state.id === ctrl.state.id)

	}
	
	ctrl.backButton = function(){window.history.back()}
	
	//ctrl.editButton = function(){location.href = (location.href + "/edit")}
	

}]);

