package cs.projects.whiterecord.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import cs.projects.whiterecord.model.Social;
import cs.projects.whiterecord.util.Criteria;
import cs.projects.whiterecord.vo.SocialVO;


public interface SocialService {

	
	public List<SocialVO> SocialConetent(Criteria cri) throws Exception;
	
	public List<Social> findAll() throws Exception;
	
	public int socialCount(Criteria cri) throws Exception;

	public Social socialWrite(Social social,HttpSession session)throws Exception;
	
	public Optional<Social> socialUpdateContent(Long sno)throws Exception;
	
	public Social socialUpdate(Social social)throws Exception;
	
	public void socialDelete(Social social)throws Exception;
	
	public void socialComplete(Social social)throws Exception;
	
	public void socialSchedul()throws Exception;
	
	public void socialViewCnt(Social social)throws Exception;

}
