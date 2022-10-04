package com.tad.common.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tad.common.dao.cmmDao;
import com.tad.common.vo.cmmVO;

@Repository
public class cmmDaoImpl implements cmmDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<cmmVO> selectComboTeacher() throws Exception {
		return sqlSession.selectList(namespace + "selectComboTeacher");
	}

	@Override
	public List<cmmVO> selectComboParent() throws Exception {
		return sqlSession.selectList(namespace + "selectComboParent");
	}

}
