package com.tad.mai.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tad.mai.dao.maiDao;
import com.tad.mai.vo.maiVO;

@Repository
public class maiDaoImpl implements maiDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<maiVO> maiCalenderListSelect(maiVO maiVO) throws Exception {
		List<maiVO> resultList = sqlSession.selectList(namespace + "maiCalenderListSelect", maiVO);
		
		return resultList;
	}

	@Override
	public int maiCalenderInsert(maiVO maiVO) throws Exception {
		int result = sqlSession.insert(namespace + "maiCalenderInsert", maiVO);
		
		return result;
	}

	@Override
	public int maiCalenderDelete(maiVO maiVO) throws Exception {
		int result = sqlSession.delete(namespace + "maiCalenderDelete", maiVO);
		
		return result;
	}

	@Override
	public List<maiVO> maiCalenderDataDtlist(maiVO maiVO) throws Exception {
		List<maiVO> resultList = sqlSession.selectList(namespace + "maiCalenderDataDtlist", maiVO);
		
		return resultList;
	}
}
