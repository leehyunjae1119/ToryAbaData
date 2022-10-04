package com.tad.common.service;

import java.util.List;
import java.util.Map;

import com.tad.common.vo.cmmVO;

public interface cmmService {
	
	public List<cmmVO> selectComboTeacher() throws Exception;
	
	public List<cmmVO> selectComboParent() throws Exception;

}
