package com.tad.pgb.service;

import java.util.List;
import java.util.Map;

import com.tad.pgb.vo.pgbChartVO;
import com.tad.pgb.vo.pgbDtoVO;
import com.tad.pgb.vo.pgbLtoVO;
import com.tad.pgb.vo.pgbPointVO;
import com.tad.pgb.vo.pgbStoVO;
import com.tad.pgb.vo.pgbVO;

public interface pgbService {
	
	public List<pgbDtoVO> pgbDtoListSelect(pgbDtoVO pgbDtoVO) throws Exception;
	
	public List<pgbLtoVO> pgbLtoListSelect(pgbLtoVO pgbLtoVO) throws Exception;
	
	public List<pgbStoVO> pgbStoListSelect(pgbStoVO pgbStoVO) throws Exception;
	
	public pgbLtoVO pgbLtoOneSelect(pgbLtoVO pgbLtoVO) throws Exception;
	
	public pgbStoVO pgbStoOneSelect(pgbStoVO pgbStoVO) throws Exception;
	
	public int pgbLtoInsert(pgbLtoVO pgbLtoVO) throws Exception;
	
	public int pgbLtoUpdate(pgbLtoVO pgbLtoVO) throws Exception;
	
	public int pgbStoInsert(pgbStoVO pgbStoVO) throws Exception;
	
	public int pgbStoUpdate(pgbStoVO pgbStoVO) throws Exception;
	
	public String pgbLtoStautsUpdate(pgbLtoVO pgbLtoVO) throws Exception;
	
	public Map<String, String> pgbStoStautsUpdate(pgbStoVO pgbStoVO) throws Exception;
	
	public int pgbPointInsert(pgbPointVO pgbPointVO) throws Exception;
	
	public int pgbPointDelete(pgbPointVO pgbPointVO) throws Exception;
	
	public List<pgbPointVO> pgbPointListSelect(pgbPointVO pgbPointVO) throws Exception;
	
	public Map<String, String> pgbStautsAutoUpdate(pgbVO pgbVO) throws Exception;
	
	public pgbVO pgbModalTitleSelect(pgbVO pgbVO) throws Exception;
	
	public List<pgbStoVO> pgbStoTmplListSelect(pgbStoVO pgbStoVO) throws Exception;
	
	public int pgbPointRoundUpdate(pgbStoVO pgbStoVO) throws Exception;

	public List<List<pgbChartVO>> pgbLtoChartDataSelect(pgbVO pgbVO) throws Exception;
	
	public int pgbStoDelete(pgbVO pgbVO) throws Exception;
}
