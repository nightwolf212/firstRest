function addAutForm($scope,$http)
{
	$scope.reset=function()
	{
		$scope.user.fio="";
		$scope.user.date="";
		$scope.user.country="";
	};

	$scope.save=function()
	{
		$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
		var year="";
		var month="";
		var day="";
		year=$scope.user.date.substring(0, 4);
		month=$scope.user.date.substring(5,7);
		day=$scope.user.date.substring(8,10);
		
		var data={
				fio: $scope.user.fio,
				datey: year,
				datem: month,
				dated: day,
				country: $scope.user.country
		
		};
		var data2=serializeData(data);
		$http.post("author/add",data2,{}).success(function(data,status)
				{
				alert("OK");
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
function authorList($scope,$http)
{
$scope.authors="";	
$scope.data=$http.get("author").success(function(data,status){
	$scope.authors=stringToListAut(data);
});
$scope.orderProp='name';
$scope.ordByName=function ()
{
	$scope.orderProp='name';
};
$scope.ordByBirth=function ()
{
	$scope.orderProp='birth';
};
$scope.ordByCountry=function ()
{
	$scope.orderProp='country';
};
$scope.deleteAut=function(id)
{
	var q=confirm("Вы уверены?");
	if(q)
		{
		var dat={id:id};
		var dat2=serializeData(dat);
		$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
		$scope.data=$http.post("author/remove",dat2).success(function(data,status){
			$scope.data=$http.get("author").success(function(data,status){
				$scope.authors=stringToListAut(data,$http);});
			
		});
		}

}
}

function stringToListAut(data)
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
		var nam=data.substring(zp+1,nextE);
		zp=nextE;
		nextE=data.indexOf(",",zp+1);
		var birt=data.substring(zp+1,nextE);
		zp=nextE;
		nextE=data.indexOf(",",zp+1);
		var countr=data.substring(zp+1,nextE);
		p=nextE;
		zp=nextE;
		res.push({id:_id, name:nam, country:countr, birth:birt});
		
	}
	
}
