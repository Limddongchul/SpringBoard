package kh.spring.interfaces;

import kh.spring.dto.MembersDTO;

public interface MembersDAO {
	public int idCheck(String id);
	public int insert(MembersDTO dto);
	public int idpwcheck(String id, String pw);
	public int delete(String id);
	public List<MembersDTO> membersearch(String loginid);
}
