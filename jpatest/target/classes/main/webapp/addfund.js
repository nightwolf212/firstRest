function addFundForm($scope,$http)
{
	$scope.reset=function()
	{
		$scope.fund.name="";
	};

	$scope.save=function()
	{	if ($scope.fund.name.length==0)
	{
		alert("Укажите название фонда");
		return;
		}
	for(var i=0; i<$scope.fund.name.length; i++)
		if($scope.fund.name.charAt(i)==',')
			{
			alert("Название не должно содержать запятых");
			return;
			}

		$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
	
		var data={
				fname: $scope.fund.name,
		
		};
		var data2=serializeData(data);
		$http.post("fund/add",data2,{}).success(function(data,status)
				{
				alert("ОК");
				});
	};	
	
}
function serializeData( data ) {
	 

    var buffer = [];

    // Serialize each key in the object.
    for ( var name in data ) {

        var value = data[ name ];

        buffer.push(
            encodeURIComponent( name ) +
            "=" +
            encodeURIComponent(  value )
        );

    }
    var source = buffer
        .join( "&" )
        .replace( /%20/g, "+" )
    ;

    return( source );

}
function fundController($scope,$http)
{
	$scope.orderProp="name";
$http.get("fund").success(function(data,status)
		{
			$scope.fundList=stringToListFund(data);
		});	
$scope.deleteFund=function(id)
{
	var q=confirm("Вы уверены?");
	if(q)
		{
		var dat={id:id};
		var dat2=serializeData(dat);
		$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
		$scope.data=$http.post("fund/remove",dat2).success(function(data,status){
			$scope.data=$http.get("fund").success(function(data,status){
				$scope.fundList=stringToListFund(data,$http);});
			
		});
		}

}
}
function stringToListFund(data)
{
	var res=new Array();
	var zp=-1;
	var p=-1;
	while(true)
	{
		zp=data.indexOf(",",zp+1);
		if(zp==-1)
			return res;
		var _id=data.substring(p+1,zp);
		var nextE=data.indexOf(",",zp+1);
		if(nextE==-1)
			nextE=data.length;
		var nam=data.substring(zp+1,nextE);
		p=nextE;
		zp=nextE;
		res.push({id:_id, name:nam});
		
	}
	
}