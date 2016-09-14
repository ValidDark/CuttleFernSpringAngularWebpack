angular.module('app').config(
		[
				'$routeProvider',
				'baseRoute',
				'homePage',
				function config($routeProvider, baseRoute, homePage) {

					$routeProvider.when('/home', {

						templateUrl : homePage,
						controller : 'HomeController',
						controllerAs : 'ctrl'

					}).when('/people', {

						templateUrl : baseRoute + 'person/PersonTemplate.html',
						controller : 'PersonController',
						controllerAs : 'ctrl',
						resolve : {
							allPeople : function(PersonService) {
								return PersonService.getAllPeople();
							}
						}

					}). when('/people/:id', {
			        	
			        	templateUrl: baseRoute + 'person/PersonDetailTemplate.html',
			        	controller: 'PersonDetailController',
			        	controllerAs: 'ctrl',
			        	resolve : {
			        		person : ['PersonDetailService', '$route', function(PersonDetailService, $route) {
								return PersonDetailService.getPersonDetails($route.current.params.id);
							}]
			        	}
			        }).when('/people/:id/edit', {
			        	
			        	templateUrl: baseRoute + 'person/PersonEditTemplate.html',
			        	controller: 'PersonEditController',
			        	controllerAs: 'ctrl',
			        	resolve : {
			        		person : ['PersonEditService', '$route', function(PersonEditService, $route) {
								return PersonEditService.getPersonDetails($route.current.params.id);
							}],
							allGroups : function(PersonEditService) {
								return PersonEditService.getAllGroups();
							},
							allStates : function(PersonEditService) {
								return PersonEditService.getAllStates();
							},
							allCities : function(PersonEditService) {
								return PersonEditService.getAllCities();
							},
							allInterests : function(PersonEditService) {
								return PersonEditService.getAllInterests();
							}
			        	}
			        }).when('/states', {

						templateUrl : baseRoute + 'state/StateTemplate.html',
						controller : 'StateController',
						controllerAs : 'ctrl',
						resolve : {
							allStates : function(StateService) {
								return StateService.getAllStates();
							}
						}
					}).when('/states/:id', {
			        	
			        	templateUrl: baseRoute + 'state/StateDetailTemplate.html',
			        	controller: 'StateDetailController',
			        	controllerAs: 'ctrl',
			        	resolve : {
			        		State : ['StateDetailService', '$route', function(StateDetailService, $route) {
								return StateDetailService.getStateDetails($route.current.params.id);
							}],
							allCities : function(StateDetailService) {
								return StateDetailService.getAllCities();
							}
			        	}
			        }).when('/states/:id/edit', {
			        	
			        	templateUrl: baseRoute + 'state/StateEditTemplate.html',
			        	controller: 'StateEditController',
			        	controllerAs: 'ctrl',
			        	resolve : {
			        		State : ['StateDetailService', '$route', function(StateEditService, $route) {
								return StateEditService.getStateDetails($route.current.params.id);
							}],
							allCities : function(StateEditService) {
								return StateEditService.getAllCities();
							}
			        	}
			        }).when('/cities', {

						templateUrl : baseRoute + 'city/CityTemplate.html',
						controller : 'CityController',
						controllerAs : 'ctrl',
						resolve : {
							allCities : function(CityService) {
								return CityService.getAllCities();
							},
							allStates : function(CityService) {
								return CityService.getAllStates();
							}
						}
					}).when('/groups', {

						templateUrl : baseRoute + 'group/GroupTemplate.html',
						controller : 'GroupController',
						controllerAs : 'ctrl',
						resolve : {
							allGroups : function(GroupService) {
								return GroupService.getAllGroups();
							}
						}
					}).when('/interests', {

						templateUrl : baseRoute + 'interest/InterestTemplate.html',
						controller : 'InterestController',
						controllerAs : 'ctrl',
						resolve : {
							allInterests : function(InterestService) {
								return InterestService.getAllInterests();
							}
						}
					}).when('/create/people', {
			        	
			        	templateUrl: baseRoute + 'person/PersonNewTemplate.html',
			        	controller: 'PersonNewController',
			        	controllerAs: 'ctrl',
			        	resolve : {
							allGroups : function(PersonEditService) {
								return PersonEditService.getAllGroups();
							},
							allStates : function(PersonEditService) {
								return PersonEditService.getAllStates();
							},
							allCities : function(PersonEditService) {
								return PersonEditService.getAllCities();
							},
							allInterests : function(PersonEditService) {
								return PersonEditService.getAllInterests();
							}
			        	}
			        }).when('/create/state', {
			        	
			        	templateUrl: baseRoute + 'state/StateNewTemplate.html',
			        	controller: 'StateNewController',
			        	controllerAs: 'ctrl',
			        	resolve : {
							allCities : function(StateNewService) {
								return StateNewService.getAllCities();
							}
			        	}
			        }).otherwise('/home');
				} ]);