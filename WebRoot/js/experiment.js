var flag = true; 
function changeShowOrHide(test,show){
	var change = $(show);
	
	if(flag){
		change.css('display','block');
		test.src="images/minus.png";
		flag=false;
	}else{
		change.css('display','none');
		test.src="images/plus.png";
		flag=true;
	}
	
}

//控制div显示或者隐藏

function showOrHide(id){
	var showid = $(id);
	for(var i=1;i<=4;i++){
		for(var j=1;j<=7;j++){
			$("#root"+i+"_child"+j).hide();
		}
	}
	showid.show();
}
