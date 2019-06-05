<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<title>定位+纠偏</title>
<style type="text/css">
*{
    margin:0px;
    padding:0px;
}
body, button, input, select, textarea {
    font: 12px/16px Verdana, Helvetica, Arial, sans-serif;
}
#container{
  min-width:600px;
  min-height:767px;
}
</style>
<script charset="utf-8" src="https://map.qq.com/api/js?v=2.exp&key=45XBZ-VP534-5PBUT-DHH5M-XWTUJ-MMF34&libraries=convertor"></script>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script>
function getLocation(){
	//判断是否支持 获取本地位置
	if (navigator.geolocation){
		navigator.geolocation.getCurrentPosition(showPosition);
	}else{
		x.innerHTML="浏览器不支持定位.";
	}
}

function showPosition(position){
	//纬度
	var lat=position.coords.latitude;
	//经度
	var lng=position.coords.longitude;
	//定位对象
	var center = new qq.maps.LatLng(lat,lng);
	var test = new qq.maps.LatLng(30.962602,118.287267);
	//纠正后的定位对象。
	var correctCenter;
	console.log(lat);
	console.log(lng);
	//调用地图命名空间中的转换接口,会纠正经纬度。   type的可选值为 1:GPS经纬度，2:搜狗经纬度，3:百度经纬度，4:mapbar经纬度，5:google经纬度，6:搜狗墨卡托
	qq.maps.convertor.translate(test, 3, function(res){
	//取出经纬度并且赋值
	latlng = res[0];
	correctCenter = new qq.maps.LatLng(res[0].lat,res[0].lng)
	console.log(latlng);
	//绘制地图
	var map = new qq.maps.Map(document.getElementById("container"),{
			center:  latlng,
			zoom: 13
    	});
	
	//设置marker标记
	var marker = new qq.maps.Marker({
			map : map,
			position : latlng
        });
	
	//添加到提示窗
	var info = new qq.maps.InfoWindow({
        map: map
    });
    //获取标记的点击事件
    qq.maps.event.addListener(marker, 'click', function() {
        info.open(); 
        info.setContent('<div style="text-align:center;white-space:nowrap;'+
        'margin:10px;">你的当前位置是这里！</div>');
        info.setPosition(correctCenter); 
    });
	
	});
}

</script>

</head>
<body onLoad="getLocation()">
<p>请允许获取地理位置</p>
<div id="container"></div>

</body>
</html>