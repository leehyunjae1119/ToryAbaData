package com.tad.mai.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tad.common.vo.pagingVO;


@Component(value="maiVO")
public class maiVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int calenderSeq;
	private int memberSeq;
	private String memberName;
	private String calenderContents;
	private String calenderRegDt;
	
	public int getCalenderSeq() {
		return calenderSeq;
	}
	public void setCalenderSeq(int calenderSeq) {
		this.calenderSeq = calenderSeq;
	}
	public int getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(int memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getCalenderContents() {
		return calenderContents;
	}
	public void setCalenderContents(String calenderContents) {
		this.calenderContents = calenderContents;
	}
	public String getCalenderRegDt() {
		return calenderRegDt;
	}
	public void setCalenderRegDt(String calenderRegDt) {
		this.calenderRegDt = calenderRegDt;
	}
	
}
