package kh.spring.interfaces;

import java.util.List;

import kh.spring.dto.BoardDTO;

public interface BoardService {
	public int insert(BoardDTO dto);
	public List<BoardDTO> getList();
	public BoardDTO BoardView(int seq);
	public int delete(int seq);
	public int update(BoardDTO dto);
}
