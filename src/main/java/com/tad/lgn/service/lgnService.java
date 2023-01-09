package com.tad.lgn.service;

import com.tad.lgn.vo.lgnVO;

public interface lgnService {

	public lgnVO login(lgnVO lgnVO) throws Exception;

	public boolean isDuplicateId(lgnVO lgnVO) throws Exception;

	public int join(lgnVO lgnVO) throws Exception;
	
	public String lgnSubAuthCheck(lgnVO lgnVO) throws Exception;
}
