package kh.spring.interfaces;

import java.util.List;

import kh.spring.dto.BoardDTO;

public interface BoardDAO {
	public int insert(BoardDTO dto);
	public List<BoardDTO> getList(int startNum, int endNum);
	public BoardDTO BoardView(int seq);
	public int delete(int seq);
	public int update(BoardDTO dto);
	public String getPageNavi(int startNum);
}
