package kh.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.MembersDTO;
import kh.spring.interfaces.MembersDAO;
import kh.spring.interfaces.MembersService;

@Component
public class MembersServiceImpl implements MembersService {

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

import kh.spring.interfaces.MembersDAO;
import kh.spring.interfaces.MembersService;

@Component
public class MembersServiceImpl implements MembersService{
	
	@Autowired
	private MembersDAO dao;
	
	
	@Override
	public int idpwcheck(String id, String pw) {
		return dao.idpwcheck(id, pw);
	}
}
