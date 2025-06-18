package com.sist.web.dao;

import org.apache.ibatis.annotations.Mapper;
import java.util.*;
import com.sist.web.vo.*;
@Mapper
public interface CampMapper {
	public List<CampVO> campListData(Map map);
	public int campTotalPage();
	public CampVO campDetailData(int cno);
}
