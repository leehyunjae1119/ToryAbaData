package com.tad.pgb.vo;

import org.springframework.stereotype.Component;

@Component(value="pgbStoVO")
public class pgbStoVO extends pgbVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String stoName;
	private String stoContents;
	private int stoTrialCnt;
	private int stoArrStdCnt;
	private int stoArrStdPst;
	private String stoArrYn;
	private String stoUrgeTpCd;
	private String stoUrgeContents;
	private String stoEnforceContents;
	private String stoMemoContents;
	private String stoArrDt;
	private String stoRegDt;
	private String delYn;
	
	public String getStoName() {
		return stoName;
	}
	public void setStoName(String stoName) {
		this.stoName = stoName;
	}
	public String getStoContents() {
		return stoContents;
	}
	public void setStoContents(String stoContents) {
		this.stoContents = stoContents;
	}
	public int getStoArrStdCnt() {
		return stoArrStdCnt;
	}
	public void setStoArrStdCnt(int stoArrStdCnt) {
		this.stoArrStdCnt = stoArrStdCnt;
	}
	public int getStoArrStdPst() {
		return stoArrStdPst;
	}
	public void setStoArrStdPst(int stoArrStdPst) {
		this.stoArrStdPst = stoArrStdPst;
	}
	public String getStoArrYn() {
		return stoArrYn;
	}
	public void setStoArrYn(String stoArrYn) {
		this.stoArrYn = stoArrYn;
	}
	public String getStoUrgeTpCd() {
		return stoUrgeTpCd;
	}
	public void setStoUrgeTpCd(String stoUrgeTpCd) {
		this.stoUrgeTpCd = stoUrgeTpCd;
	}
	public String getStoUrgeContents() {
		return stoUrgeContents;
	}
	public void setStoUrgeContents(String stoUrgeContents) {
		this.stoUrgeContents = stoUrgeContents;
	}
	public String getStoEnforceContents() {
		return stoEnforceContents;
	}
	public void setStoEnforceContents(String stoEnforceContents) {
		this.stoEnforceContents = stoEnforceContents;
	}
	public String getStoMemoContents() {
		return stoMemoContents;
	}
	public void setStoMemoContents(String stoMemoContents) {
		this.stoMemoContents = stoMemoContents;
	}
	public String getStoRegDt() {
		return stoRegDt;
	}
	public void setStoRegDt(String stoRegDt) {
		this.stoRegDt = stoRegDt;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public int getStoTrialCnt() {
		return stoTrialCnt;
	}
	public void setStoTrialCnt(int stoTrialCnt) {
		this.stoTrialCnt = stoTrialCnt;
	}
	public String getStoArrDt() {
		return stoArrDt;
	}
	public void setStoArrDt(String stoArrDt) {
		this.stoArrDt = stoArrDt;
	}
	
}
