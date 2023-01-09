package com.tad.dct.vo;

import org.springframework.stereotype.Component;


@Component(value="dctConsultingVO")
public class dctConsultingVO extends dctVO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int consultingSeq;
	private String consultingContents;
	private String onlyMyPostYn;
	private String consultingRegDt;
	
	public int getConsultingSeq() {
		return consultingSeq;
	}
	public void setConsultingSeq(int consultingSeq) {
		this.consultingSeq = consultingSeq;
	}
	public String getConsultingContents() {
		return consultingContents;
	}
	public void setConsultingContents(String consultingContents) {
		this.consultingContents = consultingContents;
	}
	public String getOnlyMyPostYn() {
		return onlyMyPostYn;
	}
	public void setOnlyMyPostYn(String onlyMyPostYn) {
		this.onlyMyPostYn = onlyMyPostYn;
	}
	public String getConsultingRegDt() {
		return consultingRegDt;
	}
	public void setConsultingRegDt(String consultingRegDt) {
		this.consultingRegDt = consultingRegDt;
	}
	
}
