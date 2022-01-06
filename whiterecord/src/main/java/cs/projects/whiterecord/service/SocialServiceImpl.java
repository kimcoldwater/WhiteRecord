package cs.projects.whiterecord.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.projects.whiterecord.Mapper.SocialMapper;
import cs.projects.whiterecord.model.Social;
import cs.projects.whiterecord.repository.SocialRepository;
import cs.projects.whiterecord.util.Criteria;

@Service
public class SocialServiceImpl implements SocialService{

	@Autowired
	private SocialRepository socialRepository;
	
	@Autowired 
	private SocialMapper socialMapper;
	
	public List<Social> SocialConetent(Criteria cri) throws Exception{
		return socialMapper.socialContent(cri);
	}
	
	public List<Social> findAll() throws Exception{
	return socialMapper.findAll();
	}
}
