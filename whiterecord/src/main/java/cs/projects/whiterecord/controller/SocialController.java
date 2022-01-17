package cs.projects.whiterecord.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import cs.projects.whiterecord.model.Member;
import cs.projects.whiterecord.model.Social;
import cs.projects.whiterecord.service.SocialService;
import cs.projects.whiterecord.util.Criteria;
import cs.projects.whiterecord.util.FileUtils;
import cs.projects.whiterecord.util.PageMaker;
import cs.projects.whiterecord.vo.SocialVO;

@RestController
@RequestMapping("social")
public class SocialController {
	
	private static final Logger logger = LoggerFactory.getLogger(SocialController.class);

	@Autowired
	private SocialService socialService;

	String result = "";
	
	@GetMapping("/social-view")
	public ModelAndView socialView() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/social/social-view");
		if(result != "") {
			modelAndView.addObject("result", result);
			result = "";
		}
		return modelAndView;
	}
	
	//회원만 삭제 가능하도록 변경
	@DeleteMapping("social-view")
	public String socialDelete(Social social)throws Exception{
		socialService.socialDelete(social);
		result=social.getSno()+"번 글이 삭제되었습니다.";
		return result;
	}
	
	@GetMapping("/social-content")
	public Map<String,Object> socialContent(Criteria cri) throws Exception{
		logger.info("cri.offerdate"+cri.getOfferdate());
		Map<String,Object> result = new HashMap<String,Object>();
		List<SocialVO> socialList = socialService.SocialConetent(cri);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(socialService.socialCount(cri));
		result.put("pageMaker", pageMaker);
		result.put("socialList", socialList);
		return result;
	}
	
	@GetMapping("/social-create")
	public ModelAndView socialCreate(HttpSession session) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		if(session.getAttribute("member") == null) {
		modelAndView.setViewName("/member/login");
		modelAndView.addObject("result", "글을 작성하시면 로그인해주세요.");
		}else {
		modelAndView.setViewName("/social/social-create");
		}
		return modelAndView;
	}
	
	@PostMapping("/social-create")
	public String socialWrite(Social social,HttpSession session) throws Exception{
		if(session.getAttribute("member") == null) {
			result = "작성실패, 로그인을 해주세요";
			return result;
		}

		socialService.socialWrite(social,session);
		
		result="글 작성 완료";
		return result;
	}
	
	//나중에 session == updateContent.mno 체크하기
	@GetMapping("/social-update")
	public ModelAndView socialUpdateView(Long sno,HttpSession session) throws Exception{
		Social socialContent = socialService.socialUpdateContent(sno).get();
		Member member = (Member) session.getAttribute("member");
		
		ModelAndView modelAndView = new ModelAndView();
		//작성자인지 확인
		if(member == null ||member.getMno() != socialContent.getMno()) {
			modelAndView.setViewName("/social/social-view");
			modelAndView.addObject("result", "본인만 수정 가능합니다");
			return modelAndView;
		}
		modelAndView.setViewName("/social/social-update");
		modelAndView.addObject("updateContent", socialContent);
		return modelAndView;
		
	}
	
	@PutMapping("social-update")
	public String socialUpdate(Social social)throws Exception{
	
		socialService.socialUpdate(social);
		
		result=social.getSno()+"번 글이 수정되었습니다.";
		return result;
	}
	

	
	
	//나중에 파일테이블 만들어서 글 삭제시 같이 삭제되도록 하기
	@PostMapping("/uploadImg")
	public Map<String,Object> image( MultipartHttpServletRequest multipart) throws Exception{
		logger.info("updateImg");
		FileUtils fileUtils = new FileUtils();
		String imgPath = fileUtils.uploadImg(multipart);
		
		Map<String, Object> mapp = new HashMap<String, Object>();
		  logger.info("imgPath"+imgPath);  

	    mapp.put("uploaded", true);
	    mapp.put("url", imgPath);
	    return mapp;
	}
	
	
}
