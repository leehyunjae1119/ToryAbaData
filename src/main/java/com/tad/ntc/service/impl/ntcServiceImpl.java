package com.tad.ntc.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tad.ntc.dao.ntcDao;
import com.tad.ntc.service.ntcService;
import com.tad.ntc.vo.ntcVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ntcServiceImpl implements ntcService {

	@Inject
	ntcDao ntcDao;

	@Override
	public List<ntcVO> ntcNoticeListSelect(ntcVO ntcVO) throws Exception {
		int startNum = 0;
		
		startNum = (ntcVO.getPageNum() - 1) * 10;
		ntcVO.setStartNum(startNum);
		
		return ntcDao.ntcNoticeListSelect(ntcVO);
	}

	@Override
	public ntcVO ntcNoticeListSelectCnt(ntcVO ntcVO) throws Exception {
		return ntcDao.ntcNoticeListSelectCnt(ntcVO);
	}
	
	@Override
	public ntcVO ntcNoticeOneSelect(ntcVO ntcVO) throws Exception {
		return ntcDao.ntcNoticeOneSelect(ntcVO);
	}

	@Override
	public int ntcNoticeInsert(ntcVO ntcVO) throws Exception {
		return ntcDao.ntcNoticeInsert(ntcVO);
	}

	@Override
	public int ntcNoticeUpdate(ntcVO ntcVO) throws Exception {
		return ntcDao.ntcNoticeUpdate(ntcVO);
	}
	
	@Override
	public int ntcNoticeDelete(ntcVO ntcVO) throws Exception {
		return ntcDao.ntcNoticeDelete(ntcVO);
	}

	@Override
	public ntcVO ntcNoticeCntSelect() throws Exception {
		return ntcDao.ntcNoticeCntSelect();
	}

}
