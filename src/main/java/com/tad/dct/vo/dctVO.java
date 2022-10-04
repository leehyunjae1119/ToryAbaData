package com.tad.dct.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;


@Component(value="dctVO")
public class dctVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int memberSeq;				// 회원번호 
	
	private int centerSeq;				// 센터번호
	private String centerName;			// 센터이름
	
	private int classSeq;				// 반번호
	private String className;			// 반이름
	
	private int studentSeq;			//아동번호
	private String studentName;		//아동이름
	private String studentBirth;		//아동생년월일
	private String studentEtc;			//아동특징
	private String studentStartDt;	//프로그램시작일
	private String studentEndDt;	//프로그램시작일
	private String studentRegDt;		//등록일자
	private String parentName;		//부모님 이름
	
	private int domainSeq;
	private String domainName;
	private String domainStatus;
    private int ltoSeq;
    private String ltoName;
    private String ltoStatus;
	
	
	public int getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}
	public int getCenterSeq() {
		return centerSeq;
	}
	public void setCenterSeq(int centerSeq) {
		this.centerSeq = centerSeq;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public int getClassSeq() {
		return classSeq;
	}
	public void setClassSeq(int classSeq) {
		this.classSeq = classSeq;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getStudentSeq() {
		return studentSeq;
	}
	public void setStudentSeq(int studentSeq) {
		this.studentSeq = studentSeq;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentBirth() {
		return studentBirth;
	}
	public void setStudentBirth(String studentBirth) {
		this.studentBirth = studentBirth;
	}
	public String getStudentEtc() {
		return studentEtc;
	}
	public void setStudentEtc(String studentEtc) {
		this.studentEtc = studentEtc;
	}
	public String getStudentStartDt() {
		return studentStartDt;
	}
	public void setStudentStartDt(String studentStartDt) {
		this.studentStartDt = studentStartDt;
	}
	public String getStudentEndDt() {
		return studentEndDt;
	}
	public void setStudentEndDt(String studentEndDt) {
		this.studentEndDt = studentEndDt;
	}
	public String getStudentRegDt() {
		return studentRegDt;
	}
	public void setStudentRegDt(String studentRegDt) {
		this.studentRegDt = studentRegDt;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public int getDomainSeq() {
		return domainSeq;
	}
	public void setDomainSeq(int domainSeq) {
		this.domainSeq = domainSeq;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getDomainStatus() {
		return domainStatus;
	}
	public void setDomainStatus(String domainStatus) {
		this.domainStatus = domainStatus;
	}
	public int getLtoSeq() {
		return ltoSeq;
	}
	public void setLtoSeq(int ltoSeq) {
		this.ltoSeq = ltoSeq;
	}
	public String getLtoName() {
		return ltoName;
	}
	public void setLtoName(String ltoName) {
		this.ltoName = ltoName;
	}
	public String getLtoStatus() {
		return ltoStatus;
	}
	public void setLtoStatus(String ltoStatus) {
		this.ltoStatus = ltoStatus;
	}
	
}
