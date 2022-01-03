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
	
	@GetMapping("/webcamPhoenix")
	public String webcamPhoenix() throws Exception {

		return "webcam/webcamPhoenix";
	}
	
	@GetMapping("/webcamYongpyong")
	public String webcamYongpyong() throws Exception {

		return "webcam/webcamYongpyong";
	}
	
	
	@GetMapping("/webcamWellihilli")
	public String webcamWellihilli() throws Exception {

		return "webcam/webcamWellihilli";
	}
	
	@GetMapping("/webcamKonjiam")
	public String webcamKonjiam() throws Exception {

		return "webcam/webcamKonjiam";
	}
	
	@GetMapping("/webcamHigh1")
	public String webcamHigh1() throws Exception {

		return "webcam/webcamHigh1";
	}

	@GetMapping("/webcamElysian")
	public String webcamElysian() throws Exception {

		return "webcam/webcamElysian";
	}
	
	
	
}
	
