package cs.projects.whiterecord.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class DensityVO {
	private Long dno;
	private double T00;
	private double T03;
	private double T09;
	private double T12;
	private double T15;
	private double T18;
	private double T21;
	@DateTimeFormat(pattern = "yy-MM-dd hh:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd hh:mm", timezone = "Asia/Seoul")
	private Date regdate;
	@DateTimeFormat(pattern = "yy-MM-dd hh:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd hh:mm", timezone = "Asia/Seoul")
	private Date newdate;
	private String resort;

}
