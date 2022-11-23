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
    
    private String weekStart;
    private String weekEnd;
    private String weekSeq;
    private String rununit;
    private String arrCnt;
    private String criterion;
    
    private int pickerSeq;
    private String pickerDvCd;
    private int pickerSelector;
    private int pickerTarget;
    private String pickerDt;
    
    private String cmpLtoCnt;
    
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
	public String getWeekStart() {
		return weekStart;
	}
	public void setWeekStart(String weekStart) {
		this.weekStart = weekStart;
	}
	public String getWeekEnd() {
		return weekEnd;
	}
	public void setWeekEnd(String weekEnd) {
		this.weekEnd = weekEnd;
	}
	public String getWeekSeq() {
		return weekSeq;
	}
	public void setWeekSeq(String weekSeq) {
		this.weekSeq = weekSeq;
	}
	public String getRununit() {
		return rununit;
	}
	public void setRununit(String rununit) {
		this.rununit = rununit;
	}
	public String getArrCnt() {
		return arrCnt;
	}
	public void setArrCnt(String arrCnt) {
		this.arrCnt = arrCnt;
	}
	public String getCriterion() {
		return criterion;
	}
	public void setCriterion(String criterion) {
		this.criterion = criterion;
	}
	public int getPickerSeq() {
		return pickerSeq;
	}
	public void setPickerSeq(int pickerSeq) {
		this.pickerSeq = pickerSeq;
	}
	public String getPickerDvCd() {
		return pickerDvCd;
	}
	public void setPickerDvCd(String pickerDvCd) {
		this.pickerDvCd = pickerDvCd;
	}
	public int getPickerSelector() {
		return pickerSelector;
	}
	public void setPickerSelector(int pickerSelector) {
		this.pickerSelector = pickerSelector;
	}
	public int getPickerTarget() {
		return pickerTarget;
	}
	public void setPickerTarget(int pickerTarget) {
		this.pickerTarget = pickerTarget;
	}
	public String getPickerDt() {
		return pickerDt;
	}
	public void setPickerDt(String pickerDt) {
		this.pickerDt = pickerDt;
	}
	public String getCmpLtoCnt() {
		return cmpLtoCnt;
	}
	public void setCmpLtoCnt(String cmpLtoCnt) {
		this.cmpLtoCnt = cmpLtoCnt;
	}
    
}
