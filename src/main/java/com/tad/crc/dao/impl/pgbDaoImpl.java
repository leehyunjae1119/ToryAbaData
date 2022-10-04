package com.tad.crc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tad.crc.dao.pgbDao;
import com.tad.crc.vo.pgbVO;

@Repository
public class pgbDaoImpl implements pgbDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<pgbVO> pgbCenterListSelect() throws Exception {
		List<pgbVO> resultList = sqlSession.selectList(namespace + "pgbCenterListSelect");
		
		return resultList;
	}
	
	@Override
	public List<pgbVO> pgbClassListSelect() throws Exception {
		List<pgbVO> resultList = sqlSession.selectList(namespace + "pgbClassListSelect");
		
		return resultList;
	}
	
	@Override
	public List<pgbVO> pgbDomainListSelect() throws Exception {
		List<pgbVO> resultList = sqlSession.selectList(namespace + "pgbDomainListSelect");
		
		return resultList;
	}
	
	@Override
	public List<pgbVO> pgbMemberListSelect() throws Exception {
		List<pgbVO> resultList = sqlSession.selectList(namespace + "pgbMemberListSelect");
		
		return resultList;
	}
	
	@Override
	public List<pgbVO> pgbStudentListSelect(pgbVO pgbVO) throws Exception {
		List<pgbVO> resultList = sqlSession.selectList(namespace + "pgbStudentListSelect", pgbVO);
		
		return resultList;
	}
	
	@Override
	public pgbVO pgbLTOCntSelect(pgbVO pgbVO) throws Exception {
		pgbVO result = sqlSession.selectOne(namespace + "pgbLTOCntSelect", pgbVO);
		
		return result;
	}
	
	@Override
	public List<pgbVO> pgbLTOCardListSelect(pgbVO pgbVO) throws Exception {
		List<pgbVO> resultList = sqlSession.selectList(namespace + "pgbLTOCardListSelect", pgbVO);
		
		return resultList;
	}
	
	@Override
	public List<pgbVO> pgbTmpDomainSeqSelect(pgbVO pgbVO) throws Exception {
		List<pgbVO> resultList = sqlSession.selectList(namespace + "pgbTmpDomainSeqSelect", pgbVO);
		
		return resultList;
	}

	@Override
	public int pgbDomainInsert(pgbVO pgbVO) throws Exception {
		int result = sqlSession.insert(namespace + "pgbDomainInsert", pgbVO);
		
		return result;
	}
	
	@Override
	public int pgbLTOInsert(pgbVO pgbVO) throws Exception {
		int result = sqlSession.insert(namespace + "pgbLTOInsert", pgbVO);
		
		return result;
	}
	
	@Override
	public int pgbManagerUpdate(pgbVO pgbVO) throws Exception {
		int result = sqlSession.update(namespace + "pgbManagerUpdate", pgbVO);
		
		return result;
	}
	
	@Override
	public int pgbDomainDelete(pgbVO pgbVO) throws Exception {
		int result = sqlSession.update(namespace + "pgbDomainDelete", pgbVO);
		
		return result;
	}

}
