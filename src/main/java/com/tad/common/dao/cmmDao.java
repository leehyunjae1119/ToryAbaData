package com.tad.common.dao;

import java.util.List;
import java.util.Map;

import com.tad.common.vo.cmmVO;

public interface cmmDao {
	
	String namespace = "com.tad.common.dao.cmmDao.";
	
	public List<cmmVO> selectComboTeacher() throws Exception;
	
	public List<cmmVO> selectComboParent() throws Exception;

}
