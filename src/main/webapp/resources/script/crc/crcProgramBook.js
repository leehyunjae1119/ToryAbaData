$(document).ready(function () {
	
	$(document).on("click", ".a_td", function() {
		var num = $(this).closest("tr").attr("data-value")
		
		$.makeDomainCardBoard(num);
		
		$("#demo_"+num).collapse("toggle");
	});
	
	$("#domainRegistBtn").on("click", function() {
		
		if(!$("#allDomain").prop("checked")){
			if($("#selectDomainSeq").val() == "0"){
				alert("발달영역을 선택하세요.");
				$("#selectDomainSeq").focus();
				return;
			}
		}
		$.goDomainInsert();
		
	});
	
	$.goDomainInsert = function() {
		var params = {
			studentSeq : $("#studentSeq").val(),
			domainSeq : $("#selectDomainSeq").val(),
			memberSeq : $("#selectMemberSeq").val()
		};
		$.ajax({
            type : "POST",
            url : "/crc/pgbDomainInsert.ajax",
            data : params,
            success : function(res){
            	$.makeDomainCardBoard($("#studentSeq").val());
            	$("#domainRegistModal").modal("hide");
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$("#allDomain").on("change", function() {
		if($(this).prop("checked")){
			$("#selectDomainSeq").val("0");
			$("#selectDomainSeq").attr("disabled", true);
		} else {
			$("#selectDomainSeq").attr("disabled", false);
		}
	});
	
	$("#managerUpdateBtn").on("click", function() {
		var params = {
			domainSeq : $("#domainSeq").val(),
			memberSeq : $("#memberSeq").val()
		};
		$.ajax({
            type : "POST",
            url : "/crc/pgbManagerUpdate.ajax",
            data : params,
            success : function(res){
            	$.makeDomainCardBoard($("#studentSeq").val());
            	$("#managerUpdateModal").modal("hide");
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	});
	
	$.getDomainSeq = function(obj) {
		return $(obj).closest(".crcDomain").children(".crcSeq").val();
	};
	
	$.openDomainDetailModal = function(seq) {
		console.log($.getDomainSeq(seq));
		alert("장기목표 편집페이지 작업중")
	};
	
	$.openDomainRegistModal = function(seq) {
		$("#studentSeq").val(seq);
		$("#domainRegistModal").modal("show");
		
	};
	
	$.openManagerUpdateModal = function(obj) {
		var domainSeq = $.getDomainSeq(obj);
		var studentSeq = $(obj).closest("tr").attr("data-value");
		
		$("#domainSeq").val(domainSeq);
		$("#studentSeq").val(studentSeq);
		
		$("#managerUpdateModal").modal("show");
	};
	
	$.domainDelete = function(obj) {
		if(!confirm("삭제 하시겠습니까?")) return;
		
		var domainSeq = $.getDomainSeq(obj);
		var studentSeq = $(obj).closest("tr").attr("data-value");
		$("#domainSeq").val(domainSeq);
		$("#studentSeq").val(studentSeq);
		
		$.goDomainRemove();
	};
	
	
	$.goDomainRemove = function() {
		var params = {
				domainSeq : $("#domainSeq").val()
			};
		// ajax 통신
        $.ajax({
            type : "POST",
            url : "/crc/crcDomainDelete.ajax",
            data : params,
            success : function(res){
            	$.makeDomainCardBoard($("#studentSeq").val());
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert("서버오류. 담당자에게 연락하세요.")
            }
        });
	};
	
	$.goSearch = function() {
		var params = {
			searchField1 : $("#searchField1").val(),
			searchField2 : $("#searchField2").val(),
			searchText1 : $("#searchText1").val()
		};

		$.ajax({
			type : "POST",
			url : "/crc/pgbStudentListSelect.ajax",
			data : params,
			success : function(res) {
				console.log(res.dataList);
				$("#studentTableBody").empty();
				$.makeStudentDataRow(res.dataList);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) { 
				alert("서버오류. 담당자에게 연락하세요.")
			}
		});
	};
	
	$.makeStudentDataRow = function(dataList) {
		dataList.forEach(function(item) {
			$("#studentTableBody").append($.makeStudentTemplateRow(item));
		});
	};
	
	$.makeStudentTemplateRow = function(data) {
		var html = ''
			+ '	<tr class="tr-vertical-align c-tr-hover" data-value="'+ data.studentSeq +'">'
			+ '		<td class="text-center a_td">'+ data.studentSeq +'</td>'
			+ '		<td class="a_td">'+ data.centerName +'</td>'
			+ '		<td class="a_td">'+ data.className +'</td>'
			+ '		<td class="a_td">'
			+ '			<span class="separator">'+ data.studentName +'</span>'
			+ '			<span class="separator">'+ data.studentBirth +'</span>'
			+ '			<span>'+ data.monthOfBirth +'개월</span>'
			+ '			<span class="badge badge-secondary ml-2">Domain Cell : '+ data.domainCnt +'</span>'
			+ '		</td>'
			+ '		<td>'
			+ '			<button type="button" class="btn btn-primary" onclick="$.openDomainRegistModal('+ data.studentSeq +')"><i class="fas fa-plus mr-2"></i>추가</button>'
			+ '		</td>'
			+ '	</tr>'
			+ '	<tr data-value="'+ data.studentSeq +'">'
			+ '		<td colspan="5" class="hiddenRow">'
			+ '			<div class="accordian-body collapse p-3" id="demo_'+ data.studentSeq +'" data-parent="#accordion">'
			+ '				<p>총 LTO : <span id="totalCompleLtoCnt_'+ data.studentSeq +'">0</span>'
			+ '					/ <span id="totalLtoCnt_'+ data.studentSeq +'">0</span></p>'
			+ '				<div class="row domainCardBoard" id="domainCardBoard_'+ data.studentSeq +'">'	
			+ '				</div>'
			+ '			</div>'
			+ '		</td>'
			+ '	</tr>';
		
		return html;
	};
	
	$.makeDomainCardBoard = function(studentSeq) {
		
		var params = {
				studentSeq : studentSeq
			};

		$.ajax({
			type : "POST",
			url : "/crc/pgbLtoListSelect.ajax",
			data : params,
			async : false,
			success : function(res) {
				$(".domainCardBoard").empty();
				
				if(res.totalCntData){
					$("#totalCompleLtoCnt_"+studentSeq).text(res.totalCntData.totalCompleLtoCnt);
					$("#totalLtoCnt_"+studentSeq).text(res.totalCntData.totalLtoCnt);
				} 
				
				$.makeDomainCardDataRow(res.dataList, studentSeq);
				console.log(res.dataList);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) { 
				alert("서버오류. 담당자에게 연락하세요.")
			}
		});
	};
	
	$.makeDomainCardDataRow = function(dataList, studentSeq) {
		dataList.forEach(function(item) {
			$("#domainCardBoard_"+studentSeq).append($.makeDomainCardTemplate(item));
		});
	};
	
	$.makeDomainCardTemplate = function(data) {
		var statusClass = data.domainStatus == 'CMP' ? 'badge-success' : 'badge-secondary';
		
		var html = ''
			+ '<div class="col-lg-6 mb-4 crcDomain">'
			+ '	<input type="hidden" class="crcSeq" value="'+data.domainSeq+'"/>'
			+ '	<div class="card border-left-secondary shadow h-100 py-2"> '
			+ '		<div class="card-body">'
			+ '			<div class="row no-gutters align-items-center">'
			+ '				<div class="col mr-2 custom-cursor-pointer" onclick="$.openDomainDetailModal(this);">'
			+ '					<span class="badge '+statusClass+' mb-1">LTO : '+data.ltoCnt+' / '+data.compleLtoCnt+'</span> '
			+ '					<div class="font-weight-bold text-primary text-uppercase mb-1">'
			+ '						담당자 : '+data.memberName
			+ '					</div>'
			+ '					<div class="h6 mb-0 font-weight-bold text-gray-800">'
			+ '						#1 DOMAIN : '+data.domainName
			+ '					</div>'
			+ '				</div>'
			+ '				<div class="col-auto mr-3" onclick="$.openManagerUpdateModal(this);">'
			+ '					<i class="fas fa-edit fa-2x text-gray-300 fa-hover"></i>'
			+ '				</div>'
			+ '				<div class="col-auto" onclick="$.domainDelete(this);">'
			+ '					<i class="fas fa-trash fa-2x text-gray-300 fa-hover"></i>'
			+ '				</div>'
			+ '			</div>'
			+ '		</div>'
			+ '	</div>'
			+ '</div>'
			;
		
		return html;
	};
	
	//초기 동작
	$.init = function() {
		$.goSearch();
	};
	
	$.init();
	
});

	function enterkey() {
		if (window.event.keyCode == 13) {
			$.goSearch();
		}
	}
