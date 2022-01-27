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
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lno")
	@SequenceGenerator(sequenceName = "lnoseq" , name="lno" , allocationSize=1)
	@Column(name="lno")
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

	}
