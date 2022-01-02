package cs.projects.whiterecord.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


	
	@GetMapping("/index")
	public String index() throws Exception {
		Document doc = Jsoup.connect("https://www.naver.com/").get();
		Elements elem = doc.select("#search_btn");
		logger.info("되니?"+elem);
		return "/index";
	}
	
}
	
