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
		if($scope.user.date.length!=10)
		{
		alert("Дата должа быть в формате ГГГГ-ММ-ДД");
		return;
		
		}
	for(var i=0; i<4; i++)
		{
			if(!($scope.user.date.charAt(i)<='9'&&$scope.user.date.charAt(i)>='0'))
				{
				alert("Дата должа быть в формате ГГГГ-ММ-ДД");
				return;
				}
		}
	for(var i=5; i<7; i++)
	{
		if(!($scope.user.date.charAt(i)<='9'&&$scope.user.date.charAt(i)>='0'))
			{
			alert("Дата должа быть в формате ГГГГ-ММ-ДД");
			return;
			}
	}
	for(var i=8; i<10; i++)
	{
		if(!($scope.user.date.charAt(i)<='9'&&$scope.user.date.charAt(i)>='0'))
			{
			alert("Дата должа быть в формате ГГГГ-ММ-ДД");
			return;
			}
	}
	if(!($scope.user.date.charAt(4)=='-'&&$scope.user.date.charAt(7)=='-'))
		{
		alert("Дата должа быть в формате ГГГГ-ММ-ДД");
		return;
		}
	
		year=$scope.user.date.substring(0, 4);
		month=$scope.user.date.substring(5,7);
		day=$scope.user.date.substring(8,10);
		if($scope.user.fio.length==0)
		{
			alert("Укажите ФИО");
			return;
		}
		if($scope.user.country.length==0)
		{
			alert("Укажите страну");
			return;
		}
		for(var i=0; i<$scope.user.fio.length; i++)
			{
				if($scope.user.fio.charAt(i)==',')
					{
					alert("ФИО не должно содержать запятых");
					return;
					}
			}
		for(var i=0; i<$scope.user.country.length; i++)
		{
			if($scope.user.country.charAt(i)==',')
				{
				alert("Страна не должно содержать запятых");
				return;
				}
		}
	
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
