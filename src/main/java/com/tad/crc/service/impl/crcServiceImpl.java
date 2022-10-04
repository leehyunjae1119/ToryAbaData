package com.tad.crc.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tad.crc.dao.crcDao;
import com.tad.crc.service.crcService;
import com.tad.crc.vo.crcVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class crcServiceImpl implements crcService {

	@Inject
	crcDao  crcDao;

	@Override
	public List<crcVO> crcDomainListSelect(crcVO crcVO) throws Exception {
		
		return crcDao.crcDomainListSelect(crcVO);
	}
	
	@Override
	public crcVO crcDomainOneSelect(crcVO crcVO) throws Exception {

		return crcDao.crcDomainOneSelect(crcVO);
	}

	@Override
	public int crcDomainInsert(crcVO crcVO) throws Exception {

		return crcDao.crcDomainInsert(crcVO);
	}

	@Override
	public int crcDomainUpdate(crcVO crcVO) throws Exception {

		return crcDao.crcDomainUpdate(crcVO);
	}

	@Override
	public int crcDomainUseYnUpdate(crcVO crcVO) throws Exception {

		return crcDao.crcDomainUseYnUpdate(crcVO);
	}

	@Override
	public int crcDomainDelete(crcVO crcVO) throws Exception {

		return crcDao.crcDomainDelete(crcVO);
	}
	
	@Override
	public List<crcVO> crcLTOListSelect(crcVO crcVO) throws Exception {
		
		return crcDao.crcLTOListSelect(crcVO);
	}
	
	@Override
	public crcVO crcLTOOneSelect(crcVO crcVO) throws Exception {
		
		return crcDao.crcLTOOneSelect(crcVO);
	}
	
	@Override
	public int crcLTOInsert(crcVO crcVO) throws Exception {
		
		return crcDao.crcLTOInsert(crcVO);
	}
	
	@Override
	public int crcLTOUpdate(crcVO crcVO) throws Exception {
		
		return crcDao.crcLTOUpdate(crcVO);
	}
	
	@Override
	public int crcLTODelete(crcVO crcVO) throws Exception {
		
		return crcDao.crcLTODelete(crcVO);
	}
	
	@Override
	public List<crcVO> crcSTOListSelect(crcVO crcVO) throws Exception {
		
		return crcDao.crcSTOListSelect(crcVO);
	}
	
	@Override
	public crcVO crcSTOOneSelect(crcVO crcVO) throws Exception {
		
		return crcDao.crcSTOOneSelect(crcVO);
	}
	
	@Override
	public int crcSTOInsert(crcVO crcVO) throws Exception {
		
		return crcDao.crcSTOInsert(crcVO);
	}
	
	@Override
	public int crcSTOUpdate(crcVO crcVO) throws Exception {
		
		return crcDao.crcSTOUpdate(crcVO);
	}
	
	@Override
	public int crcSTODelete(crcVO crcVO) throws Exception {
		
		return crcDao.crcSTODelete(crcVO);
	}
}
