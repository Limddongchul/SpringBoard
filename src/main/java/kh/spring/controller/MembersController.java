package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
	public ModelAndView toLogin(String id, String pw, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		int result = service.idpwcheck(id,pw);
		
		if(result>0) {
			session.setAttribute("loginId", id);

			mav.addObject("result", result);
			mav.setViewName("loginProc.jsp");
		}else {
			mav.addObject("result", result);
			mav.setViewName("loginProc.jsp");
		}
		
		return mav;
		
	}
	
	
//	public ModelAndView idCheck(String id) {
//		ModelAndView mav = new ModelAndView();
//		int result = this.service.idCheck(id);
//		
//		mav.addObject("result", result);
//		mav.setViewName(".");
//		return mav;
//	}
	
	@RequestMapping("/join.do")
	public ModelAndView insert(MembersDTO dto) {
		int result = this.service.insert(dto);
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName("index.jsp");
		return mav;
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index.jsp";
	}
	
	@RequestMapping("/index.do")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/mypage.do")
	public String mypage() {
		return "mypage.jsp";
	}
	
	@RequestMapping("/memberout")
	public ModelAndView memberout(HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView();

		
		int result = service.delete((String)request.getSession().getAttribute("loginId"));

		mav.addObject("result",result);
		mav.addObject("session",session);
		mav.setViewName("memberout.jsp");
		
		return mav;
	}
	
	@RequestMapping("/myInfo.do")	
	public ModelAndView myInfo(String loginid) {
		ModelAndView mav = new ModelAndView();
				
		MembersDTO result = service.membersearch(loginid);
		
		System.out.println(result);
		mav.addObject("result", result);
		mav.addObject("loginid", loginid);
		mav.setViewName("myInfo.jsp");
		
		return mav;
	}
	
	@RequestMapping("/update.do")
	public ModelAndView update(MembersDTO dto) {
		ModelAndView mav = new ModelAndView();
		
		int result = service.update(dto);
		
		System.out.println(result);
		
		mav.addObject("result", result);
		mav.setViewName("updateProc.jsp");
		
		return mav;
	}
}
