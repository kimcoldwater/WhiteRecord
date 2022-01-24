package cs.projects.whiterecord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cs.projects.whiterecord.model.Review;

@Transactional(readOnly = true)
public interface ReviewRepository extends JpaRepository<Review , Long>{
}
