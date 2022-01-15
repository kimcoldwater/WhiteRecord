package cs.projects.whiterecord.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cs.projects.whiterecord.Mapper.MemberMapper;
import cs.projects.whiterecord.model.Member;
import cs.projects.whiterecord.repository.MemberRepository;
import cs.projects.whiterecord.util.TempKey;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired 
	private MemberMapper memberMapper;
	
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	

	
	public Member joinInsert(Member member) throws Exception{
		String pw = member.getPw();
		String inputPw = pwEncoder.encode(pw);
		member.setPw(inputPw);
		if(member.getName() == null || member.getName() == "") {
		member.setName(member.getId());
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
	
}
