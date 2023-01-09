package com.tad.lgn;

import java.util.HashMap;
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
import com.tad.lgn.service.lgnService;
import com.tad.lgn.vo.lgnVO;

@Controller
@RequestMapping(value = "/lgn", method = RequestMethod.GET)
public class lgnController {
	
	@Inject
	lgnService lgnService;
	
	@Inject
	SessionManager sessionManager;
	
	private final String MESSAGE_CODE_SUCCESS 		= "0";	//성공 
	private final String MESSAGE_CODE_AUTHWARN 		= "1";	//미승인
	private final String MESSAGE_CODE_PWDWARN 		= "2";	//비밀번호불일치
	private final String MESSAGE_CODE_FAIL 			= "3";	//실패
	private final String MESSAGE_CODE_DUPL 			= "4";	//중복
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		
		return "/lgn/login";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		
		return "/lgn/join";
	}
	
	@ResponseBody
	@RequestMapping(value = "/login.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String loginAjax(HttpServletRequest request, HttpServletResponse response, lgnVO lgnVO, Model model) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		lgnVO result = lgnService.login(lgnVO);
		String loginCd = "";
		
		if(result == null) {
			loginCd = MESSAGE_CODE_FAIL;
			
		} else {
			if(lgnVO.getMemberPw().equals(result.getMemberPw()) && "Y".equals(result.getApprovalYn())) {
				loginCd = MESSAGE_CODE_SUCCESS;
				result.setMemberPw(null);
				sessionManager.createSession(result, response);
				
			} else if(lgnVO.getMemberPw().equals(result.getMemberPw()) && "N".equals(result.getApprovalYn())) {
				loginCd = MESSAGE_CODE_AUTHWARN;
				
			} else {
				loginCd = MESSAGE_CODE_PWDWARN;
				
			}
		}
		
		resultMap.put("result", result);
		resultMap.put("loginCd", loginCd);
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "/join.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String joinAjax(HttpServletRequest request, HttpServletResponse response, Model model, lgnVO lgnVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String joinCd = "";
		
		boolean idChk = lgnService.isDuplicateId(lgnVO);
		if(idChk) {
			int res = lgnService.join(lgnVO);
			if(res > 0) {
				joinCd = MESSAGE_CODE_SUCCESS;
			} else {
				joinCd = MESSAGE_CODE_FAIL;
			}
		} else {
			joinCd = MESSAGE_CODE_DUPL;
		}
		
		resultMap.put("joinCd", joinCd);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		sessionManager.expires(request);
		
		return "redirect:/mai/main";
	}
	
	/*
	 * 샘플 ajax
	 */
	@ResponseBody
	@RequestMapping(value = "/lgnSubAuthCheck.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String lgnSubAuthCheck(HttpServletRequest request, HttpServletResponse response, Model model, lgnVO lgnVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String subAuth = lgnService.lgnSubAuthCheck(lgnVO);
		resultMap.put("subAuth", subAuth);
		
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
