package cs.projects.whiterecord.vo;

import java.util.List;

import lombok.Data;

@Data
public class SafeCasterVO {
	
	private String code;
	private String message;
	private List<SafeDataVO> data;

}
