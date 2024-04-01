package com.tad.crc.service;

import java.util.List;

import com.tad.crc.vo.crcVO;

public interface crcService {

	//영역
	public List<crcVO> crcDomainListSelect(crcVO crcVO) throws Exception;
	
	public crcVO crcDomainOneSelect(crcVO crcVO) throws Exception;
	
	public int crcDomainInsert(crcVO crcVO) throws Exception;
	
	public int crcDomainUpdate(crcVO crcVO) throws Exception;
	
	public int crcDomainUseYnUpdate(crcVO crcVO) throws Exception;
	
	public int crcDomainDelete(crcVO crcVO) throws Exception;
	
	//장기목표
	public List<crcVO> crcLTOListSelect(crcVO crcVO) throws Exception;
	
	public crcVO crcLTOOneSelect(crcVO crcVO) throws Exception;
	
	public int crcLTOInsert(crcVO crcVO) throws Exception;
	
	public int crcLTOUpdate(crcVO crcVO) throws Exception;
	
	public int crcLTODelete(crcVO crcVO) throws Exception;
	
	//단기목표
	public List<crcVO> crcSTOListSelect(crcVO crcVO) throws Exception;
	
	public crcVO crcSTOOneSelect(crcVO crcVO) throws Exception;
	
	public int crcSTOInsert(crcVO crcVO) throws Exception;
	
	public int crcSTOUpdate(crcVO crcVO) throws Exception;
	
	public int crcSTODelete(crcVO crcVO) throws Exception;
	
	public List<crcVO> crcGroupListSelect(crcVO crcVO) throws Exception;
	
	public int crcGroupInsert(crcVO crcVO) throws Exception;
	
	public int crcGroupUpdate(crcVO crcVO) throws Exception;
	
	public int crcGroupItemUpdate(crcVO crcVO) throws Exception;
	
	public int crcGroupUseYnUpdate(crcVO crcVO) throws Exception;
	
	public int crcGroupDelete(crcVO crcVO) throws Exception;
	
}
