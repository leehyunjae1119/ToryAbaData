package com.tad.pgb.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tad.pgb.dao.pgbDao;
import com.tad.pgb.vo.pgbDtoVO;
import com.tad.pgb.vo.pgbLtoVO;
import com.tad.pgb.vo.pgbPointVO;
import com.tad.pgb.vo.pgbStoVO;
import com.tad.pgb.vo.pgbVO;

@Repository
public class pgbDaoImpl implements pgbDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<pgbDtoVO> pgbDtoListSelect(pgbDtoVO pgbDtoVO) throws Exception {
		
		List<pgbDtoVO> resultList = sqlSession.selectList(namespace + "pgbDtoListSelect", pgbDtoVO);
		
		return resultList;
	}

	@Override
	public List<pgbLtoVO> pgbLtoListSelect(pgbLtoVO pgbLtoVO) throws Exception {

		List<pgbLtoVO> resultList = sqlSession.selectList(namespace + "pgbLtoListSelect", pgbLtoVO);
		
		return resultList;
	}

	@Override
	public List<pgbStoVO> pgbStoListSelect(pgbStoVO pgbStoVO) throws Exception {

		List<pgbStoVO> resultList = sqlSession.selectList(namespace + "pgbStoListSelect", pgbStoVO);
		
		return resultList;
	}

	@Override
	public pgbLtoVO pgbLtoOneSelect(pgbLtoVO pgbLtoVO) throws Exception {

		pgbLtoVO result = sqlSession.selectOne(namespace + "pgbLtoOneSelect", pgbLtoVO);
		
		return result;
	}
	
	@Override
	public pgbStoVO pgbStoOneSelect(pgbStoVO pgbStoVO) throws Exception {
		
		pgbStoVO result = sqlSession.selectOne(namespace + "pgbStoOneSelect", pgbStoVO);
		
		return result;
	}
	
	@Override
	public int pgbLtoInsert(pgbLtoVO pgbLtoVO) throws Exception {
		
		int result = sqlSession.insert(namespace + "pgbLtoInsert", pgbLtoVO);
		
		return result;
	}
	
	@Override
	public int pgbLtoUpdate(pgbLtoVO pgbLtoVO) throws Exception {
		
		int result = sqlSession.update(namespace + "pgbLtoUpdate", pgbLtoVO);
		
		return result;
	}
	
	@Override
	public int pgbStoInsert(pgbStoVO pgbStoVO) throws Exception {
		
		int result = sqlSession.insert(namespace + "pgbStoInsert", pgbStoVO);
		
		return result;
	}
	
	@Override
	public int pgbStoUpdate(pgbStoVO pgbStoVO) throws Exception {
		
		int result = sqlSession.update(namespace + "pgbStoUpdate", pgbStoVO);
		
		return result;
	}

	@Override
	public int pgbLtoStautsUpdate(pgbLtoVO pgbLtoVO) throws Exception {
		
		int result = sqlSession.update(namespace + "pgbLtoStautsUpdate", pgbLtoVO);
		
		return result;
	}
	
	@Override
	public int pgbStoStautsUpdate(pgbStoVO pgbStoVO) throws Exception {
		
		int result = sqlSession.update(namespace + "pgbStoStautsUpdate", pgbStoVO);
		
		return result;
	}
	
	@Override
	public String pgbStoStautsAutoUpdate(pgbVO pgbVO) throws Exception {
		String resultStr = "";
		int result = sqlSession.update(namespace + "pgbStoStautsAutoUpdate", pgbVO);
		if(result > 0 ) {
			System.out.println("==== dao.pgbStoStautsAutoUpdate : " + resultStr);
			resultStr = pgbVO.getStoStatus();
		}
		return resultStr;
	}
	
	@Override
	public String pgbLtoStautsAutoUpdate(pgbVO pgbVO) throws Exception {
		String resultStr = "";
		int result = sqlSession.update(namespace + "pgbLtoStautsAutoUpdate", pgbVO);
		if(result > 0 ) {
			resultStr = pgbVO.getLtoStatus();
		}
		return resultStr;
	}
	
	@Override
	public String pgbDtoStautsAutoUpdate(pgbVO pgbVO) throws Exception {
		String resultStr = "";
		int result = sqlSession.update(namespace + "pgbDtoStautsAutoUpdate", pgbVO);
		if(result > 0 ) {
			resultStr = pgbVO.getDomainStatus();
		}
		return resultStr;
	}

	@Override
	public int pgbPointInsert(pgbPointVO pgbPointVO) throws Exception {

		int result = sqlSession.insert(namespace + "pgbPointInsert", pgbPointVO);
		
		return result;
	}
	
	@Override
	public int pgbPointDelete(pgbPointVO pgbPointVO) throws Exception {
		
		int result = sqlSession.delete(namespace + "pgbPointDelete", pgbPointVO);
		
		return result;
	}

	@Override
	public List<pgbPointVO> pgbPointListSelect(pgbPointVO pgbPointVO) throws Exception {

		List<pgbPointVO> resultList = sqlSession.selectList(namespace + "pgbPointListSelect", pgbPointVO);
		
		return resultList;
	}

}
