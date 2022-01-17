package cs.projects.whiterecord.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SocialVO {
	

	private Long sno;
	private String resort;
	private String title;
	private String content;
	private Long mno;
	private String area;
	private String contact;
	private String categori;
	private int viewcnt;
	private String complete;
	
	@DateTimeFormat(pattern = "yy-MM-dd hh:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd hh:mm", timezone = "Asia/Seoul")
	private Date regdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd", timezone = "Asia/Seoul")
	private Date offerdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd", timezone = "Asia/Seoul")
	private Date enddate;
	private int bookmarkcnt;

	private MemberVO memberVO;

	
}
