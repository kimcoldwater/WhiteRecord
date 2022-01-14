package cs.projects.whiterecord.controller;

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
}
