package cs.projects.whiterecord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cs.projects.whiterecord.model.Member;


@Transactional(readOnly = true)
public interface MemberRepository extends JpaRepository<Member , Long>{
	
	 int countById(String id);

	
	
	
	
	
}
