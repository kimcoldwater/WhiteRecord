package cs.projects.whiterecord.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cs.projects.whiterecord.model.Social;
import cs.projects.whiterecord.util.Criteria;
import cs.projects.whiterecord.vo.SocialVO;

@Mapper
public interface SocialMapper {

	
		public List<Social> findAll();
		
		public List<SocialVO> socialContent(Criteria cri);
		
		public int socialCount(Criteria cri);
		
		public void socialCompelete(Social social);
	
		public void socialSchedul();
}
