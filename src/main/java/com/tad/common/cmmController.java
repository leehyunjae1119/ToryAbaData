package com.tad.common;

import java.util.HashMap;
import java.util.List;
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

import com.tad.common.service.cmmService;
import com.tad.common.vo.cmmVO;

@Controller
@RequestMapping(value = "/cmm", method = RequestMethod.GET)
public class cmmController {

	@Inject
	cmmService cmmService;
	
	@ResponseBody
	@RequestMapping(value = "/selectComboTeacher.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String selectComboTeacher(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<cmmVO> dataList = cmmService.selectComboTeacher();
		resultMap.put("dataList", dataList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectComboParent.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String selectComboParent(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<cmmVO> dataList = cmmService.selectComboParent();
		resultMap.put("dataList", dataList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
}
