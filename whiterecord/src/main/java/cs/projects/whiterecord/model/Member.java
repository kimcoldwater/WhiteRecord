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
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mno")
	@SequenceGenerator(sequenceName = "mnoseq" , name="mno" , allocationSize=1)
	@Column(name="mno")
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
