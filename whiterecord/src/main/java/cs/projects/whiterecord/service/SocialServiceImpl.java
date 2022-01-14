package cs.projects.whiterecord.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.projects.whiterecord.Mapper.SocialMapper;
import cs.projects.whiterecord.model.Social;
import cs.projects.whiterecord.repository.SocialRepository;
import cs.projects.whiterecord.util.Criteria;

@Service
public class SocialServiceImpl implements SocialService{

	@Autowired
	private SocialRepository socialRepository;
	
	@Autowired 
	private SocialMapper socialMapper;
	
	public List<Social> SocialConetent(Criteria cri) throws Exception{
		return socialMapper.socialContent(cri);
	}
	
	public List<Social> findAll() throws Exception{
	return socialMapper.findAll();
	}
	
	public int socialCount(Criteria cri) throws Exception{
		return socialMapper.socialCount(cri);
	}
	
	public Social socialWrite(Social social)throws Exception{
		if(social.getCategori().equals("동호회") || social.getCategori().equals("강습제공") 
				||social.getCategori().equals("강습요청")||social.getCategori().equals("쉐어모집")||social.getCategori().equals("기타")){
			social.setEnddate(social.getOfferdate());
			social.setOfferdate(null);
		}
		
		social.setMno(1); // 나중에 세션값 넣기
		social.setId("test");
		return socialRepository.save(social);	
		}

	public Optional<Social> socialUpdateContent(Long sno)throws Exception{
		
		return socialRepository.findById(sno);
	}
	
	public Social socialUpdate(Social social)throws Exception{
		
		if(social.getCategori().equals("동호회") || social.getCategori().equals("강습제공") 
				||social.getCategori().equals("강습요청")||social.getCategori().equals("쉐어모집")||social.getCategori().equals("기타")){
			social.setEnddate(social.getOfferdate());
			social.setOfferdate(null);
		}
		Long checkSno = social.getSno();
		Social socialContent = socialRepository.findById(checkSno).get();
		social.setId(socialContent.getId());
		social.setComplete(socialContent.getComplete());
		social.setRegdate(socialContent.getRegdate());
		social.setMno(socialContent.getMno());
		social.setViewcnt(socialContent.getViewcnt());
		social.setBookmarkcnt(socialContent.getBookmarkcnt());
		return socialRepository.save(social);
	
		
	}

	public void socialDelete(Social social)throws Exception{
		Long sno = social.getSno();
		socialRepository.deleteById(sno);
	}

}
