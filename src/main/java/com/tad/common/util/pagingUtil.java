package com.tad.common.util;

import com.tad.common.vo.pagingVO;

public class pagingUtil {
	
	private static final int MAX_CNT = 10;
	
	// 페이징 정보 세팅
	public static pagingVO pagination(int pageNum, int pageCnt) {
		
		int startPage = 0;
		int endPage = 0;
		int prevPage = 0;
		int nextPage = 0;
		
		startPage = (pageNum / MAX_CNT) * MAX_CNT + 1;
		
		endPage = ( ( (pageNum / MAX_CNT) + 1 ) *  MAX_CNT ) > pageCnt ? pageCnt : ( (pageNum / MAX_CNT) + 1 ) *  MAX_CNT;
		
		prevPage = (startPage - 1) < 0 ? 0 : startPage - 1;
		
		nextPage = (endPage + 1) > pageCnt ? 0 : endPage + 1;

		pagingVO pagingVO = new pagingVO();
		
		pagingVO.setPageNum(pageNum);
		pagingVO.setPageCnt(pageCnt);
		pagingVO.setStartPage(startPage);
		pagingVO.setEndPage(endPage);
		pagingVO.setPrevPage(prevPage);
		pagingVO.setNextPage(nextPage);
		
		return pagingVO;
	}
	

}
