angular.module('app').controller('GroupController', ['GroupService', 'allGroups', '$location', function GroupController(CityService, allGroups, $location) {

	var ctrl = this;
	
	ctrl.groups = allGroups.data
	
	console.dir(ctrl.groups)
	
	ctrl.backButton = function(){window.history.back()}
	
	ctrl.new = function() {

	console.log("going to: create/group")
	$location.path("create/group")
	console.log(location.href)
	}
	
}]);