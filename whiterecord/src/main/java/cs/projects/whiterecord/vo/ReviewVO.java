package cs.projects.whiterecord.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReviewVO {
	private Long rno;
	private Long mno;
	private Long lno;
	private String title;
	private String content;
	private int viewcnt;
	private int likecnt;
    @DateTimeFormat(pattern = "yy-MM-dd hh:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd hh:mm", timezone = "Asia/Seoul")
	private Date regdate;
    private String rimg;
    private String resort;
    private String categori;

    private MemberVO memberVO;
}
