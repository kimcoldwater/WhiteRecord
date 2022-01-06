package cs.projects.whiterecord.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cs.projects.whiterecord.model.Social;

public interface SocialRepository extends JpaRepository<Social , Long>{
	
	
}
