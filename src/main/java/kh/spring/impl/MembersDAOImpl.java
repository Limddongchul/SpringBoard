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
	public int idpwcheck(String id, String pw) {
		String sql = "select * from spring_member where id=? and pw=?";
		return template.update(sql,id,pw);
	}
}
