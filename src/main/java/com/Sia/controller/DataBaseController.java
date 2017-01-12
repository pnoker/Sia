package com.Sia.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Sia.model.DataBase;
import com.Sia.model.DataBaseExample;
import com.Sia.pojo.DockedItems;
import com.Sia.pojo.GridDataResult;
import com.Sia.pojo.SearchItems;
import com.Sia.service.DataBaseService;
import com.alibaba.fastjson.JSON;
import com.annotation.AuthPassport;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月15日
 * @description
 */
@Controller
@RequestMapping("/dataBase")
public class DataBaseController extends BaseController {
	static final Logger logger = LogManager.getLogger(DataBaseController.class);// 日志
	@Autowired
	private DataBaseService dataBaseService;

	@AuthPassport
	@RequestMapping("/dataBaseView")
	public String dataBaseView(HttpServletRequest request, ModelMap modelMap) {
		logger.info("加载首页");
		DockedItems dockedItems = new DockedItems();
		String items = dockedItems.getDockedItems(request, "标记", "tick", "onConfirmClick");
		items += dockedItems.getDockedItems(request, "添加", "time_add", "onConfirmClick");
		items += dockedItems.getDockedItems(request, "删除", "time_delete", "onConfirmClick");
		items += dockedItems.getDockedItems(request, "刷新", "arrow_refresh", "onConfirmClick");
		items = items.substring(0, items.lastIndexOf(","));
		modelMap.addAttribute("dockedItems", items);
		SearchItems searchItems = new SearchItems();
		String search = searchItems.getSearchItems("dataBase-id", "数据库名称 ", "MySql-Sia");
		search += searchItems.getSearchItems("dataBaseType-id", "数据库类型", "MySql");
		search = search.substring(0, search.lastIndexOf(","));
		modelMap.addAttribute("searchItems", search);
		return "/part/dataBaseView";
	}

	@AuthPassport
	@ResponseBody
	@RequestMapping(value = "/jsonData", produces = "text/html;charset=UTF-8")
	public String jsonData(HttpServletRequest request, @RequestParam int start, @RequestParam int limit) {
		logger.info("读取数据库列表信息");
		GridDataResult<DataBase> gridDataResult = new GridDataResult<DataBase>();
		DataBaseExample example = new DataBaseExample(start, limit);
		DataBaseExample.Criteria criteria = example.createCriteria();
		List<DataBase> list = dataBaseService.selectByExample(example);
		int total = dataBaseService.countByExample(example);
		gridDataResult.setRoot(list);
		gridDataResult.setTotal(total);
		return JSON.toJSONString(gridDataResult);
	}
}
