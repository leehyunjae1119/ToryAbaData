package com.tad.mai.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tad.mai.dao.maiDao;
import com.tad.mai.service.maiService;
import com.tad.mai.vo.maiVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class maiServiceImpl implements maiService {

	@Inject
	maiDao maiDao;

	@Override
	public List<maiVO> maiCalenderListSelect(maiVO maiVO) throws Exception {
		return maiDao.maiCalenderListSelect(maiVO);
	}

	@Override
	public int maiCalenderInsert(maiVO maiVO) throws Exception {
		return maiDao.maiCalenderInsert(maiVO);
	}

	@Override
	public int maiCalenderDelete(maiVO maiVO) throws Exception {
		return maiDao.maiCalenderDelete(maiVO);
	}

	@Override
	public List<maiVO> maiCalenderDataDtlist(maiVO maiVO) throws Exception {
		return maiDao.maiCalenderDataDtlist(maiVO);
	}


}
