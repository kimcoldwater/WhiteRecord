package cs.projects.whiterecord.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cs.projects.whiterecord.model.Member;
import cs.projects.whiterecord.util.MypageCriteria;
import cs.projects.whiterecord.vo.ReviewVO;
import cs.projects.whiterecord.vo.SocialVO;

@Mapper
public interface MemberMapper {

	public void editId(Member member)throws Exception;
	
	public void editName(Member member)throws Exception;
	
	public void editEmail(Member member)throws Exception;

	public void editImg(Member member)throws Exception;
	
	public List<SocialVO> mypageSocial(MypageCriteria cri)throws Exception;
	
	public int mypageSocialCount(MypageCriteria cri)throws Exception;
	
	public List<ReviewVO> mypageReview(MypageCriteria cri)throws Exception;
	
	public int mypageReviewCount(MypageCriteria cri)throws Exception;
}
