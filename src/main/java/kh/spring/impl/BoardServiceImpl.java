package kh.spring.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.BoardDTO;
import kh.spring.interfaces.BoardDAO;
import kh.spring.interfaces.BoardService;

@Component
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
	@Override
	public int insert(BoardDTO dto) {
		return dao.insert(dto);
	}

	@Override
	public List<BoardDTO> getList() {
		return dao.getList();
	}

	@Override
	public int delete(int seq) {
		return dao.delete(seq);
	}

	@Override
	public int update(BoardDTO dto) {
		return dao.update(dto);
	}

	@Override
	public BoardDTO BoardView(int seq) {
		return dao.BoardView(seq);
	}

}
