package com.tad.crc.service;

import java.util.List;

import com.tad.crc.vo.pgbVO;

public interface pgbService {
	
	public List<List<pgbVO>> pgbSelectBoxListSelect() throws Exception;

	public List<pgbVO> pgbStudentListSelect(pgbVO pgbVO) throws Exception;
	
	public pgbVO pgbLTOCntSelect(pgbVO pgbVO) throws Exception;
	
	public List<pgbVO> pgbLTOCardListSelect(pgbVO pgbVO) throws Exception;
	
	public int pgbDomainInsert(pgbVO pgbVO) throws Exception;
	
	public int pgbManagerUpdate(pgbVO pgbVO) throws Exception;
	
	public int pgbDomainDelete(pgbVO pgbVO) throws Exception;
	
}
