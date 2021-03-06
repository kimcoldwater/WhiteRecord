package cs.projects.whiterecord.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cs.projects.whiterecord.model.Social;


@Transactional(readOnly = true)
public interface SocialRepository extends JpaRepository<Social , Long>{
	
	Optional<Social> findById(Long sno);
	
	
	
	
}
