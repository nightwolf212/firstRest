function addExhibitForm($scope,$http)
{
	
	$scope.autList=new Array();
	$scope.kitList=new Array();
	$scope.ordr='name';
	$scope.data=$http.get("author").success(function(data,status){
		$scope.autList=stringToListAut(data);
	});
	$scope.data=$http.get("kit").success(function(data,status){
		$scope.kitList=stringToListKit(data,$http);
	});
	$scope.reset=function()
	{
		$scope.exhibit.name="";
		$scope.exhibit.kitid="";
		$scope.exhibit.autid="";
		$scope.exhibit.date="";
		$scope.exhibit.resp="";
		
		
	};
	
	$scope.save=function()
	{
		if($scope.exhibit.name.length==0)
		{
		alert("Укажите название");
		return;
		}
	if($scope.exhibit.date.length!=4)
	{
	alert("Укажите дату в формате ГГГГ");
	return;
	}
	if($scope.exhibit.resp.length==0)
	{
	alert("Укажите ответственное лицо");
	return;
	}
for(var i=0; i<$scope.exhibit.name.length; i++)
	{
		if($scope.exhibit.name.charAt(i)==',')
			{
				alert("Название не должно содержать запятых");
				return;
			}
	}
for(var i=0; i<$scope.exhibit.date.length; i++)
{
	if(!($scope.exhibit.date.charAt(i)<='9' &&$scope.exhibit.date.charAt(i)>='0'))
		{
			alert("Укажите дату в формате ГГГГ");
			return;
		}
}
for(var i=0; i<$scope.exhibit.resp.length; i++)
{
	if($scope.exhibit.resp.charAt(i)==',')
		{
			alert("Имя ответственного лица не должно содержать запятых");
			return;
		}
}
		$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
		
		var data={
				ename: $scope.exhibit.name,
				datey: $scope.exhibit.date,
				autId: $scope.exhibit.autid,
				respName: $scope.exhibit.resp, 
				kitId: $scope.exhibit.kitid,
				
		};
		var data2=serializeData(data);
		$http.post("exhibit/add",data2,{}).success(function(data,status)
				{
				alert(status);
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
function Min(a,b)
{
	if(a<b)
		return a;
	return b;
	}
function exhibitsGeneral($scope,$http)
{
	$scope.data=$http.get("exhibit").success(function(data,status){
		$scope.exhibitList=stringToListExhibit(data,$http);});
	$scope.orderProp='name';
	$scope.ordByName=function()
	{
		$scope.orderProp='name';
	}
	$scope.ordByDate=function()
	{
		$scope.orderProp='date';
	}
	$scope.ordByAuth=function()
	{
		$scope.orderProp='authorName';
	}
	$scope.ordByResp=function()
	{
		$scope.orderProp='respName';
	}
	$scope.ordByKit=function()
	{
		$scope.orderProp='kitName';
	}
	$scope.deleteExhib=function(id)
	{
		var q=confirm("Вы уверены?");
		if(q)
			{
			var dat={id:id};
			var dat2=serializeData(dat);
			$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
			$scope.data=$http.post("exhibit/remove",dat2).success(function(data,status){
				$scope.data=$http.get("exhibit").success(function(data,status){
					$scope.exhibitList=stringToListExhibit(data,$http);});
				
			});
			}

	}
	
	
}
function exhibitInKit($scope,$routeParams,$http)
{
	
	$scope.data=$http.get("kit/"+$routeParams.kitId+"/exhibits").success(function(data,status){
		$scope.exhibitList=stringToListExhibit(data,$http);});
	
	$scope.ordByName=function()
	{
		$scope.orderProp='name';
	}
	$scope.ordByDate=function()
	{
		$scope.orderProp='date';
	}
	$scope.ordByAuth=function()
	{
		$scope.orderProp='authorName';
	}
	$scope.ordByResp=function()
	{
		$scope.orderProp='respName';
	}
	$scope.ordByKit=function()
	{
		$scope.orderProp='kitName';
	}
	$scope.deleteExhib=function(id)
	{
		var q=confirm("Вы уверены?");
		if(q)
			{
			var dat={id:id};
			var dat2=serializeData(dat);
			$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
			$scope.data=$http.post("exhibit/remove",dat2).success(function(data,status){
				$scope.data=$http.get("exhibit").success(function(data,status){
					$scope.exhibitList=stringToListExhibit(data,$http);});
				
			});
			}

	}
	
}
function stringToListExhibit(mdata,$http)
{
	var res=new Array();
	var zp=-1;
	var p=-1;
	while(true)
	{
		zp=mdata.indexOf(",",zp+1);
		if(zp==-1)
			return res;
		var _id=mdata.substring(p+1,zp);
		var nextE=mdata.indexOf(",",zp+1);
		var nam=mdata.substring(zp+1,nextE);
		zp=nextE;
		nextE=mdata.indexOf(",",zp+1);
		var ktId=mdata.substring(zp+1,nextE);
		zp=nextE;
		nextE=mdata.indexOf(",",zp+1);
		var dat=mdata.substring(zp+1,nextE);
		zp=nextE;
		nextE=mdata.indexOf(",",zp+1);
		var authId=mdata.substring(zp+1,nextE);
		zp=nextE;
		nextE=mdata.indexOf(",",zp+1);
		var resp=mdata.substring(zp+1,nextE);
		zp=nextE;
		nextE=mdata.indexOf(",",zp+1);
		var free=mdata.substring(zp+1,nextE);
		zp=nextE;
		nextE=mdata.indexOf(",",zp+1);
		var kitId=mdata.substring(zp+1,nextE);
		zp=nextE;
		nextE=mdata.indexOf(",",zp+1);
		var kitName=mdata.substring(zp+1,nextE);
		zp=nextE;
		nextE=mdata.indexOf(",",zp+1);
		var fundId=mdata.substring(zp+1,nextE);
		zp=nextE;
		nextE=mdata.indexOf(",",zp+1);
		var kitFree=mdata.substring(zp+1,nextE);
		zp=nextE;
		nextE=mdata.indexOf(",",zp+1);
		var authorId=mdata.substring(zp+1,nextE);
		zp=nextE;
		nextE=mdata.indexOf(",",zp+1);
		var authorName=mdata.substring(zp+1,nextE);
		zp=nextE;
		nextE=mdata.indexOf(",",zp+1);
		var authorBirth=mdata.substring(zp+1,nextE);
		zp=nextE;
		nextE=mdata.indexOf(",",zp+1);
		var authorCountr=mdata.substring(zp+1,nextE);
		p=nextE;
		zp=nextE;
		res.push({id:_id, name:nam, kitId:kitId,date:dat,authorId:authorId,respName:resp,isFree:free,kitName:kitName,authorName:authorName});
				
	}
}
function exhibitByAut($scope,$routeParams,$http)
{
	$scope.data=$http.get("author/"+$routeParams.autId+"/exhibits").success(function(data,status){
		$scope.exhibitList=stringToListExhibit(data,$http);
	});
	
	$scope.ordByName=function()
	{
		$scope.orderProp='name';
	}
	$scope.ordByDate=function()
	{
		$scope.orderProp='date';
	}
	
	$scope.ordByResp=function()
	{
		$scope.orderProp='respName';
	}
	$scope.ordByKit=function()
	{
		$scope.orderProp='kitName';
	}
	$scope.deleteExhib=function(id)
	{
		var q=confirm("Вы уверены?");
		if(q)
			{
			var dat={id:id};
			var dat2=serializeData(dat);
			$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
			$scope.data=$http.post("exhibit/remove",dat2).success(function(data,status){
				$scope.data=$http.get("exhibit").success(function(data,status){
					$scope.exhibitList=stringToListExhibit(data,$http);});
				
			});
			}

	}

}
	
