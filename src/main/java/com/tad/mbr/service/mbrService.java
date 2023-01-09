package com.tad.mbr.service;

import java.util.List;

import com.tad.mbr.vo.mbrVO;

public interface mbrService {

	public List<mbrVO> mbrMemberListSelect(mbrVO mbrVO) throws Exception;
	
	public mbrVO mbrMemberListSelectCnt(mbrVO mbrVO) throws Exception;
	
	public int mbrApprovalYnUpdate(mbrVO mbrVO) throws Exception;
	
	public int mbrMemberAuthCdUpdate(mbrVO mbrVO) throws Exception;
	
	public int mbrMemberPwReset(mbrVO mbrVO) throws Exception;
	
	public int mbrProfileUpdate(mbrVO mbrVO) throws Exception;
	
	public mbrVO mbrMemberOneSelect(mbrVO mbrVO) throws Exception;
	
	public List<mbrVO> teachListSelect(mbrVO mbrVO) throws Exception;
	
	public List<mbrVO> authTeachListSelect(mbrVO mbrVO) throws Exception;
	
	public int subAuthInsert(mbrVO mbrVO) throws Exception;
	
	public int subAuthDelete(mbrVO mbrVO) throws Exception;
}
