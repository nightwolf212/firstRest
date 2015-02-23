angular.module('kitroute', []).
  config(['$routeProvider', 
  function($routeProvider) {
    $routeProvider.
        when('/kits', {
          templateUrl: 'kits-list.html',
          controller: 'kitsGeneral'}).
        when('/kitsinfund/:fundId', {
          templateUrl: 'kitsinfund.html', 
          controller: 'kitsInFund'
        }).
        otherwise({
          redirectTo: '/kits'
        });
  }]);