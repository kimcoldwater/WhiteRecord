package cs.projects.whiterecord.service;

import java.util.List;

import cs.projects.whiterecord.model.Member;
import cs.projects.whiterecord.util.MypageCriteria;
import cs.projects.whiterecord.vo.ReviewVO;
import cs.projects.whiterecord.vo.SocialVO;

public interface MemberService {

	public Member joinInsert(Member member) throws Exception;
	
	public int idCheck(Member member)throws Exception;
	
	public Member login(Member member)throws Exception;
	
	public List<Member> findId(Member member)throws Exception;
	
	public String findPw(Member member)throws Exception;
	
	public Member naverLogin(Member login)throws Exception;
	
	public int nameCheck(Member member)throws Exception;
	
	public void editId(Member member)throws Exception;
	
	public void editName(Member member)throws Exception;
	
	public void editEmail(Member member)throws Exception;
	
	public 	Member findByMno(Member member)throws Exception;
	
	public void editImg(Member member)throws Exception;
	
	public List<SocialVO> mypageSocial(MypageCriteria cri)throws Exception;
	
	public int mypageSocialCount(MypageCriteria cri)throws Exception;

	public List<ReviewVO> mypageReview(MypageCriteria cri)throws Exception;
	
	public int mypageReviewCount(MypageCriteria cri)throws Exception;
}
