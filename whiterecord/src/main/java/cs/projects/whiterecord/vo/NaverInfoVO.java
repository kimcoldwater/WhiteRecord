package cs.projects.whiterecord.vo;

import java.util.Map;

import lombok.Data;

@Data
public class NaverInfoVO {
	
	private Long id;
	private Map<String, Object> properties;
	private String connected_at;
	private Map<String, Object> kakao_account;
	
}
