package com.tad.crc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tad.crc.dao.pgbDao;
import com.tad.crc.service.pgbService;
import com.tad.crc.vo.pgbVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class pgbSerivceImpl implements pgbService {
	
	@Inject
	pgbDao pgbDao;
	
	@Override
	public List<List<pgbVO>> pgbSelectBoxListSelect() throws Exception {
		
		List<List<pgbVO>> result = new ArrayList<List<pgbVO>>();
		
		List<pgbVO> centerList = pgbDao.pgbCenterListSelect();
		List<pgbVO> classList = pgbDao.pgbClassListSelect();
		List<pgbVO> domainList = pgbDao.pgbDomainListSelect();
		List<pgbVO> memberList = pgbDao.pgbMemberListSelect();
		
		result.add(centerList);
		result.add(classList);
		result.add(domainList);
		result.add(memberList);
		
		return result;
	}

	@Override
	public List<pgbVO> pgbStudentListSelect(pgbVO pgbVO) throws Exception {
		
		return pgbDao.pgbStudentListSelect(pgbVO);
	}
	
	@Override
	public pgbVO pgbLTOCntSelect(pgbVO pgbVO) throws Exception {
		
		return pgbDao.pgbLTOCntSelect(pgbVO);
	}
	
	@Override
	public List<pgbVO> pgbLTOCardListSelect(pgbVO pgbVO) throws Exception {
		
		return pgbDao.pgbLTOCardListSelect(pgbVO);
	}

	@Override
	public int pgbDomainInsert(pgbVO pgbVO) throws Exception {
		int result = 0;
		if(pgbVO.getDomainSeq() == 0) {
			List<pgbVO> seqList = pgbDao.pgbTmpDomainSeqSelect(pgbVO);
			
			for(pgbVO vo : seqList) {
				pgbVO paramVO = new pgbVO();
				
				paramVO.setStudentSeq(pgbVO.getStudentSeq());
				paramVO.setMemberSeq(pgbVO.getMemberSeq());
				paramVO.setDomainSeq(vo.getDomainSeq());
				paramVO.setOldDomainSeq(vo.getDomainSeq());
				
				pgbDao.pgbDomainInsert(paramVO);
				
				
				result = pgbDao.pgbLTOInsert(paramVO);
			}
		} else {
			pgbVO.setOldDomainSeq(pgbVO.getDomainSeq());
			int newDomainSeq = pgbDao.pgbDomainInsert(pgbVO);
			result = pgbDao.pgbLTOInsert(pgbVO);
		}
		return 0;
	}
	
	@Override
	public int pgbManagerUpdate(pgbVO pgbVO) throws Exception {
		
		return pgbDao.pgbManagerUpdate(pgbVO);
	}
	
	@Override
	public int pgbDomainDelete(pgbVO pgbVO) throws Exception {
		
		return pgbDao.pgbDomainDelete(pgbVO);
	}

}
