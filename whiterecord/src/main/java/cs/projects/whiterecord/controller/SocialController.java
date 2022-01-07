package cs.projects.whiterecord.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cs.projects.whiterecord.model.Social;
import cs.projects.whiterecord.service.SocialService;
import cs.projects.whiterecord.util.Criteria;
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
		Map<String,Object> result = new HashMap<String,Object>();
		List<Social> socialList = socialService.SocialConetent(cri);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(socialService.socialCount(cri));
		result.put("pageMaker", pageMaker);
		result.put("socialList", socialList);
		return result;
	}
	
	
}
