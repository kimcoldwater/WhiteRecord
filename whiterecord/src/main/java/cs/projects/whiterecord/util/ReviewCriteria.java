package cs.projects.whiterecord.util;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReviewCriteria {
	private int page;
	private int perPageNum;
	private int rowStart;
	private int rowEnd;
	private Long lno;
	
	
	
	
	



	public Long getLno() {
		return lno;
	}

	public void setLno(Long lno) {
		this.lno = lno;
	}

	public ReviewCriteria() {
		this.page = 1;
		this.perPageNum = 20;
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
			this.perPageNum = 20;
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




	
}
