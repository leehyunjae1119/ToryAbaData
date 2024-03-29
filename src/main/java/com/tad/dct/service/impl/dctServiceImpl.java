package com.tad.dct.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tad.dct.service.dctService;
import com.tad.dct.vo.dctChartVO;
import com.tad.dct.vo.dctConsultingVO;
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
	public List<dctVO> dctAuthCenterListSelect(dctVO dctVO) throws Exception {
		
		return dctDao.dctAuthCenterListSelect(dctVO);
	}

	@Override
	public int dctCenterInsert(dctVO dctVO) throws Exception {

		return dctDao.dctCenterInsert(dctVO);
	}

	@Override
	public int dctCenterUpdate(dctVO dctVO) throws Exception {
		return dctDao.dctCenterUpdate(dctVO);
	}

	@Override
	public int dctCenterDelete(dctVO dctVO) throws Exception {
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
		return dctDao.dctStudentUpdate(dctVO);
	}
	
	@Override
	public int dctStudentDelete(dctVO dctVO) throws Exception {
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

	@Override
	public List<dctVO> dctCompletionListSelect(dctVO dctVO) throws Exception {
		int startNum = 0;
		
		startNum = (dctVO.getPageNum() - 1) * 10;
		dctVO.setStartNum(startNum);
		
		return dctDao.dctCompletionListSelect(dctVO);
	}
	@Override
	public dctVO dctCompletionListSelectCnt(dctVO dctVO) throws Exception {
		return dctDao.dctCompletionListSelectCnt(dctVO);
	}

	@Override
	public List<dctChartVO> dctRunUnitListSelect(dctChartVO dctChartVO) throws Exception {
		return dctDao.dctRunUnitListSelect(dctChartVO);
	}
	
	@Override
	public List<dctChartVO> dctCriteriaListSelect(dctChartVO dctChartVO) throws Exception {
		return dctDao.dctCriteriaListSelect(dctChartVO);
	}
	
	@Override
	public List<dctChartVO> dctDomainSelect(dctVO dctVO) throws Exception {
		return dctDao.dctDomainSelect(dctVO);
	}

	@Override
	public int dctDatePickerUpdate(dctChartVO dctChartVO) throws Exception {
		
		int deleteResult = dctDao.dctDatePickerDelete(dctChartVO);
		
		String[] strArr = dctChartVO.getPickerDt().split("\\|\\|");
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(strArr));
        
        int result = 0;
        for(String pickerDt : list) {
        	dctChartVO.setPickerDt(pickerDt);
        	int insertResult = dctDao.dctDatePickerInsert(dctChartVO);
        	result += insertResult;
        }
		return result;
	}

	@Override
	public List<dctChartVO> dctDatePickerSelect(dctChartVO dctChartVO) throws Exception {
		return dctDao.dctDatePickerSelect(dctChartVO);
	}

	@Override
	public List<List<dctChartVO>> dctDomainChartDataSelect(dctChartVO dctChartVO) throws Exception {

		List<List<dctChartVO>> resultList = new ArrayList<List<dctChartVO>>();
		try {
			List<dctChartVO> datePicker = dctDao.dctDatePickerSelect(dctChartVO);
			
			for(dctChartVO vo : datePicker) {
				dctChartVO paramVO = new dctChartVO();
				paramVO.setStudentSeq(vo.getPickerTarget());
				paramVO.setPickerDt(vo.getPickerDt());
				
				List<dctChartVO> result = dctDao.dctDomainChartDataSelect(paramVO);
				
				resultList.add(result);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultList;
	}

	@Override
	public List<dctVO> dctReportCrcListSelect(dctVO dctVO) throws Exception {
		
		List<dctVO> dtoList = dctDao.dctDomainListSelect(dctVO);
		List<dctVO> ltoList = dctDao.dctLtoListSelect(dctVO);
		List<dctVO> stoList = dctDao.dctStoListSelect(dctVO);
		
		for(dctVO domainVO : dtoList) {
			List<dctVO> lList = new ArrayList<dctVO>();
			
			for(dctVO ltoVO : ltoList) {
				List<dctVO> sList = new ArrayList<dctVO>();
				for(dctVO stoVO : stoList) {
					if(ltoVO.getLtoSeq() == stoVO.getLtoSeq()) {
						sList.add(stoVO);
					}
				}
				ltoVO.setStoList(sList);
				
				if(domainVO.getDomainSeq() == ltoVO.getDomainSeq()) {
					lList.add(ltoVO);
				}
			}
			domainVO.setLtoList(lList);
		}
		return dtoList;
	}

	@Override
	public List<dctVO> dctDomainListSelect(dctVO dctVO) throws Exception {
		return dctDao.dctDomainListSelect(dctVO);
	}

	@Override
	public dctVO dctMainCardData() throws Exception {
		return dctDao.dctMainCardData();
	}

	@Override
	public List<dctConsultingVO> dctConsultingListSelect(dctConsultingVO dctConsultingVO) throws Exception {
		return dctDao.dctConsultingListSelect(dctConsultingVO);
	}

	@Override
	public dctConsultingVO dctConsultingOneSelect(dctConsultingVO dctConsultingVO) throws Exception {
		return dctDao.dctConsultingOneSelect(dctConsultingVO);
	}

	@Override
	public int dctConsultingInsert(dctConsultingVO dctConsultingVO) throws Exception {
		return dctDao.dctConsultingInsert(dctConsultingVO);
	}

	@Override
	public int dctConsultingUpdate(dctConsultingVO dctConsultingVO) throws Exception {
		return dctDao.dctConsultingUpdate(dctConsultingVO);
	}

	@Override
	public int dctConsultingDelete(dctConsultingVO dctConsultingVO) throws Exception {
		return dctDao.dctConsultingDelete(dctConsultingVO);
	}

	@Override
	public List<dctConsultingVO> dctConsultingDataDtlist(dctConsultingVO dctConsultingVO) throws Exception {
		return dctDao.dctConsultingDataDtlist(dctConsultingVO);
	}

	@Override
	public List<dctVO> dctVideoListSelect(dctVO dctVO) throws Exception {
		return dctDao.dctVideoListSelect(dctVO);
	}

	@Override
	public int dctVideoInsert(dctVO dctVO) throws Exception {
		return dctDao.dctVideoInsert(dctVO);
	}

	@Override
	public int dctVideoUpdate(dctVO dctVO) throws Exception {
		return dctDao.dctVideoUpdate(dctVO);
	}

	@Override
	public int dctVideoDelete(dctVO dctVO) throws Exception {
		return dctDao.dctVideoDelete(dctVO);
	}

	@Override
	public dctVO dctVideoOneSelect(dctVO dctVO) throws Exception {
		return dctDao.dctVideoOneSelect(dctVO);
	}

}
