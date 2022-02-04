package cs.projects.whiterecord.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.projects.whiterecord.Mapper.DensityMapper;
import cs.projects.whiterecord.model.Density;
import cs.projects.whiterecord.repository.DensityRepository;
import cs.projects.whiterecord.vo.DensityVO;

@Service
public class DensityServiceImpl implements DensityService {

	@Autowired
	private DensityRepository densityRepository;
	
	@Autowired
	private DensityMapper densityMapper;
	
	
	public Density dataInsert(Density density)throws Exception{
		return densityRepository.save(density);
	}
	
	public void densityUpdate(Density density)throws Exception{
		densityMapper.densityUpdate(density);
	}
	
	public List<DensityVO> densityList(Density density)throws Exception{
		List<DensityVO> densityList = new ArrayList<>();
		
		Map<String , Object> map = new HashMap<>();
		map.put("inputDate", 0);
		map.put("resort", density.getResort());
		map.put("regdate", density.getRegdate());
		
		DensityVO densityVO0 = densityMapper.densityList(map);
		
		Map<String , Object> map2 = new HashMap<>();
		map2.put("inputDate", 7);
		map2.put("resort", density.getResort());
		map2.put("regdate", density.getRegdate());

		
		DensityVO densityVO7 = densityMapper.densityList(map2);
		
		Map<String , Object> map3 = new HashMap<>();
		map3.put("inputDate", 14);
		map3.put("resort", density.getResort());
		map3.put("regdate", density.getRegdate());

		
		DensityVO densityVO14 = densityMapper.densityList(map3); 
		
		densityList.add(densityVO0);
		densityList.add(densityVO7);
		densityList.add(densityVO14);
		
		
		
		
		return densityList;
	}
	
	}


