package cs.projects.whiterecord.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cs.projects.whiterecord.model.Review;
import cs.projects.whiterecord.util.MapCriteria;
import cs.projects.whiterecord.util.ReviewCriteria;
import cs.projects.whiterecord.vo.LocationVO;
import cs.projects.whiterecord.vo.ReviewVO;

@Mapper
public interface MapMapper {

	public List<LocationVO> locationView(MapCriteria mapCriteria) throws Exception;
	
	public int locationCount(MapCriteria mapCriteria) throws Exception;
	
	public List<ReviewVO> reviewContent(ReviewCriteria reviewCriteria)throws Exception;
	
	public int reviewCount(ReviewCriteria reviewCriteria)throws Exception;
	
	public void locationImg(Long lno,String imgScr)throws Exception;
	
	public void reviewCnt(Long lno)throws Exception;
	
	public void reviewCntDown(Long lno)throws Exception;
	
	
	public void reviewEdit(Map<String, Object> map)throws Exception;

	public void reviewImgEdit(String rimg, Long rno)throws Exception;
	
	public void reviewViewCnt(Long rno)throws Exception;
	
}
