package com.tad.dct.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tad.dct.service.dctService;
import com.tad.dct.vo.dctVO;
import com.tad.crc.dao.crcDao;
import com.tad.crc.vo.crcVO;
import com.tad.dct.dao.dctDao;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class dctServiceImpl implements dctService {

	@Inject
	dctDao dctDao;
	
	@Inject
	crcDao crcDao;

	@Override
	public List<dctVO> dctCenterListSelect(dctVO dctVO) throws Exception {
		
		return dctDao.dctCenterListSelect(dctVO);
	}

	@Override
	public int dctCenterInsert(dctVO dctVO) throws Exception {

		return dctDao.dctCenterInsert(dctVO);
	}

	@Override
	public int dctCenterUpdate(dctVO dctVO) throws Exception {
		// TODO Auto-generated method stub
		return dctDao.dctCenterUpdate(dctVO);
	}

	@Override
	public int dctCenterDelete(dctVO dctVO) throws Exception {
		// TODO Auto-generated method stub
		return dctDao.dctCenterDelete(dctVO);
	}

	@Override
	public List<dctVO> dctClassListSelect(dctVO dctVO) throws Exception {
		
		return dctDao.dctClassListSelect(dctVO);
	}

	@Override
	public int dctClassInsert(dctVO dctVO) throws Exception {

		return dctDao.dctClassInsert(dctVO);
	}

	@Override
	public int dctClassUpdate(dctVO dctVO) throws Exception {
		// TODO Auto-generated method stub
		return dctDao.dctClassUpdate(dctVO);
	}

	@Override
	public int dctClassDelete(dctVO dctVO) throws Exception {
		// TODO Auto-generated method stub
		return dctDao.dctClassDelete(dctVO);
	}
	
	@Override
	public List<dctVO> dctStudentListSelect(dctVO dctVO) throws Exception {
		
		return dctDao.dctStudentListSelect(dctVO);
	}
	
	@Override
	public dctVO dctStudentOneSelect(dctVO dctVO) throws Exception {
		
		return dctDao.dctStudentOneSelect(dctVO);
	}
	
	@Override
	public int dctStudentInsert(dctVO dctVO) throws Exception {
		int result = dctDao.dctStudentInsert(dctVO);
		//커리큘럼 자동 삽입
		crcVO crcVO = new crcVO();
		crcVO.setStudentSeq(result);
		int crcResult = crcDao.crcAutoInsert(crcVO);
		return crcResult;
	}
	
	@Override
	public int dctStudentUpdate(dctVO dctVO) throws Exception {
		// TODO Auto-generated method stub
		return dctDao.dctStudentUpdate(dctVO);
	}
	
	@Override
	public int dctStudentDelete(dctVO dctVO) throws Exception {
		// TODO Auto-generated method stub
		return dctDao.dctStudentDelete(dctVO);
	}
	
	@Override
	public List<List<dctVO>> dctCurriculumListSelect(dctVO dctVO) throws Exception {
		List<dctVO> selectList = dctDao.dctCurriculumListSelect(dctVO);
		List<dctVO> domainList = dctDao.dctDomainSeqListSelect(dctVO);
		
		List<List<dctVO>> resultList = new ArrayList<List<dctVO>>();
		
		for(dctVO a : domainList) {
			List<dctVO> tmpList = new ArrayList<dctVO>();
			for(dctVO vo : selectList) {
				if(a.getDomainSeq() == vo.getDomainSeq()) {
					tmpList.add(vo);
				}
			}
			resultList.add(tmpList);
		}
		return resultList;
	}

}
