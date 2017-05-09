var loginForm = Ext
		.create(
				'Ext.form.FormPanel',
				{
					title : '用户登陆',
					region : 'center',
					xtype : 'form',
					fieldDefaults : {
						labelWidth : 70,
						labelAlign : 'center',
						padding : '0 10 5 10',
						margin : '10 8 8 8'
					},
					layout : 'anchor',
					frame : true,
					width : '70%',
					height : 330,
					tools : [ {
						xtype : 'button',
						icon : ctxPath + '/images/icon/QR.png',
						handler : QRlogin
					} ],
					items : [
							{
								xtype : 'textfield',
								fieldLabel : '账号',
								name : 'username',
								emptyText : '用户名/邮箱/手机号',
								allowBlank : false,
							},
							{
								xtype : 'textfield',
								fieldLabel : '密码',
								name : 'password',
								emptyText : '密码',
								allowBlank : false,
								inputType : 'password',
							},
							{
								xtype : 'textfield',
								fieldLabel : '验证码',
								name : 'validate',
								emptyText : '验证码',
								allowBlank : false,
							},
							{
								xtype : 'component',
								anchor : '100%',
								style : 'text-align: center;',
								html : [
										'<img id="validate" src="/Sia/validate" style="width:100%;height:40px">',
										'<a href="javascript:reLoadValidate();"style="text-decoration: none;">看不清楚？点击刷新！</a>' ]
							}, {
								xtype : 'radiogroup',
								columns : 2,
								items : [ {
									inputValue : '1',
									boxLabel : '记住密码',
									name : 'remember',
									style : 'margin-right:20px'
								}, {
									inputValue : '0',
									boxLabel : '不记住',
									name : 'remember',
									checked : true
								} ]
							} ],
					buttons : [ {
						text : '登陆',
						icon : ctxPath + '/images/icon/login.png',
						handler : login
					}, {
						text : '重置',
						icon : ctxPath + '/images/icon/reset.png',
						handler : reset
					}, '-', {
						text : '新用户注册?',
						icon : ctxPath + '/images/icon/regist.png',
						handler : register
					} ]
				});

function login() {
	if (loginForm.form.isValid()) {
		Ext.Ajax.request({
			method : 'get',
			url : ctxPath + '/loginIn',
			params : {
				username : encodeURI(Ext.String.trim(loginForm.getForm()
						.findField('username').getValue())),
				password : encodeURI(Ext.String.trim(loginForm.getForm()
						.findField('password').getValue())),
				validate : encodeURI(Ext.String.trim(loginForm.getForm()
						.findField('validate').getValue())),
				remember : loginForm.getForm().findField('remember').getValue()
			},
			success : function(response) {
				var responseText = Ext.decode(response.responseText);
				if (responseText.result != 'Y') {
					reLoadValidate();
					loginForm.getForm().findField('validate').setValue('');
					Ext.Msg.alert('错误！', responseText.message);
				} else {
					Ext.Msg.alert('成功！', responseText.message);
					document.location.href = ctxPath + '/index';
				}
			}
		});
	}
};

function reset() {

};

function register() {

};

function reLoadValidate() {
	var validate = document.getElementById("validate");
	validate.src = '/Sia/validate?rnd=' + Math.random();
	validate.value = document.getElementById('validate').value = '';
};

function QRlogin() {
	var rnd = Math.random();
	Ext.Msg
			.alert({
				title : '二维码登陆',
				message : [
						'<img src="/Sia/qrImage?rnd=' + rnd
								+ '" width="250px" height="250px">',
						'<p style="font-size: 1.5em;text-align: center;">扫描二维码登录系统</p>' ]
			});
};

function keyDownSearch(e) {
	var theEvent = e || window.event;
	var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
	if (code == 13) {
		login();
	}
}
