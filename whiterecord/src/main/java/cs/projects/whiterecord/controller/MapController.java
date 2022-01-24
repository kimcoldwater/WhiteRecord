package cs.projects.whiterecord.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cs.projects.whiterecord.model.Location;
import cs.projects.whiterecord.model.Member;
import cs.projects.whiterecord.model.Review;
import cs.projects.whiterecord.service.MapService;
import cs.projects.whiterecord.util.MapCriteria;
import cs.projects.whiterecord.util.MapPageMaker;
import cs.projects.whiterecord.vo.LocationVO;


@RestController
@RequestMapping("map")
public class MapController {
	
	private static final Logger logger = LoggerFactory.getLogger(MapController.class);


	@Autowired
	private MapService mapService;
	
	String result = "";
	
	@GetMapping("/taste")
	public ModelAndView tasteView() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/map/taste");
		if(result != "") {
		modelAndView.addObject("result", result);
		result="";
		}
		return modelAndView;

	}
	
	@GetMapping("/location-view")
	public Map<String, Object> locationView(MapCriteria mapCriteria)throws Exception{
	Map<String,Object> result = new HashMap<String,Object>();
	List<LocationVO> locaList = mapService.locationView(mapCriteria);
	MapPageMaker pageMaker = new MapPageMaker();
	pageMaker.setCri(mapCriteria);
	pageMaker.setTotalCount(mapService.locationCount(mapCriteria));
	result.put("pageMaker", pageMaker);
	result.put("locaList", locaList);
	return result;
	}
	
	@GetMapping("/taste-write")
	public ModelAndView tasteWriteView(HttpSession session) throws Exception {
		Member member = (Member) session.getAttribute("member");
		ModelAndView modelAndView = new ModelAndView();

		if(member == null) {
			result = "로그인이 필요합니다.";
			modelAndView.setViewName("/map/taste");
			modelAndView.addObject("result", result);
			result="";
			return modelAndView;	
		}

		modelAndView.setViewName("/map/taste-write");

		return modelAndView;
	}
	
	@PostMapping("/taste-write")
	public String tasteWrite(Location location,Review review,HttpSession session) throws Exception{
		
		logger.info("?"+location+review);
		Member member = (Member) session.getAttribute("member");
		if(member == null) {
			result = "로그인이 필요합니다.";
			return result;
		}
		Long mno = member.getMno();
		int locationCheck = mapService.locationCheck(location);
		if(locationCheck == 0 ) {
		location.setMno(mno);
		mapService.locationInsert(location);
		}
		review.setMno(mno);
		mapService.reviewInsert(review,location);
		result = "리뷰 작성 완료";
		return result;
	}
	
	
	
	
}
	
