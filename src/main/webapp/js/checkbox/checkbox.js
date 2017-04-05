/**
 * jquery 获取 被选中的checkbox，使用ajax方法传递到后台
 */
$(function(){
	//点击提交的时候，获取全部被选中的checkbox的value的值
	$("#checkboxSub").click(function(){checkbox();});
	
	//一键全选或者一键接触全选
	$("#checkboxAll").click(function(){checkboxall(this);});
	
	//单独点击某一个checkbox选项时，判断是否满足全选的标准
	$(".checkboxStr").click(function(){checkboxone();});
});
/*单独点击某一个checkbox选项时*，判断是否满足全选的标准*/
function checkboxone(thisid){
	var sum=$("input[name='checkboxStr']").length;
	var checkedsum=$("input[name='checkboxStr']:checked").length;
	alert(sum+" "+checkedsum+" "+(sum==checkedsum));
	if(sum==checkedsum){
		//勾选全选
		$("input[name='checkboxAll']").prop("checked", true);
	}else{
		//取消勾选全选
		$("input[name='checkboxAll']").prop("checked", false);
	}
}

/*一次勾选全部选项或者一次取消勾选全部选项*/
function checkboxall(thisid){
	 var isChecked = $(thisid).prop("checked");
	 $("input[name='checkboxStr']").prop("checked", isChecked);
}

/*获取被选中的checkbox的值*/
function checkbox(){
  var checkboxStr = "";
  $('input:checkbox[name=checkboxStr]:checked').each(function(i){
   if(0==i){
	   checkboxStr = $(this).val();
   }else{
	   checkboxStr += (","+$(this).val());
   }
  });
  
  /*调用ajax方法*/
  ajaxto(checkboxStr);
}

/*将前台的数据传递到后台的ajax方法*/
function ajaxto(checkboxStr){
	var data="&checkboxStr="+checkboxStr;
	$.ajax({
		url : "checkbox/checkbox.action",// 请求地址
		timeout : 600000,//超时时间设置，单位毫秒
		async : true,// 异步
		cache : false,// 缓存
		type : 'post',// 请求方式
		/*data: $('#formid').serialize(),//序列化表单*/			
		data:data,						
		dataType : 'json',// 服务器返回的数据类型
		contentType:"application/x-www-form-urlencoded; charset=utf-8",
		success : function(msg) {// 请求成功后调用的
			if(msg.result=="true"){
				//传递到后台成功提示
				alert("操作成功");
			}else{
				//传递到后台失败提示
				alert("操作失败");
				return false;
			}
		
		},
		
		error :function(){
		alert("异常");
		}
	});
}
