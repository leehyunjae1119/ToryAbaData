package com.tad.crc.vo;

import org.springframework.stereotype.Component;

@Component(value="pgbVO")
public class pgbVO extends crcVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	private String searchField1;
	private String searchField2;
	private String searchText1;
	
	private int oldDomainSeq;
	private int centerSeq;
	private String centerName;
	private int classSeq;
	private String className;
	private String studentName;
	private String studentBirth;
	private String monthOfBirth;
	private String domainCnt;
	
	private String totalLtoCnt;
	private String totalCompleLtoCnt;
	private String memberName;
	private String ltoCnt;
	private String compleLtoCnt;
	
	private String memberEmail;
	private String memberCp;

	private String selectDomainSeq;
	private String selectMemberSeq;
	
	public String getSearchField1() {
		return searchField1;
	}
	public void setSearchField1(String searchField1) {
		this.searchField1 = searchField1;
	}
	public String getSearchField2() {
		return searchField2;
	}
	public void setSearchField2(String searchField2) {
		this.searchField2 = searchField2;
	}
	public String getSearchText1() {
		return searchText1;
	}
	public void setSearchText1(String searchText1) {
		this.searchText1 = searchText1;
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
	public String getMonthOfBirth() {
		return monthOfBirth;
	}
	public void setMonthOfBirth(String monthOfBirth) {
		this.monthOfBirth = monthOfBirth;
	}
	public String getDomainCnt() {
		return domainCnt;
	}
	public void setDomainCnt(String domainCnt) {
		this.domainCnt = domainCnt;
	}
	public String getTotalLtoCnt() {
		return totalLtoCnt;
	}
	public void setTotalLtoCnt(String totalLtoCnt) {
		this.totalLtoCnt = totalLtoCnt;
	}
	public String getTotalCompleLtoCnt() {
		return totalCompleLtoCnt;
	}
	public void setTotalCompleLtoCnt(String totalCompleLtoCnt) {
		this.totalCompleLtoCnt = totalCompleLtoCnt;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getLtoCnt() {
		return ltoCnt;
	}
	public void setLtoCnt(String ltoCnt) {
		this.ltoCnt = ltoCnt;
	}
	public String getCompleLtoCnt() {
		return compleLtoCnt;
	}
	public void setCompleLtoCnt(String compleLtoCnt) {
		this.compleLtoCnt = compleLtoCnt;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberCp() {
		return memberCp;
	}
	public void setMemberCp(String memberCp) {
		this.memberCp = memberCp;
	}
	public String getSelectDomainSeq() {
		return selectDomainSeq;
	}
	public void setSelectDomainSeq(String selectDomainSeq) {
		this.selectDomainSeq = selectDomainSeq;
	}
	public String getSelectMemberSeq() {
		return selectMemberSeq;
	}
	public void setSelectMemberSeq(String selectMemberSeq) {
		this.selectMemberSeq = selectMemberSeq;
	}
	public int getOldDomainSeq() {
		return oldDomainSeq;
	}
	public void setOldDomainSeq(int oldDomainSeq) {
		this.oldDomainSeq = oldDomainSeq;
	}
	
}
