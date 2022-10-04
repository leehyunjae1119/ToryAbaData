package com.tad.dct.dao;

import java.util.List;

import com.tad.dct.vo.dctVO;

public interface dctDao {

	String namespace = "com.tad.dct.dao.dctDao.";
	
	public List<dctVO> dctCenterListSelect(dctVO dctVO) throws Exception;

	public int dctCenterInsert(dctVO dctVO) throws Exception;
	
	public int dctCenterUpdate(dctVO dctVO) throws Exception;
	
	public int dctCenterDelete(dctVO dctVO) throws Exception;
	
	public List<dctVO> dctClassListSelect(dctVO dctVO) throws Exception;
	
	public int dctClassInsert(dctVO dctVO) throws Exception;
	
	public int dctClassUpdate(dctVO dctVO) throws Exception;
	
	public int dctClassDelete(dctVO dctVO) throws Exception;
	
	public List<dctVO> dctStudentListSelect(dctVO dctVO) throws Exception;
	
	public dctVO dctStudentOneSelect(dctVO dctVO) throws Exception;
	
	public int dctStudentInsert(dctVO dctVO) throws Exception;
	
	public int dctStudentUpdate(dctVO dctVO) throws Exception;
	
	public int dctStudentDelete(dctVO dctVO) throws Exception;
	
	public List<dctVO> dctCurriculumListSelect(dctVO dctVO) throws Exception;
	
	public List<dctVO> dctDomainSeqListSelect(dctVO dctVO) throws Exception;
}