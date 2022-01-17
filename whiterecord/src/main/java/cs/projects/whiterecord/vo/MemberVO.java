package cs.projects.whiterecord.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MemberVO {
	private Long mno;
	private String id;
	private String pw;
	private String name;
	@DateTimeFormat(pattern = "yy-MM-dd hh:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd hh:mm", timezone = "Asia/Seoul")
	private Date joindate;
	private String img;
	private String email;
}
