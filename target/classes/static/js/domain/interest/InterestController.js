angular.module('app').controller('InterestController', ['InterestService', 'allInterests', '$location', function InterestController(InterestService, allInterests, $location) {

	var ctrl = this;
	
	ctrl.interests = allInterests.data
	
	console.dir(ctrl.interests)
	
	ctrl.backButton = function(){window.history.back()}
	
	ctrl.new = function() {

	console.log("going to: create/interest")
	$location.path("create/interest")
	console.log(location.href)
	}
	
}]);