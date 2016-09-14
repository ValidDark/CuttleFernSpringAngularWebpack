angular.module('app').service('StateNewService', ['$http', function($http) {

	var url = 'api/states/';
	
	this.getAllCities = function() { return $http.get('api/cities/') }
}])
