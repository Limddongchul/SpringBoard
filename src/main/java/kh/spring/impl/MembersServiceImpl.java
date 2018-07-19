package kh.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
