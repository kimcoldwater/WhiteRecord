package cs.projects.whiterecord.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import cs.projects.whiterecord.model.Social;
import cs.projects.whiterecord.service.SocialService;
import cs.projects.whiterecord.util.Criteria;
import cs.projects.whiterecord.util.FileUtils;
import cs.projects.whiterecord.util.PageMaker;

@RestController
@RequestMapping("social")
public class SocialController {
	
	private static final Logger logger = LoggerFactory.getLogger(SocialController.class);

	@Autowired
	private SocialService socialService;

	
	@GetMapping("/social-view")
	public ModelAndView socialView() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/social/social-view");
		return modelAndView;
	}
	
	@GetMapping("/social-content")
	public Map<String,Object> socialContent(Criteria cri) throws Exception{
		logger.info("cri.offerdate"+cri.getOfferdate());
		Map<String,Object> result = new HashMap<String,Object>();
		List<Social> socialList = socialService.SocialConetent(cri);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(socialService.socialCount(cri));
		result.put("pageMaker", pageMaker);
		result.put("socialList", socialList);
		return result;
	}
	
	//나중에 세션null이면 걸러내기
	@GetMapping("/social-create")
	public ModelAndView socialCreate() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/social/social-create");
		return modelAndView;
	}
	
	@PostMapping("/social-create")
	public String socialWrite(Social social) throws Exception{
		
		if(social.getCategori().equals("동호회") ){
			social.setEnddate(social.getOfferdate());
			social.setOfferdate(null);
		}
		
		social.setMno(1); // 나중에 세션값 넣기
		social.setId("test");
		socialService.socialWrite(social);
		
		String result = "작성완료";
		return result;
	}
	
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
