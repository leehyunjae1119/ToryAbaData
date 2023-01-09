package com.tad.ntc.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.tad.common.vo.pagingVO;

@Component(value="ntcVO")
public class ntcVO extends pagingVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int rownum;
	private int noticeSeq;
	private String noticeTitle;
	private String noticeContents;
	private int noticeRegMbrSeq;
	private String memberName;
	private String noticeRegDt;
	
	private String searchText1;
	
	private int noticeCnt;
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getNoticeSeq() {
		return noticeSeq;
	}
	public void setNoticeSeq(int noticeSeq) {
		this.noticeSeq = noticeSeq;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContents() {
		return noticeContents;
	}
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	public int getNoticeRegMbrSeq() {
		return noticeRegMbrSeq;
	}
	public void setNoticeRegMbrSeq(int noticeRegMbrSeq) {
		this.noticeRegMbrSeq = noticeRegMbrSeq;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getNoticeRegDt() {
		return noticeRegDt;
	}
	public void setNoticeRegDt(String noticeRegDt) {
		this.noticeRegDt = noticeRegDt;
	}
	public String getSearchText1() {
		return searchText1;
	}
	public void setSearchText1(String searchText1) {
		this.searchText1 = searchText1;
	}
	public int getNoticeCnt() {
		return noticeCnt;
	}
	public void setNoticeCnt(int noticeCnt) {
		this.noticeCnt = noticeCnt;
	}
	
}
