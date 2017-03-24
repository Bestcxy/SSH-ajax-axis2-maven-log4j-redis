$(function(){
	//$("#userName").blur(function(){checkUserName2(this)});
	$(".mark").blur(function(){checkUserName2(this)});
});

//提交表单的ajax
function checkUserName2(theid){
	
	//data="&"+id+"="+value是ajax的本质模式,这里id是一个变量,比如 id="userName",等同于 data={userName:value}={'userName':value},二者 的区别是{}中的key不能为变量
	//var data="&"+id+"="+value;
	var data=gainJson(theid);
	
		$.ajax({
			url : "register/checkUserName.action",// 请求地址
			//timeout : 600000,//超时时间设置，单位毫秒
			async : false,// 异步
			cache : false,// 缓存
			type : 'post',// 请求方式
			/*data: $('#formid').serialize(),//序列化表单*/			
			data:data,						
			dataType : 'json',// 服务器返回的数据类型
			contentType:"application/x-www-form-urlencoded; charset=utf-8",
			success : function(msg) {// 请求成功后调用的
				if(msg.result=="true"){
					//去除非法提示
					alert("true");
				}else{
					//增加非法提示
					alert("false");
					return false;
				}
			
			},
			
			error :function(){
			alert("异常");
			}
		});

	};

	//获取id和值的公共方法，返回json格式
	function gainJson(theid){
		var id=$(theid).attr("id");
		var value=$("#"+id+"").val();
		var str="&"+id+"="+value;
		return str;
	}
/*function checkUserName(theid){
	var date2={
			"username":"jecket10",
			"password":"123456"
		};//gainJson(theid);
	$.ajax({
		url :"register/checkUserName.action",// 请求地址
		timeout : 600000,//超时时间设置，单位毫秒
		//async : false,// 异步
		//cache : false,// 缓存
		type : "POST",// 请求方式
		date:$("#formid").serialize(),    //data: $('#formid').serialize(),//序列化表单
		//contentType:"application/x-www-form-urlencoded",
		dataType : 'json',// 服务器返回的数据类型
		success : function(msg) {// 请求成功后调用的
			if(msg.result=="true"){
				//去除非法提示
				alert("true");
			}else{
				//增加非法提示
				alert("false");
			}
		},
		error :function(){
		alert("异常");
		}
		
	});
}

//获取id和值的公共方法，返回json格式
function gainJson(theid){
	var id=$(theid).attr("id");
	var value=$("#"+id+"").val();
	var str="{\""+id+"\":"+value+"}";
	return str;
}*/
