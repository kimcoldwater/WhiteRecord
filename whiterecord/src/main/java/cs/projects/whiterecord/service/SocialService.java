package cs.projects.whiterecord.service;

import java.util.List;

import cs.projects.whiterecord.model.Social;
import cs.projects.whiterecord.util.Criteria;


public interface SocialService {

	
	public List<Social> SocialConetent(Criteria cri) throws Exception;
	
	public List<Social> findAll() throws Exception;
	
}
