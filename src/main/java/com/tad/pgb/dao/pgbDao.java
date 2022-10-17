package com.tad.pgb.dao;

import java.util.List;

import com.tad.pgb.vo.pgbDtoVO;
import com.tad.pgb.vo.pgbLtoVO;
import com.tad.pgb.vo.pgbPointVO;
import com.tad.pgb.vo.pgbStoVO;
import com.tad.pgb.vo.pgbVO;


public interface pgbDao {
	
	String namespace = "com.tad.pgb.dao.pgbDao.";
	
	public List<pgbDtoVO> pgbDtoListSelect(pgbDtoVO pgbDtoVO) throws Exception;
	
	public List<pgbLtoVO> pgbLtoListSelect(pgbLtoVO pgbLtoVO) throws Exception;
	
	public List<pgbStoVO> pgbStoListSelect(pgbStoVO pgbStoVO) throws Exception;
	
	public pgbLtoVO pgbLtoOneSelect(pgbLtoVO pgbLtoVO) throws Exception;
	
	public pgbStoVO pgbStoOneSelect(pgbStoVO pgbStoVO) throws Exception;

	public int pgbLtoInsert(pgbLtoVO pgbLtoVO) throws Exception;
	
	public int pgbLtoUpdate(pgbLtoVO pgbLtoVO) throws Exception;
	
	public int pgbStoInsert(pgbStoVO pgbStoVO) throws Exception;
	
	public int pgbStoUpdate(pgbStoVO pgbStoVO) throws Exception;
	
	public int pgbLtoStautsUpdate(pgbLtoVO pgbLtoVO) throws Exception;
	
	public int pgbStoStautsUpdate(pgbStoVO pgbStoVO) throws Exception;
	
	public String pgbDtoStautsAutoUpdate(pgbVO pgbVO) throws Exception;
	
	public String pgbLtoStautsAutoUpdate(pgbVO pgbVO) throws Exception;
	
	public String pgbStoStautsAutoUpdate(pgbVO pgbVO) throws Exception;
	
	public int pgbPointInsert(pgbPointVO pgbPointVO) throws Exception;
	
	public int pgbPointDelete(pgbPointVO pgbPointVO) throws Exception;
	
	public List<pgbPointVO> pgbPointListSelect(pgbPointVO pgbPointVO) throws Exception;
}
