angular.module('app').service('GroupService', function($http){

	var url = 'api/groups/'
	
	this.getAllGroups = function() { return $http.get(url) }


});