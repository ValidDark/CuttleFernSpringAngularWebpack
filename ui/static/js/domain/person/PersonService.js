angular.module('app').service('PersonService', function($http){

	var url = 'api/people/'
	
	this.getAllPeople = function() { return $http.get(url) }

});