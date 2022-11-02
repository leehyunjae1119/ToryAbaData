package com.tad.mbr;

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
import com.tad.mbr.service.mbrService;
import com.tad.mbr.vo.mbrVO;

@Controller
@RequestMapping(value = "/mbr", method = RequestMethod.GET)
public class mbrController {

	@Inject
	SessionManager sessionManager;
	
	@Inject
	mbrService mbrService;
	
	@RequestMapping(value = "/memberBoard", method = RequestMethod.GET)
	public String memberBoard(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		
		return "/mbr/memberBoard";
	}
	
	@ResponseBody
	@RequestMapping(value = "/mbrMemberListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String mbrMemberListSelect(HttpServletRequest request, HttpServletResponse response, Model model, mbrVO mbrVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<mbrVO> resultList = mbrService.mbrMemberListSelect(mbrVO);
		
		resultMap.put("dataList", resultList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/mbrApprovalYnUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String mbrApprovalYnUpdate(HttpServletRequest request, HttpServletResponse response, Model model, mbrVO mbrVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = mbrService.mbrApprovalYnUpdate(mbrVO);
		
		resultMap.put("dataList", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/mbrMemberAuthCdUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String mbrMemberAuthCdUpdate(HttpServletRequest request, HttpServletResponse response, Model model, mbrVO mbrVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = mbrService.mbrMemberAuthCdUpdate(mbrVO);
		
		resultMap.put("dataList", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
}
