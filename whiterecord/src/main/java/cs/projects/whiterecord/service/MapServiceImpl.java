package cs.projects.whiterecord.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.projects.whiterecord.Mapper.MapMapper;
import cs.projects.whiterecord.model.Location;
import cs.projects.whiterecord.model.Review;
import cs.projects.whiterecord.repository.LocationRepository;
import cs.projects.whiterecord.repository.ReviewRepository;
import cs.projects.whiterecord.util.MapCriteria;
import cs.projects.whiterecord.vo.LocationVO;

@Service
public class MapServiceImpl implements MapService {

	private static final Logger logger = LoggerFactory.getLogger(MapServiceImpl.class);

	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired 
	private MapMapper mapMapper;
	
	public int locationCheck(Location location)throws Exception{
		int check = locationRepository.countByLnameAndAddress(location.getLname(), location.getAddress());
		return check;
	}

	public Location locationInsert(Location location) throws Exception{

		return locationRepository.saveAndFlush(location);
	}
	
	public Review reviewInsert(Review review, Location location)throws Exception{
		Location locationLno = locationRepository.findByLnameAndAddress(location.getLname(), location.getAddress());
		review.setLno(locationLno.getLno());
		logger.info("lno"+locationLno.getLno());
		return reviewRepository.save(review);
	}
	
	public int locationCount(MapCriteria mapCriteria)throws Exception{
		return mapMapper.locationCount(mapCriteria);
		
	}
	
	public List<LocationVO> locationView(MapCriteria mapCriteria)throws Exception{
		return mapMapper.locationView(mapCriteria);
	}
	
}
