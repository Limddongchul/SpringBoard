package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dto.BoardDTO;
import kh.spring.interfaces.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/boardView.do")
	public ModelAndView getList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String navi;
		int currentPage = 0;
		String currentPageString = request.getParameter("currentPage");

		if(currentPageString == null){
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(currentPageString);
		}

		navi = service.getPageNavi(currentPage);
		
		List<BoardDTO> result = service.getList(currentPage*10-9,currentPage*10);
		mav.addObject("result", result);
		mav.addObject("navi",navi);
		mav.setViewName("BoardList.jsp");
		return mav;
	}
	
	
	@RequestMapping("/boardInsert.do")
	public ModelAndView insert(BoardDTO dto) {
		ModelAndView mav = new ModelAndView();
		int result = service.insert(dto);
		mav.addObject("result", result);
		mav.setViewName("BoardResult.jsp");
		return mav;
	}
	
	@RequestMapping("/articleView.do")
	public ModelAndView boardView(int no) {
		ModelAndView mav = new ModelAndView();
		BoardDTO result = service.BoardView(no);
		mav.addObject("result", result);
		mav.setViewName("BoardView.jsp");
		return mav;
	}
	
	@RequestMapping("/boardDelete.do")
	public ModelAndView delete(int seq) {
		ModelAndView mav = new ModelAndView();
		int result = service.delete(seq);
		mav.addObject("result", result);
		mav.setViewName("BoardList.jsp");
		return mav;
	}
	
	@RequestMapping("/boardUpdate.do")
	public ModelAndView update(BoardDTO dto) {
		ModelAndView mav = new ModelAndView();
		int result = service.update(dto);
		mav.addObject("result", result);
		mav.setViewName("BoardList.jsp");
		return mav;
	}

}
