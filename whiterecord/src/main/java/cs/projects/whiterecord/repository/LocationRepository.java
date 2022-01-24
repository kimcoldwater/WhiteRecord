package cs.projects.whiterecord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cs.projects.whiterecord.model.Location;

@Transactional(readOnly = true)
public interface LocationRepository extends JpaRepository<Location , Long>{

	Location findByLnameAndAddress(String name, String address);
	
	int countByLnameAndAddress(String name, String address);
}
