package com.tad.common.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tad.common.dao.cmmDao;
import com.tad.common.service.cmmService;
import com.tad.common.vo.cmmVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class cmmServiceImpl implements cmmService {

	@Inject
	cmmDao cmmDao;
	
	@Override
	public List<cmmVO> selectComboTeacher() throws Exception {
		return cmmDao.selectComboTeacher();
	}

	@Override
	public List<cmmVO> selectComboParent() throws Exception {
		return cmmDao.selectComboParent();
	}

}
