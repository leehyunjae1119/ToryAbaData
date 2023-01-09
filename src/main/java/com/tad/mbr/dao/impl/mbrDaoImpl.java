package com.tad.mbr.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tad.mbr.dao.mbrDao;
import com.tad.mbr.vo.mbrVO;

@Repository
public class mbrDaoImpl implements mbrDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<mbrVO> mbrMemberListSelect(mbrVO mbrVO) throws Exception {
		List<mbrVO> resultList = sqlSession.selectList(namespace + "mbrMemberListSelect", mbrVO);
		return resultList;
	}

	@Override
	public mbrVO mbrMemberListSelectCnt(mbrVO mbrVO) throws Exception {
		mbrVO result = sqlSession.selectOne(namespace + "mbrMemberListSelectCnt", mbrVO);
		return result;
	}
	
	@Override
	public int mbrApprovalYnUpdate(mbrVO mbrVO) throws Exception {
		int result = sqlSession.update(namespace + "mbrApprovalYnUpdate", mbrVO);
		return result;
	}

	@Override
	public int mbrMemberAuthCdUpdate(mbrVO mbrVO) throws Exception {
		int result = sqlSession.update(namespace + "mbrMemberAuthCdUpdate", mbrVO);
		return result;
	}
	
	@Override
	public int mbrMemberPwReset(mbrVO mbrVO) throws Exception {
		int result = sqlSession.update(namespace + "mbrMemberPwReset", mbrVO);
		return result;
	}

	@Override
	public mbrVO mbrMemberOneSelect(mbrVO mbrVO) throws Exception {
		mbrVO result = sqlSession.selectOne(namespace + "mbrMemberOneSelect", mbrVO);
		return result;
	}

	@Override
	public int mbrProfileUpdate(mbrVO mbrVO) throws Exception {
		int result = sqlSession.update(namespace + "mbrProfileUpdate", mbrVO);
		return result;
	}

	@Override
	public List<mbrVO> teachListSelect(mbrVO mbrVO) throws Exception {
		List<mbrVO> resultList = sqlSession.selectList(namespace + "teachListSelect", mbrVO);
		return resultList;
	}

	@Override
	public List<mbrVO> authTeachListSelect(mbrVO mbrVO) throws Exception {
		List<mbrVO> resultList = sqlSession.selectList(namespace + "authTeachListSelect", mbrVO);
		return resultList;
	}

	@Override
	public int subAuthInsert(mbrVO mbrVO) throws Exception {
		int result = sqlSession.insert(namespace + "subAuthInsert", mbrVO);
		return result;
	}

	@Override
	public int subAuthDelete(mbrVO mbrVO) throws Exception {
		int result = sqlSession.delete(namespace + "subAuthDelete", mbrVO);
		return result;
	}

}
