package cs.projects.whiterecord.util;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Criteria {
	private int page;
	private int perPageNum;
	private int rowStart;
	private int rowEnd;
	private String categori = "";
	private String area;
	private String resort = "";
	private String searchType = "";
	private String keyword = "";
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date offerdate = null;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date offerdateEnd = null;
	private boolean completeCheck = false;
	
	
	
	
	
	

	public Date getOfferdateEnd() {
		return offerdateEnd;
	}

	public void setOfferdateEnd(Date offerdateEnd) {
		this.offerdateEnd = offerdateEnd;
	}

	public boolean isCompleteCheck() {
		return completeCheck;
	}

	public void setCompleteCheck(boolean completeCheck) {
		this.completeCheck = completeCheck;
	}

	public Date getOfferdate() {
		return offerdate;
	}

	public void setOfferdate(Date offerdate) {
		this.offerdate = offerdate;
	}

	public String getResort() {
		return resort;
	}

	public void setResort(String resort) {
		this.resort = resort;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCategori() {
		return categori;
	}

	public void setCategori(String categori) {
		this.categori = categori;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Criteria() {
		this.page = 1;
		this.perPageNum = 9;
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
			this.perPageNum = 9;
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
				+ ", categori=" + categori + ", area=" + area + ", resort=" + resort + ", searchType=" + searchType
				+ ", keyword=" + keyword + "]";
	}



	
}
