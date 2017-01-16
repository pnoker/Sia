package com.Sia.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Sia.model.AdapterExample;
import com.Sia.model.ConfigProtocol;
import com.Sia.model.ConfigProtocolExample;
import com.Sia.model.DataReal;
import com.Sia.model.DataRealExample;
import com.Sia.model.Gateway;
import com.Sia.model.GatewayExample;
import com.Sia.pojo.Adapter;
import com.Sia.pojo.Config;
import com.Sia.pojo.GateWay;
import com.Sia.pojo.GridDataResult;
import com.Sia.pojo.Item;
import com.Sia.pojo.OpcUaNodes;
import com.Sia.pojo.Variable;
import com.Sia.service.AdapterService;
import com.Sia.service.ConfigProtocolService;
import com.Sia.service.DataRealService;
import com.Sia.service.GatewayService;
import com.Sia.util.tools.BasePath;
import com.Sia.util.tools.HttpClientUtil;
import com.alibaba.fastjson.JSON;
import com.annotation.AuthPassport;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月16日
 * @description
 */
@Controller
@RequestMapping("/rest")
public class RestController extends BaseController {
	static final Logger logger = LogManager.getLogger(RestController.class);// 日志
	@Autowired
	private GatewayService gatewayService;
	@Autowired
	private AdapterService adapterService;
	@Autowired
	private DataRealService dataRealService;
	@Autowired
	private ConfigProtocolService configProtocolService;

	@AuthPassport
	@RequestMapping("/jsonCnfg")
	public String jsonCnfg(HttpServletRequest request, ModelMap modelMap) {
		logger.info("加载json配置页面");
		return "/part/jsonCnfg";
	}

	@ResponseBody
	@RequestMapping(value = "/xmlData", produces = "text/xml;charset=UTF-8")
	public OpcUaNodes xmlData(HttpServletRequest request, ModelMap modelMap) {
		logger.info("返回XML数据");
		// GateWay
		List<GateWay> gateWay = new ArrayList<GateWay>();
		GridDataResult<Gateway> gridDataResult = new GridDataResult<Gateway>();
		GatewayExample exampleG = new GatewayExample();
		GatewayExample.Criteria criteriaG = exampleG.createCriteria();
		List<Gateway> gateways = gatewayService.selectByExample(exampleG);
		for (Gateway listG : gateways) {
			// Adapter
			List<Adapter> adapters = new ArrayList<Adapter>();
			AdapterExample exampleA = new AdapterExample();
			AdapterExample.Criteria criteriaA = exampleA.createCriteria();
			criteriaA.andGatewayIdEqualTo(listG.getNodeId());
			List<com.Sia.model.Adapter> adaptersA = adapterService.selectByExample(exampleA);
			for (com.Sia.model.Adapter listA : adaptersA) {
				// Variable
				List<Variable> variables = new ArrayList<Variable>();
				DataRealExample exampleD = new DataRealExample();
				DataRealExample.Criteria criteriaD = exampleD.createCriteria();
				criteriaD.andAdapterIdEqualTo(listA.getNodeId());
				List<DataReal> dataReals = dataRealService.selectByExample(exampleD);
				for (DataReal listD : dataReals) {
					// variables.add(new Variable(listD.getNodeId().toString(),
					// listD.getName(), listD.getValueType(),
					// listD.getWriteAble(), listD.getAdapterId().toString(),
					// listD.getValue()));
				}
				// adapters.add(new Adapter(listA.getNodeId().toString(),
				// listA.getName(), listA.getGatewayId().toString(),
				// variables));
			}
			gateWay.add(new GateWay(listG.getNodeId().toString(), listG.getName(), adapters));
		}
		// OpcUaNodes
		OpcUaNodes opcUaNodes = new OpcUaNodes(gateWay);
		return opcUaNodes;
	}

	/**
	 * @param request
	 * @param modelMap
	 * @return json
	 */
	@ResponseBody
	@RequestMapping(value = "/jsonData", produces = "text/json;charset=UTF-8")
	public String jsonData(HttpServletRequest request, ModelMap modelMap) {
		logger.info("返回json数据");
		// GateWay
		List<GateWay> gateWay = new ArrayList<GateWay>();
		GridDataResult<Gateway> gridDataResult = new GridDataResult<Gateway>();
		GatewayExample exampleG = new GatewayExample();
		GatewayExample.Criteria criteriaG = exampleG.createCriteria();
		List<Gateway> gateways = gatewayService.selectByExample(exampleG);
		for (Gateway listG : gateways) {
			// Adapter
			List<Adapter> adapters = new ArrayList<Adapter>();
			AdapterExample exampleA = new AdapterExample();
			AdapterExample.Criteria criteriaA = exampleA.createCriteria();
			criteriaA.andGatewayIdEqualTo(listG.getNodeId());
			List<com.Sia.model.Adapter> adaptersA = adapterService.selectByExample(exampleA);
			for (com.Sia.model.Adapter listA : adaptersA) {
				// Variable
				List<Variable> variables = new ArrayList<Variable>();
				DataRealExample exampleD = new DataRealExample();
				DataRealExample.Criteria criteriaD = exampleD.createCriteria();
				criteriaD.andAdapterIdEqualTo(listA.getNodeId());
				List<DataReal> dataReals = dataRealService.selectByExample(exampleD);
				for (DataReal listD : dataReals) {
					// variables.add(new Variable(listD.getNodeId().toString(),
					// listD.getName(), listD.getValueType(),
					// listD.getWriteAble(), listD.getAdapterId().toString(),
					// listD.getValue()));
				}
				// adapters.add(new Adapter(listA.getNodeId().toString(),
				// listA.getName(), listA.getGatewayId().toString(),
				// variables));
			}
			gateWay.add(new GateWay(listG.getNodeId().toString(), listG.getName(), adapters));
		}
		// OpcUaNodes
		OpcUaNodes opcUaNodes = new OpcUaNodes(gateWay);
		return JSON.toJSONString(opcUaNodes);
	}

	@ResponseBody
	@RequestMapping(value = "/data", produces = "text/json;charset=UTF-8")
	public String getData(HttpServletRequest request, @RequestParam(value = "gateway", required = false) String gateway, @RequestParam(value = "adapter", required = false) String adapter,
			@RequestParam(value = "variable", required = false) String variable) {
		if (gateway == null) {// 没有输入网关信息，返回的是全部网关
			GatewayExample exampleGate = new GatewayExample();
			GatewayExample.Criteria criteriaGate = exampleGate.createCriteria();
			List<Gateway> gateways = gatewayService.selectByExample(exampleGate);
			Map<String, Object> map = new HashMap<String, Object>();
			List<String> list = new ArrayList<String>();
			for (Gateway gateway_1 : gateways) {
				list.add(gateway_1.getNodeId().toString());
			}
			map.put("gateway", list);
			return JSON.toJSONString(map);
		} else {
			if (adapter == null) {// 输入了网关，但是没有输入适配器信息，返回的是该网关下全部的适配器
				int GateWay = Integer.parseInt(gateway);
				AdapterExample exampleAdapter = new AdapterExample();
				AdapterExample.Criteria criteriaAdapter = exampleAdapter.createCriteria();
				criteriaAdapter.andGatewayIdEqualTo(GateWay);
				List<com.Sia.model.Adapter> adapters = adapterService.selectByExample(exampleAdapter);
				Map<String, Object> map = new HashMap<String, Object>();
				List<String> list = new ArrayList<String>();
				for (com.Sia.model.Adapter adapter_1 : adapters) {
					list.add(adapter_1.getNodeId().toString());
				}
				map.put("adapter", list);
				return JSON.toJSONString(map);
			} else {
				if (variable == null) {// 输入了网关，输入了适配器，但是没有输入适配器底下的变量，返回该适配器下全部的变量
					int Adapter = Integer.parseInt(adapter);
					DataRealExample exampleData = new DataRealExample();
					DataRealExample.Criteria criteriaData = exampleData.createCriteria();
					criteriaData.andAdapterIdEqualTo(Adapter);
					List<DataReal> dataReals = dataRealService.selectByExample(exampleData);
					Map<String, Object> map = new HashMap<String, Object>();
					List<String> list = new ArrayList<String>();
					for (DataReal dataReal : dataReals) {
						list.add(dataReal.getNodeId().toString());
					}
					map.put("variable", list);
					return JSON.toJSONString(map);
				} else {
					int Variable = Integer.parseInt(variable);
					DataRealExample exampleData = new DataRealExample();
					DataRealExample.Criteria criteriaData = exampleData.createCriteria();
					criteriaData.andNodeIdEqualTo(Variable);
					List<DataReal> dataReals = dataRealService.selectByExample(exampleData);
					for (DataReal dataReal : dataReals) {
						dataReal.setProtocolId(null);
						dataReal.setAdapterId(null);
						dataReal.setTag(null);
					}
					return JSON.toJSONString(dataReals);
				}
			}
		}
	}

	@ResponseBody
	@RequestMapping(value = "/xml/opcua", produces = "text/xml;charset=UTF-8")
	public OpcUaNodes xmlOpcua(HttpServletRequest request, ModelMap modelMap, @RequestParam String text) {
		logger.info("返回点位配置的XML数据");
		String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
		Pattern pat = Pattern.compile(rexp);
		Matcher mat = pat.matcher(text.split(":")[0]);
		boolean isIp = mat.find();
		// GateWay
		List<GateWay> gateWay = new ArrayList<GateWay>();
		GridDataResult<Gateway> gridDataResult = new GridDataResult<Gateway>();
		GatewayExample exampleG = new GatewayExample();
		GatewayExample.Criteria criteriaG = exampleG.createCriteria();
		List<Gateway> gateways = gatewayService.selectByExample(exampleG);
		for (Gateway listG : gateways) {
			// Adapter
			List<Adapter> adapters = new ArrayList<Adapter>();
			AdapterExample exampleA = new AdapterExample();
			AdapterExample.Criteria criteriaA = exampleA.createCriteria();
			criteriaA.andGatewayIdEqualTo(listG.getNodeId());
			List<com.Sia.model.Adapter> adaptersA = adapterService.selectByExample(exampleA);
			for (com.Sia.model.Adapter listA : adaptersA) {
				// Variable
				List<Variable> variables = new ArrayList<Variable>();
				DataRealExample exampleD = new DataRealExample();
				DataRealExample.Criteria criteriaD = exampleD.createCriteria();
				criteriaD.andAdapterIdEqualTo(listA.getNodeId());
				List<DataReal> dataReals = dataRealService.selectByExample(exampleD);
				for (DataReal listD : dataReals) {
					ConfigProtocolExample exampleC = new ConfigProtocolExample();
					ConfigProtocolExample.Criteria criteriaC = exampleC.createCriteria();
					criteriaC.andDataRealIdEqualTo(listD.getNodeId());
					List<ConfigProtocol> configProtocols = configProtocolService.selectByExample(exampleC);
					Item item = null;
					for (ConfigProtocol list : configProtocols) {
						item = new Item(list.getDataRealId(), 1, list.getDeviceId(), list.getModAddr(), list.getType(), list.getRw(), list.getFre(), listD.getValue());
					}
					variables.add(new Variable(listD.getNodeId().toString(), listD.getName(), listD.getValueType(), listD.getWriteAble(), listD.getAdapterId().toString(), item));
				}
				adapters.add(
						new Adapter(listA.getNodeId().toString(), listA.getName(), listA.getGatewayId().toString(), text.split(":")[0], text.split(":")[1], "localhost", "6001", "client", variables));
			}
			gateWay.add(new GateWay(listG.getNodeId().toString(), listG.getName(), adapters));
		}
		// OpcUaNodes
		OpcUaNodes opcUaNodes = new OpcUaNodes(gateWay);
		return opcUaNodes;
	}

	/**
	 * 下载仪表读取XML配置文件
	 */
	@ResponseBody
	@RequestMapping(value = "/xml/getCnfg", produces = "text/xml;charset=UTF-8") // 点击按钮
	public String getCnfgXml(HttpServletRequest request, ModelMap modelMap, @RequestParam String text) {
		logger.info("返回点位配置的XML数据");
		text = decoderURL(text);
		BasePath basePath = new BasePath();
		String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
		Pattern pat = Pattern.compile(rexp);
		String[] params;
		params = text.split(":");
		if (params.length != 2) {
			return createSimpleFailureJson("填写有误请重新填写！");
		}
		Matcher mat = pat.matcher(params[0]);
		boolean isIp = mat.find();
		Config config = new Config();
		if (isIp) {
			rexp = "^\\d{1,6}$";
			pat = Pattern.compile(rexp);
			mat = pat.matcher(params[1]);
			boolean isPort = mat.find();
			if (isPort) {
				HttpClientUtil httpClientUtil = new HttpClientUtil();
				try {
					httpClientUtil.doGet("localhost", 8080, "/Sia/rest/xml/opcua", "Config", text);// httpclient生成config文件
				} catch (ClientProtocolException e) {
					logger.info(e.getMessage());
					return createSimpleFailureJson(e.getMessage());
				} catch (IOException e) {
					logger.info(e.getMessage());
					return createSimpleFailureJson(e.getMessage());
				}
			} else {
				return createSimpleFailureJson("错误，Port填写有误！");
			}
		} else {
			return createSimpleFailureJson("错误，IP填写有误！");
		}
		return createSimpleSuccessJson("生成成功，文件在:" + basePath.getBasePath() + "Config.xml");
	}
}
