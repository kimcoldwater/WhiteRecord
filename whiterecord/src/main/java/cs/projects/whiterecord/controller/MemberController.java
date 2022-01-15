package cs.projects.whiterecord.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cs.projects.whiterecord.model.Member;
import cs.projects.whiterecord.service.MemberService;

@RestController
@RequestMapping("member")
public class MemberController {
		
		private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
		
		@Autowired
		private MemberService memberService;
		
		String result="";
		
		@GetMapping("/join")
		public ModelAndView joinView() throws Exception{
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("/member/join");
			return modelAndView;
		}
		
		@PostMapping("/join")
		public String joinInsert(Member member) throws Exception{
			memberService.joinInsert(member);
			result="회원가입 완료";
			return result;

			
		}
		
		@PostMapping("/idCheck")
		public int idCheck(Member member)throws Exception{
			int result = memberService.idCheck(member);

			return result;
		}
		
		@GetMapping("/login")
		public ModelAndView loginView() throws Exception{
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("/member/login");
			return modelAndView;
		}
		
		@PostMapping("/login")
		public String login(Member login,HttpServletRequest request) throws Exception{
			Member member = memberService.login(login);
			HttpSession session = request.getSession();
			if(member != null) {	
				if(session.getAttribute("member") != null) {
				session.removeAttribute("member"); 
			}
				session.setAttribute("member", member);
				result="로그인 완료";
				return result;
				}else {
					result="아이디와 비밀번호를 확인해주세요";
					return result;
				}
		}
		
		@PostMapping("/logout")
		public void logout(HttpSession session)throws Exception{
			session.invalidate();
		}
		
		@GetMapping("/findId")
		public Map<String,Object> findId(Member member)throws Exception{
			Map<String,Object> result = new HashMap<String,Object>();
			List<Member> idList = memberService.findId(member);
			if(idList == null) {
				result.put("idList", null);
				logger.info("null 들옴??");
				return result;
			}
			result.put("idList", idList);
			return result;
		}
	
		@PostMapping("/findPw")
		public String findPw(Member member)throws Exception{
			logger.info("들어옴?"+member.getEmail()+member.getId());
			String newPw = memberService.findPw(member);
			return newPw;
		}
		
}
