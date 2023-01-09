package com.tad.ntc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tad.ntc.dao.ntcDao;
import com.tad.ntc.vo.ntcVO;

@Repository
public class ntcDaoImpl implements ntcDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ntcVO> ntcNoticeListSelect(ntcVO ntcVO) throws Exception {
		List<ntcVO> resultList = sqlSession.selectList(namespace + "ntcNoticeListSelect", ntcVO);
		return resultList;
	}

	@Override
	public ntcVO ntcNoticeListSelectCnt(ntcVO ntcVO) throws Exception {
		ntcVO result = sqlSession.selectOne(namespace + "ntcNoticeListSelectCnt", ntcVO);
		return result;
	}
	
	@Override
	public ntcVO ntcNoticeOneSelect(ntcVO ntcVO) throws Exception {
		ntcVO result = sqlSession.selectOne(namespace + "ntcNoticeOneSelect", ntcVO);
		return result;
	}

	@Override
	public int ntcNoticeInsert(ntcVO ntcVO) throws Exception {
		int result = sqlSession.insert(namespace + "ntcNoticeInsert", ntcVO);
		return result;
	}

	@Override
	public int ntcNoticeUpdate(ntcVO ntcVO) throws Exception {
		int result = sqlSession.update(namespace + "ntcNoticeUpdate", ntcVO);
		return result;
	}
	
	@Override
	public int ntcNoticeDelete(ntcVO ntcVO) throws Exception {
		int result = sqlSession.delete(namespace + "ntcNoticeDelete", ntcVO);
		return result;
	}
	
	@Override
	public ntcVO ntcNoticeCntSelect() throws Exception {
		ntcVO result = sqlSession.selectOne(namespace + "ntcNoticeCntSelect");
		return result;
	}
	
}
