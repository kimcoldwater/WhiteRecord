package cs.projects.whiterecord.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cs.projects.whiterecord.model.Member;


@Transactional(readOnly = true)
public interface MemberRepository extends JpaRepository<Member , Long>{
	
	 int countById(String id);
	 
	 Member findById(String id);
	 
	 List<Member> findByEmail(String email);
	 
	 Member findByIdAndEmail(String id, String email);

	
	
	
	
	
}
