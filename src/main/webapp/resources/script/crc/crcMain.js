$(document).ready(function () {

	//초기 동작
	$.init = function() {
		$.goDomainListSelect();
		$("#collapseCardLTO").collapse('hide');
//		$("#collapseCardSTO").collapse('hide');
	};
	
	$.collapseCardHide = function() {
		$("#collapseCardLTO").collapse('hide');
//		$("#collapseCardSTO").collapse('hide');
		$("#collapseCardDomain").collapse('hide');
	};
	
	$.getCurriculumSeq = function(obj) {
		return $(obj).closest("tr").children(".crcSeq").val();
	};
	
	$.getCurriculumName = function(obj) {
		return $(obj).closest("tr").children(".crcName").text();
	};
	
	$.init();
});