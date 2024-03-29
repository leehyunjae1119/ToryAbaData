package com.tad.pgb;

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
import com.tad.lgn.vo.lgnVO;
import com.tad.pgb.service.pgbService;
import com.tad.pgb.vo.pgbVO;
import com.tad.pgb.vo.pgbChartVO;
import com.tad.pgb.vo.pgbDtoVO;
import com.tad.pgb.vo.pgbLtoVO;
import com.tad.pgb.vo.pgbPointVO;
import com.tad.pgb.vo.pgbStoVO;

@Controller
@RequestMapping(value = "/pgb", method = RequestMethod.GET)
public class pgbController {
	
	@Inject
	SessionManager sessionManager;
	
	@Inject
	pgbService pgbService;
	
	@ResponseBody
	@RequestMapping(value = "/pgbDtoListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbDtoListSelect(HttpServletRequest request, HttpServletResponse response, Model model, pgbDtoVO pgbDtoVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<pgbDtoVO> resultList = pgbService.pgbDtoListSelect(pgbDtoVO);
		
		resultMap.put("dataList", resultList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbLtoListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbLtoListSelect(HttpServletRequest request, HttpServletResponse response, Model model, pgbLtoVO pgbLtoVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<pgbLtoVO> resultList = pgbService.pgbLtoListSelect(pgbLtoVO);
		
		resultMap.put("dataList", resultList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbStoListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbStoListSelect(HttpServletRequest request, HttpServletResponse response, Model model, pgbStoVO pgbStoVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<pgbStoVO> resultList = pgbService.pgbStoListSelect(pgbStoVO);
		
		resultMap.put("dataList", resultList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbLtoOneSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbLtoOneSelect(HttpServletRequest request, HttpServletResponse response, Model model, pgbLtoVO pgbLtoVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		pgbLtoVO result = pgbService.pgbLtoOneSelect(pgbLtoVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbStoOneSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbStoOneSelect(HttpServletRequest request, HttpServletResponse response, Model model, pgbStoVO pgbStoVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		pgbStoVO result = pgbService.pgbStoOneSelect(pgbStoVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbLtoInsert.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbLtoInsert(HttpServletRequest request, HttpServletResponse response, Model model, pgbLtoVO pgbLtoVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = pgbService.pgbLtoInsert(pgbLtoVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbLtoUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbLtoUpdate(HttpServletRequest request, HttpServletResponse response, Model model, pgbLtoVO pgbLtoVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = pgbService.pgbLtoUpdate(pgbLtoVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbStoInsert.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbStoInsert(HttpServletRequest request, HttpServletResponse response, Model model, pgbStoVO pgbStoVO) throws Exception {
		
		System.out.println(pgbStoVO.getStoName());
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = pgbService.pgbStoInsert(pgbStoVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbStoUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbStoUpdate(HttpServletRequest request, HttpServletResponse response, Model model, pgbStoVO pgbStoVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = pgbService.pgbStoUpdate(pgbStoVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbDtoStautsUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbDtoStautsUpdate(HttpServletRequest request, HttpServletResponse response, Model model, pgbDtoVO pgbDtoVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String result = pgbService.pgbDtoStautsUpdate(pgbDtoVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbLtoStautsUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbLtoStautsUpdate(HttpServletRequest request, HttpServletResponse response, Model model, pgbLtoVO pgbLtoVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String result = pgbService.pgbLtoStautsUpdate(pgbLtoVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbStoStautsUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbStoStautsUpdate(HttpServletRequest request, HttpServletResponse response, Model model, pgbStoVO pgbStoVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Map<String, String> result = pgbService.pgbStoStautsUpdate(pgbStoVO);
		
		resultMap.put("dtoStatus", result.get("dtoStatus"));
		resultMap.put("ltoStatus", result.get("ltoStatus"));
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbPointInsert.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbPointInsert(HttpServletRequest request, HttpServletResponse response, Model model, pgbPointVO pgbPointVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		lgnVO lgnVO = (lgnVO)sessionManager.getSession(request);
		pgbPointVO.setPointRegMbrSeq(lgnVO.getMemberSeq());
		
		int result = pgbService.pgbPointInsert(pgbPointVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbPointDelete.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbPointDelete(HttpServletRequest request, HttpServletResponse response, Model model, pgbPointVO pgbPointVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = pgbService.pgbPointDelete(pgbPointVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbPointListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbPointListSelect(HttpServletRequest request, HttpServletResponse response, Model model, pgbPointVO pgbPointVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();

		List<pgbPointVO> result = pgbService.pgbPointListSelect(pgbPointVO);
		
		resultMap.put("dataList", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbStautsAutoUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbStautsAutoUpdate(HttpServletRequest request, HttpServletResponse response, Model model, pgbVO pgbVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Map<String, String> result = pgbService.pgbStautsAutoUpdate(pgbVO);
		
		if("STO".equals(pgbVO.getUpdateFlag())) {
			resultMap.put("dtoStatus", result.get("dtoStatus"));
			resultMap.put("ltoStatus", result.get("ltoStatus"));
			resultMap.put("stoStatus", result.get("stoStatus"));
		} else if ("LTO".equals(pgbVO.getUpdateFlag())) {
			resultMap.put("dtoStatus", result.get("dtoStatus"));
			resultMap.put("ltoStatus", result.get("ltoStatus"));
		} else if ("DTO".equals(pgbVO.getUpdateFlag())) {
			resultMap.put("dtoStatus", result.get("dtoStatus"));
		}
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbModalTitleSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbModalTitleSelect(HttpServletRequest request, HttpServletResponse response, Model model, pgbVO pgbVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		pgbVO data = pgbService.pgbModalTitleSelect(pgbVO);
		
		resultMap.put("data", data);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbStoTmplListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbStoTmplListSelect(HttpServletRequest request, HttpServletResponse response, Model model, pgbStoVO pgbStoVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<pgbStoVO> dataList = pgbService.pgbStoTmplListSelect(pgbStoVO);
		
		resultMap.put("dataList", dataList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbLtoTmplListSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbLtoTmplListSelect(HttpServletRequest request, HttpServletResponse response, Model model, pgbLtoVO pgbLtoVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<pgbLtoVO> dataList = pgbService.pgbLtoTmplListSelect(pgbLtoVO);
		
		resultMap.put("dataList", dataList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbPointRoundUpdate.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbPointRoundUpdate(HttpServletRequest request, HttpServletResponse response, Model model, pgbStoVO pgbStoVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = pgbService.pgbPointRoundUpdate(pgbStoVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	

	@ResponseBody
	@RequestMapping(value = "/pgbLtoChartDataSelect.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbLtoChartDataSelect(HttpServletRequest request, HttpServletResponse response, Model model, pgbVO pgbVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<List<pgbChartVO>> resultList = pgbService.pgbLtoChartDataSelect(pgbVO);
		
		resultMap.put("dataList", resultList);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbStoDelete.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbStoDelete(HttpServletRequest request, HttpServletResponse response, Model model, pgbVO pgbVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = pgbService.pgbStoDelete(pgbVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pgbLtoDelete.ajax", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String pgbLtoDelete(HttpServletRequest request, HttpServletResponse response, Model model, pgbVO pgbVO) throws Exception {
		
		String json = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int result = pgbService.pgbLtoDelete(pgbVO);
		
		resultMap.put("data", result);
		
		json = objectMapper.writeValueAsString(resultMap);
		
		return json;
	}
}
