package com.tad.mbr.dao;

import java.util.List;

import com.tad.mbr.vo.mbrVO;

public interface mbrDao {

	String namespace = "com.tad.mbr.dao.mbrDao.";
	
	public List<mbrVO> mbrMemberListSelect(mbrVO mbrVO) throws Exception;
	
	public int mbrApprovalYnUpdate(mbrVO mbrVO) throws Exception;
	
	public int mbrMemberAuthCdUpdate(mbrVO mbrVO) throws Exception;
}
