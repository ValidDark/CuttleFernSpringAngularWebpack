angular.module('app').service('StateService', function($http){

	var url = 'api/states/'
	
	this.getAllStates = function() { return $http.get(url) }

});