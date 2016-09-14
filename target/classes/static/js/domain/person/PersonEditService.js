angular.module('app').service('PersonEditService', ['$http', function($http) {

	var url = 'api/people/';
	
	this.getPersonDetails = function(id) { return $http.get(url + id) }

	this.newPerson = function(person) { return () => { $http.post(url, person) } }
	
	this.getAllInterests = function() { return $http.get('api/interests/') }
	
	this.getAllGroups = function() { return $http.get('api/groups/') }
	
	this.getAllStates = function() { return $http.get('api/states/') }
	
	this.getAllCities = function() { return $http.get('api/cities/') }
	
	this.editPersonDetails = function(id, person) { return () => { $http.patch(url + id, person) } }
	
	this.deletePersonDetails = function(id, person) { return () => { $http.delete(url + id, person) } }

	
}])
