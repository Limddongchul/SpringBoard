package kh.spring.interfaces;

import java.util.List;

import kh.spring.dto.MembersDTO;

public interface MembersService {
	public int idCheck(String id);
	public int insert(MembersDTO dto);
	public int idpwcheck(MembersDTO dto);
	public int delete(String id);
	public MembersDTO membersearch(String loginid);
	public int update(MembersDTO dto);
	
}
