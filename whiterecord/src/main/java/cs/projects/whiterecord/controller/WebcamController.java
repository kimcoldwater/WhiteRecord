package cs.projects.whiterecord.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebcamController {
	
	private static final Logger logger = LoggerFactory.getLogger(WebcamController.class);


	
	@GetMapping("/webcamResort")
	public String webcamResort() throws Exception {

		return "webcam/webcamResort";
	}
	
	@GetMapping("/webcamJisan")
	public String webcamJisan() throws Exception {

		return "webcam/webcamJisan";
	}
	
}
	
