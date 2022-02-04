package cs.projects.whiterecord.vo;

import lombok.Data;

@Data
public class SafeDataVO {

	private String hh;
	private String zipCd;
	private double flowDensityPercentile;
	private double contactDensityPercentile;
	private double congestionPercentile;
	private double taxiDensityPercentile;
	
}
