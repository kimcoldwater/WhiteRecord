package cs.projects.whiterecord.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("map")
public class MapController {
	
	private static final Logger logger = LoggerFactory.getLogger(MapController.class);


	
	@GetMapping("/taste")
	public ModelAndView tasteView() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/map/taste");
		return modelAndView;

	}

	
	
	
	
}
	
