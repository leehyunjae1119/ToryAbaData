package com.tad.lgn.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;


@Component(value="lgnVO")
public class lgnVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private int memberSeq;	// 회원번호 
    private String memberId;    // 회원아이디 
    private String memberPw;    // 회원패스워드 
    private String memberName;    // 회원이름 
    private String memberEmail;    // 회원이메일 
    private String memberCp;    // 회원연락처 
    private String memberAuthCd;    // 회원권한코드 
    private int centerSeq;    // 소속센터 
    private String memberRegDt;    // 등록일자 
    private String approvalYn;	// 승인여부 
	private String resultMsg;

	private int authCenterSeq;
	private int authClassSeq;
	private int authStudentSeq;
	
	public int getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	public String getMemberAuthCd() {
		return memberAuthCd;
	}
	public void setMemberAuthCd(String memberAuthCd) {
		this.memberAuthCd = memberAuthCd;
	}
	public int getCenterSeq() {
		return centerSeq;
	}
	public void setCenterSeq(int centerSeq) {
		this.centerSeq = centerSeq;
	}
	public String getMemberRegDt() {
		return memberRegDt;
	}
	public void setMemberRegDt(String memberRegDt) {
		this.memberRegDt = memberRegDt;
	}
	public String getApprovalYn() {
		return approvalYn;
	}
	public void setApprovalYn(String approvalYn) {
		this.approvalYn = approvalYn;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public int getAuthCenterSeq() {
		return authCenterSeq;
	}
	public void setAuthCenterSeq(int authCenterSeq) {
		this.authCenterSeq = authCenterSeq;
	}
	public int getAuthClassSeq() {
		return authClassSeq;
	}
	public void setAuthClassSeq(int authClassSeq) {
		this.authClassSeq = authClassSeq;
	}
	public int getAuthStudentSeq() {
		return authStudentSeq;
	}
	public void setAuthStudentSeq(int authStudentSeq) {
		this.authStudentSeq = authStudentSeq;
	}
	@Override
	public String toString() {
		return "lgnVO [\nmemberSeq=" + memberSeq + "\nmemberId=" + memberId + "\nmemberPw=" + memberPw + "\nmemberName="
				+ memberName + "\nmemberEmail=" + memberEmail + "\nmemberCp=" + memberCp + "\nmemberAuthCd="
				+ memberAuthCd + "\ncenterSeq=" + centerSeq + "\nmemberRegDt=" + memberRegDt + "\napprovalYn="
				+ approvalYn + "\nresultMsg=" + resultMsg + "\n]";
	}

	
}
