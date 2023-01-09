package com.tad.mai.dao;

import java.util.List;

import com.tad.mai.vo.maiVO;

public interface maiDao {

	String namespace = "com.tad.mai.dao.maiDao.";
	
	public List<maiVO> maiCalenderListSelect(maiVO maiVO) throws Exception;
	
	public int maiCalenderInsert(maiVO maiVO) throws Exception;
	
	public int maiCalenderDelete(maiVO maiVO) throws Exception;
	
	public List<maiVO> maiCalenderDataDtlist(maiVO maiVO) throws Exception;

}
