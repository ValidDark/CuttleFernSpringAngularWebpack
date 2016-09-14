angular.module('app').service('PersonDetailService', ['$http', function($http) {

	var url = 'api/people/';
	
	this.getPersonDetails = function(id) { return $http.get(url + id) }

	this.getAllInterests = function() { return $http.get('api/interests/') }
	
	this.getAllGroups = function() { return $http.get('api/groups/') }
}])
