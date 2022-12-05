package com.tad.ntc.service;

import java.util.List;

import com.tad.ntc.vo.ntcVO;

public interface ntcService {
	
	public List<ntcVO> ntcNoticeListSelect(ntcVO ntcVO) throws Exception;
	
	public ntcVO ntcNoticeListSelectCnt(ntcVO ntcVO) throws Exception;
	
	public ntcVO ntcNoticeOneSelect(ntcVO ntcVO) throws Exception;
	
	public int ntcNoticeInsert(ntcVO ntcVO) throws Exception;
	
	public int ntcNoticeUpdate(ntcVO ntcVO) throws Exception;
	
	public int ntcNoticeDelete(ntcVO ntcVO) throws Exception;
	
}
