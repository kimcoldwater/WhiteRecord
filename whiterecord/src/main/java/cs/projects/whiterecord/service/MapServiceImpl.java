package cs.projects.whiterecord.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.projects.whiterecord.Mapper.MapMapper;
import cs.projects.whiterecord.model.Location;
import cs.projects.whiterecord.model.Review;
import cs.projects.whiterecord.repository.LocationRepository;
import cs.projects.whiterecord.repository.ReviewRepository;
import cs.projects.whiterecord.util.FileUtils;
import cs.projects.whiterecord.util.MapCriteria;
import cs.projects.whiterecord.util.ReviewCriteria;
import cs.projects.whiterecord.vo.LocationVO;
import cs.projects.whiterecord.vo.ReviewVO;

@Service
public class MapServiceImpl implements MapService {

	private static final Logger logger = LoggerFactory.getLogger(MapServiceImpl.class);

	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired 
	private MapMapper mapMapper;
	
	@Autowired
	private FileUtils fileUtils;
	
	
	public Location locationInsert(Location location) throws Exception{

		return locationRepository.saveAndFlush(location);
	}
	
	public int locationCheck(Location location)throws Exception{
		int check = locationRepository.countByLnameAndAddress(location.getLname(), location.getAddress());
		return check;
	}

	
	public Review reviewInsert(Review review, Location location)throws Exception{
		Location locationLno = locationRepository.findByLnameAndAddress(location.getLname(), location.getAddress());
		String imgSrc = getImgSrc(review.getContent());
		review.setLno(locationLno.getLno());
		review.setCategori(location.getCategori());
		review.setResort(location.getResort());
		if(imgSrc != "") {
		review.setRimg(imgSrc);
		//업데이트 시 최신리뷰 썸네일로 location 사진을 변경
		mapMapper.locationImg(locationLno.getLno(),imgSrc);
		review.setContent(fileUtils.moveImg(review.getContent()));
		}
		//location에 리뷰카운트 +1
		mapMapper.reviewCnt(locationLno.getLno());
		return reviewRepository.save(review);
	}
	
	//리뷰 중 첫번째 사진 썸네일로 지정
	public String getImgSrc(String content) {
		  Pattern nonValidPattern = Pattern
			  		.compile("(?i)< *[IMG][^\\>]*[src] *= *[\"\']{0,1}([^\"\'\\ >]*)");
			  		int imgCnt = 0;
			  		String img = "";
			  		Matcher matcher = nonValidPattern.matcher(content);
			  		while (matcher.find()) {
			  			img = matcher.group(1);
			  			img = img.replace("/img", "/image");
			  		
			  			imgCnt++;
			  			if(imgCnt == 1){
			  		        break;                                  
			  		    }
			  		}
			  		return img;
	}
	
	public int locationCount(MapCriteria mapCriteria)throws Exception{
		return mapMapper.locationCount(mapCriteria);
		
	}
	
	public List<LocationVO> locationView(MapCriteria mapCriteria)throws Exception{
		return mapMapper.locationView(mapCriteria);
	}
	
	public List<ReviewVO> reviewContent(ReviewCriteria reviewCriteria)throws Exception{
		return mapMapper.reviewContent(reviewCriteria);
	}
	
	public int reviewCount(ReviewCriteria reviewCriteria)throws Exception{
		return mapMapper.reviewCount(reviewCriteria);
	}
	
	//수정뷰
	public Review editView(Long rno)throws Exception{
		return reviewRepository.findByRno(rno);
	}

	public void reviewEdit(Review review)throws Exception{
	String imgSrc = getImgSrc(review.getContent());
	if(imgSrc != "") {
		review.setContent(fileUtils.moveImg(review.getContent()));
		
	}
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("rno", review.getRno());
	map.put("title",review.getTitle());
	map.put("content",review.getContent());
	map.put("resort",review.getResort());
	map.put("categori", review.getCategori());
	map.put("rimg", imgSrc);
	mapMapper.reviewEdit(map);
	}
	
	
	public void reviewDelete(Review review)throws Exception{
		reviewRepository.deleteById(review.getRno());
		mapMapper.reviewCntDown(review.getLno());
	}

	public void reviewViewCnt(Long rno)throws Exception{
		mapMapper.reviewViewCnt(rno);
	}

}
