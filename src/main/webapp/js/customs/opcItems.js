var typeStore = Ext.create('Ext.data.Store', {
	fields : [ 'text', 'value' ],
	data : [ {
		"text" : "Input State",
		"value" : "0"
	}, {
		"text" : "Coils",
		"value" : "1"
	}, {
		"text" : "Input Register",
		"value" : "2"
	}, {
		"text" : "Holding Register",
		"value" : "3"
	} ]
});

var rwStore = Ext.create('Ext.data.Store', {
	fields : [ 'text', 'value' ],
	data : [ {
		"text" : "读->Read",
		"value" : "0"
	}, {
		"text" : "写->Write",
		"value" : "1"
	} ]
});

var writeAbleStore = Ext.create('Ext.data.Store', {
	fields : [ 'text', 'value' ],
	data : [ {
		"text" : "读写",
		"value" : "y"
	}, {
		"text" : "只读",
		"value" : "n"
	} ]
});
var valueTypeStore = Ext.create('Ext.data.Store', {
	fields : [ 'text', 'value' ],
	data : [ {
		"text" : "Double",
		"value" : "double"
	}, {
		"text" : "String",
		"value" : "string"
	} ]
});
var tagStore = Ext.create('Ext.data.Store', {
	fields : [ 'text', 'value' ],
	data : [ {
		"text" : "0",
		"value" : "0"
	}, {
		"text" : "1",
		"value" : "1"
	}, {
		"text" : "2",
		"value" : "2"
	}, {
		"text" : "3",
		"value" : "3"
	}, {
		"text" : "4",
		"value" : "4"
	}, {
		"text" : "5",
		"value" : "5"
	}, {
		"text" : "6",
		"value" : "6"
	}, {
		"text" : "7",
		"value" : "7"
	}, {
		"text" : "8",
		"value" : "8"
	}, {
		"text" : "9",
		"value" : "9"
	} ]
});

var configWin = function(text, type, data) {
	var FormPanel = Ext.create('Ext.form.FormPanel', {
		frame : true,
		width : 500,
		height : 280,
		scrollable : true,
		bodyPadding : 10,
		layout : 'form',
		items : [ {
			xtype : 'combobox',
			store : dataRealStore,
			name : 'dataRealId',
			fieldLabel : '点位NodeID',
			allowBlank : false,
			editable : false,
			blankText : '点位必须关联一个适配器节点NodeID！',
			displayField : 'name',
			valueField : 'nodeId'
		}, {
			xtype : 'textfield',
			name : 'deviceId',
			fieldLabel : '设备号',
			allowBlank : false,
			blankText : '值类型不能为空！',
			value : ''
		}, {
			xtype : 'textfield',
			name : 'modAddress',
			fieldLabel : 'Modbus地址',
			allowBlank : false,
			blankText : '可写操作不能为空！',
			value : ''
		}, {
			xtype : 'combobox',
			name : 'type',
			store : typeStore,
			fieldLabel : '参数类型',
			allowBlank : false,
			editable : false,
			blankText : '参数类型不能为空！',
			value : '',
			displayField : 'text',
			valueField : 'value'
		}, {
			xtype : 'combobox',
			name : 'rw',
			store : rwStore,
			fieldLabel : '读写',
			allowBlank : false,
			editable : false,
			blankText : '读写标识不能为空！',
			value : '',
			displayField : 'text',
			valueField : 'value'
		}, {
			xtype : 'textfield',
			name : 'fre',
			fieldLabel : '采集频率',
			allowBlank : false,
			blankText : '采集频率不能为空！',
			value : ''
		} ],
		buttons : [
				{
					text : text,
					type : 'submit',
					handler : function() {
						if (FormPanel.form.isValid()) {
							Ext.Ajax.request({
								method : 'get',
								url : ctxPath + '/opcItems/cnfg/' + type
										+ '.do',
								params : {
									dataRealId : FormPanel.getForm().findField(
											'dataRealId').getValue(),
									deviceId : FormPanel.getForm().findField(
											'deviceId').getValue(),
									modAddress : FormPanel.getForm().findField(
											'modAddress').getValue(),
									type : FormPanel.getForm()
											.findField('type').getValue(),
									rw : FormPanel.getForm().findField('rw')
											.getValue(),
									fre : FormPanel.getForm().findField('fre')
											.getValue()
								},
								success : function(response) {
									var responseText = Ext
											.decode(response.responseText);
									if (responseText.result != 'Y') {
										Ext.Msg.alert('错误！',
												responseText.message);
									} else {
										Ext.Msg.alert('成功！',
												responseText.message);
										FormPanel.reset();
										Win.close();
										store.loadPage(1);
									}
								}
							});
						}
					}
				},
				{
					text : '重置',
					handler : function() {
						if (type != 'update') {
							FormPanel.reset();
						} else {
							FormPanel.getForm().findField('dataRealId')
									.setEditable(false);
							FormPanel.getForm().findField('dataRealId')
									.setValue(data.dataRealId);
							FormPanel.getForm().findField('deviceId').setValue(
									data.deviceId);
							FormPanel.getForm().findField('modAddress')
									.setValue(data.modAddr);
							FormPanel.getForm().findField('type').setValue(
									data.type);
							FormPanel.getForm().findField('rw').setValue(
									data.rw);
							FormPanel.getForm().findField('fre').setValue(
									data.fre);
						}
					}
				}, {
					text : '取消',
					handler : function() {
						FormPanel.reset();
						Win.close();
					}
				} ]
	});

	var Win = new Ext.Window({
		layout : 'fit',
		constrain : true,
		resizable : false,
		closable : false,
		modal : true,
		plain : true,
		items : FormPanel,
		title : text + '适配器点位属性配置',
		listeners : {
			beforeshow : function(win, opts) {
			}
		}
	});

	if (type != 'add') {
		FormPanel.getForm().findField('dataRealId').setEditable(false);
		FormPanel.getForm().findField('dataRealId').setValue(data.dataRealId);
		FormPanel.getForm().findField('deviceId').setValue(data.deviceId);
		FormPanel.getForm().findField('modAddress').setValue(data.modAddr);
		FormPanel.getForm().findField('type').setValue(data.type);
		FormPanel.getForm().findField('rw').setValue(data.rw);
		FormPanel.getForm().findField('fre').setValue(data.fre);
	}
	Win.show();
}
var dataRealWin = function(text, type, data) {// 适配器变量添加与修改弹窗
	var FormPanel = Ext
			.create(
					'Ext.form.FormPanel',
					{
						frame : true,
						width : 500,
						height : 300,
						scrollable : true,
						bodyPadding : 10,
						layout : 'form',
						items : [ {
							xtype : 'textfield',
							name : 'nodeId',
							fieldLabel : '节点NodeID',
							regex : /^\d{5,6}$/,
							regexText : '请输入数字，长度为5~6位',
							allowBlank : false,
							blankText : '节点NodeID不能为空！',
							value : ''
						}, {
							xtype : 'combobox',
							store : adapterStore,
							name : 'adapterId',
							fieldLabel : '适配器NodeID',
							allowBlank : false,
							editable : false,
							blankText : '点位必须关联一个适配器节点NodeID！',
							displayField : 'name',
							valueField : 'nodeId'
						}, {
							xtype : 'textfield',
							name : 'name',
							fieldLabel : '点位名称',
							maxLength : 8,
							allowBlank : false,
							blankText : '点位名称不能为空！',
							value : ''
						}, {
							xtype : 'combobox',
							name : 'valueType',
							store : valueTypeStore,
							fieldLabel : '值类型',
							allowBlank : false,
							editable : false,
							blankText : '值类型不能为空！',
							value : '',
							displayField : 'text',
							valueField : 'value'
						}, {
							xtype : 'combobox',
							name : 'writeAble',
							store : writeAbleStore,
							fieldLabel : '是否可写',
							allowBlank : false,
							editable : false,
							blankText : '可写操作不能为空！',
							value : '',
							displayField : 'text',
							valueField : 'value'
						}, {
							xtype : 'textfield',
							name : 'value',
							store : writeAbleStore,
							fieldLabel : '变量值',
							allowBlank : false,
							blankText : '变量值不能为空！',
							value : '0',
							displayField : 'text',
							valueField : 'value'
						}, {
							xtype : 'combobox',
							name : 'tag',
							store : tagStore,
							fieldLabel : '协议编号',
							allowBlank : false,
							editable : false,
							blankText : '协议编号不能为空！',
							value : '',
							displayField : 'text',
							valueField : 'value'
						} ],
						buttons : [
								{
									text : text,
									type : 'submit',
									handler : function() {
										if (FormPanel.form.isValid()) {
											Ext.Ajax
													.request({
														method : 'get',
														url : ctxPath
																+ '/adapter/cnfg/'
																+ type + '.do',
														params : {
															nodeId : FormPanel
																	.getForm()
																	.findField(
																			'nodeId')
																	.getValue(),
															adapterId : FormPanel
																	.getForm()
																	.findField(
																			'adapterId')
																	.getValue(),
															name : encodeURI(FormPanel
																	.getForm()
																	.findField(
																			'name')
																	.getValue()),
															valueType : FormPanel
																	.getForm()
																	.findField(
																			'valueType')
																	.getValue(),
															writeAble : FormPanel
																	.getForm()
																	.findField(
																			'writeAble')
																	.getValue(),
															value : encodeURI(FormPanel
																	.getForm()
																	.findField(
																			'value')
																	.getValue()),
															tag : FormPanel
																	.getForm()
																	.findField(
																			'tag')
																	.getValue()
														},
														success : function(
																response) {
															var responseText = Ext
																	.decode(response.responseText);
															if (responseText.result != 'Y') {
																Ext.Msg
																		.alert(
																				'错误！',
																				responseText.message);
															} else {
																Ext.Msg
																		.alert(
																				'成功！',
																				responseText.message);
																FormPanel
																		.reset();
																Win.close();
																store
																		.loadPage(1);
															}
														}
													});
										}
									}
								},
								{
									text : '重置',
									handler : function() {
										if (type != 'update') {
											FormPanel.reset();
										} else {
											FormPanel.getForm().findField(
													'nodeId')
													.setEditable(false);
											FormPanel.getForm().findField(
													'adapterId').setEditable(
													false);
											FormPanel.getForm().findField(
													'nodeId').setValue(
													data.nodeId);
											FormPanel.getForm().findField(
													'adapterId').setValue(
													data.adapterId);
											FormPanel.getForm().findField(
													'name').setValue(data.name);
											FormPanel.getForm().findField(
													'valueType').setValue(
													data.valueType);
											FormPanel.getForm().findField(
													'writeAble').setValue(
													data.writeAble);
											FormPanel.getForm().findField(
													'value').setValue(
													data.value);
											FormPanel.getForm()
													.findField('tag').setValue(
															data.tag);
										}

									}
								}, {
									text : '取消',
									handler : function() {
										FormPanel.reset();
										Win.close();
									}
								} ]
					});

	var Win = new Ext.Window({
		layout : 'fit',
		constrain : true,
		resizable : false,
		closable : false,
		modal : true,
		plain : true,
		items : FormPanel,
		title : text + '适配器点位',
		listeners : {
			beforeshow : function(win, opts) {
			}
		}
	});

	if (type != 'add') {
		FormPanel.getForm().findField('nodeId').setEditable(false);
		FormPanel.getForm().findField('adapterId').setEditable(false);
		FormPanel.getForm().findField('nodeId').setValue(data.nodeId);
		FormPanel.getForm().findField('adapterId').setValue(data.adapterId);
		FormPanel.getForm().findField('name').setValue(data.name);
		FormPanel.getForm().findField('valueType').setValue(data.valueType);
		FormPanel.getForm().findField('writeAble').setValue(data.writeAble);
		FormPanel.getForm().findField('value').setValue(data.value);
		FormPanel.getForm().findField('tag').setValue(data.tag);
	}
	Win.show();
}

var adapterWin = function(text, type, data) {// 适配器新增与修改弹窗
	var FormPanel = Ext.create('Ext.form.FormPanel', {
		frame : true,
		width : 500,
		height : 300,
		scrollable : true,
		bodyPadding : 10,
		layout : 'form',
		items : [ {
			xtype : 'textfield',
			name : 'nodeId',
			fieldLabel : '节点NodeID',
			regex : /^\d{5,6}$/,
			regexText : '请输入数字，长度为5~6位',
			allowBlank : false,
			blankText : '节点NodeID不能为空！',
			value : ''
		}, {
			xtype : 'combobox',
			store : gatewayStore,
			name : 'gatewayId',
			fieldLabel : '网关NodeID',
			allowBlank : false,
			editable : false,
			blankText : '适配器必须关联一个网关节点NodeID！',
			displayField : 'name',
			valueField : 'nodeId'
		}, {
			xtype : 'textfield',
			name : 'name',
			fieldLabel : '适配器名称',
			maxLength : 8,
			allowBlank : false,
			blankText : '适配器名称不能为空！',
			value : ''
		}, {
			xtype : 'textfield',
			name : 'serial',
			fieldLabel : '显示位号',
			allowBlank : false,
			blankText : '适配器名称不能为空！',
			value : ''
		}, {
			xtype : 'textfield',
			name : 'typeserial',
			fieldLabel : '存储位号',
			allowBlank : false,
			blankText : '适配器名称不能为空！',
			value : ''
		}, {
			xtype : 'textfield',
			name : 'longAddress',
			fieldLabel : '设备长地址',
			regex : /^[0-9a-fA-F]{16}$/,
			regexText : '请输入正确的设备长地址',
			allowBlank : false,
			blankText : '设备长地址不能为空！',
			value : ''
		}, {
			xtype : 'textfield',
			name : 'subAddress',
			fieldLabel : '从站地址',
			regex : /^[0-9a-fA-F]{2,}$/,
			regexText : '请输入正确的从站地址',
			value : 'FF'
		}, {
			xtype : 'textfield',
			name : 'type',
			fieldLabel : '仪表类型',
			maxLength : 8,
			allowBlank : false,
			blankText : '适配器名称不能为空！',
			value : ''
		}, {
			xtype : 'textfield',
			name : 'factory',
			fieldLabel : '生产厂家',
			maxLength : 8,
			allowBlank : false,
			blankText : '适配器名称不能为空！',
			value : ''
		} ],
		buttons : [
				{
					text : text,
					type : 'submit',
					handler : function() {
						if (FormPanel.form.isValid()) {
							Ext.Ajax.request({
								method : 'get',
								url : ctxPath + '/adapter/' + type + '.do',
								params : {
									nodeId : FormPanel.getForm().findField(
											'nodeId').getValue(),
									gatewayId : FormPanel.getForm().findField(
											'gatewayId').getValue(),
									name : encodeURI(FormPanel.getForm()
											.findField('name').getValue()),
									serial : FormPanel.getForm().findField(
											'serial').getValue(),
									typeserial : FormPanel.getForm().findField(
											'typeserial').getValue(),
									longAddress : FormPanel.getForm()
											.findField('longAddress')
											.getValue(),
									subAddress : FormPanel.getForm().findField(
											'subAddress').getValue(),
									type : encodeURI(FormPanel.getForm()
											.findField('type').getValue()),
									factory : encodeURI(FormPanel.getForm()
											.findField('factory').getValue())
								},
								success : function(response) {
									var responseText = Ext
											.decode(response.responseText);
									if (responseText.result != 'Y') {
										Ext.Msg.alert('错误！',
												responseText.message);
									} else {
										Ext.Msg.alert('成功！',
												responseText.message);
										FormPanel.reset();
										Win.close();
										store.loadPage(1);
									}
								}
							});
						}
					}
				},
				{
					text : '重置',
					handler : function() {
						if (type != 'update') {
							FormPanel.reset();
						} else {
							FormPanel.getForm().findField('nodeId')
									.setEditable(false);
							FormPanel.getForm().findField('gatewayId')
									.setEditable(false);
							FormPanel.getForm().findField('nodeId').setValue(
									data.nodeId);
							FormPanel.getForm().findField('gatewayId')
									.setValue(data.gatewayId);
							FormPanel.getForm().findField('name').setValue(
									data.name);
							FormPanel.getForm().findField('serial').setValue(
									data.serial);
							FormPanel.getForm().findField('typeserial')
									.setValue(data.typeserial);
							FormPanel.getForm().findField('longAddress')
									.setValue(data.longAddress);
							FormPanel.getForm().findField('subAddress')
									.setValue(data.subAddress);
							FormPanel.getForm().findField('type').setValue(
									data.type);
							FormPanel.getForm().findField('factory').setValue(
									data.factory);
						}

					}
				}, {
					text : '取消',
					handler : function() {
						FormPanel.reset();
						Win.close();
					}
				} ]
	});

	var Win = new Ext.Window({
		layout : 'fit',
		constrain : true,
		resizable : false,
		closable : false,
		modal : true,
		plain : true,
		items : FormPanel,
		title : text + '适配器',
		listeners : {
			beforeshow : function(win, opts) {
			}
		}
	});

	if (type != 'add') {
		FormPanel.getForm().findField('nodeId').setEditable(false);
		FormPanel.getForm().findField('gatewayId').setEditable(false);
		FormPanel.getForm().findField('nodeId').setValue(data.nodeId);
		FormPanel.getForm().findField('gatewayId').setValue(data.gatewayId);
		FormPanel.getForm().findField('name').setValue(data.name);
		FormPanel.getForm().findField('serial').setValue(data.serial);
		FormPanel.getForm().findField('typeserial').setValue(data.typeserial);
		FormPanel.getForm().findField('longAddress').setValue(data.longAddress);
		FormPanel.getForm().findField('subAddress').setValue(data.subAddress);
		FormPanel.getForm().findField('type').setValue(data.type);
		FormPanel.getForm().findField('factory').setValue(data.factory);
	}
	Win.show();
}

var gatewayWin = function(text, type, data) {// 网关新增与修改弹窗
	var FormPanel = Ext.create('Ext.form.FormPanel', {
		frame : true,
		width : 400,
		height : 180,
		scrollable : true,
		bodyPadding : 10,
		layout : 'form',
		items : [ {
			xtype : 'textfield',
			name : 'nodeId',
			fieldLabel : '节点NodeID',
			regex : /^\d{5,6}$/,
			regexText : '请输入数字，至少5位,之多6位',
			allowBlank : false,
			blankText : '节点NodeID不能为空！',
			value : ''
		}, {
			xtype : 'textfield',
			name : 'name',
			fieldLabel : '网关名称',
			maxLength : 16,
			allowBlank : false,
			blankText : '网关名称不能为空！',
			value : ''
		}, {
			xtype : 'textfield',
			name : 'ip',
			fieldLabel : '网关IP',
			emptyMsg : 'xxx.xxx.xxx.xxx',
			regex : /\d+\.\d+\.\d+\.\d+/,
			regexText : '请输入正确的网关地址，如：192.168.1.3',
			maxLength : 15,
			allowBlank : false,
			blankText : '网关IP不能为空！',
			value : ''
		}, {
			xtype : 'textfield',
			name : 'port',
			fieldLabel : '网关端口',
			regex : /^\d{3,5}$/,
			regexText : '请输入正确的端口号',
			allowBlank : false,
			blankText : '网关端口不能为空！',
			value : '6000'
		} ],
		buttons : [
				{
					text : text,
					type : 'submit',
					handler : function() {
						if (FormPanel.form.isValid()) {
							Ext.Ajax.request({
								method : 'get',
								url : ctxPath + '/gateWay/' + type + '.do',
								params : {
									nodeId : FormPanel.getForm().findField(
											'nodeId').getValue(),
									name : encodeURI(FormPanel.getForm()
											.findField('name').getValue()),
									ip : FormPanel.getForm().findField('ip')
											.getValue(),
									port : FormPanel.getForm()
											.findField('port').getValue()
								},
								success : function(response) {
									var responseText = Ext
											.decode(response.responseText);
									if (responseText.result != 'Y') {
										Ext.Msg.alert('错误！',
												responseText.message);
									} else {
										Ext.Msg.alert('成功！',
												responseText.message);
										FormPanel.reset();
										Win.close();
										store.loadPage(1);
									}
								}
							});
						}
					}
				},
				{
					text : '重置',
					handler : function() {
						if (type != 'update') {
							FormPanel.reset();
						} else {
							FormPanel.getForm().findField('nodeId')
									.setEditable(false);
							FormPanel.getForm().findField('nodeId').setValue(
									data.nodeId);
							FormPanel.getForm().findField('name').setValue(
									data.name);
							FormPanel.getForm().findField('ip').setValue(
									data.ip);
							FormPanel.getForm().findField('port').setValue(
									data.port);
						}

					}
				}, {
					text : '取消',
					handler : function() {
						FormPanel.reset();
						Win.close();
					}
				} ]
	});

	var Win = new Ext.Window({
		layout : 'fit',
		constrain : true,
		resizable : false,
		closable : false,
		modal : true,
		plain : true,
		items : FormPanel,
		title : text + '网关',
		listeners : {
			beforeshow : function(win, opts) {
			}
		}
	});

	if (type != 'add') {
		FormPanel.getForm().findField('nodeId').setEditable(false);
		FormPanel.getForm().findField('nodeId').setValue(data.nodeId);
		FormPanel.getForm().findField('name').setValue(data.name);
		FormPanel.getForm().findField('ip').setValue(data.ip);
		FormPanel.getForm().findField('port').setValue(data.port);
	}
	Win.show();
}

/**
 * 自动初始化chart，延迟1s
 */
var init = setTimeout(function() {
	setCharts(radar, 'radar');
}, 1000);

/**
 * 玫瑰图
 */
var radar = {
	title : {
		text : '多雷达图',
		subtext : '纯属虚构'
	},
	tooltip : {
		trigger : 'axis'
	},
	legend : {
		x : 'center',
		data : [ '某软件', '某主食手机', '某水果手机', '降水量', '蒸发量' ]
	},
	toolbox : {
		show : true,
		feature : {
			mark : {
				show : true
			},
			dataView : {
				show : true,
				readOnly : false
			},
			restore : {
				show : true
			},
			saveAsImage : {
				show : true
			}
		}
	},
	calculable : true,
	polar : [ {
		indicator : [ {
			text : '品牌',
			max : 100
		}, {
			text : '内容',
			max : 100
		}, {
			text : '可用性',
			max : 100
		}, {
			text : '功能',
			max : 100
		} ],
		center : [ '25%', 200 ],
		radius : 80
	}, {
		indicator : [ {
			text : '外观',
			max : 100
		}, {
			text : '拍照',
			max : 100
		}, {
			text : '系统',
			max : 100
		}, {
			text : '性能',
			max : 100
		}, {
			text : '屏幕',
			max : 100
		} ],
		radius : 80
	}, {
		indicator : (function() {
			var res = [];
			for (var i = 1; i <= 12; i++) {
				res.push({
					text : i + '月',
					max : 100
				});
			}
			return res;
		})(),
		center : [ '75%', 200 ],
		radius : 80
	} ],
	series : [
			{
				type : 'radar',
				tooltip : {
					trigger : 'item'
				},
				itemStyle : {
					normal : {
						areaStyle : {
							type : 'default'
						}
					}
				},
				data : [ {
					value : [ 60, 73, 85, 40 ],
					name : '某软件'
				} ]
			},
			{
				type : 'radar',
				polarIndex : 1,
				data : [ {
					value : [ 85, 90, 90, 95, 95 ],
					name : '某主食手机'
				}, {
					value : [ 95, 80, 95, 90, 93 ],
					name : '某水果手机'
				} ]
			},
			{
				type : 'radar',
				polarIndex : 2,
				itemStyle : {
					normal : {
						areaStyle : {
							type : 'default'
						}
					}
				},
				data : [
						{
							name : '降水量',
							value : [ 2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 75.6,
									82.2, 48.7, 18.8, 6.0, 2.3 ],
						},
						{
							name : '蒸发量',
							value : [ 2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 35.6,
									62.2, 32.6, 20.0, 6.4, 3.3 ]
						} ]
			} ]
};

/**
 * 设置chart
 * 
 * @param option
 * @param id
 */
function setCharts(id) {
	var myChart = echarts.init(document.getElementById(id), 'macarons');
	myChart.setOption(radar);
}