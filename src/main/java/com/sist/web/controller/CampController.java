package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

import com.sist.web.service.*;
import com.sist.web.vo.*;
@Controller
public class CampController {
	@Autowired
	private CampService service;
	@GetMapping("/camp/list")
	public String camp_list(@RequestParam(name = "page",required = false) String page,Model model) {
		Map map=service.campListData(page);
		
		model.addAttribute("list",map.get("list"));
		model.addAttribute("curpage",map.get("curpage"));
		model.addAttribute("totalpage",map.get("totalpage"));
		model.addAttribute("startPage",map.get("startPage"));
		model.addAttribute("endPage",map.get("endPage"));
		
		model.addAttribute("main_html","camp/list");
		return "main";
	}
	@GetMapping("/camp/detail")
	public String camp_detail(@RequestParam("cno") int cno,Model model) {
		CampVO vo=service.campDetailData(cno);
		model.addAttribute("vo",vo);
		model.addAttribute("main_html","camp/detail");
		return "main";
	}
}
