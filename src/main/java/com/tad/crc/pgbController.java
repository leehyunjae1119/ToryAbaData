package com.tad.crc;

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
import com.tad.crc.service.pgbService;
import com.tad.crc.vo.pgbVO;

@Controller
@RequestMapping(value = "/crc", method = RequestMethod.GET)
public class pgbController {
	
	@Inject
	SessionManager sessionManager;
	
	@Inject
	pgbService pgbService;

	@RequestMapping(value = "/programBook", method = RequestMethod.GET)
	public String programBook(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		
		List<List<pgbVO>> selectBoxList = pgbService.pgbSelectBoxListSelect();
		
		model.addAttribute("centerList", selectBoxList.get(0));
		model.addAttribute("classList", selectBoxList.get(1));
		model.addAttribute("domainList", selectBoxList.get(2));
		model.addAttribute("memberList", selectBoxList.get(3));
		
		return "/crc/programBook";
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbStudentListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbStudentListSelect(HttpServletRequest request, HttpServletResponse response, Model model, pgbVO pgbVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<pgbVO> resultList = pgbService.pgbStudentListSelect(pgbVO);
		
		resultMap.put("dataList", resultList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbLtoListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbLtoListSelect(HttpServletRequest request, HttpServletResponse response, Model model, pgbVO pgbVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		pgbVO totalCntData = pgbService.pgbLTOCntSelect(pgbVO);
		List<pgbVO> resultList = pgbService.pgbLTOCardListSelect(pgbVO);
		
		resultMap.put("totalCntData", totalCntData);
		resultMap.put("dataList", resultList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbDomainInsert.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbDomainInsert(HttpServletRequest request, HttpServletResponse response, Model model, pgbVO pgbVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();

		int result = pgbService.pgbDomainInsert(pgbVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbManagerUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbManagerUpdate(HttpServletRequest request, HttpServletResponse response, Model model, pgbVO pgbVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = pgbService.pgbManagerUpdate(pgbVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbDomainDelete.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbDomainDelete(HttpServletRequest request, HttpServletResponse response, Model model, pgbVO pgbVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = pgbService.pgbDomainDelete(pgbVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
}
