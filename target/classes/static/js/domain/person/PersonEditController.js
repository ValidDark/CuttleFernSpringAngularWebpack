angular.module('app').controller('PersonEditController', ['PersonEditService', 'person', 'allGroups', 'allInterests', 'allStates', 'allCities', '$scope', '$routeParams', function(PersonEditService, person, allGroups, allInterests, allStates, allCities, $scope, $routeParams)
{
	
	var ctrl = this
	
	ctrl.person = person.data
	
	ctrl.interests = allInterests.data
	
	ctrl.groups = allGroups.data
	
	ctrl.interested = []
	
	let personGroupMap = ctrl.person.groups.map(e=> e.id );
	
	ctrl.groups.forEach(ele => {
		if(personGroupMap.includes(ele.id))
			ctrl.grouped[ele.id] = true;
	})
	
	let personInterestMap = ctrl.person.interests.map(e=> e.id );
	
	ctrl.interests.forEach(ele => {
		if(personInterestMap.includes(ele.id))
			ctrl.interested[ele.id] = true;
	})
	
	ctrl.grouped = []
	
	
	ctrl.states = allStates.data
	
	ctrl.cities = allCities.data
	
	ctrl.stateSelected = function(state)
	{
		ctrl.person.city.state = state
		ctrl.person.city.name = "----"
	}
	
	ctrl.citySelected = function(city)
	{
		ctrl.person.city = city;
	}
	
	ctrl.cityInState = function(city)
	{
		return (city.state.id === ctrl.person.city.state.id)

	}
	
	ctrl.hasInterest = function(interest){ return(ctrl.person.interests.map(e=>e.id).includes(interest.id))}
	
	ctrl.belongsToGroup = function(group){ return(ctrl.person.groups.map(e=>e.id).includes(group.id))}
	
	ctrl.groupInCity = function(group){ return(angular.equals(ctrl.person.city, group.city))}
	
	ctrl.hasGroupInterest = function(group){ return(ctrl.person.interests.map(e=>e.id).includes(group.interest.id))}
	
	ctrl.backButton = function(){window.history.back()}
	
	ctrl.editButton = function(){location.href = (location.href + "/edit")}
	
	ctrl.save = PersonEditService.editPersonDetails($routeParams.id, ctrl.person)
	
	ctrl.delete = PersonEditService.deletePersonDetails($routeParams.id, ctrl.person)
	
	ctrl.interestToggled = function(interest){
		let index = ctrl.person.interests.map(e=>e.id).indexOf(interest.id)
		console.log(index)
		if( index != -1)
			{
				ctrl.person.interests.splice(index, 1)
			}
		else
			{
			ctrl.person.interests.push(interest)
			}
	}
	
	ctrl.groupToggled = function(group){
		let index = ctrl.person.groups.map(e=>e.id).indexOf(group.id)
		console.log(index)
		if( index != -1)
			{
				ctrl.person.groups.splice(index, 1)
			}
		else
			{
			ctrl.person.groups.push(group)
			}
	}
	
}]);




