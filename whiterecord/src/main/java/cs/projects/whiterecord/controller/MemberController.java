package cs.projects.whiterecord.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import cs.projects.whiterecord.model.Member;
import cs.projects.whiterecord.service.MemberService;
import cs.projects.whiterecord.util.FileUtils;
import cs.projects.whiterecord.util.MyPageMaker;
import cs.projects.whiterecord.util.MypageCriteria;
import cs.projects.whiterecord.vo.NaverInfoVO;
import cs.projects.whiterecord.vo.NaverLoginVO;
import cs.projects.whiterecord.vo.ReviewVO;
import cs.projects.whiterecord.vo.SocialVO;

@RestController
@RequestMapping("member")
public class MemberController {
		
		private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
		
		@Autowired
		private MemberService memberService;
		
		@Autowired
		private FileUtils fileUtils;
		
		String result="";
		
		@GetMapping("join")
		public ModelAndView joinView(HttpSession session) throws Exception{
			Member member = (Member) session.getAttribute("member");
			ModelAndView modelAndView = new ModelAndView();
			if(member != null) {
			modelAndView.setViewName("redirect:/social/social-view");
			return modelAndView;	
			}
			modelAndView.setViewName("member/join");
			return modelAndView;
		}
		
		@PostMapping("join")
		public String joinInsert(Member member) throws Exception{
			memberService.joinInsert(member);
			result="회원가입 완료";
			return result;

			
		}
		
		@PostMapping("idCheck")
		public int idCheck(Member member)throws Exception{
			int result = memberService.idCheck(member);

			return result;
		}
		
		@GetMapping("login")
		public ModelAndView loginView(HttpSession session) throws Exception{
			Member member = (Member) session.getAttribute("member");
			ModelAndView modelAndView = new ModelAndView();
			if(member != null) {
			modelAndView.setViewName("redirect:/social/social-view");
			return modelAndView;	
			}
			modelAndView.setViewName("member/login");
			return modelAndView;
		}
		
		@PostMapping("login")
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
		
		@GetMapping("naver")
		public ModelAndView logion(String code,HttpServletRequest request)throws Exception{
			HttpSession session = request.getSession();
			
			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper mapper = new ObjectMapper();
			
			//Access Token받기
			HttpHeaders headersAccess = new HttpHeaders();
			headersAccess.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			
			MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
			params.add("grant_type", "authorization_code");
			params.add("client_id","ac37f9d7520c09a7ebac6b58d274743f");
			params.add("redirect_uri","http://13.125.0.44:8080/member/naver");
			params.add("code", code);
			
			HttpEntity<MultiValueMap<String, String>> kakaoRequest = new HttpEntity<>(params, headersAccess);
			
			ResponseEntity<String> response = restTemplate.exchange("https://kauth.kakao.com/oauth/token"
			, HttpMethod.POST, kakaoRequest, String.class);
			NaverLoginVO naverVO = mapper.readValue(response.getBody(), NaverLoginVO.class);
			
			//사용자정보 가져오기
			HttpHeaders headersInfo = new HttpHeaders();
			headersInfo.add("Authorization", "Bearer " + naverVO.getAccess_token());
			headersInfo.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			
			HttpEntity<HttpHeaders> kakaoInfo = new HttpEntity<>(headersInfo);
			
			ResponseEntity<String> infoResponse = restTemplate.exchange("https://kapi.kakao.com/v2/user/me", 
					HttpMethod.POST, kakaoInfo , String.class);
			NaverInfoVO infoVO = mapper.readValue(infoResponse.getBody(), NaverInfoVO.class);
			String nickname = String.valueOf(infoVO.getProperties().get("nickname"));
			String id = String.valueOf(infoVO.getId());
			
			Member member = new Member();
			member.setId(id);
			if(memberService.idCheck(member) == 0) {
				member.setName(nickname);
				memberService.joinInsert(member);
				Member login = memberService.naverLogin(member);
				session.setAttribute("member", login);
			}else {
				Member login = memberService.naverLogin(member);
				session.setAttribute("member", login);
			}
			
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("redirect:/social/social-view");
			return modelAndView;
			
		}
		
		
		@PostMapping("logout")
		public void logout(HttpSession session)throws Exception{
			session.invalidate();
		}
		
		@GetMapping("findId")
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
	
		@PostMapping("findPw")
		public String findPw(Member member)throws Exception{
			logger.info("들어옴?"+member.getEmail()+member.getId());
			String newPw = memberService.findPw(member);
			return newPw;
		}
		
		
		@GetMapping("info-edit")
		public ModelAndView infoEdit(HttpSession session) throws Exception{
			ModelAndView modelAndView = new ModelAndView();
			if(session.getAttribute("member")==null) {
				modelAndView.setViewName("redirect:/member/login");
				return modelAndView;
						
			}
			
			modelAndView.setViewName("member/info-edit");
			return modelAndView;
		}
		
		@PostMapping("editName")
		public int editName(Member member,HttpSession session) throws Exception{
			int data = 0;			
			
			if(memberService.nameCheck(member) == 0) {
			Member memberVO = (Member) session.getAttribute("member");
			member.setMno(memberVO.getMno());
			memberService.editName(member);
			Member reSession = memberService.findByMno(member);
			session.setAttribute("member", reSession);
			}else {
				data = 1;
			}
		return data;	
		}
		@PostMapping("editId")
		public int editId(Member member,HttpSession session) throws Exception{
			int data = 0;
			if(memberService.idCheck(member) == 0) {
			Member memberVO = (Member) session.getAttribute("member");
			member.setMno(memberVO.getMno());
			memberService.editId(member);
			Member reSession = memberService.findByMno(member);
			session.setAttribute("member", reSession);
			}else {
				data = 1;
			}
			return data;	
		}
		@PostMapping("editEmail")
		public int editEmail(Member member,HttpSession session) throws Exception{
			Member memberVO = (Member) session.getAttribute("member");
			member.setMno(memberVO.getMno());
			memberService.editEmail(member);
			Member reSession = memberService.findByMno(member);
			session.setAttribute("member", reSession);
			int data = 0;
			return data;	
		}
		
		@PostMapping("editImg")
		public void editImg(MultipartHttpServletRequest multipart,HttpSession session,Member member) throws Exception{
			String img = fileUtils.memberImg(multipart);
			logger.info("img"+img);
			Member memberVO = (Member) session.getAttribute("member");
			member.setMno(memberVO.getMno());
			member.setImg(img);
			memberService.editImg(member);
			Member reSession = memberService.findByMno(member);
			session.setAttribute("member", reSession);
	
		}
		
		//마이페이지
		@GetMapping("mypage")
		public ModelAndView mypageView() throws Exception{
		//	Member member = (Member) session.getAttribute("member");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("member/mypage");
			return modelAndView;
		}
		
		@GetMapping("mypage-social")
		public Map<String,Object> mypageSocial(MypageCriteria cri) throws Exception{
			Map<String,Object> result = new HashMap<String,Object>();
			List<SocialVO> socialList = memberService.mypageSocial(cri);
			MyPageMaker pageMaker = new MyPageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(memberService.mypageSocialCount(cri));
			result.put("pageMaker", pageMaker);
			result.put("socialList", socialList);
			return result;	
		}
		
		@GetMapping("mypage-review")
		public Map<String,Object> mypageReview(MypageCriteria cri) throws Exception{
			Map<String,Object> result = new HashMap<String,Object>();
			List<ReviewVO> revList = memberService.mypageReview(cri);
			MyPageMaker pageMaker = new MyPageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(memberService.mypageReviewCount(cri));
			result.put("pageMaker", pageMaker);
			result.put("revList", revList);
			return result;	
		}
}
