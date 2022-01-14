package cs.projects.whiterecord.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cs.projects.whiterecord.Mapper.MemberMapper;
import cs.projects.whiterecord.model.Member;
import cs.projects.whiterecord.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired 
	private MemberMapper memberMapper;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	

	
	public Member joinInsert(Member member) throws Exception{
		String pw = member.getPw();
		String inputPw = passwordEncoder.encode(pw);
		member.setPw(inputPw);

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


}
