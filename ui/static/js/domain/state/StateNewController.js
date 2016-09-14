angular.module('app').controller('StateNewController', ['StateNewService', 'allCities', '$routeParams', function(StateNewService, allCities, $routeParams)
{
	
	var ctrl = this
	
	ctrl.state = {
			  "name": ""
			}
	
	ctrl.cities = allCities.data
	
	ctrl.cityInState = function(city)
	{
		return (city.state.id === ctrl.state.id)

	}
	
	ctrl.backButton = function(){window.history.back()}
	
	//ctrl.editButton = function(){location.href = (location.href + "/edit")}
	

}]);

