package com.tad.mai;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tad.common.util.SessionManager;
import com.tad.lgn.vo.lgnVO;

@Controller
public class maiController {
	
	@Inject
	SessionManager sessionManager;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		return "redirect:/mai/main";
	}
	
	@RequestMapping(value = "/mai/main", method = RequestMethod.GET)
	public String main(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {

		return "/mai/main";
	}
	
}
