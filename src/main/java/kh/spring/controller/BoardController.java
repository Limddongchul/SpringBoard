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
	public ModelAndView getList() {
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> result = service.getList();
		System.out.println("½ÃÄö½º:"+result.get(0).getSeq());
		mav.addObject("result", result);
		mav.setViewName("BoardList.jsp");
		return mav;
	}
	
	
	@RequestMapping("/boardInsert.do")
	public ModelAndView insert(BoardDTO dto) {
		System.out.println("µé¾î¿È");
		ModelAndView mav = new ModelAndView();
		int result = service.insert(dto);
		mav.addObject("result", result);
		mav.setViewName("BoardResult.jsp");
		return mav;
	}
	
	@RequestMapping("/articleView.do")
	public ModelAndView boardView(int seq) {
		ModelAndView mav = new ModelAndView();
		BoardDTO result = service.BoardView(seq);
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
