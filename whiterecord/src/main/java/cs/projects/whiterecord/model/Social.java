package cs.projects.whiterecord.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class Social {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sno")
	@SequenceGenerator(sequenceName = "snoseq" , name="sno" , allocationSize=1)
	@Column(name="sno")
	private Long sno;
	
	private String resort;
	private String title;
	private String content;
	private int mno;
	private String id;
	private String area;
	private String contact;
	private String categori;
	private int viewcnt;
	private String complete;
    @DateTimeFormat(pattern = "yy-MM-dd hh:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd hh:mm", timezone = "Asia/Seoul")
	private Date regdate;
    @DateTimeFormat(pattern = "MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd", timezone = "Asia/Seoul")
	private Date offerdate;
	private Date enddate;
	private int bookmarkcnt;
	
}
