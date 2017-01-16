package com.Sia.controller;

import java.util.ArrayList;
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

import com.Sia.model.Adapter;
import com.Sia.model.AdapterExample;
import com.Sia.model.ConfigProtocol;
import com.Sia.model.ConfigProtocolExample;
import com.Sia.model.DataReal;
import com.Sia.model.DataRealExample;
import com.Sia.model.Gateway;
import com.Sia.model.GatewayExample;
import com.Sia.model.OrderDisp;
import com.Sia.pojo.ConfigTree;
import com.Sia.pojo.DockedItems;
import com.Sia.pojo.GridDataResult;
import com.Sia.pojo.SearchItems;
import com.Sia.service.AdapterService;
import com.Sia.service.ConfigProtocolService;
import com.Sia.service.DataRealService;
import com.Sia.service.GatewayService;
import com.Sia.service.OrderDisService;
import com.alibaba.fastjson.JSON;
import com.annotation.AuthPassport;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月22日
 * @description
 */
@Controller
@RequestMapping("/opcItems")
public class OPCController extends BaseController {
	static final Logger logger = LogManager.getLogger(OPCController.class);// 日志
	@Autowired
	private GatewayService gatewayService;
	@Autowired
	private AdapterService adapterService;
	@Autowired
	private DataRealService dataRealService;
	@Autowired
	private ConfigProtocolService configProtocolService;
	@Autowired
	private OrderDisService orderDisService;

	@AuthPassport
	@ResponseBody
	@RequestMapping(value = "/cnfg/add", produces = "text/html;charset=UTF-8")
	public String cnfgAdd(HttpServletRequest request, @RequestParam String dataRealId, @RequestParam String deviceId, @RequestParam String modAddress, @RequestParam String type,
			@RequestParam String rw, @RequestParam String fre) {
		String message = "";
		String name = "配置";
		int DataRealId = Integer.parseInt(dataRealId);
		int DeviceId = Integer.parseInt(deviceId);
		int ModAddress = Integer.parseInt(modAddress);
		int Type = Integer.parseInt(type);
		int Rw = Integer.parseInt(rw);
		int Fre = Integer.parseInt(fre);
		ConfigProtocol configProtocol = configProtocolService.selectByDataRealId(DataRealId);
		if (configProtocol == null) {
			configProtocol = new ConfigProtocol(name, DataRealId, DeviceId, ModAddress, Type, Rw, Fre);
			logger.info("开始向数据库中新增了一条配置记录");
			if (configProtocolService.insertSelective(configProtocol) > 0) {
				logger.info("成功新增一条适配置记录");
				message = "配置新增成功";
			} else {
				logger.info("新增配置记录失败");
				return createSimpleFailureJson("操作失败");
			}
		} else {
			return createSimpleFailureJson("NodeID:" + configProtocol.getId() + "已存在,新增适配器点位失败!");
		}
		return createSimpleSuccessJson(message);
	}

	/**
	 * @param request
	 * @param nodeId 这里的nodeId其实是deta_real_id
	 * @return
	 */
	@AuthPassport
	@ResponseBody
	@RequestMapping(value = "/cnfg/delete", produces = "text/html;charset=UTF-8")
	public String cnfgDelete(HttpServletRequest request, @RequestParam String nodeId) {
		String message = "适配器点位";
		String[] nodes = nodeId.split(",");
		for (String node : nodes) {
			int NodeID = Integer.parseInt(node);
			ConfigProtocol configProtocol = configProtocolService.selectByDataRealId(NodeID);
			if (configProtocol != null) {
				logger.info("开始删除适配器点位配置");
				if (configProtocolService.deleteByPrimaryKey(configProtocol.getId()) > 0) {
					logger.info("配置" + NodeID + "删除成功");
					message += configProtocol.getName() + "、";
				} else {
					logger.info("适配器点位配置删除失败");
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
	@RequestMapping(value = "/cnfg/update", produces = "text/html;charset=UTF-8")
	public String cnfgUpdate(HttpServletRequest request, @RequestParam String dataRealId, @RequestParam String deviceId, @RequestParam String modAddress, @RequestParam String type,
			@RequestParam String rw, @RequestParam String fre) {
		String message = "";
		String name = "配置";
		int DataRealId = Integer.parseInt(dataRealId);
		int DeviceId = Integer.parseInt(deviceId);
		int ModAddress = Integer.parseInt(modAddress);
		int Type = Integer.parseInt(type);
		int Rw = Integer.parseInt(rw);
		int Fre = Integer.parseInt(fre);
		ConfigProtocol configProtocol = configProtocolService.selectByDataRealId(DataRealId);
		if (configProtocol != null) {
			if (configProtocol.getDataRealId().equals(DataRealId) && configProtocol.getDeviceId().equals(DeviceId) && configProtocol.getModAddr().equals(ModAddress)
					&& configProtocol.getType().equals(Type) && configProtocol.getRw().equals(Rw) && configProtocol.getFre().equals(Fre)) {
				logger.info("适配器点位配置修改失败");
				return createSimpleFailureJson("请至少修改一个参数再提交");
			} else {
				configProtocol = new ConfigProtocol(configProtocol.getId(), name, DataRealId, DeviceId, ModAddress, Type, Rw, Fre);
				if (configProtocolService.updateByPrimaryKeySelective(configProtocol) > 0) {
					logger.info("适配器点位" + name + "修改成功");
					message = "修改成功";
				} else {
					logger.info("适配器点位修改失败");
					return createSimpleFailureJson("操作失败");
				}
			}
		} else {
			return createSimpleFailureJson("适配器的该点位" + name + "不存在,修改操作失败!");
		}
		return createSimpleSuccessJson(message);
	}

	@AuthPassport
	@ResponseBody
	@RequestMapping(value = "/cnfg/list", produces = "text/html;charset=UTF-8")
	public String cnfgList(HttpServletRequest request, @RequestParam(value = "nodeId", required = false) String nodeId, @RequestParam int start, @RequestParam int limit) {
		if (nodeId == null) {
			nodeId = "0";
		}
		int NodeID = Integer.parseInt(nodeId);
		GridDataResult<ConfigProtocol> gridDataResult = new GridDataResult<ConfigProtocol>();
		ConfigProtocolExample example = new ConfigProtocolExample(start, limit);
		ConfigProtocolExample.Criteria criteria = example.createCriteria();
		if (NodeID != 0) {
			criteria.andDataRealIdEqualTo(NodeID);
		}
		List<ConfigProtocol> list = configProtocolService.selectByExample(example);
		gridDataResult.setRoot(list);
		return JSON.toJSONString(gridDataResult);
	}

	@AuthPassport
	@ResponseBody
	@RequestMapping(value = "/list", produces = "text/html;charset=UTF-8")
	public String list(HttpServletRequest request, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "nodeId", required = false) String nodeId,
			@RequestParam int start, @RequestParam int limit) {
		if (name == null) {
			name = "";
		}
		if (nodeId == null) {
			nodeId = "0";
		}
		int NodeID = Integer.parseInt(nodeId);
		GridDataResult<DataReal> gridDataResult = new GridDataResult<DataReal>();
		DataRealExample example = new DataRealExample(start, limit);
		DataRealExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause("node_id desc");
		if (!name.equals("")) {
			criteria.andNameLike("%" + name + "%");
		}
		if (NodeID != 0) {
			criteria.andNodeIdEqualTo(NodeID);
		}
		int total = dataRealService.countByExample(example);
		List<DataReal> list = dataRealService.selectByExample(example);
		gridDataResult.setTotal(total);
		gridDataResult.setRoot(list);
		return JSON.toJSONString(gridDataResult);
	}

	@AuthPassport
	@ResponseBody
	@RequestMapping(value = "/cnfg/restart", produces = "text/html;charset=UTF-8")
	public String cnfgReStart(HttpServletRequest request, @RequestParam String id) {
		String message = "";
		int Id = Integer.parseInt(id);
		OrderDisp orderDisp = new OrderDisp();
		orderDisp.setId(Id);
		orderDisp.setFlag((byte) 1);
		orderDisp.setAtTime(new Date());
		if (orderDisService.updateByPrimaryKeySelective(orderDisp) > 0) {
			message = "请稍等，OPC UA Server 启动中……";
		} else {
			return createSimpleFailureJson("启动失败……");
		}
		return createSimpleSuccessJson(message);
	}

	@AuthPassport
	@ResponseBody
	@RequestMapping(value = "/tree", produces = "text/html;charset=UTF-8")
	public String tree(HttpServletRequest request) {
		logger.info("初始化根节点OPC UA");
		ConfigTree tree = new ConfigTree("opc_server", "OPC UA", true, false);// 初始化根节点
		logger.info("初始化节点网关");
		ArrayList<ConfigTree> childrenGate = new ArrayList<ConfigTree>();// 网关
		GatewayExample exampleGate = new GatewayExample();
		GatewayExample.Criteria criteriaGate = exampleGate.createCriteria();
		List<Gateway> gateways = gatewayService.selectByExample(exampleGate);
		for (Gateway listGate : gateways) {
			logger.info("初始化节点适配器");
			ArrayList<ConfigTree> childrenAdapter = new ArrayList<ConfigTree>();// 适配器
			AdapterExample exampleAdapter = new AdapterExample();
			AdapterExample.Criteria criteriaAdapter = exampleAdapter.createCriteria();
			criteriaAdapter.andGatewayIdEqualTo(listGate.getNodeId());
			List<Adapter> adapters = adapterService.selectByExample(exampleAdapter);
			for (Adapter listAdapter : adapters) {
				logger.info("初始化节点变量");
				ArrayList<ConfigTree> childrenData = new ArrayList<ConfigTree>();// 变量
				DataRealExample exampleData = new DataRealExample();
				DataRealExample.Criteria criteriaData = exampleData.createCriteria();
				criteriaData.andAdapterIdEqualTo(listAdapter.getNodeId());
				List<DataReal> dataReals = dataRealService.selectByExample(exampleData);
				for (DataReal listData : dataReals) {
					logger.info("初始化节点变量配置属性");
					ArrayList<ConfigTree> childrenCofig = new ArrayList<ConfigTree>();// 变量
					ConfigProtocolExample exampleConfig = new ConfigProtocolExample();
					ConfigProtocolExample.Criteria criteriaConfig = exampleConfig.createCriteria();
					criteriaConfig.andDataRealIdEqualTo(listData.getNodeId());
					List<ConfigProtocol> configs = configProtocolService.selectByExample(exampleConfig);
					for (ConfigProtocol listConfig : configs) {
						childrenCofig.add(new ConfigTree("config", listConfig.getName(), true, true, listConfig.getDataRealId().toString(), listData.getAdapterId().toString()));
					}
					childrenData.add(new ConfigTree("data", listData.getName(), true, false, listData.getNodeId().toString(), listData.getAdapterId().toString(), childrenCofig));
				}
				childrenAdapter.add(new ConfigTree("adapter", listAdapter.getName(), true, false, listAdapter.getNodeId().toString(), listAdapter.getGatewayId().toString(), childrenData));
			}
			childrenGate.add(new ConfigTree("gateway", listGate.getName(), true, false, listGate.getNodeId().toString(), childrenAdapter));
		}
		tree.setChildren(childrenGate);
		return JSON.toJSONString(tree);
	}

	@AuthPassport
	@RequestMapping("/opcItemsView")
	public String opcItemsView(HttpServletRequest request, ModelMap modelMap) {
		logger.info("加载OPC页面");
		/*
		 * DockedItems dockedItems = new DockedItems(); String items =
		 * dockedItems.getDockedItems(request, "生成OPC UA配置XML文件", "tick",
		 * "onOpcUaClick"); modelMap.addAttribute("dockedItems", items);
		 */
		SearchItems searchItems = new SearchItems();
		String search = searchItems.getSearchItems("dataRealNodeId-Name", "点位名称", "累计值");
		search += searchItems.getSearchItems("dataRealName-NodeId", "节点ID", "52000");
		search += searchItems.getSearchItems("dataRealName-ParentId", "父节点ID", "52010");
		search += searchItems.getSearchItems("dataRealName-Type", "值类型", "String");
		search += searchItems.getSearchItems("dataRealName-WriteAble", "读写性", "读写");
		search = search.substring(0, search.lastIndexOf(","));
		modelMap.addAttribute("searchItems", search);
		return "/part/opcItemsView";
	}

	@AuthPassport
	@RequestMapping("/opcItemsCnfg")
	public String opcItemsCnfg(HttpServletRequest request, ModelMap modelMap) {
		logger.info("加载OPC配置页面");
		DockedItems dockedItems = new DockedItems();
		String items = dockedItems.getDockedItems(request, "新增网关\\\\适配器\\\\变量", "add", "onAddClick");
		items += dockedItems.getDockedItems(request, "刷新", "refresh", "onReloadClick");
		items = items.substring(0, items.lastIndexOf(","));
		modelMap.addAttribute("dockedItems", items);
		SearchItems searchItems = new SearchItems();
		String search = searchItems.getSearchItems("dataRealNodeId-id", "点位节点", "55555");
		search += searchItems.getSearchItems("dataRealName-id", "点位名称", "温度");
		search = search.substring(0, search.lastIndexOf(","));
		modelMap.addAttribute("searchItems", search);
		return "/part/opcItemsCnfg";
	}
}
