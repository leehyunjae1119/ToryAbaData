package com.tad.dct.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;


@Component(value="dctChartVO")
public class dctChartVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int studentSeq;			//아동번호
    private String startDt;
    private String endDt;
    
    private String dtm;
    private String domainSeq;
    private String domainName;
    private String totCnt;
    private String cmpCnt;
    private String urgCnt;
    private String faiCnt;
    
	public int getStudentSeq() {
		return studentSeq;
	}
	public void setStudentSeq(int studentSeq) {
		this.studentSeq = studentSeq;
	}
	public String getStartDt() {
		return startDt;
	}
	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	public String getDtm() {
		return dtm;
	}
	public void setDtm(String dtm) {
		this.dtm = dtm;
	}
	public String getDomainSeq() {
		return domainSeq;
	}
	public void setDomainSeq(String domainSeq) {
		this.domainSeq = domainSeq;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(String totCnt) {
		this.totCnt = totCnt;
	}
	public String getCmpCnt() {
		return cmpCnt;
	}
	public void setCmpCnt(String cmpCnt) {
		this.cmpCnt = cmpCnt;
	}
	public String getUrgCnt() {
		return urgCnt;
	}
	public void setUrgCnt(String urgCnt) {
		this.urgCnt = urgCnt;
	}
	public String getFaiCnt() {
		return faiCnt;
	}
	public void setFaiCnt(String faiCnt) {
		this.faiCnt = faiCnt;
	}
}
