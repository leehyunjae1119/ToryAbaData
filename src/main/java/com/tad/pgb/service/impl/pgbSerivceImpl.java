package com.tad.pgb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tad.pgb.dao.pgbDao;
import com.tad.pgb.service.pgbService;
import com.tad.pgb.vo.pgbDtoVO;
import com.tad.pgb.vo.pgbLtoVO;
import com.tad.pgb.vo.pgbPointVO;
import com.tad.pgb.vo.pgbStoVO;
import com.tad.pgb.vo.pgbVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class pgbSerivceImpl implements pgbService {
	
	@Inject
	pgbDao pgbDao;

	@Override
	public List<pgbDtoVO> pgbDtoListSelect(pgbDtoVO pgbDtoVO) throws Exception {
		return pgbDao.pgbDtoListSelect(pgbDtoVO);
	}

	@Override
	public List<pgbLtoVO> pgbLtoListSelect(pgbLtoVO pgbLtoVO) throws Exception {
		return pgbDao.pgbLtoListSelect(pgbLtoVO);
	}

	@Override
	public List<pgbStoVO> pgbStoListSelect(pgbStoVO pgbStoVO) throws Exception {
		return pgbDao.pgbStoListSelect(pgbStoVO);
	}

	@Override
	public pgbLtoVO pgbLtoOneSelect(pgbLtoVO pgbLtoVO) throws Exception {
		return pgbDao.pgbLtoOneSelect(pgbLtoVO);
	}
	
	@Override
	public pgbStoVO pgbStoOneSelect(pgbStoVO pgbStoVO) throws Exception {
		return pgbDao.pgbStoOneSelect(pgbStoVO);
	}

	@Override
	public int pgbLtoInsert(pgbLtoVO pgbLtoVO) throws Exception {
		return pgbDao.pgbLtoInsert(pgbLtoVO);
	}
	
	@Override
	public int pgbLtoUpdate(pgbLtoVO pgbLtoVO) throws Exception {
		return pgbDao.pgbLtoUpdate(pgbLtoVO);
	}
	
	@Override
	public int pgbStoInsert(pgbStoVO pgbStoVO) throws Exception {
		return pgbDao.pgbStoInsert(pgbStoVO);
	}
	
	@Override
	public int pgbStoUpdate(pgbStoVO pgbStoVO) throws Exception {
		return pgbDao.pgbStoUpdate(pgbStoVO);
	}
	
	@Override
	public String pgbLtoStautsUpdate(pgbLtoVO pgbLtoVO) throws Exception {
		
		String result = "";
		int ltoResult = pgbDao.pgbLtoStautsUpdate(pgbLtoVO);
		
		if(ltoResult > 0) {
			pgbVO pgbVO = new pgbVO();
			pgbVO.setDomainSeq(pgbLtoVO.getDomainSeq());
			result = pgbDao.pgbDtoStautsAutoUpdate(pgbVO);
			
		}
		
		return result;
	}

	@Override
	public Map<String, String> pgbStoStautsUpdate(pgbStoVO pgbStoVO) throws Exception {

		Map<String, String> result = new HashMap<String, String>();
		int stoResult = pgbDao.pgbStoStautsUpdate(pgbStoVO);
		
		if(stoResult > 0) {
			pgbVO pgbVO = new pgbVO();
			pgbVO.setLtoSeq(pgbStoVO.getLtoSeq());
			pgbVO.setDomainSeq(pgbStoVO.getDomainSeq());
			
			String ltoStatus = pgbDao.pgbLtoStautsAutoUpdate(pgbVO);
			String dtoStatus = pgbDao.pgbDtoStautsAutoUpdate(pgbVO);
			
			result.put("ltoStatus", ltoStatus);
			result.put("dtoStatus", dtoStatus);
			
		}
		return result;
	}

	@Override
	public int pgbPointInsert(pgbPointVO pgbPointVO) throws Exception {
		return pgbDao.pgbPointInsert(pgbPointVO);
	}
	
	@Override
	public int pgbPointDelete(pgbPointVO pgbPointVO) throws Exception {
		return pgbDao.pgbPointDelete(pgbPointVO);
	}

	@Override
	public List<pgbPointVO> pgbPointListSelect(pgbPointVO pgbPointVO) throws Exception {
		return pgbDao.pgbPointListSelect(pgbPointVO);
	}
	
	@Override
	public Map<String, String> pgbStautsAutoUpdate(pgbVO pgbVO) throws Exception{
		Map<String, String> result = new HashMap<String, String>();
		if("STO".equals(pgbVO.getUpdateFlag())) {
			String stoStatus = pgbDao.pgbStoStautsAutoUpdate(pgbVO);
			String ltoStatus = pgbDao.pgbLtoStautsAutoUpdate(pgbVO);
			String dtoStatus = pgbDao.pgbDtoStautsAutoUpdate(pgbVO);
			result.put("stoStatus", stoStatus);
			result.put("ltoStatus", ltoStatus);
			result.put("dtoStatus", dtoStatus);
		} else if ("LTO".equals(pgbVO.getUpdateFlag())) {
			String ltoStatus = pgbDao.pgbLtoStautsAutoUpdate(pgbVO);
			String dtoStatus = pgbDao.pgbDtoStautsAutoUpdate(pgbVO);
			result.put("ltoStatus", ltoStatus);
			result.put("dtoStatus", dtoStatus);
		} else if ("DTO".equals(pgbVO.getUpdateFlag())) {
			String dtoStatus = pgbDao.pgbDtoStautsAutoUpdate(pgbVO);
			result.put("dtoStatus", dtoStatus);
		} else {
			
		}
		return result;
	}
	

}
