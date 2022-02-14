package cs.projects.whiterecord.util;

public class MypageCriteria {
	private int page;
	private int perPageNum;
	private int rowStart;
	private int rowEnd;
	private Long mno;
	
	
	
	
	
	


	public Long getMno() {
		return mno;
	}

	public void setMno(Long mno) {
		this.mno = mno;
	}

	public MypageCriteria() {
		this.page = 1;
		this.perPageNum = 5;
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
			this.perPageNum = 5;
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
