angular.module('app').controller('StateController', ['StateService', 'allStates', '$location', function StateController(StateService, allStates, $location) {

	var ctrl = this;
	
	ctrl.states = allStates.data
	
	console.dir(ctrl.states)
	
	ctrl.backButton = function(){window.history.back()}
	
	ctrl.new = function() {
//		let newState = {
//				  "name": "",
//				  "city": {
//					  "name": "",
//					  "state": {
//						  "name": ""
//						}
//					},
//				  "interests": [],
//				  "groups": []
//						}
//	ctrl.people.push(newState)
//	
//	let index = 0
//	
//	ctrl.people.forEach( function(e){if(e.id>=index) index = e.id})
//			
//		
//	index += 1;
	console.log("going to: create/people")
	$location.path("create/state")
	console.log(location.href)
	}
	
}]);