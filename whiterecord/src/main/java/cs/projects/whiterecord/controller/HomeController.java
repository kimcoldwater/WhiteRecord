package cs.projects.whiterecord.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


	
	@GetMapping("resort/info")
	public ModelAndView resortInfo() throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("resort/info");
		
		return modelAndView;
	}
	
	@GetMapping("home")
	public ModelAndView index() throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		
		return modelAndView;
		
	}
	
}
	
