package com.tad.mbr.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tad.mbr.dao.mbrDao;
import com.tad.mbr.service.mbrService;
import com.tad.mbr.vo.mbrVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class mbrServiceImpl implements mbrService {

	@Inject
	mbrDao mbrDao;

	@Override
	public List<mbrVO> mbrMemberListSelect(mbrVO mbrVO) throws Exception {
		int startNum = 0;
		
		startNum = (mbrVO.getPageNum() - 1) * 10;
		mbrVO.setStartNum(startNum);
		
		return mbrDao.mbrMemberListSelect(mbrVO);
	}
	
	@Override
	public mbrVO mbrMemberListSelectCnt(mbrVO mbrVO) throws Exception {
		return mbrDao.mbrMemberListSelectCnt(mbrVO);
	}

	@Override
	public int mbrApprovalYnUpdate(mbrVO mbrVO) throws Exception {
		return mbrDao.mbrApprovalYnUpdate(mbrVO);
	}

	@Override
	public int mbrMemberAuthCdUpdate(mbrVO mbrVO) throws Exception {
		return mbrDao.mbrMemberAuthCdUpdate(mbrVO);
	}
	
	@Override
	public int mbrMemberPwReset(mbrVO mbrVO) throws Exception {
		return mbrDao.mbrMemberPwReset(mbrVO);
	}

	@Override
	public mbrVO mbrMemberOneSelect(mbrVO mbrVO) throws Exception {
		return mbrDao.mbrMemberOneSelect(mbrVO);
	}

	@Override
	public int mbrProfileUpdate(mbrVO mbrVO) throws Exception {
		return mbrDao.mbrProfileUpdate(mbrVO);
	}

	@Override
	public List<mbrVO> teachListSelect(mbrVO mbrVO) throws Exception {
		return mbrDao.teachListSelect(mbrVO);
	}

	@Override
	public List<mbrVO> authTeachListSelect(mbrVO mbrVO) throws Exception {
		return mbrDao.authTeachListSelect(mbrVO);
	}

	@Override
	public int subAuthInsert(mbrVO mbrVO) throws Exception {
		return mbrDao.subAuthInsert(mbrVO);
	}

	@Override
	public int subAuthDelete(mbrVO mbrVO) throws Exception {
		return mbrDao.subAuthDelete(mbrVO);
	}
}
