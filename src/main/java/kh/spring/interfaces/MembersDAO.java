package kh.spring.interfaces;

import java.util.List;

import kh.spring.dto.MembersDTO;

public interface MembersDAO {
	public int idCheck(String id);
	public int insert(MembersDTO dto);
	public int idpwcheck(String id, String pw);
	
}
