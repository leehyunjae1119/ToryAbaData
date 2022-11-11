$(document).ready(function () {
	
	$('#collapseCardDomain').on('show.bs.collapse', function () {
		$("#collapseCardLTO").collapse('hide');
		$("#collapseCardSTO").collapse('hide');
	});
	
	$('#collapseCardLTO').on('show.bs.collapse', function () {
		$("#collapseCardDomain").collapse('hide');
		$("#collapseCardSTO").collapse('hide');
	});
	
	$('#collapseCardSTO').on('show.bs.collapse', function () {
		$("#collapseCardDomain").collapse('hide');
		$("#collapseCardLTO").collapse('hide');
	});

	//초기 동작
	$.init = function() {
		$.goDomainListSelect();

	};
	
	$.getCurriculumSeq = function(obj) {
		return $(obj).closest("tr").children(".crcSeq").val();
	};
	
	$.getCurriculumName = function(obj) {
		return $(obj).closest("tr").children(".crcName").text();
	};
	
	$.init();
});