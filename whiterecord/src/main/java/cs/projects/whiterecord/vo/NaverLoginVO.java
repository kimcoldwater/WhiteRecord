package cs.projects.whiterecord.vo;

import lombok.Data;

@Data
public class NaverLoginVO {
	private String token_type;
	private String access_token;
	private Integer expires_in;
	private String refresh_token;
	private String scope;
	private Integer refresh_token_expires_in;
}
