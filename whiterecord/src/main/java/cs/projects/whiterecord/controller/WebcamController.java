package cs.projects.whiterecord.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("webcam")
public class WebcamController {
	
	private static final Logger logger = LoggerFactory.getLogger(WebcamController.class);


	
	@GetMapping("/webcam-resort")
	public String webcamResort() throws Exception {

		return "webcam/webcam-resort";
	}
	
	@GetMapping("/webcam-jisan")
	public String webcamJisan() throws Exception {

		return "webcam/webcam-jisan";
	}
	
	@GetMapping("/webcam-phoenix")
	public String webcamPhoenix() throws Exception {

		return "webcam/webcam-phoenix";
	}
	
	@GetMapping("/webcam-yongpyong")
	public String webcamYongpyong() throws Exception {

		return "webcam/webcam-yongpyong";
	}
	
	
	@GetMapping("/webcam-wellihilli")
	public String webcamWellihilli() throws Exception {

		return "webcam/webcam-wellihilli";
	}
	
	@GetMapping("/webcam-konjiam")
	public String webcamKonjiam() throws Exception {

		return "webcam/webcam-konjiam";
	}
	
	@GetMapping("/webcam-high1")
	public String webcamHigh1() throws Exception {

		return "webcam/webcam-high1";
	}

	@GetMapping("/webcam-elysian")
	public String webcamElysian() throws Exception {

		return "webcam/webcam-elysian";
	}
	
	@GetMapping("/webcam-vivaldi")
	public String webcamVivaldi() throws Exception {

		return "webcam/webcam-vivaldi";
	}

	@GetMapping("/webcam-oakvalley")
	public String webcamOakvalley() throws Exception {

		return "webcam/webcam-oakvalley";
	}	
	
	@GetMapping("/webcam-muju")
	public String webcamMuju() throws Exception {

		return "webcam/webcam-muju";
	}		

	@GetMapping("/webcam-eden")
	public String webcamEden() throws Exception {

		return "webcam/webcam-eden";
	}		
	
	
	
	
}
	
