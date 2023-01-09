package com.tad.lgn.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tad.lgn.dao.lgnDao;
import com.tad.lgn.vo.lgnVO;

@Repository
public class lgnDaoImpl implements lgnDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public lgnVO login(lgnVO lgnVO) throws Exception {

		lgnVO result = sqlSession.selectOne(namespace + "login", lgnVO);
		
		return result;
	}

	@Override
	public int join(lgnVO lgnVO) throws Exception {
		
		int res = sqlSession.insert(namespace + "join", lgnVO);
		
		return res;
	}

	@Override
	public String lgnSubAuthCheck(lgnVO lgnVO) throws Exception {
		String res = sqlSession.selectOne(namespace + "lgnSubAuthCheck", lgnVO);
		
		return res;
	}

}
