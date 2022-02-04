package cs.projects.whiterecord.Mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cs.projects.whiterecord.model.Density;
import cs.projects.whiterecord.vo.DensityVO;

@Mapper
public interface DensityMapper {

	public void densityUpdate(Density density)throws Exception;
	
	public DensityVO densityList(Map<String, Object> map)throws Exception;
}
