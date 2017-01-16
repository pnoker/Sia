var customWin = function(text, type, data) {
	var FormPanel = Ext.create('Ext.form.FormPanel', {
		frame : true,
		width : 400,
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
		buttons : [ {
			text : text,
			type : 'submit',
			handler : function() {
				if (FormPanel.form.isValid()) {
					Ext.Ajax.request({
						method : 'get',
						url : ctxPath + '/gateWay/' + type+'.do',
						params : {
							nodeId : FormPanel.getForm().findField('nodeId').getValue(),
							name : encodeURI(FormPanel.getForm().findField('name').getValue()),
							ip : FormPanel.getForm().findField('ip').getValue(),
							port : FormPanel.getForm().findField('port').getValue()
						},
						success : function(response) {
							var responseText = Ext.decode(response.responseText);
							if (responseText.result != 'Y') {
								Ext.Msg.alert('错误！', responseText.message);
							} else {
								Ext.Msg.alert('成功！', responseText.message);
								FormPanel.reset();
								Win.close();
								store.loadPage(1);
							}
						}
					});
				}
			}
		}, {
			text : '重置',
			handler : function() {
				if (type != 'update') {
					FormPanel.reset();
				} else {
					FormPanel.getForm().findField('nodeId').setEditable(false);
					FormPanel.getForm().findField('nodeId').setValue(data.nodeId);
					FormPanel.getForm().findField('name').setValue(data.name);
					FormPanel.getForm().findField('ip').setValue(data.ip);
					FormPanel.getForm().findField('port').setValue(data.port);
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
		width : 500,
		height : 210,
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
