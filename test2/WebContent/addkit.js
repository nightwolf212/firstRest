function addKitForm($scope,$http)
{

	$scope.fundsList=new Array();
	var buf="";
	$scope.data="";
	$scope.stringFunds=$http.get("fund").success(function(data,status){
	buf=data;
	$scope.data=data;
	$scope.fundsList=stringToListFund($scope.data);
	});
	$scope.reset=function()
	{
		$scope.kit.name="";
		$scope.kit.fundid=0;
		
	};
	
	$scope.save=function()
	{
		$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
		
		var data={
				kname: $scope.kit.name,
				fundId: $scope.kit.fundid
				
		};
		var data2=serializeData(data);
		$http.post("kit/add",data2,{}).success(function(data,status)
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
function Min(a,b)
{
	if(a<b)
		return a;
	return b;
	}
function kitsGeneral($scope,$http)
{
	$scope.orderProp='id';
	$scope.data=$http.get("kit").success(function(data,status){
		$scope.kitList=stringToListKit(data,$http);
	});
	$scope.ordByName=function()
	{
		$scope.orderProp='name';
	}
	$scope.ordByFund=function()
	{
		$scope.orderProp='fundId';
	}
	$scope.deleteKit=function(id)
	{
		var q=confirm("Вы уверены?");
		if(q)
			{
			var dat={id:id};
			var dat2=serializeData(dat);
			$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
			$scope.data=$http.post("kit/remove",dat2).success(function(data,status){
				$scope.data=$http.get("kit").success(function(data,status){
					$scope.kitList=stringToListKit(data,$http);});
				
			});
			}

	}

}
function kitsInFund($scope,$routeParams,$http)
{
	$scope.fundId=$routeParams.fundId;
	$scope.orderProp='name';
	$scope.data=$http.get("fund/"+$scope.fundId+"/kits").success(function(data,status){
		$scope.kitList=stringToListKit(data,$http);
		
	});
	$scope.deleteKit=function(id)
	{
		var q=confirm("Вы уверены?");
		if(q)
			{
			var dat={id:id};
			var dat2=serializeData(dat);
			$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
			$scope.data=$http.post("kit/remove",dat2).success(function(data,status){
				$scope.data=$http.get("kit").success(function(data,status){
					$scope.kitList=stringToListKit(data,$http);});
			});
			}

	}
	
	
}
function stringToListKit(mdata,$http)
{
	var res=new Array();
	var zp=-1;
	var p=-1;
	var fundInf=new Array();
	while(true)
	{
		zp=mdata.indexOf(",",zp+1);
		if(zp==-1)
			return res;
		var _id=mdata.substring(p+1,zp);
		var nextE=mdata.indexOf(",",zp+1);
		var knam=mdata.substring(zp+1,nextE);
		zp=nextE;
		nextE=mdata.indexOf(",",zp+1);
		var fund=mdata.substring(zp+1,nextE);
		zp=nextE;
		nextE=mdata.indexOf(",",zp+1);
		var free=mdata.substring(zp+1,nextE);
		zp=nextE;
		nextE=mdata.indexOf(",",zp+1);
		var fundId=mdata.substring(zp+1,nextE);
		zp=nextE;
		nextE=mdata.indexOf(",",zp+1);
		var fundName=mdata.substring(zp+1,nextE);
		p=nextE;
		zp=nextE;
		res.push({id:_id, kname:knam, fundName:fundName, fundid:fund, isfree:free});
			
	
		
	
	
		}
	
}
