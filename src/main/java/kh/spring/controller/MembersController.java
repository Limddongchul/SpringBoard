package kh.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dto.MembersDTO;
import kh.spring.interfaces.MembersService;

@Controller
public class MembersController {
	
	@Autowired
	private MembersService service;
	
	@RequestMapping("/login.do")
	public ModelAndView toLogin(MembersDTO dto, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		int result = service.idpwcheck(dto.getId(), dto.getPw());
		
		mav.addObject("result", result);
		mav.setViewName("loginProc.jsp");
		
		return mav;
		
	}
	
}
