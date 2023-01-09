package com.tad.lgn.dao;

import com.tad.lgn.vo.lgnVO;

public interface lgnDao {

	String namespace = "com.tad.lgn.dao.lgnDao.";
	
	public lgnVO login(lgnVO lgnVO) throws Exception;

	public int join(lgnVO lgnVO) throws Exception;
	
	public String lgnSubAuthCheck(lgnVO lgnVO) throws Exception;
}
