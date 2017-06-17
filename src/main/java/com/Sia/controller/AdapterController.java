package com.Sia.controller;

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
import com.Sia.model.DataReal;
import com.Sia.model.State;
import com.Sia.pojo.DockedItems;
import com.Sia.pojo.GridDataResult;
import com.Sia.pojo.SearchItems;
import com.Sia.service.AdapterService;
import com.Sia.service.DataRealService;
import com.Sia.service.StateService;
import com.alibaba.fastjson.JSON;
import com.annotation.AuthPassport;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月21日
 * @description
 */
@Controller
@RequestMapping("/adapter")
public class AdapterController extends BaseController {
    static final Logger logger = LogManager.getLogger(AdapterController.class);// 日志
    @Autowired
    private AdapterService adapterService;
    @Autowired
    private StateService stateService;
    @Autowired
    private DataRealService dataRealService;

    @AuthPassport
    @ResponseBody
    @RequestMapping(value = "/add", produces = "text/html;charset=UTF-8")
    public String add(HttpServletRequest request, @RequestParam String nodeId, @RequestParam String gatewayId,
                      @RequestParam String name, @RequestParam String serial, @RequestParam String typeserial,
                      @RequestParam String longAddress, @RequestParam String subAddress, @RequestParam String type,
                      @RequestParam String factory) {
        String message = "";
        name = decoderURL(name);
        type = decoderURL(type);
        factory = decoderURL(factory);
        int NodeID = Integer.parseInt(nodeId);
        int GatewayID = Integer.parseInt(gatewayId);
        int ProtoclID = 1;
        State adapterState = stateService.selectByPrimaryKey(NodeID);
        if (adapterState == null) {
            adapterState = new State(new Date(), NodeID);
            logger.info("开始向数据库中新增了一条状态记录");
            if (stateService.insertSelective(adapterState) > 0) {
                logger.info("成功新增一条状态记录");
                Adapter adapter = new Adapter(NodeID, GatewayID, name, serial, typeserial, longAddress, subAddress,
                        type, factory, ProtoclID);
                logger.info("开始向数据库中新增了一条适配器记录");
                if (adapterService.insertSelective(adapter) > 0) {
                    logger.info("成功新增一条适配器记录");
                    message = "适配器:" + name + "新增成功";
                } else {
                    logger.info("新增适配器记录失败");
                    return createSimpleFailureJson("操作失败");
                }
            } else {
                logger.info("新增状态记录失败");
                return createSimpleFailureJson("操作失败");
            }
        } else {
            return createSimpleFailureJson("NodeID:" + NodeID + "已存在,新增适配器失败!");
        }
        return createSimpleSuccessJson(message);
    }

    @AuthPassport
    @ResponseBody
    @RequestMapping(value = "/cnfg/add", produces = "text/html;charset=UTF-8")
    public String cnfgAdd(HttpServletRequest request, @RequestParam String nodeId, @RequestParam String adapterId,
                          @RequestParam String name, @RequestParam String valueType,
                          @RequestParam String writeAble, @RequestParam String value, @RequestParam String tag) {
        String message = "";
        name = decoderURL(name);
        int NodeID = Integer.parseInt(nodeId);
        int AdapterID = Integer.parseInt(adapterId);
        int Tag = Integer.parseInt(tag);
        int ProtoclID = 1;
        DataReal dataReal = dataRealService.selectByPrimaryKey(NodeID);
        if (dataReal == null) {
            dataReal = new DataReal(NodeID, AdapterID, name, valueType, writeAble, Tag, value, ProtoclID);
            logger.info("开始向数据库中新增了一条适配器点位记录");
            if (dataRealService.insertSelective(dataReal) > 0) {
                logger.info("成功新增一条适配器点位记录");
                message = "适配器点位:" + name + "新增成功";
            } else {
                logger.info("新增适配器点位记录失败");
                return createSimpleFailureJson("操作失败");
            }
        } else {
            return createSimpleFailureJson("NodeID:" + NodeID + "已存在,新增适配器点位失败!");
        }
        return createSimpleSuccessJson(message);
    }

    @AuthPassport
    @ResponseBody
    @RequestMapping(value = "/delete", produces = "text/html;charset=UTF-8")
    public String delete(HttpServletRequest request, @RequestParam String nodeId) {
        String message = "适配器";
        String[] nodes = nodeId.split(",");
        for (String node : nodes) {
            int NodeID = Integer.parseInt(node);
            Adapter adapter = adapterService.selectByPrimaryKey(NodeID);
            if (adapter != null) {
                logger.info("开始删除适配器");
                if (adapterService.deleteByPrimaryKey(NodeID) > 0) {
                    logger.info("适配器" + NodeID + "删除成功");
                    if (stateService.deleteByPrimaryKey(NodeID) > 0) {
                        logger.info("适配器" + adapter.getSerial() + "状态删除成功");
                        message += adapter.getSerial() + "、";
                    } else {
                        logger.info("适配器" + adapter.getSerial() + "状态删除失败");
                        return createSimpleFailureJson("适配器删除成功，但是适配器的状态记录删除失败");
                    }
                } else {
                    logger.info("适配器删除失败");
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
    @RequestMapping(value = "/cnfg/delete", produces = "text/html;charset=UTF-8")
    public String cnfgDelete(HttpServletRequest request, @RequestParam String nodeId) {
        String message = "适配器点位";
        String[] nodes = nodeId.split(",");
        for (String node : nodes) {
            int NodeID = Integer.parseInt(node);
            DataReal dataReal = dataRealService.selectByPrimaryKey(NodeID);
            if (dataReal != null) {
                logger.info("开始删除适配器点位");
                if (dataRealService.deleteByPrimaryKey(NodeID) > 0) {
                    logger.info("适配器点位" + NodeID + "删除成功");
                    message += dataReal.getName() + "、";
                } else {
                    logger.info("适配器点位删除失败");
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
    public String update(HttpServletRequest request, @RequestParam String nodeId, @RequestParam String gatewayId,
                         @RequestParam String name, @RequestParam String serial,
                         @RequestParam String typeserial, @RequestParam String longAddress, @RequestParam String
                                 subAddress, @RequestParam String type, @RequestParam String factory) {
        String message = "";
        name = decoderURL(name);
        type = decoderURL(type);
        factory = decoderURL(factory);
        int NodeID = Integer.parseInt(nodeId);
        int GatewayID = Integer.parseInt(gatewayId);
        int ProtoclID = 1;
        Adapter adapter = adapterService.selectByPrimaryKey(NodeID);
        if (adapter != null) {
            if (adapter.getNodeId().equals(NodeID) && adapter.getGatewayId().equals(GatewayID) && adapter.getName()
                    .equals(name) && adapter.getSerial().equals(serial)
                    && adapter.getTypeserial().equals(typeserial) && adapter.getLongAddress().equals(longAddress) &&
                    adapter.getSubAddress().equals(subAddress) && adapter.getType().equals(type)
                    && adapter.getFactory().equals(factory) && adapter.getProtoclId().equals(ProtoclID)) {
                logger.info("适配器修改失败");
                return createSimpleFailureJson("请至少修改一个参数再提交");
            } else {
                adapter = new Adapter(NodeID, GatewayID, name, serial, typeserial, longAddress, subAddress, type,
                        factory, ProtoclID);
                if (adapterService.updateByPrimaryKeySelective(adapter) > 0) {
                    logger.info("适配器" + name + "修改成功");
                    message = "修改成功";
                } else {
                    logger.info("适配器修改失败");
                    return createSimpleFailureJson("操作失败");
                }
            }
        } else {
            return createSimpleFailureJson("适配器" + name + "不存在,修改操作失败!");
        }
        return createSimpleSuccessJson(message);
    }

    @AuthPassport
    @ResponseBody
    @RequestMapping(value = "/cnfg/update", produces = "text/html;charset=UTF-8")
    public String cnfgUpdate(HttpServletRequest request, @RequestParam String nodeId, @RequestParam String adapterId,
                             @RequestParam String name, @RequestParam String valueType,
                             @RequestParam String writeAble, @RequestParam String value, @RequestParam String tag) {
        String message = "";
        name = decoderURL(name);
        int NodeID = Integer.parseInt(nodeId);
        int AdapterID = Integer.parseInt(adapterId);
        byte Tag = Byte.parseByte(tag);
        int ProtoclID = 1;
        DataReal dataReal = dataRealService.selectByPrimaryKey(NodeID);
        if (dataReal != null) {
            if (dataReal.getNodeId().equals(NodeID) && dataReal.getAdapterId().equals(AdapterID) && dataReal.getName
                    ().equals(name) && dataReal.getValueType().equals(valueType)
                    && dataReal.getTag().equals(Tag) && dataReal.getWriteAble().equals(writeAble) && dataReal
                    .getProtocolId().equals(ProtoclID) && dataReal.getValue().equals(value)) {
                logger.info("适配器点位修改失败");
                return createSimpleFailureJson("请至少修改一个参数再提交");
            } else {
                dataReal = new DataReal(NodeID, AdapterID, name, valueType, writeAble, Tag, value, ProtoclID);
                if (dataRealService.updateByPrimaryKeySelective(dataReal) > 0) {
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
    @RequestMapping(value = "/list", produces = "text/html;charset=UTF-8")
    public String list(HttpServletRequest request, @RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "nodeid", required = false) String nodeId,
                       @RequestParam(value = "serial", required = false) String serial, @RequestParam int start,
                       @RequestParam int limit) {
        if (name == null) {
            name = "";
        }
        if (nodeId == null) {
            nodeId = "0";
        }
        if (serial == null) {
            serial = "";
        }
        int NodeID = Integer.parseInt(nodeId);
        GridDataResult<Adapter> gridDataResult = new GridDataResult<Adapter>();
        AdapterExample example = new AdapterExample(start, limit);
        AdapterExample.Criteria criteria = example.createCriteria();
        if (!name.equals("")) {
            criteria.andNameLike("%" + name + "%");
        }
        if (NodeID != 0) {
            criteria.andNodeIdEqualTo(NodeID);
        }
        if (!serial.equals("")) {
            criteria.andSerialLike("%" + serial + "%");
        }
        int total = adapterService.countByExample(example);
        List<Adapter> list = adapterService.selectByExample(example);
        gridDataResult.setTotal(total);
        gridDataResult.setRoot(list);
        return JSON.toJSONString(gridDataResult);
    }

	/*
     * @AuthPassport
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/tree", produces = "text/html;charset=UTF-8")
	 * public String tree(HttpServletRequest request) { DataRealTree tree = new
	 * DataRealTree("适配器", true, false); ArrayList<DataRealTree> childrenA = new
	 * ArrayList<DataRealTree>(); AdapterExample exampleA = new
	 * AdapterExample(); AdapterExample.Criteria criteriaA =
	 * exampleA.createCriteria(); List<Adapter> adapters =
	 * adapterService.selectByExample(exampleA); for (Adapter listA : adapters)
	 * { DataRealExample exampleD = new DataRealExample();
	 * DataRealExample.Criteria criteriaD = exampleD.createCriteria();
	 * criteriaD.andAdapterIdEqualTo(listA.getNodeId()); List<DataReal>
	 * dataReals = dataRealService.selectByExample(exampleD);
	 * ArrayList<DataRealTree> childrenD = new ArrayList<DataRealTree>(); for
	 * (DataReal listD : dataReals) { childrenD.add(new DataRealTree(true,
	 * false, listD.getNodeId().toString(), listD.getAdapterId().toString(),
	 * listD.getName(), listD.getValueType(), listD.getWriteAble(),
	 * listD.getTag().toString(), listD.getValue())); } childrenA.add(new
	 * DataRealTree(false, true, listA.getNodeId().toString(), listA.getName(),
	 * childrenD)); } tree.setChildren(childrenA); return
	 * JSON.toJSONString(tree); }
	 */

    @AuthPassport
    @RequestMapping("/adapterView")
    public String adapterView(HttpServletRequest request, ModelMap modelMap) {
        logger.info("加载适配器页面");

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
        String search = searchItems.getSearchItems("adapterName-Name", "适配器", "无线水表");
        search += searchItems.getSearchItems("adapterSerial-Serial", "显示位号", "SIA-apt");
        search += searchItems.getSearchItems("adapterSerial-Type", "仪表类型", "无线IO");
        search += searchItems.getSearchItems("adapterSerial-Factory", "生产厂家", "中科奥维");
        search += searchItems.getSearchItems("adapterSerial-IsEnable", "状态", "启用/未启用");
        search = search.substring(0, search.lastIndexOf(","));
        modelMap.addAttribute("searchItems", search);
        return "/part/adapterView";
    }

    @AuthPassport
    @RequestMapping("/adapterCnfg")
    public String adapterCnfg(HttpServletRequest request, ModelMap modelMap) {
        logger.info("加载适配器配置页面");
        DockedItems dockedItems = new DockedItems();
        String items = dockedItems.getDockedItems(request, "修改", "tick", "onUpdateClick");
        items += dockedItems.getDockedItems(request, "添加", "time_add", "onAddClick");
        items += dockedItems.getDockedItems(request, "删除", "time_delete", "onDeleteClick");
        items += dockedItems.getDockedItems(request, "刷新", "arrow_refresh", "onReloadClick");
        items = items.substring(0, items.lastIndexOf(","));
        modelMap.addAttribute("dockedItems", items);
        SearchItems searchItems = new SearchItems();
        String search = searchItems.getSearchItems("adapterNodeId-id", "节点", "52000");
        search += searchItems.getSearchItems("adapterName-id", "名称", "Sia");
        search = search.substring(0, search.lastIndexOf(","));
        modelMap.addAttribute("searchItems", search);
        return "/part/adapterCnfg";
    }
}
