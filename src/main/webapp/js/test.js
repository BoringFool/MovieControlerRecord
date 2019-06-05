$(document).ready(function(){
	var testp = new test();
	var path = testp.path();
	testp.query(path);
});

function test(){
	
};

test.prototype.query=function (path){
	$.ajax({
		type:'post',
		url:path+'/show/query',
		dataType:'json',
		success:function(data){
			console.log(data);
			var html = "<ul>";
			for(var i = 0; i < data.length; i++){
				html += "<li>"+data[i].fname+"</li>";
				html += "<li>"+data[i].attention+"</li>";
				html += "<li>"+data[i].backDate+"</li>";
				html += "<li>"+data[i].episodes+"</li>";
				html += "<li>"+data[i].finished+"</li>";
				html += "<li>"+data[i].id+"</li>";
				html += "<li>"+data[i].season+"</li>";
				html += "<li>"+data[i].state+"</li>";
				html += "<li>"+data[i].top+"</li>";
				html += "<li>"+data[i].totalNum+"</li>";
				html += "<li>"+data[i].unused+"</li>";
				html += "<li>"+data[i].updateDate+"</li>";
			};
			html +="</ul>"
			$("#showblock").html(html);
		},
		error:function(){
			console.log("请求失败！");
		}
	});
};

test.prototype.path = function(){
	//获取当前完整网址
	var curWwwPath=window.document.location.href;
	//获取主机地址之后的目录，如： myproj/view/index.jsp
	var pathName=window.document.location.pathname;
	var pos=curWwwPath.indexOf(pathName);
	//获取主机地址，如： http://localhost:8080
	var localhostPaht=curWwwPath.substring(0,pos);
	//获取带"/"的项目名，如：/myproj
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	//得到了 http://localhost:8080/myproj
	var realPath=localhostPaht+projectName;
	return realPath;
}

