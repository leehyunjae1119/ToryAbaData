package com.tad.pgb.vo;

import org.springframework.stereotype.Component;

@Component(value = "pgbChartVO")
public class pgbChartVO extends pgbVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String stoName;
	private String pointDt;
	private String reaRatio;
	private String urgRatio;
	
	private String stoArrYn;
	private int stoArrStdPst;
	
	public String getStoName() {
		return stoName;
	}
	public void setStoName(String stoName) {
		this.stoName = stoName;
	}
	public String getPointDt() {
		return pointDt;
	}
	public void setPointDt(String pointDt) {
		this.pointDt = pointDt;
	}
	public String getReaRatio() {
		return reaRatio;
	}
	public void setReaRatio(String reaRatio) {
		this.reaRatio = reaRatio;
	}
	public String getUrgRatio() {
		return urgRatio;
	}
	public void setUrgRatio(String urgRatio) {
		this.urgRatio = urgRatio;
	}
	public String getStoArrYn() {
		return stoArrYn;
	}
	public void setStoArrYn(String stoArrYn) {
		this.stoArrYn = stoArrYn;
	}
	public int getStoArrStdPst() {
		return stoArrStdPst;
	}
	public void setStoArrStdPst(int stoArrStdPst) {
		this.stoArrStdPst = stoArrStdPst;
	}
	

}
