angular.module('app').controller('PersonDetailController', ['PersonDetailService', 'person', '$routeParams', function(PersonDetailService, person, $routeParams)
{
	
	var ctrl = this
	
	ctrl.person = person.data
	
	ctrl.hasInterest = function(interest){ return(ctrl.person.interests.map(e=>e.id).includes(interest.id))}
	
	ctrl.belongsToGroup = function(group){ return(ctrl.person.groups.map(e=>e.id).includes(group.id))}
	
	ctrl.groupInCity = function(group){ return(angular.equals(ctrl.person.city, group.city))}
	
	ctrl.hasGroupInterest = function(group){ return(ctrl.person.interests.map(e=>e.id).includes(group.interest.id))}
	
	ctrl.backButton = function(){window.history.back()}
	
	ctrl.editButton = function(){location.href = (location.href + "/edit")}
	
	console.dir(ctrl.interests);
	
	//ctrl.save = PersonDetailService.editPersonDetails($routeParams.id, ctrl.person)
	
	//ctrl.delete = PersonDetailService.deletePersonDetails($routeParams.id, ctrl.person)
	
}]);



//Get cities dropdown working, and default value for States and fix checkboxes
