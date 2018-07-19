package kh.spring.interfaces;

import kh.spring.dto.MembersDTO;

public interface MembersDAO {
	public int idCheck(String id);
	public int insert(MembersDTO dto);
}
