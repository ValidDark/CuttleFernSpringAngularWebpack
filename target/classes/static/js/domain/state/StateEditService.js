angular.module('app').service('StateEditService', ['$http', function($http) {

	var url = 'api/states/';
	
	this.getStateDetails = function(id) { return $http.get(url + id) }

	this.getAllCities = function() { return $http.get('api/cities/') }
}])
