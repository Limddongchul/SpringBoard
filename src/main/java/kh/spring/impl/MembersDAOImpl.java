package kh.spring.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kh.spring.dto.MembersDTO;
import kh.spring.interfaces.MembersDAO;


@Component
public class MembersDAOImpl implements MembersDAO{
	
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public int idCheck(String id) {
		String sql = "select id from spring_member where id=?";
		return template.update(sql, id);
	}

	@Override
	public int insert(MembersDTO dto) {
		String sql = "insert into spring_member values(spring_member_seq.nextval, ?, ?, ?)";
		return template.update(sql, dto.getId(), dto.getPw(), dto.getName());
	}

	
	@Override
	public int idpwcheck(MembersDTO dto) {
		String sql = "select * from spring_member where id=? and pw=?";
		return template.update(sql,dto.getId(),dto.getPw());
	}
	
	@Override
	public int delete(String id) {
		String sql = "delete from spring_member where id=?";
		return template.update(sql, id);
	}
	
	@Override
	public MembersDTO membersearch(String loginid) {
		return template.queryForObject("select * from spring_member where id=?", new Object[] {loginid}, new RowMapper<MembersDTO>() {
			@Override
			public MembersDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MembersDTO dto = new MembersDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				return dto;
			}
		});
	}
	
	@Override
	public int update(MembersDTO dto) {
		String sql = "update spring_member set name=?, pw=? where id=?";
		return template.update(sql, dto.getName(),dto.getPw(),dto.getId());
	}
}
