package com.tad.mai;

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
import com.tad.dct.vo.dctVO;
import com.tad.lgn.vo.lgnVO;
import com.tad.mai.service.maiService;
import com.tad.mai.vo.maiVO;
import com.tad.ntc.service.ntcService;
import com.tad.ntc.vo.ntcVO;

@Controller
public class maiController {
	
	@Inject
	SessionManager sessionManager;
	
	@Inject
	ntcService ntcService;
	
	@Inject
	dctService dctService;
	
	@Inject
	maiService maiService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		return "redirect:/mai/main";
	}
	
	@RequestMapping(value = "/mai/main", method = RequestMethod.GET)
	public String main(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		
		try {
			lgnVO lgnVO = (lgnVO)sessionManager.getSession(request);
			dctVO dctVO = new dctVO();
			dctVO.setMemberSeq(lgnVO.getMemberSeq());

			dctVO mainCardData = dctService.dctMainCardData();
			
			ntcVO ntcVO = new ntcVO();
			ntcVO.setPageNum(1);
			List<ntcVO> notice = ntcService.ntcNoticeListSelect(ntcVO);
			
			model.addAttribute("centerCnt", mainCardData.getCenterCnt());
			model.addAttribute("superCnt", mainCardData.getSuperCnt());
			model.addAttribute("teachCnt", mainCardData.getTeachCnt());
			model.addAttribute("studentCnt", mainCardData.getStudentCnt());
			model.addAttribute("notice", notice);

		} catch (Exception e) {
			model.addAttribute("centerCnt", 0);
			model.addAttribute("superCnt", 0);
			model.addAttribute("teachCnt", 0);
			model.addAttribute("studentCnt", 0);
			model.addAttribute("notice", null);
		}
		
		return "/mai/main";
	}
	
	@RequestMapping(value = "/mai/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		return "/mai/test";
	}
	
	@ResponseBody
	@RequestMapping(value = "/mai/maiCalenderDataDtlist.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctConsultingDataDtlist(HttpServletRequest request, HttpServletResponse response, Model model, maiVO maiVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<maiVO> dataList = maiService.maiCalenderDataDtlist(maiVO);
		
		resultMap.put("dataList", dataList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/mai/maiCalenderListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctConsultingListSelect(HttpServletRequest request, HttpServletResponse response, Model model, maiVO maiVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<maiVO> dataList = maiService.maiCalenderListSelect(maiVO);
		
		resultMap.put("dataList", dataList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "/mai/maiCalenderDelete.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctConsultingDelete(HttpServletRequest request, HttpServletResponse response, Model model, maiVO maiVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = maiService.maiCalenderDelete(maiVO);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/mai/maiCalenderInsert.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String dctConsultingInsert(HttpServletRequest request, HttpServletResponse response, Model model, maiVO maiVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = maiService.maiCalenderInsert(maiVO);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
}
