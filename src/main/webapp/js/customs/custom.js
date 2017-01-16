var changePagel = function(url, title, id, icon) {
	var tabs = Ext.getCmp('indexTabPanel');
	var tab = tabs.getComponent(id + 'Window');
	if (!tab) {
		tab = tabs.add({
			title : title,
			html : "<iframe width=100% height=100% frameborder='0' src='" + url
					+ ".do' />",
			id : id + "Window",
			icon : icon,
			closable : true
		});
	}
	tabs.setActiveTab(tab);
};

var failureMsgAlert = function(message) {
	Ext.Msg.alert('错误！', message);
};

var successMsgAlert = function(message) {
	Ext.Msg.alert('成功！', message);
};

var onConfirmClick = function() {
	Ext.MessageBox.confirm('温馨提示', '确定修改?', showResult, this);
};

var showResult = function(btn, text) {
	showToast(Ext.String.format('修改成功！'));
};

var showToast = function(s) {
	Ext.toast({
		html : s,
		closable : true,
		align : 't',
		slideInDuration : 400,
		minWidth : 400
	});
};

var showProgress = function(title, msg, timeOut, toast) {
	var me = this, i = 0, fn;
	Ext.MessageBox.show({
		title : title,
		msg : msg,
		progressText : '初始化……',
		width : 300,
		progress : true,
		closable : false
	});

	fn = function() {
		++i;
		if (i == 12) {
			Ext.MessageBox.hide();
			me.showToast(toast);
		} else {
			var val = i / 11;
			Ext.MessageBox.updateProgress(val, Math.round(100 * val)
					+ '% Completed');
			setTimeout(fn, timeOut);
		}
	}
	setTimeout(fn, timeOut);
}
