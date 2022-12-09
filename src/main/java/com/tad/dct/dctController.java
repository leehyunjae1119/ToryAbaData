package com.tad.dct;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tad.common.util.SessionManager;
import com.tad.common.util.pagingUtil;
import com.tad.common.vo.pagingVO;
import com.tad.dct.service.dctService;
import com.tad.pgb.service.pgbService;
import com.tad.dct.vo.dctChartVO;
import com.tad.dct.vo.dctVO;
import com.tad.lgn.vo.lgnVO;
import com.tad.ntc.vo.ntcVO;
import com.tad.pgb.vo.pgbVO;

@Controller
@RequestMapping(value = "/dct", method = RequestMethod.GET)
public class dctController {
	
	@Inject
	dctService dctService;
	
	@Inject
	pgbService pgbService;
	
	@Inject
	SessionManager sessionManager;
	
	@RequestMapping(value = "/centerBoard", method = RequestMethod.GET)
	public String centerBoard(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		
		return "/dct/centerBoard";
	}
	
	@RequestMapping(value = "/classBoard", method = RequestMethod.GET)
	public String classBoard(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		model.addAttribute("centerSeq", (String)request.getParameter("centerSeq"));
		model.addAttribute("centerName", (String)request.getParameter("centerName"));
		
		return "/dct/classBoard";
	}
	
	@RequestMapping(value = "/studentBoard", method = RequestMethod.GET)
	public String studentBoard(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		model.addAttribute("classSeq", (String)request.getParameter("classSeq"));
		model.addAttribute("className", (String)request.getParameter("className"));
		
		return "/dct/studentBoard";
	}
	
	@RequestMapping(value = "/studentDetail", method = RequestMethod.GET)
	public String studentDetail(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {

		dctVO dctVO = new dctVO();
		dctVO.setStudentSeq(Integer.parseInt(request.getParameter("studentSeq")));
		dctVO date = dctService.dctStudentOneSelect(dctVO);
		
		model.addAttribute("studentSeq", (String)request.getParameter("studentSeq"));
		model.addAttribute("date", date);
		
		return "/dct/studentDetail";
	}

	@RequestMapping(value = "/completionBoard", method = RequestMethod.GET)
	public String completionBoard(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		int studentSeq = Integer.parseInt( (String)request.getParameter("studentSeq") );
		
		pgbVO pgbVO = new pgbVO();
		dctVO dctVO = new dctVO();
		
		pgbVO.setStudentSeq(studentSeq);
		pgbVO data = pgbService.pgbModalTitleSelect(pgbVO);
		
		dctVO.setStudentSeq(studentSeq);
		dctVO.setCenterName(data.getCenterName());
		dctVO.setClassName(data.getClassName());
		dctVO.setStudentName(data.getStudentName());
		
		List<dctVO> domainList = dctService.dctDomainListSelect(dctVO);
		
		model.addAttribute("studentData", dctVO);
		model.addAttribute("domainList", domainList);
		
		return "/dct/completionBoard";
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctCompletionListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctCompletionListSelect(HttpServletRequest request, HttpServletResponse response, Model model, dctVO dctVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<dctVO> resultList = dctService.dctCompletionListSelect(dctVO);
		
		dctVO result = dctService.dctCompletionListSelectCnt(dctVO);
		
		pagingVO pagingVO = pagingUtil.pagination(dctVO.getPageNum(), result.getPageCnt());
		
		resultMap.put("dataList", resultList);
		resultMap.put("pagingVO", pagingVO);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@RequestMapping(value = "/runUnitBoard", method = RequestMethod.GET)
	public String runUnitBoard(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		int studentSeq = Integer.parseInt( (String)request.getParameter("studentSeq") );
		
		pgbVO pgbVO = new pgbVO();
		dctVO dctVO = new dctVO();
		
		pgbVO.setStudentSeq(studentSeq);
		pgbVO data = pgbService.pgbModalTitleSelect(pgbVO);
		
		dctVO.setStudentSeq(studentSeq);
		dctVO.setCenterName(data.getCenterName());
		dctVO.setClassName(data.getClassName());
		dctVO.setStudentName(data.getStudentName());
		
		model.addAttribute("studentData", dctVO);
		
		return "/dct/runUnitBoard";
	}
	
	@RequestMapping(value = "/criteriaBoard", method = RequestMethod.GET)
	public String criteriaBoard(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		int studentSeq = Integer.parseInt( (String)request.getParameter("studentSeq") );
		
		pgbVO pgbVO = new pgbVO();
		dctVO dctVO = new dctVO();
		
		pgbVO.setStudentSeq(studentSeq);
		pgbVO data = pgbService.pgbModalTitleSelect(pgbVO);
		
		dctVO.setStudentSeq(studentSeq);
		dctVO.setCenterName(data.getCenterName());
		dctVO.setClassName(data.getClassName());
		dctVO.setStudentName(data.getStudentName());
		
		List<dctChartVO> domainList = dctService.dctDomainSelect(dctVO);
		
		model.addAttribute("studentData", dctVO);
		model.addAttribute("domainList", domainList);
		
		return "/dct/criteriaBoard";
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctCenterListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctCenterListSelect(HttpServletRequest request, HttpServletResponse response, Model model, dctVO dctVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<dctVO> resultList = dctService.dctCenterListSelect(dctVO);
		
		resultMap.put("dataList", resultList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctCenterInsert.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctCenterInsert(HttpServletRequest request, HttpServletResponse response, Model model, dctVO dctVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = dctService.dctCenterInsert(dctVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctCenterUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctCenterUpdate(HttpServletRequest request, HttpServletResponse response, Model model, dctVO dctVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = dctService.dctCenterUpdate(dctVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctCenterDelete.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctCenterDelete(HttpServletRequest request, HttpServletResponse response, Model model, dctVO dctVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = dctService.dctCenterDelete(dctVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "/dctClassListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctClassListSelect(HttpServletRequest request, HttpServletResponse response, Model model, dctVO dctVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<dctVO> resultList = dctService.dctClassListSelect(dctVO);
		
		resultMap.put("dataList", resultList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctClassInsert.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctClassInsert(HttpServletRequest request, HttpServletResponse response, Model model, dctVO dctVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = dctService.dctClassInsert(dctVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctClassUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctClassUpdate(HttpServletRequest request, HttpServletResponse response, Model model, dctVO dctVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = dctService.dctClassUpdate(dctVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctClassDelete.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctClassDelete(HttpServletRequest request, HttpServletResponse response, Model model, dctVO dctVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = dctService.dctClassDelete(dctVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "/dctStudentListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctStudentListSelect(HttpServletRequest request, HttpServletResponse response, Model model, dctVO dctVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<dctVO> resultList = dctService.dctStudentListSelect(dctVO);
		
		resultMap.put("dataList", resultList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctStudentOneSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctStudentOneSelect(HttpServletRequest request, HttpServletResponse response, Model model, dctVO dctVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		dctVO result = dctService.dctStudentOneSelect(dctVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctStudentInsert.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctStudentInsert(HttpServletRequest request, HttpServletResponse response, Model model, dctVO dctVO) throws Exception {
		
		System.out.println(dctVO.toString());
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = dctService.dctStudentInsert(dctVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctStudentUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctStudentUpdate(HttpServletRequest request, HttpServletResponse response, Model model, dctVO dctVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = dctService.dctStudentUpdate(dctVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctStudentDelete.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctStudentDelete(HttpServletRequest request, HttpServletResponse response, Model model, dctVO dctVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = dctService.dctStudentDelete(dctVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctCurriculumListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctCurriculumListSelect(HttpServletRequest request, HttpServletResponse response, Model model, dctVO dctVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<List<dctVO>> dataList = dctService.dctCurriculumListSelect(dctVO);
		
		resultMap.put("dataList", dataList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctRunUnitListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctRunUnitListSelect(HttpServletRequest request, HttpServletResponse response, Model model, dctChartVO dctChartVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();

		List<dctChartVO> dataList = dctService.dctRunUnitListSelect(dctChartVO);
		
		resultMap.put("dataList", dataList);
		json = objectMapper.writeValueAsString(resultMap);
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctCriteriaListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctCriteriaListSelect(HttpServletRequest request, HttpServletResponse response, Model model, dctChartVO dctChartVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<dctChartVO> dataList = dctService.dctCriteriaListSelect(dctChartVO);
		
		resultMap.put("dataList", dataList);
		json = objectMapper.writeValueAsString(resultMap);
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctDatePickerUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctDatePickerUpdate(HttpServletRequest request, HttpServletResponse response, Model model, dctChartVO dctChartVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		lgnVO lgnVO = (lgnVO)sessionManager.getSession(request);
		dctChartVO.setPickerSelector(lgnVO.getMemberSeq());
		int result = dctService.dctDatePickerUpdate(dctChartVO);
		
		resultMap.put("result", result);
		json = objectMapper.writeValueAsString(resultMap);
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctDatePickerSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctDatePickerSelect(HttpServletRequest request, HttpServletResponse response, Model model, dctChartVO dctChartVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		lgnVO lgnVO = (lgnVO)sessionManager.getSession(request);
		dctChartVO.setPickerSelector(lgnVO.getMemberSeq());
		List<dctChartVO> dataList = dctService.dctDatePickerSelect(dctChartVO);
		
		resultMap.put("dataList", dataList);
		json = objectMapper.writeValueAsString(resultMap);
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctDomainChartDataSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctDomainChartDataSelect(HttpServletRequest request, HttpServletResponse response, Model model, dctChartVO dctChartVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();

		lgnVO lgnVO = (lgnVO)sessionManager.getSession(request);
		dctChartVO.setPickerSelector(lgnVO.getMemberSeq());
		List<List<dctChartVO>> dataList = dctService.dctDomainChartDataSelect(dctChartVO);
		
		resultMap.put("dataList", dataList);
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dctReportCrcListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctReportCrcListSelect(HttpServletRequest request, HttpServletResponse response, Model model, dctVO dctVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<dctVO> dataList = dctService.dctReportCrcListSelect(dctVO);
		
		resultMap.put("dataList", dataList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
}
