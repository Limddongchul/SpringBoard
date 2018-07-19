package kh.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kh.spring.dto.MembersDTO;
import kh.spring.interfaces.MembersDAO;

@Component
public class MembersDAOImpl implements MembersDAO {

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public int idCheck(String id) {
		String sql = "select id from spring_member where id=?";
		return template.update(sql, id);
	}

	@Override
	public int insert(MembersDTO dto) {
		String sql = "insert into spring_members values(spring_member_seq.nextval, ?, ?, ?)";
		return template.update(sql, dto.getId(), dto.getPw(), dto.getName());
	}

}
