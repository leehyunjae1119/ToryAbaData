package com.tad.pgb.vo;


import org.springframework.stereotype.Component;

@Component(value="pgbDtoVO")
public class pgbDtoVO extends pgbVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String domainTpCd;
	private String domainName;
	private String domainContents;
	private String domainUseYn;
	private String domainRegDt;
	private String delYn;
	
	public String getDomainTpCd() {
		return domainTpCd;
	}
	public void setDomainTpCd(String domainTpCd) {
		this.domainTpCd = domainTpCd;
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
	
}
