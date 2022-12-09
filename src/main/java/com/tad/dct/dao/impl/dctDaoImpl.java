package com.tad.dct.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tad.dct.dao.dctDao;
import com.tad.dct.vo.dctChartVO;
import com.tad.dct.vo.dctVO;

@Repository
public class dctDaoImpl implements dctDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<dctVO> dctCenterListSelect(dctVO dctVO) throws Exception {
		
		List<dctVO> resultList = sqlSession.selectList(namespace + "dctCenterListSelect", dctVO);
		
		return resultList;
	}

	@Override
	public int dctCenterInsert(dctVO dctVO) throws Exception {

		int result = sqlSession.insert(namespace + "dctCenterInsert", dctVO);
		
		return result;
	}

	@Override
	public int dctCenterUpdate(dctVO dctVO) throws Exception {

		int result = sqlSession.update(namespace + "dctCenterUpdate", dctVO);
		
		return result;
	}

	@Override
	public int dctCenterDelete(dctVO dctVO) throws Exception {

		int result = sqlSession.delete(namespace + "dctCenterDelete", dctVO);
		
		return result;
	}
	
	@Override
	public List<dctVO> dctClassListSelect(dctVO dctVO) throws Exception {
		
		List<dctVO> resultList = sqlSession.selectList(namespace + "dctClassListSelect", dctVO);
		
		return resultList;
	}
	
	@Override
	public int dctClassInsert(dctVO dctVO) throws Exception {
		
		int result = sqlSession.insert(namespace + "dctClassInsert", dctVO);
		
		return result;
	}
	
	@Override
	public int dctClassUpdate(dctVO dctVO) throws Exception {
		
		int result = sqlSession.update(namespace + "dctClassUpdate", dctVO);
		
		return result;
	}
	
	@Override
	public int dctClassDelete(dctVO dctVO) throws Exception {
		
		int result = sqlSession.delete(namespace + "dctClassDelete", dctVO);
		
		return result;
	}
	
	@Override
	public List<dctVO> dctStudentListSelect(dctVO dctVO) throws Exception {
		
		List<dctVO> resultList = sqlSession.selectList(namespace + "dctStudentListSelect", dctVO);
		
		return resultList;
	}
	
	@Override
	public dctVO dctStudentOneSelect(dctVO dctVO) throws Exception {
		
		dctVO result = sqlSession.selectOne(namespace + "dctStudentOneSelect", dctVO);
		
		return result;
	}
	
	@Override
	public int dctStudentInsert(dctVO dctVO) throws Exception {
		
		int result = sqlSession.insert(namespace + "dctStudentInsert", dctVO);
		int studentSeq = 0;
		if(result > 0) {
			studentSeq = dctVO.getStudentSeq();
		}
		return studentSeq;
	}
	
	@Override
	public int dctStudentUpdate(dctVO dctVO) throws Exception {
		
		int result = sqlSession.update(namespace + "dctStudentUpdate", dctVO);
		
		return result;
	}
	
	@Override
	public int dctStudentDelete(dctVO dctVO) throws Exception {
		
		int result = sqlSession.delete(namespace + "dctStudentDelete", dctVO);
		
		return result;
	}

	@Override
	public List<dctVO> dctCurriculumListSelect(dctVO dctVO) throws Exception {
		
		List<dctVO> resultList = sqlSession.selectList(namespace + "dctCurriculumListSelect", dctVO);
		
		return resultList;
	}
	
	@Override
	public List<dctVO> dctDomainSeqListSelect(dctVO dctVO) throws Exception {
		
		List<dctVO> resultList = sqlSession.selectList(namespace + "dctDomainSeqListSelect", dctVO);
		
		return resultList;
	}
	
	@Override
	public List<dctVO> dctCompletionListSelect(dctVO dctVO) throws Exception {
		
		List<dctVO> resultList = sqlSession.selectList(namespace + "dctCompletionListSelect", dctVO);
		
		return resultList;
	}
	
	@Override
	public dctVO dctCompletionListSelectCnt(dctVO dctVO) throws Exception {
		
		dctVO result = sqlSession.selectOne(namespace + "dctCompletionListSelectCnt", dctVO);
		
		return result;
	}

	@Override
	public List<dctChartVO> dctRunUnitListSelect(dctChartVO dctChartVO) throws Exception {
		
		List<dctChartVO> resultList = sqlSession.selectList(namespace + "dctRunUnitListSelect", dctChartVO);
		
		return resultList;
	}
	
	@Override
	public List<dctChartVO> dctCriteriaListSelect(dctChartVO dctChartVO) throws Exception {
		
		List<dctChartVO> resultList = sqlSession.selectList(namespace + "dctCriteriaListSelect", dctChartVO);
		
		return resultList;
	}
	
	@Override
	public List<dctChartVO> dctDomainSelect(dctVO dctVO) throws Exception {
		
		List<dctChartVO> resultList = sqlSession.selectList(namespace + "dctDomainSelect", dctVO);
		
		return resultList;
	}
	
	@Override
	public int dctDatePickerDelete(dctChartVO dctChartVO) throws Exception {
		
		int result = sqlSession.delete(namespace + "dctDatePickerDelete", dctChartVO);
		
		return result;
	}
	
	@Override
	public int dctDatePickerInsert(dctChartVO dctChartVO) throws Exception {
		
		int result = sqlSession.insert(namespace + "dctDatePickerInsert", dctChartVO);
		
		return result;
	}
	
	@Override
	public List<dctChartVO> dctDatePickerSelect(dctChartVO dctChartVO) throws Exception {
		
		List<dctChartVO> resultList = sqlSession.selectList(namespace + "dctDatePickerSelect", dctChartVO);
		
		return resultList;
	}
	
	@Override
	public List<dctChartVO> dctDomainChartDataSelect(dctChartVO dctChartVO) throws Exception {
		
		List<dctChartVO> resultList = sqlSession.selectList(namespace + "dctDomainChartDataSelect", dctChartVO);
		
		return resultList;
	}

	@Override
	public List<dctVO> dctDomainListSelect(dctVO dctVO) throws Exception {
		
		List<dctVO> resultList = sqlSession.selectList(namespace + "dctDomainListSelect", dctVO);
		
		return resultList;
	}
	
	@Override
	public List<dctVO> dctLtoListSelect(dctVO dctVO) throws Exception {
		
		List<dctVO> resultList = sqlSession.selectList(namespace + "dctLtoListSelect", dctVO);
		
		return resultList;
	}
	
	@Override
	public List<dctVO> dctStoListSelect(dctVO dctVO) throws Exception {
		
		List<dctVO> resultList = sqlSession.selectList(namespace + "dctStoListSelect", dctVO);
		
		return resultList;
	}
}
