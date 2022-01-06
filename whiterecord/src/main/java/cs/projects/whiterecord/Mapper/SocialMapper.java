package cs.projects.whiterecord.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cs.projects.whiterecord.model.Social;
import cs.projects.whiterecord.util.Criteria;

@Mapper
public interface SocialMapper {

	
		public List<Social> findAll();
		
		public List<Social> socialContent(Criteria cri);
}
