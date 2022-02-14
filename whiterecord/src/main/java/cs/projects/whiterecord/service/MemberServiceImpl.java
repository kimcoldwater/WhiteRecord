package cs.projects.whiterecord.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cs.projects.whiterecord.Mapper.MemberMapper;
import cs.projects.whiterecord.model.Member;
import cs.projects.whiterecord.repository.MemberRepository;
import cs.projects.whiterecord.util.MypageCriteria;
import cs.projects.whiterecord.util.TempKey;
import cs.projects.whiterecord.vo.ReviewVO;
import cs.projects.whiterecord.vo.SocialVO;

@Service
public class MemberServiceImpl implements MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired 
	private MemberMapper memberMapper;
	
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	

	
	public Member joinInsert(Member member) throws Exception{
		if(member.getPw() != "") {
		String pw = member.getPw();
		String inputPw = pwEncoder.encode(pw);
		member.setPw(inputPw);
		if(member.getName() == null || member.getName() == "") {
		member.setName(member.getId());
		}
		}
		return memberRepository.save(member);
	}
	
	public int idCheck(Member member)throws Exception{
		int idCheck = memberRepository.countById(member.getId());
		int result;
		if(idCheck == 1) {
			result = 1;
		}else {
			result = 0;
		}
		return result;
	}

	public Member login(Member login)throws Exception{
		Member member =  memberRepository.findById(login.getId());
		if(member == null) {
			return member = null;
		}
		boolean pwMatch = pwEncoder.matches(login.getPw(), member.getPw());
		if (pwMatch == true) {
			return member;
		}else {
			return member = null;
		}
	}
	
	public List<Member> findId(Member member)throws Exception{
		List<Member> findIdList = memberRepository.findByEmail(member.getEmail());
		return findIdList;
	}
	public String findPw(Member member)throws Exception{
		Member memberAll = memberRepository.findByIdAndEmail(member.getId(), member.getEmail());
		if(memberAll == null) {
			return "";
		}
		String memberKey = new TempKey().getKey(6,false);
		String inputPw = pwEncoder.encode(memberKey);
		memberAll.setPw(inputPw);
		memberRepository.save(memberAll);
		
		
		return memberKey;
	}
	
	public Member naverLogin(Member login)throws Exception{
		Member member =  memberRepository.findById(login.getId());
		return member;
	}

	
	public int nameCheck(Member member)throws Exception{
		return memberRepository.countByName(member.getName());
	}
	
	public void editId(Member member)throws Exception{
		memberMapper.editId(member);
	}
	
	public void editName(Member member)throws Exception{
		memberMapper.editName(member);
	}
	
	public void editEmail(Member member)throws Exception{
		memberMapper.editEmail(member);
	}
	
	public 	Member findByMno(Member member)throws Exception{
		return memberRepository.findByMno(member.getMno());
	}
	
	public void editImg(Member member)throws Exception{
		memberMapper.editImg(member);
	}

	public List<SocialVO> mypageSocial(MypageCriteria cri)throws Exception{
		return memberMapper.mypageSocial(cri);
	}
	
	public int mypageSocialCount(MypageCriteria cri)throws Exception{
		return memberMapper.mypageSocialCount(cri);
	}
	
	public List<ReviewVO> mypageReview(MypageCriteria cri)throws Exception{
		return memberMapper.mypageReview(cri);
	}
	
	public int mypageReviewCount(MypageCriteria cri)throws Exception{
		return memberMapper.mypageReviewCount(cri);
	}
}
