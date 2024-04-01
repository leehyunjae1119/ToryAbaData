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
import com.tad.crc.service.crcService;
import com.tad.crc.vo.crcVO;

@Controller
@RequestMapping(value = "/crc", method = RequestMethod.GET)
public class crcController {
	
	@Inject
	SessionManager sessionManager;
	
	@Inject
	crcService crcService;
	
	@RequestMapping(value = "/curriculumBoard", method = RequestMethod.GET)
	public String curriculumBoard(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		
		return "/crc/curriculumBoard";
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcDomainListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcDomainListSelect(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<crcVO> resultList = crcService.crcDomainListSelect(crcVO);
		
		resultMap.put("dataList", resultList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcGroupListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcGroupListSelect(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<crcVO> resultList = crcService.crcGroupListSelect(crcVO);
		
		resultMap.put("dataList", resultList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcGroupInsert.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcGroupInsert(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = crcService.crcGroupInsert(crcVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcGroupUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcGroupUpdate(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = crcService.crcGroupUpdate(crcVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcGroupItemUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcGroupItemUpdate(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = crcService.crcGroupItemUpdate(crcVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcGroupUseYnUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcGroupUseYnUpdate(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = crcService.crcGroupUseYnUpdate(crcVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcGroupDelete.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcGroupDelete(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = crcService.crcGroupDelete(crcVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcDomainOneSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcDomainOneSelect(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		crcVO result = crcService.crcDomainOneSelect(crcVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcDomainInsert.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcDomainInsert(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {

		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = crcService.crcDomainInsert(crcVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcDomainUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcDomainUpdate(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = crcService.crcDomainUpdate(crcVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcDomainDelete.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcDomainDelete(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = crcService.crcDomainDelete(crcVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcDomainUseYnUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcDomainUseYnUpdate(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = crcService.crcDomainUseYnUpdate(crcVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	/////////////////////////

	@ResponseBody
	@RequestMapping(value = "/crcLTOListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcLTOListSelect(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<crcVO> resultList = crcService.crcLTOListSelect(crcVO);
		
		resultMap.put("dataList", resultList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcLTOOneSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcLTOOneSelect(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		crcVO result = crcService.crcLTOOneSelect(crcVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcLTOInsert.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcLTOInsert(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {

		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = crcService.crcLTOInsert(crcVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcLTOUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcLTOUpdate(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = crcService.crcLTOUpdate(crcVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcLTODelete.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcLTODelete(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = crcService.crcLTODelete(crcVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
/////////////////////////

	@ResponseBody
	@RequestMapping(value = "/crcSTOListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcSTOListSelect(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<crcVO> resultList = crcService.crcSTOListSelect(crcVO);
		
		resultMap.put("dataList", resultList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcSTOOneSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcSTOOneSelect(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		crcVO result = crcService.crcSTOOneSelect(crcVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcSTOInsert.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcSTOInsert(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {

		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = crcService.crcSTOInsert(crcVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcSTOUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcSTOUpdate(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = crcService.crcSTOUpdate(crcVO);
		
		resultMap.put("result", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/crcSTODelete.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String crcSTODelete(HttpServletRequest request, HttpServletResponse response, Model model, crcVO crcVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = crcService.crcSTODelete(crcVO);
		
		resultMap.put("result", result);
		
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
