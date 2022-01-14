package cs.projects.whiterecord.service;

import cs.projects.whiterecord.model.Member;

public interface MemberService {

	public Member joinInsert(Member member) throws Exception;
	
	public int idCheck(Member member)throws Exception;
}
