package com.tad.pgb.vo;

import org.springframework.stereotype.Component;

@Component(value="pgbPointVO")
public class pgbPointVO extends pgbVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String pointRsltCd;
	private int pointRegMbrSeq;
	private String pointRegDt;
	
	public String getPointRsltCd() {
		return pointRsltCd;
	}
	public void setPointRsltCd(String pointRsltCd) {
		this.pointRsltCd = pointRsltCd;
	}
	public int getPointRegMbrSeq() {
		return pointRegMbrSeq;
	}
	public void setPointRegMbrSeq(int pointRegMbrSeq) {
		this.pointRegMbrSeq = pointRegMbrSeq;
	}
	public String getPointRegDt() {
		return pointRegDt;
	}
	public void setPointRegDt(String pointRegDt) {
		this.pointRegDt = pointRegDt;
	}
}
