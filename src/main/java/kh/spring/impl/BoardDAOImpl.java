package kh.spring.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.BoardDTO;
import kh.spring.interfaces.BoardDAO;

@Component
public class BoardDAOImpl implements BoardDAO {

	@Autowired
//	private JdbcTemplate template;
	private SqlSessionTemplate template;

	@Override
	public int insert(BoardDTO dto) {
		return template.insert("Board.insert",dto);
	}

	@Override
	public List<BoardDTO> getList(int startNum, int endNum) {
		Map<String,Integer> map = new HashMap<>();
		map.put("startNum", startNum);
		map.put("endNum",endNum);
		return template.selectList("Board.getList",map);
	}
	
	@Override
	public String getPageNavi(int currentPage) {
		
		int recordTotalCount=0;

		recordTotalCount = template.selectOne("Board.getPageNavi");
		
		int recordCountPerPage = 10; 
		int naviCountPerPage = 10;
		int pageTotalCount = 0; 

		if(recordTotalCount % recordCountPerPage > 0) { 
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}



		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = (currentPage - 1)/ naviCountPerPage * naviCountPerPage + 1;
		int endNavi = startNavi + (naviCountPerPage - 1);

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}


		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}

		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='boardView.do?currentPage="+(startNavi-1)+"'< </a>");
		}
		for(int i = startNavi;i <= endNavi;i++) {
			if(currentPage == i) {
				sb.append("<a href='boardView.do?currentPage=" + i + "'> <b>" + i + "</b></a>");
			}else {
				sb.append("<a href='boardView.do?currentPage=" + i + "'> " + i + "</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='boardView.do?currentPage="+(endNavi+1)+"'>></a>");
		}



		String result = sb.toString();

		return result;
	}

	@Override
	public BoardDTO BoardView(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	/*@Override
	public int insert(BoardDTO dto) {
		String sql = "insert into spring_board values(spring_board_seq.nextval, ?, ?, ?, 10)";
		return template.update(sql, dto.getTitle(),dto.getContents(), dto.getWriter());
	}

	@Override
	public List<BoardDTO> getList(int startNum, int endNum) {
		String sql = "select * from (select spring_board.*, row_number() over(order by seq desc) as num from spring_board) where num between ? and ?";
		Object[] params = {startNum, endNum};
		return template.query(sql, params, new RowMapper<BoardDTO>(){

			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardDTO tmp = new BoardDTO();
				tmp.setSeq(rs.getInt("seq"));
				tmp.setTitle(rs.getString("title"));
				tmp.setContents(rs.getString("contents"));
				tmp.setWriter(rs.getString("writer"));
				tmp.setCount(rs.getInt("count"));
				return tmp;
			}

		});
	}

	@Override
	public BoardDTO BoardView(int seq) {
		String sql = "select * from spring_board where seq=?";
		return template.queryForObject(sql, new Object[] {seq}, new RowMapper<BoardDTO>() {

			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardDTO tmp = new BoardDTO();
				tmp.setSeq(rs.getInt("seq"));
				tmp.setTitle(rs.getString("title"));
				tmp.setContents(rs.getString("contents"));
				tmp.setWriter(rs.getString("writer"));
				tmp.setCount(rs.getInt("count"));
				return tmp;
			}

		});
	}

	@Override
	public int delete(int seq) {
		String sql = "delete from spring_board where seq=?";
		return template.update(sql, seq);
	}

	@Override
	public int update(BoardDTO dto) {
		String sql = "update spring_board set contents=? where seq=?";
		return template.update(sql, dto.getContents(), dto.getSeq());
	}
	
	@Override
	public String getPageNavi(int currentPage) {
		String sql = "select count(*) totalCount from spring_board";
		
		int recordTotalCount=0;

		recordTotalCount = template.query(sql, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getInt(1);
			}
		}).get(0);
		
		int recordCountPerPage = 10; 
		int naviCountPerPage = 10;
		int pageTotalCount = 0; 

		if(recordTotalCount % recordCountPerPage > 0) { 
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}



		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = (currentPage - 1)/ naviCountPerPage * naviCountPerPage + 1;
		int endNavi = startNavi + (naviCountPerPage - 1);

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}


		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}

		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='boardView.do?currentPage="+(startNavi-1)+"'< </a>");
		}
		for(int i = startNavi;i <= endNavi;i++) {
			if(currentPage == i) {
				sb.append("<a href='boardView.do?currentPage=" + i + "'> <b>" + i + "</b></a>");
			}else {
				sb.append("<a href='boardView.do?currentPage=" + i + "'> " + i + "</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='boardView.do?currentPage="+(endNavi+1)+"'>></a>");
		}



		String result = sb.toString();

		return result;
	}*/

}
