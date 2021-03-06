package cs.projects.whiterecord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cs.projects.whiterecord.model.Density;

@Transactional(readOnly = true)
public interface DensityRepository extends JpaRepository<Density , Long>{
	
}
