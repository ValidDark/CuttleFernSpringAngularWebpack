angular.module('app').controller('PersonController', ['PersonService', 'allPeople', '$location', function PersonController(PersonService, allPeople, $location) {

	var ctrl = this;
	
	ctrl.people = allPeople.data
	
	console.dir(ctrl.people)
	
	ctrl.backButton = function(){window.history.back()}
	
	ctrl.new = function() {
//		let newPerson = {
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
//	ctrl.people.push(newPerson)
//	
//	let index = 0
//	
//	ctrl.people.forEach( function(e){if(e.id>=index) index = e.id})
//			
//		
//	index += 1;
	console.log("going to: create/people")
	$location.path("create/people")
	console.log(location.href)
	}
	
}]);