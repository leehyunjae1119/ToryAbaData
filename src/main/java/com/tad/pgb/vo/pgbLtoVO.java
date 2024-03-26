package com.tad.pgb.vo;

import org.springframework.stereotype.Component;

@Component(value="pgbLtoVO")
public class pgbLtoVO extends pgbVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ltoName;
	private String ltoContents;
	private String ltoArrTpCd;
	private String ltoArrDt;
	private String ltoRegDt;
	private String delYn;
	private String ltoSeqList;
	private String ltoContentsList;
	
	public String getLtoName() {
		return ltoName;
	}
	public void setLtoName(String ltoName) {
		this.ltoName = ltoName;
	}
	public String getLtoContents() {
		return ltoContents;
	}
	public void setLtoContents(String ltoContents) {
		this.ltoContents = ltoContents;
	}
	public String getLtoArrTpCd() {
		return ltoArrTpCd;
	}
	public void setLtoArrTpCd(String ltoArrTpCd) {
		this.ltoArrTpCd = ltoArrTpCd;
	}
	public String getLtoArrDt() {
		return ltoArrDt;
	}
	public void setLtoArrDt(String ltoArrDt) {
		this.ltoArrDt = ltoArrDt;
	}
	public String getLtoRegDt() {
		return ltoRegDt;
	}
	public void setLtoRegDt(String ltoRegDt) {
		this.ltoRegDt = ltoRegDt;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getLtoSeqList() {
		return ltoSeqList;
	}
	public void setLtoSeqList(String ltoSeqList) {
		this.ltoSeqList = ltoSeqList;
	}
	public String getLtoContentsList() {
		return ltoContentsList;
	}
	public void setLtoContentsList(String ltoContentsList) {
		this.ltoContentsList = ltoContentsList;
	}
	
}
