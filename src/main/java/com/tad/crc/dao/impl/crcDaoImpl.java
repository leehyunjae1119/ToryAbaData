package com.tad.crc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tad.crc.dao.crcDao;
import com.tad.crc.vo.crcVO;

@Repository
public class crcDaoImpl implements crcDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<crcVO> crcDomainListSelect(crcVO crcVO) throws Exception {
		List<crcVO> resultList = sqlSession.selectList(namespace + "crcDomainListSelect", crcVO);
		
		return resultList;
	}

	@Override
	public crcVO crcDomainOneSelect(crcVO crcVO) throws Exception {
		crcVO result = sqlSession.selectOne(namespace + "crcDomainOneSelect", crcVO);

		return result;
	}

	@Override
	public int crcDomainInsert(crcVO crcVO) throws Exception {
		int result = sqlSession.insert(namespace + "crcDomainInsert", crcVO);

		return result;
	}

	@Override
	public int crcDomainUpdate(crcVO crcVO) throws Exception {
		int result = sqlSession.insert(namespace + "crcDomainUpdate", crcVO);

		return result;
	}

	@Override
	public int crcDomainUseYnUpdate(crcVO crcVO) throws Exception {
		int result = sqlSession.insert(namespace + "crcDomainUseYnUpdate", crcVO);

		return result;
	}

	@Override
	public int crcDomainDelete(crcVO crcVO) throws Exception {
		int result = sqlSession.insert(namespace + "crcDomainDelete", crcVO);

		return result;
	}
	
	@Override
	public List<crcVO> crcLTOListSelect(crcVO crcVO) throws Exception {
		List<crcVO> resultList = sqlSession.selectList(namespace + "crcLTOListSelect", crcVO);
		
		return resultList;
	}
	
	@Override
	public crcVO crcLTOOneSelect(crcVO crcVO) throws Exception {
		crcVO result = sqlSession.selectOne(namespace + "crcLTOOneSelect", crcVO);
		
		return result;
	}
	
	@Override
	public int crcLTOInsert(crcVO crcVO) throws Exception {
		int result = sqlSession.insert(namespace + "crcLTOInsert", crcVO);
		
		return result;
	}
	
	@Override
	public int crcLTOUpdate(crcVO crcVO) throws Exception {
		int result = sqlSession.insert(namespace + "crcLTOUpdate", crcVO);
		
		return result;
	}
	
	@Override
	public int crcLTODelete(crcVO crcVO) throws Exception {
		int result = sqlSession.insert(namespace + "crcLTODelete", crcVO);
		
		return result;
	}
	
	@Override
	public List<crcVO> crcSTOListSelect(crcVO crcVO) throws Exception {
		List<crcVO> resultList = sqlSession.selectList(namespace + "crcSTOListSelect", crcVO);
		
		return resultList;
	}
	
	@Override
	public crcVO crcSTOOneSelect(crcVO crcVO) throws Exception {
		crcVO result = sqlSession.selectOne(namespace + "crcSTOOneSelect", crcVO);
		
		return result;
	}
	
	@Override
	public int crcSTOInsert(crcVO crcVO) throws Exception {
		int result = sqlSession.insert(namespace + "crcSTOInsert", crcVO);
		
		return result;
	}
	
	@Override
	public int crcSTOUpdate(crcVO crcVO) throws Exception {
		int result = sqlSession.insert(namespace + "crcSTOUpdate", crcVO);
		
		return result;
	}
	
	@Override
	public int crcSTODelete(crcVO crcVO) throws Exception {
		int result = sqlSession.insert(namespace + "crcSTODelete", crcVO);
		
		return result;
	}

	@Override
	public int crcAutoInsert(crcVO crcVO) throws Exception {
		
		List<crcVO> dtoTmpList = sqlSession.selectList(namespace + "crcDTOTmpListSelect");
		
		for(crcVO vo : dtoTmpList) {
			vo.setStudentSeq(crcVO.getStudentSeq());
			sqlSession.insert(namespace + "crcDTOAutoInsert", vo);
			sqlSession.insert(namespace + "crcLTOAutoInsert", vo);
		}
		
		return 1;
	}


}
