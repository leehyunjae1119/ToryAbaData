package com.tad.crc.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component(value="crcVO")
public class crcVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int rownum;
	
	private int domainSeq;
	private int studentSeq;
	private int memberSeq;
	private String domainTpCd;
	private String domainStatus;
	private String domainName;
	private String domainContents;
	private String domainUseYn;
	private String domainRegDt;
	private String delYn;
	
	private int ltoSeq;
	private int ltoDomainSeq;
	private String ltoStatus;
	private String ltoName;
	private String ltoContents;
	private String ltoArrTpCd;
	private String ltoArrDt;
	private String ltoRegDt;
	
	private int stoSeq;
	private int stoLtoSeq;
	private String stoStatus;
	private String stoName;
	private String stoContents;
	private int stoTrialCnt;
	private int stoArrStdCnt;
	private String stoArrStdPst;
	private String stoArrYn;
	private String stoUrgeTpCd;
	private String stoUrgeContents;
	private String stoEnforceContents;
	private String stoMemoContents;
	private String stoRegDt;
	
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
	public int getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getDomainTpCd() {
		return domainTpCd;
	}
	public void setDomainTpCd(String domainTpCd) {
		this.domainTpCd = domainTpCd;
	}
	public String getDomainStatus() {
		return domainStatus;
	}
	public void setDomainStatus(String domainStatus) {
		this.domainStatus = domainStatus;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getDomainContents() {
		return domainContents;
	}
	public void setDomainContents(String domainContents) {
		this.domainContents = domainContents;
	}
	public String getDomainUseYn() {
		return domainUseYn;
	}
	public void setDomainUseYn(String domainUseYn) {
		this.domainUseYn = domainUseYn;
	}
	public String getDomainRegDt() {
		return domainRegDt;
	}
	public void setDomainRegDt(String domainRegDt) {
		this.domainRegDt = domainRegDt;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public int getLtoSeq() {
		return ltoSeq;
	}
	public void setLtoSeq(int ltoSeq) {
		this.ltoSeq = ltoSeq;
	}
	public int getLtoDomainSeq() {
		return ltoDomainSeq;
	}
	public void setLtoDomainSeq(int ltoDomainSeq) {
		this.ltoDomainSeq = ltoDomainSeq;
	}
	public String getLtoStatus() {
		return ltoStatus;
	}
	public void setLtoStatus(String ltoStatus) {
		this.ltoStatus = ltoStatus;
	}
	public String getLtoName() {
		return ltoName;
	}
	public void setLtoName(String ltoName) {
		this.ltoName = ltoName;
	}
	public String getLtoContents() {
		return ltoContents;
	}
	public void setLtoContents(String ltoContents) {
		this.ltoContents = ltoContents;
	}
	public String getLtoArrTpCd() {
		return ltoArrTpCd;
	}
	public void setLtoArrTpCd(String ltoArrTpCd) {
		this.ltoArrTpCd = ltoArrTpCd;
	}
	public String getLtoArrDt() {
		return ltoArrDt;
	}
	public void setLtoArrDt(String ltoArrDt) {
		this.ltoArrDt = ltoArrDt;
	}
	public String getLtoRegDt() {
		return ltoRegDt;
	}
	public void setLtoRegDt(String ltoRegDt) {
		this.ltoRegDt = ltoRegDt;
	}
	public int getStoSeq() {
		return stoSeq;
	}
	public void setStoSeq(int stoSeq) {
		this.stoSeq = stoSeq;
	}
	public int getStoLtoSeq() {
		return stoLtoSeq;
	}
	public void setStoLtoSeq(int stoLtoSeq) {
		this.stoLtoSeq = stoLtoSeq;
	}
	public String getStoStatus() {
		return stoStatus;
	}
	public void setStoStatus(String stoStatus) {
		this.stoStatus = stoStatus;
	}
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
	public String getStoArrStdPst() {
		return stoArrStdPst;
	}
	public void setStoArrStdPst(String stoArrStdPst) {
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
	public int getStoTrialCnt() {
		return stoTrialCnt;
	}
	public void setStoTrialCnt(int stoTrialCnt) {
		this.stoTrialCnt = stoTrialCnt;
	}
	
	
}
