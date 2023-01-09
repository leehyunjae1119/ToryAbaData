package com.tad.mai.service;

import java.util.List;

import com.tad.mai.vo.maiVO;

public interface maiService {

	public List<maiVO> maiCalenderListSelect(maiVO maiVO) throws Exception;
	
	public int maiCalenderInsert(maiVO maiVO) throws Exception;
	
	public int maiCalenderDelete(maiVO maiVO) throws Exception;
	
	public List<maiVO> maiCalenderDataDtlist(maiVO maiVO) throws Exception;

}
