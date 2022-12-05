package com.tad.ntc.dao;

import java.util.List;

import com.tad.ntc.vo.ntcVO;

public interface ntcDao {

	String namespace = "com.tad.ntc.dao.ntcDao.";
	
	public List<ntcVO> ntcNoticeListSelect(ntcVO ntcVO) throws Exception;
	
	public ntcVO ntcNoticeListSelectCnt(ntcVO ntcVO) throws Exception;
	
	public ntcVO ntcNoticeOneSelect(ntcVO ntcVO) throws Exception;
	
	public int ntcNoticeInsert(ntcVO ntcVO) throws Exception;
	
	public int ntcNoticeUpdate(ntcVO ntcVO) throws Exception;
	
	public int ntcNoticeDelete(ntcVO ntcVO) throws Exception;
	
}
