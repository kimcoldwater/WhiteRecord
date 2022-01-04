package cs.projects.whiterecord.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SocialController {

	
	
	private static final Logger logger = LoggerFactory.getLogger(SocialController.class);

	
	@GetMapping("/socialView")
	public String socialView() throws Exception{
		return "/social/socialView";
	}
}
