package cs.projects.whiterecord.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cs.projects.whiterecord.model.Density;
import cs.projects.whiterecord.service.DensityService;

@RestController
@RequestMapping("density")
public class DensityController {

	private static final Logger logger = LoggerFactory.getLogger(DensityController.class);
	

	@Autowired
	private DensityService densityService;
	
	@GetMapping("/density-view")
	public ModelAndView densityView() throws Exception{
		
		
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/density/density-view");
		
		
		return modelAndView;
	}
	
	@GetMapping("/density-list")
	public Map<String,Object> densityList(Density density) throws Exception{

		Map<String,Object> result = new HashMap<>();
		result.put("densityList", densityService.densityList(density));
		

		
		return result;
	}

}
