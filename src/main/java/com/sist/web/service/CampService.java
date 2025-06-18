package com.sist.web.service;
import java.util.*;
import com.sist.web.vo.*;
public interface CampService {
	public Map campListData(String page);
	public CampVO campDetailData(int cno);
}
