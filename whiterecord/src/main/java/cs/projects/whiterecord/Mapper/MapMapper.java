package cs.projects.whiterecord.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cs.projects.whiterecord.util.MapCriteria;
import cs.projects.whiterecord.vo.LocationVO;

@Mapper
public interface MapMapper {

	public List<LocationVO> locationView(MapCriteria mapCriteria) throws Exception;
	
	public int locationCount(MapCriteria mapCriteria) throws Exception;
}
