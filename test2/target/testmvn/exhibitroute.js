angular.module('exhibroute', []).
  config(['$routeProvider', 
  function($routeProvider) {
    $routeProvider.
        when('/exhibits', {
          templateUrl: 'exhibit-list.html',
          controller: 'exhibitsGeneral'}).
        when('/exhibits/:kitId', {
          templateUrl: 'exhibinkit.html', 
          controller: 'exhibitInKit'
        }).when('/exhibits/aut/:autId', {
            templateUrl: 'exhibbyaut.html', 
            controller: 'exhibitByAut'
          }).
        otherwise({
          redirectTo: '/exhibits'
        });
  }]);