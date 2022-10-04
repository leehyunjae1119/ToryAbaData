var sessionData = true;
function isSideBarToggle() {
	
	sessionData = $("#accordionSidebar").hasClass("toggled") ? true : false;
	sessionStorage.setItem("isSideBarToggle", sessionData );
}

$(document).ready(function () {
	
	if(sessionStorage.getItem("isSideBarToggle") == "false"){
		$("#accordionSidebar").addClass("toggled");
	}
	
	$("#_logoutBtn").on("click", function() {
		location.href = "../lgn/logout";
	});
	
	$("#_maiMenu").on("click", function() {
		location.href = "../mai/main";
	});
	
	$("#_dctMenu").on("click", function() {
		location.href = "../dct/centerBoard";
	});
	
	$("#_crcMenuCurriculum").on("click", function() {
		location.href = "../crc/curriculumBoard";
	});
	
	$("#_crcMenuProgramBook").on("click", function() {
		location.href = "../crc/programBook";
	});
	
	//$.setComboBox(태그 아이디, 기본값(선택/선택안함), 선택적용값, 데이터 조회 URL )
	$.setComboBox = function(id, defaultText, value, url) {
		$("#"+id).empty();
		$.makeComboBoxOption(id, defaultText, "", value);
		
		// ajax 통신
        $.ajax({
            type : "POST",
            url : url,
            success : function(res){
            	if(res.dataList){
            		res.dataList.forEach(function(item) {
            			console.log(item.text);
            			$.makeComboBoxOption(id, item.text, item.value, value);
					});
            	}
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ 
            }
        });
	};
	
	$.makeComboBoxOption = function(id, text, value, selected) {
		console.log(text);
		var opt = "";
		
		if(text == "선택"){
			opt = '<option value="" ' + (selected=="선택" ? 'selected' : '') + '>선택</option>';
		} else if (text == "선택안함") {
			opt = '<option value="0" ' + (selected=="선택안함" ? 'selected' : '') + '>선택안함</option>';
		} else {
			opt = '<option value="'+value+'" ' 
				+ (value==selected ? 'selected >' : '>')
				+ text + '</option>';
		}
		
		$("#"+id).append(opt);
	};
	
	$.getDateFormat = function(date, format) {
		var d = new Date(date);
		var yyyy = d.getFullYear();
		var mm = numFormat(d.getMonth()+1);
		var dd = numFormat(d.getDate());
		var hh = numFormat(d.getHours());
		var mi = numFormat(d.getMinutes());
		var ss = numFormat(d.getSeconds());
		
		var d_str = "";
		var gubun = "";
		if(format.substring(4,5) == "-"){
			gubun = "-";
		} else if(format.substring(4,5) == "."){
			gubun = ".";
		} else if(format.substring(4,5) == "/"){
			gubun = "/";
		}
		
		if(format.indexOf("YYYY") > -1){
			d_str += yyyy;
		}
		if(format.indexOf("MM") > -1){
			if(d_str != "") d_str+=gubun;
			d_str += mm;
		}
		if(format.indexOf("DD") > -1){
			if(d_str != "") d_str+=gubun;
			d_str += dd;
		}
		if(format.indexOf("HH") > -1){
			if(d_str != "") d_str+=" ";
			d_str += hh;
		}
		if(format.indexOf("MI") > -1){
			if(d_str != "") d_str+=":";
			d_str += mi;
		}
		if(format.indexOf("SS") > -1){
			if(d_str != "") d_str+=":";
			d_str += ss;
		}
		
		return d_str;
	};
	
	function numFormat(variable)
	{
		variable = Number(variable).toString();
		if(Number(variable) < 10 && variable.length == 1)
			variable = "0" + variable;
		return variable;
	}
});






