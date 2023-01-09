package com.tad.lgn.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tad.lgn.dao.lgnDao;
import com.tad.lgn.service.lgnService;
import com.tad.lgn.vo.lgnVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class lgnServiceImpl implements lgnService {

	@Inject
	lgnDao lgnDao;

	@Override
	public lgnVO login(lgnVO lgnVO) throws Exception {
		lgnVO result = lgnDao.login(lgnVO);
		
		return result;
	}

	@Override
	public boolean isDuplicateId(lgnVO lgnVO) throws Exception {
		lgnVO result = lgnDao.login(lgnVO);
		if(result == null) {
			return true;
		}
		return false;
	}

	@Override
	public int join(lgnVO lgnVO) throws Exception {
		int res = lgnDao.join(lgnVO);
		
		return res;
	}

	@Override
	public String lgnSubAuthCheck(lgnVO lgnVO) throws Exception {
		return lgnDao.lgnSubAuthCheck(lgnVO);
	}
}
