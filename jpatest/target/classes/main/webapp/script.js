function myF($scope) 
{
 var responseData;
    $http.get('http://localhost:8080/simple-rest/greeting').then(function(response){
        responseData = response.data;
    });
$scope.data='12';
}
