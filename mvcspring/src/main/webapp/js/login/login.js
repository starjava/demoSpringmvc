$(function(){
	$("#vcodeurl").click(function(){
		$("#vcode").attr("src","http://localhost:8080/mvcspring/pages/Login/image.jsp?random="+new Date().getTime());
	});
});

