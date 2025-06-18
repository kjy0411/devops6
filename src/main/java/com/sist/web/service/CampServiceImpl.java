package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.vo.*;
import com.sist.web.dao.*;
@Service
public class CampServiceImpl implements CampService{
	@Autowired
	private CampMapper cDao;

	@Override
	public Map campListData(String page) {
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		Map map=new HashMap();
		int rowSize=12;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		map.put("start", start);
		map.put("end", end);
		
		List<CampVO> list=cDao.campListData(map);
		int totalpage=cDao.campTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		map=new HashMap();
		
		map.put("list", list);
		map.put("curpage", curpage);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		return map;
	}

	@Override
	public CampVO campDetailData(int cno) {
		return cDao.campDetailData(cno);
	}
	

}
