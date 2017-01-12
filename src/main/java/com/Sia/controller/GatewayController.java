package com.Sia.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
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

import com.Sia.model.Gateway;
import com.Sia.model.GatewayExample;
import com.Sia.model.State;
import com.Sia.pojo.DockedItems;
import com.Sia.pojo.GridDataResult;
import com.Sia.pojo.SearchItems;
import com.Sia.service.GatewayService;
import com.Sia.service.StateService;
import com.alibaba.fastjson.JSON;
import com.annotation.AuthPassport;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月20日
 * @description 网关操作有关的Controller
 */
@Controller
@RequestMapping("/gateWay")
public class GatewayController extends BaseController {
	static final Logger logger = LogManager.getLogger(GatewayController.class);// 日志
	@Autowired
	private GatewayService gatewayService;
	@Autowired
	private StateService stateService;

	/**
	 * 新增网关
	 * 
	 * @param request
	 * @param nodeId，节点编号
	 * @param name，网关名称
	 * @param ip，网关ip
	 * @param port，网关对应的端口号
	 * @return
	 */
	@AuthPassport
	@ResponseBody
	@RequestMapping(value = "/add", produces = "text/html;charset=UTF-8")
	public String add(HttpServletRequest request, @RequestParam String nodeId, @RequestParam String name, @RequestParam String ip, @RequestParam String port) {
		String message = "";
		name = decoderURL(name);
		int NodeID = Integer.parseInt(nodeId);
		int Port = Integer.parseInt(port);
		State gateWayState = stateService.selectByPrimaryKey(NodeID);
		if (gateWayState == null) {
			gateWayState = new State(new Date(), NodeID);
			logger.info("开始向数据库中新增了一条状态记录");
			if (stateService.insertSelective(gateWayState) > 0) {
				logger.info("成功新增一条状态记录");
				Gateway gateway = new Gateway(NodeID, name, ip, Port);
				logger.info("开始向数据库中新增了一条网关记录");
				if (gatewayService.insertSelective(gateway) > 0) {
					logger.info("成功新增一条网关记录");
					message = "网关" + ip + "新增成功";
				} else {
					logger.info("新增网关记录失败");
					return createSimpleFailureJson("操作失败");
				}
			} else {
				logger.info("新增状态记录失败");
				return createSimpleFailureJson("操作失败");
			}
		} else {
			return createSimpleFailureJson("NodeID:" + NodeID + "已存在,新增网关失败!");
		}
		return createSimpleSuccessJson(message);
	}

	@AuthPassport
	@ResponseBody
	@RequestMapping(value = "/delete", produces = "text/html;charset=UTF-8")
	public String delete(HttpServletRequest request, @RequestParam String nodeId) {
		String message = "网关";
		String[] nodes = nodeId.split(",");
		for (String node : nodes) {
			int NodeID = Integer.parseInt(node);
			Gateway gateway = gatewayService.selectByPrimaryKey(NodeID);
			if (gateway != null) {
				logger.info("开始删除网关");
				if (gatewayService.deleteByPrimaryKey(NodeID) > 0) {
					logger.info("网关" + NodeID + "删除成功");
					if (stateService.deleteByPrimaryKey(NodeID) > 0) {
						logger.info("网关" + gateway.getIp() + "状态删除成功");
						message += gateway.getIp() + "、";
					} else {
						logger.info(gateway.getIp() + "状态删除失败");
						return createSimpleFailureJson("网关删除成功，但是网关的状态记录删除失败");
					}
				} else {
					logger.info("网关删除失败");
					return createSimpleFailureJson("操作失败");
				}
			} else {
				return createSimpleFailureJson("NodeID:" + NodeID + "不存在,删除操作失败!");
			}
		}
		message = message.substring(0, message.lastIndexOf("、")) + "删除成功";
		return createSimpleSuccessJson(message);
	}

	@AuthPassport
	@ResponseBody
	@RequestMapping(value = "/update", produces = "text/html;charset=UTF-8")
	public String update(HttpServletRequest request, @RequestParam String nodeId, @RequestParam String name, @RequestParam String ip, @RequestParam String port) {
		String message = "";
		name = decoderURL(name);
		int NodeID = Integer.parseInt(nodeId);
		int Port = Integer.parseInt(port);
		Gateway gateway = gatewayService.selectByPrimaryKey(NodeID);
		if (gateway != null) {
			if (gateway.getName().equals(name) && gateway.getIp().equals(ip) && gateway.getPort().equals(Port)) {
				logger.info("网关修改失败");
				return createSimpleFailureJson("请至少修改一个参数再提交");
			} else {
				gateway = new Gateway(NodeID, name, ip, Port);
				if (gatewayService.updateByPrimaryKeySelective(gateway) > 0) {
					logger.info("网关" + ip + "修改成功");
					message = "修改成功";
				} else {
					logger.info("网关修改失败");
					return createSimpleFailureJson("操作失败");
				}
			}
		} else {
			return createSimpleFailureJson("网关" + ip + "不存在,修改操作失败!");
		}
		return createSimpleSuccessJson(message);
	}

	@AuthPassport
	@ResponseBody
	@RequestMapping(value = "/list", produces = "text/html;charset=UTF-8")
	public String list(HttpServletRequest request, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "nodeId", required = false) String nodeId,
			@RequestParam(value = "ip", required = false) String ip, @RequestParam(value = "port", required = false) String port, @RequestParam(value = "isEnable", required = false) String isEnable,
			@RequestParam int start, @RequestParam int limit) {
		if (name == null) {
			name = "";
		}
		if (nodeId == null) {
			nodeId = "0";
		}
		if (ip == null) {
			ip = "";
		}
		int NodeID = Integer.parseInt(nodeId);
		GridDataResult<Gateway> gridDataResult = new GridDataResult<Gateway>();
		GatewayExample example = new GatewayExample(start, limit);
		GatewayExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause("at_time desc");
		if (!name.equals("")) {
			criteria.andNameLike("%" + name + "%");
		}
		if (NodeID != 0) {
			criteria.andNodeIdEqualTo(NodeID);
		}
		if (!ip.equals("")) {
			criteria.andIpLike("%" + ip + "%");
		}
		int total = gatewayService.countByExample(example);
		List<Gateway> list = gatewayService.selectByExample(example);
		gridDataResult.setTotal(total);
		gridDataResult.setRoot(list);
		return JSON.toJSONString(gridDataResult);
	}

	@AuthPassport
	@RequestMapping("/gateWayView")
	public String gateWayView(HttpServletRequest request, ModelMap modelMap) {
		logger.info("加载网关页面");
		/*
		 * DockedItems dockedItems = new DockedItems(); String items =
		 * dockedItems.getDockedItems(request, "修改", "tick", "onUpdateClick");
		 * items += dockedItems.getDockedItems(request, "添加", "time_add",
		 * "onAddClick"); items += dockedItems.getDockedItems(request, "删除",
		 * "time_delete", "onDeleteClick"); items +=
		 * dockedItems.getDockedItems(request, "刷新", "arrow_refresh",
		 * "onReloadClick"); items = items.substring(0, items.lastIndexOf(","));
		 * modelMap.addAttribute("dockedItems", items);
		 */
		SearchItems searchItems = new SearchItems();
		String search = searchItems.getSearchItems("gateWayIp-Name", "网关名称", "质检大楼");
		search += searchItems.getSearchItems("gateWayPort-Id", "节点ID", "52000");
		search += searchItems.getSearchItems("gateWayPort-Ip", "IP地址", "127.0.0.1");
		search += searchItems.getSearchItems("gateWayPort-Port", "端口号", "6000");
		search += searchItems.getSearchItems("gateWayPort-IsEnable", "状态", "启用/未启用");
		search = search.substring(0, search.lastIndexOf(","));
		modelMap.addAttribute("searchItems", search);
		return "/part/gateWayView";
	}
}
