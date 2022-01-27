package cs.projects.whiterecord.service;

import java.util.List;

import cs.projects.whiterecord.model.Location;
import cs.projects.whiterecord.model.Review;
import cs.projects.whiterecord.util.MapCriteria;
import cs.projects.whiterecord.util.ReviewCriteria;
import cs.projects.whiterecord.vo.LocationVO;
import cs.projects.whiterecord.vo.ReviewVO;

public interface MapService {

	//이미 저장된 장소인지 확인
	public int locationCheck(Location location)throws Exception;
	
	//장소저장
	public Location locationInsert(Location location) throws Exception;
	
	//리뷰저장
	public Review reviewInsert(Review review , Location location)throws Exception;
	
	//맵
	public int locationCount(MapCriteria cri)throws Exception;
	
	public List<LocationVO> locationView(MapCriteria cri)throws Exception;
	
	//리뷰
	public List<ReviewVO> reviewContent(ReviewCriteria reviewCriteria)throws Exception;
	
	public int reviewCount(ReviewCriteria reviewCriteria)throws Exception;
	
	public Review editView(Long rno)throws Exception;
	
	public void reviewEdit(Review review)throws Exception;
	
	public void reviewDelete(Review review)throws Exception;
	
}
