Ext.define('model.Gateway', {
	extend: 'Ext.data.Model',
	fields: [{
		type: 'string',
		name: 'name'
	}, {
		type: 'string',
		name: 'nodeId'
	}, {
		type: 'string',
		name: 'ip'
	}, {
		type: 'string',
		name: 'port'
	}, {
		type: 'string',
		login: 'isEnable'
	}, {
		type: 'string',
		login: 'state'
	}, {
		type: 'int',
		name: 'atTime'
	}]
});

Ext.define('model.Adapter', {
	extend: 'Ext.data.Model',
	fields: [{
		type: 'string',
		name: 'name'
	}, {
		type: 'string',
		name: 'nodeId'
	}, {
		type: 'string',
		name: 'gatewayId'
	}, {
		type: 'string',
		name: 'serial'
	}, {
		type: 'string',
		name: 'typeserial'
	}, {
		type: 'string',
		name: 'longAddress'
	}, {
		type: 'string',
		name: 'subAddress'
	}, {
		type: 'string',
		name: 'type'
	}, {
		type: 'string',
		name: 'factory'
	}, {
		type: 'string',
		name: 'protoclId'
	}, {
		type: 'int',
		login: 'isEnable'
	}, {
		type: 'int',
		name: 'atTime'
	}]
});

Ext.define('model.DataReal', {
	extend: 'Ext.data.Model',
	fields: [{
		type: 'string',
		name: 'name'
	}, {
		type: 'string',
		name: 'nodeId'
	}, {
		type: 'string',
		name: 'adapterId'
	}, {
		type: 'string',
		name: 'valueType'
	}, {
		type: 'string',
		name: 'writeAble'
	}, {
		type: 'string',
		name: 'tag'
	}, {
		type: 'string',
		name: 'value'
	}, {
		type: 'int',
		name: 'atTime'
	}]
});

Ext.define('model.Config', {
	extend: 'Ext.data.Model',
	fields: [{
		type: 'string',
		name: 'name'
	}, {
		type: 'string',
		name: 'nodeId'
	}, {
		type: 'string',
		name: 'parentNodeId'
	}]
});