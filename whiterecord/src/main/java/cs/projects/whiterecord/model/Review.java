package cs.projects.whiterecord.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rno")
	@SequenceGenerator(sequenceName = "rnoseq" , name="rno" , allocationSize=1)
	@Column(name="rno")
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

	}
