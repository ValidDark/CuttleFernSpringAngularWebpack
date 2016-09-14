angular.module('app').service('InterestService', function($http){

	var url = 'api/interests'
	
	this.getAllInterests = function() { return $http.get(url) }
	
	


});