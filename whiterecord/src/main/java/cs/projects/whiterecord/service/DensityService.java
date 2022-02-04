package cs.projects.whiterecord.service;

import java.util.List;
import java.util.Map;

import cs.projects.whiterecord.model.Density;
import cs.projects.whiterecord.vo.DensityVO;

public interface DensityService {
	
	public Density dataInsert(Density density)throws Exception;

	public void densityUpdate(Density density)throws Exception;
	
	public List<DensityVO> densityList(Density density)throws Exception;

}
