package cs.projects.whiterecord.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("list")
public class ListController {

	private static final Logger logger = LoggerFactory.getLogger(ListController.class);
	

	@GetMapping("list-view")
	public ModelAndView listView() throws Exception{
		
	
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list/list-view");

		return modelAndView;
	}
	

}
