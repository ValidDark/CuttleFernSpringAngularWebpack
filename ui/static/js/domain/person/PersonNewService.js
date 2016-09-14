angular.module('app').service('PersonNewService', ['$http', function($http) {

	var url = 'api/people/';

	this.newPerson = function(person) { return () => { $http.post(url, person) } }
	
	this.getAllInterests = function() { return $http.get('api/interests/') }
	
	this.getAllGroups = function() { return $http.get('api/groups/') }
	
	this.getAllStates = function() { return $http.get('api/states/') }
	
	this.getAllCities = function() { return $http.get('api/cities/') }
	
}])
