package kh.spring.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kh.spring.dto.BoardDTO;
import kh.spring.interfaces.BoardDAO;

@Component
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private JdbcTemplate template;

	@Override
	public int insert(BoardDTO dto) {
		String sql = "insert into spring_board values(spring_board_seq.nextval, ?, ?, ?, ?)";
		return template.update(sql, dto.getTitle(),dto.getContents(), dto.getWriter(), dto.getCount());
	}

	@Override
	public List<BoardDTO> getList() {
		String sql = "select * from spring_board order by seq";
		return template.query(sql, new RowMapper<BoardDTO>(){

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
		String sql = "select * from board where seq=?";
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

}
