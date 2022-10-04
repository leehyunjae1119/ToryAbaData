package com.tad.crc.dao;

import java.util.List;

import com.tad.crc.vo.pgbVO;

public interface pgbDao {
	
	String namespace = "com.tad.crc.dao.pgbDao.";
	
	public List<pgbVO> pgbCenterListSelect() throws Exception;
	
	public List<pgbVO> pgbClassListSelect() throws Exception;
	
	public List<pgbVO> pgbDomainListSelect() throws Exception;
	
	public List<pgbVO> pgbMemberListSelect() throws Exception;
	
	public List<pgbVO> pgbStudentListSelect(pgbVO pgbVO) throws Exception;
	
	public pgbVO pgbLTOCntSelect(pgbVO pgbVO) throws Exception;
	
	public List<pgbVO> pgbLTOCardListSelect(pgbVO pgbVO) throws Exception;
	
	public List<pgbVO> pgbTmpDomainSeqSelect(pgbVO pgbVO) throws Exception;
	
	public int pgbDomainInsert(pgbVO pgbVO) throws Exception;
	
	public int pgbLTOInsert(pgbVO pgbVO) throws Exception;
	
	public int pgbManagerUpdate(pgbVO pgbVO) throws Exception;
	
	public int pgbDomainDelete(pgbVO pgbVO) throws Exception;

}
