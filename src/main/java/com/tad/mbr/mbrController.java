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
import com.tad.common.util.pagingUtil;
import com.tad.common.vo.pagingVO;
import com.tad.lgn.vo.lgnVO;
import com.tad.mbr.service.mbrService;
import com.tad.dct.service.dctService;
import com.tad.dct.vo.dctVO;
import com.tad.mbr.vo.mbrVO;

@Controller
@RequestMapping(value = "/mbr", method = RequestMethod.GET)
public class mbrController {

	@Inject
	SessionManager sessionManager;
	
	@Inject
	mbrService mbrService;
	
	@Inject
	dctService dctService;
	
	@RequestMapping(value = "/memberBoard", method = RequestMethod.GET)
	public String memberBoard(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		
		return "/mbr/memberBoard";
	}
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		lgnVO lgnVO = (lgnVO)sessionManager.getSession(request);
		mbrVO mbrVO = new mbrVO();
		mbrVO.setMemberSeq(lgnVO.getMemberSeq());
		
		mbrVO result = mbrService.mbrMemberOneSelect(mbrVO);
		model.addAttribute("result", result);
		return "/mbr/mypage";
	}
	
	@ResponseBody
	@RequestMapping(value = "/mbrMemberListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String mbrMemberListSelect(HttpServletRequest request, HttpServletResponse response, Model model, mbrVO mbrVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<mbrVO> resultList = mbrService.mbrMemberListSelect(mbrVO);
		
		mbrVO result = mbrService.mbrMemberListSelectCnt(mbrVO);
		pagingVO pagingVO = pagingUtil.pagination(mbrVO.getPageNum(), result.getPageCnt());
		
		resultMap.put("dataList", resultList);
		resultMap.put("pagingVO", pagingVO);
		
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
	
	@ResponseBody
	@RequestMapping(value = "/mbrProfileUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String mbrProfileUpdate(HttpServletRequest request, HttpServletResponse response, Model model, mbrVO mbrVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = mbrService.mbrProfileUpdate(mbrVO);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/mbrMemberPwReset.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String mbrMemberPwReset(HttpServletRequest request, HttpServletResponse response, Model model, mbrVO mbrVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = mbrService.mbrMemberPwReset(mbrVO);
		
		resultMap.put("dataList", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/centerListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String centerListSelect(HttpServletRequest request, HttpServletResponse response, Model model, mbrVO mbrVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		dctVO dctVO = new dctVO();
		List<dctVO> result = dctService.dctCenterListSelect(dctVO);
		
		resultMap.put("dataList", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/teachListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String teachListSelect(HttpServletRequest request, HttpServletResponse response, Model model, mbrVO mbrVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<mbrVO> result = mbrService.teachListSelect(mbrVO);
		
		resultMap.put("dataList", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/authTeachListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String authTeachListSelect(HttpServletRequest request, HttpServletResponse response, Model model, mbrVO mbrVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<mbrVO> result = mbrService.authTeachListSelect(mbrVO);
		
		resultMap.put("dataList", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/subAuthInsert.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String subAuthInsert(HttpServletRequest request, HttpServletResponse response, Model model, mbrVO mbrVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = mbrService.subAuthInsert(mbrVO);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/subAuthDelete.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String subAuthDelete(HttpServletRequest request, HttpServletResponse response, Model model, mbrVO mbrVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = mbrService.subAuthDelete(mbrVO);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
}
