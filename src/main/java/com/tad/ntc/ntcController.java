package com.tad.ntc;

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
import com.tad.lgn.vo.lgnVO;
import com.tad.ntc.service.ntcService;
import com.tad.ntc.vo.ntcVO;

@Controller
@RequestMapping(value = "/ntc", method = RequestMethod.GET)
public class ntcController {

	@Inject
	SessionManager sessionManager;
	
	@Inject
	ntcService ntcService;
	
	@RequestMapping(value = "/noticeBoard", method = RequestMethod.GET)
	public String noticeBoard(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		
		return "/ntc/noticeBoard";
	}

	@ResponseBody
	@RequestMapping(value = "/ntcNoticeListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String ntcNoticeListSelect(HttpServletRequest request, HttpServletResponse response, Model model, ntcVO ntcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<ntcVO> resultList = ntcService.ntcNoticeListSelect(ntcVO);
		
		ntcVO result = ntcService.ntcNoticeListSelectCnt(ntcVO);
		
		pagingVO pagingVO = pagingUtil.pagination(ntcVO.getPageNum(), result.getPageCnt());
		
		resultMap.put("dataList", resultList);
		resultMap.put("pagingVO", pagingVO);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/ntcNoticeOneSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String ntcNoticeOneSelect(HttpServletRequest request, HttpServletResponse response, Model model, ntcVO ntcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		ntcVO result = ntcService.ntcNoticeOneSelect(ntcVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/ntcNoticeInsert.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String ntcNoticeInsert(HttpServletRequest request, HttpServletResponse response, Model model, ntcVO ntcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		lgnVO lgnVO = (lgnVO)sessionManager.getSession(request);
		ntcVO.setNoticeRegMbrSeq(lgnVO.getMemberSeq());
		
		int result = ntcService.ntcNoticeInsert(ntcVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/ntcNoticeUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String ntcNoticeUpdate(HttpServletRequest request, HttpServletResponse response, Model model, ntcVO ntcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = ntcService.ntcNoticeUpdate(ntcVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/ntcNoticeDelete.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String ntcNoticeDelete(HttpServletRequest request, HttpServletResponse response, Model model, ntcVO ntcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = ntcService.ntcNoticeDelete(ntcVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
}
