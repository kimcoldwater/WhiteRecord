package cs.projects.whiterecord.util;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MapCriteria {
	private int page;
	private int perPageNum;
	private int rowStart;
	private int rowEnd;
	private String categori = "";
	private String resort = "";
	
	
	
	
	

	public String getResort() {
		return resort;
	}

	public void setResort(String resort) {
		this.resort = resort;
	}


	public String getCategori() {
		return categori;
	}

	public void setCategori(String categori) {
		this.categori = categori;
	}


	public MapCriteria() {
		this.page = 1;
		this.perPageNum = 30;
	}
	
	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 30;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPage() {
		return page;
	}
	
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}
	
	public int getPerPageNum() {
		return this.perPageNum;
	}
	
	public int getRowStart() {
		rowStart = ((page - 1) * perPageNum) + 1;
		return rowStart;
	}
	
	public int getRowEnd() {
		rowEnd = rowStart + perPageNum - 1;
		return rowEnd;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", rowStart=" + rowStart + ", rowEnd=" + rowEnd
				+ ", categori=" + categori + "]";
	}



	
}
