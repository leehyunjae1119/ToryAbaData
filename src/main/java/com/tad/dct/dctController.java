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
import com.tad.dct.service.dctService;
import com.tad.pgb.service.pgbService;
import com.tad.dct.vo.dctChartVO;
import com.tad.dct.vo.dctVO;
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
		
		List<dctVO> dataList = dctService.dctCompletionListSelect(dctVO);
		
		model.addAttribute("studentData", dctVO);
		model.addAttribute("dataList", dataList);
		
		return "/dct/completionBoard";
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
	
	/*
	 * 샘플 ajax
	 */
	@ResponseBody
	@RequestMapping(value = "/sample.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String sampleAjax(HttpServletRequest request, HttpServletResponse response, Model model/*  VO추가  */) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("sampleData", null);
		System.out.println("asdasdasd");
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
		
	
}
