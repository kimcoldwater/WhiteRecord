package cs.projects.whiterecord.service;

import java.util.List;
import java.util.Optional;

import cs.projects.whiterecord.model.Social;
import cs.projects.whiterecord.util.Criteria;


public interface SocialService {

	
	public List<Social> SocialConetent(Criteria cri) throws Exception;
	
	public List<Social> findAll() throws Exception;
	
	public int socialCount(Criteria cri) throws Exception;

	public Social socialWrite(Social social)throws Exception;
	
	public Optional<Social> socialUpdateContent(Long sno)throws Exception;
	
	public Social socialUpdate(Social social)throws Exception;
	
	public void socialDelete(Social social)throws Exception;
	
	
}
