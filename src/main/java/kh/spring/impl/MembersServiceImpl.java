package kh.spring.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.MembersDTO;
import kh.spring.interfaces.MembersDAO;
import kh.spring.interfaces.MembersService;

@Component
public class MembersServiceImpl implements MembersService{
	
	@Autowired
	private MembersDAO dao;
	
	@Override
	public int idCheck(String id) {
		return dao.idCheck(id);
	}

	@Override
	public int insert(MembersDTO dto) {
		return dao.insert(dto);
	}

	@Override
	public int idpwcheck(MembersDTO dto) {
		return dao.idpwcheck(dto);
	}
	
	@Override
	public int delete(String id) {
		return dao.delete(id);
	}
	
	@Override
	public MembersDTO membersearch(String loginid) {
		return dao.membersearch(loginid);
	}
	@Override
	public int update(MembersDTO dto) {
		return dao.update(dto);
	}
}
