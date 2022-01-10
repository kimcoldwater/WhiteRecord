package cs.projects.whiterecord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cs.projects.whiterecord.model.Social;


@Transactional(readOnly = true)
public interface SocialRepository extends JpaRepository<Social , Long>{
	
	
}
