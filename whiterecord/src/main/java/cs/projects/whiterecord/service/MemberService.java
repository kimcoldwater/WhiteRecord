package cs.projects.whiterecord.service;

import java.util.List;

import cs.projects.whiterecord.model.Member;

public interface MemberService {

	public Member joinInsert(Member member) throws Exception;
	
	public int idCheck(Member member)throws Exception;
	
	public Member login(Member member)throws Exception;
	
	public List<Member> findId(Member member)throws Exception;
	
	public String findPw(Member member)throws Exception;
}
