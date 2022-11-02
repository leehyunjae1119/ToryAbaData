package com.tad.mbr.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tad.mbr.service.mbrService;
import com.tad.mbr.vo.mbrVO;
import com.tad.mbr.dao.mbrDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class mbrServiceImpl implements mbrService {

	@Inject
	mbrDao mbrDao;

	@Override
	public List<mbrVO> mbrMemberListSelect(mbrVO mbrVO) throws Exception {
		return mbrDao.mbrMemberListSelect(mbrVO);
	}

	@Override
	public int mbrApprovalYnUpdate(mbrVO mbrVO) throws Exception {
		return mbrDao.mbrApprovalYnUpdate(mbrVO);
	}

	@Override
	public int mbrMemberAuthCdUpdate(mbrVO mbrVO) throws Exception {
		return mbrDao.mbrMemberAuthCdUpdate(mbrVO);
	}
}
