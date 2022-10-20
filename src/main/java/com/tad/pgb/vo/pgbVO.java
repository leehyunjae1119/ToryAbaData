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
	private int tmplSeq;
	
	private String domainStatus;
	private String ltoStatus;
	private String stoStatus;
	
	private String updateFlag;
	
	private String centerName;
	private String className;
	private String studentName;
	
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
	public int getTmplSeq() {
		return tmplSeq;
	}
	public void setTmplSeq(int tmplSeq) {
		this.tmplSeq = tmplSeq;
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
	public String getUpdateFlag() {
		return updateFlag;
	}
	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
}
