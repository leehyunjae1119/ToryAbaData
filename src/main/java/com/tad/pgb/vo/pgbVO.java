package com.tad.pgb.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component(value = "pgbVO")
public class pgbVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rownum;

	private int domainSeq;
	private int studentSeq;
	private int ltoSeq;
	private int stoSeq;
	private int pointSeq;
	
	private String domainStatus;
	private String ltoStatus;
	private String stoStatus;
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getDomainSeq() {
		return domainSeq;
	}
	public void setDomainSeq(int domainSeq) {
		this.domainSeq = domainSeq;
	}
	public int getStudentSeq() {
		return studentSeq;
	}
	public void setStudentSeq(int studentSeq) {
		this.studentSeq = studentSeq;
	}
	public int getLtoSeq() {
		return ltoSeq;
	}
	public void setLtoSeq(int ltoSeq) {
		this.ltoSeq = ltoSeq;
	}
	public int getStoSeq() {
		return stoSeq;
	}
	public void setStoSeq(int stoSeq) {
		this.stoSeq = stoSeq;
	}
	public int getPointSeq() {
		return pointSeq;
	}
	public void setPointSeq(int pointSeq) {
		this.pointSeq = pointSeq;
	}
	public String getDomainStatus() {
		return domainStatus;
	}
	public void setDomainStatus(String domainStatus) {
		this.domainStatus = domainStatus;
	}
	public String getLtoStatus() {
		return ltoStatus;
	}
	public void setLtoStatus(String ltoStatus) {
		this.ltoStatus = ltoStatus;
	}
	public String getStoStatus() {
		return stoStatus;
	}
	public void setStoStatus(String stoStatus) {
		this.stoStatus = stoStatus;
	}

}
