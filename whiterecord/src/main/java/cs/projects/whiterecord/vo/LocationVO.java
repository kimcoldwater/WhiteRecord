package cs.projects.whiterecord.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import cs.projects.whiterecord.model.Member;
import lombok.Data;

@Data
public class LocationVO {
	private Long lno;
	private Long mno;
	private String resort;
	private String lname;
	private String tel;
	private String address;
	private String raddress;
	private double x;
	private double y;
	private String categori;
	private String foodtype;
	private int reviewcnt;
	private int likecnt;
	private String img;


    @DateTimeFormat(pattern = "yy-MM-dd hh:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd hh:mm", timezone = "Asia/Seoul")
	private Date regdate;
    
    private MemberVO memberVO;
}
