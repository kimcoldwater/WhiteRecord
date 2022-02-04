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
public class Density {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dno")
	@SequenceGenerator(sequenceName = "dnoseq" , name="dno" , allocationSize=1)
	@Column(name="dno")
	private Long dno;
	private double T00;
	private double T03;
	private double T09;
	private double T12;
	private double T15;
	private double T18;
	private double T21;
	@DateTimeFormat(pattern = "yy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd", timezone = "Asia/Seoul")
	private Date regdate;
	@DateTimeFormat(pattern = "yy-MM-dd hh:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd hh:mm", timezone = "Asia/Seoul")
	private Date newdate;
	private String resort;


	
}
