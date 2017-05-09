var test = setTimeout(function() {
	setCharts(line, 'line');
}, 1000);
function setCharts(option, id) {
	var myChart = echarts.init(document.getElementById(id), 'macarons');
	myChart.setOption(option);
	// setInterval(function() {
	// option.series[0].data[0].value = (Math.random() * 100).toFixed(2) - 0;
	// option.series[1].data[0].value = (Math.random() * 7).toFixed(2) - 0;
	// option.series[2].data[0].value = (Math.random() * 2).toFixed(2) - 0;
	// option.series[3].data[0].value = (Math.random() * 2).toFixed(2) - 0;
	// myChart.setOption(option, true);
	// }, 2000);
}

var line = {
	title : {
		text : '历史数据折线图'
	},
	tooltip : {
		trigger : 'item',
		formatter : function(params) {
			var date = new Date(params.value[0]);
			data = date.getFullYear() + '-' + (date.getMonth() + 1) + '-'
					+ date.getDate() + ' ' + date.getHours() + ':'
					+ date.getMinutes();
			return data + '<br/>' + params.value[1] + ', ' + params.value[2];
		}
	},
	dataZoom : {
		show : true,
		start : 70
	},
	legend : {
		data : [ 'series1' ]
	},
	grid : {
		y2 : 80
	},
	xAxis : [ {
		type : 'time',
		splitNumber : 10
	} ],
	yAxis : [ {
		type : 'value'
	} ],
	series : [ {
		name : 'series1',
		type : 'line',
		showAllSymbol : true,
		symbolSize : function(value) {
			return Math.round(value[2] / 10) + 2;
		},
		data : (function() {
			var d = [];
			var len = 0;
			var now = new Date();
			var value;
			while (len++ < 200) {
				d.push([ new Date(2014, 9, 1, 0, len * 10000),
						(Math.random() * 30).toFixed(2) - 0,
						(Math.random() * 100).toFixed(2) - 0 ]);
			}
			return d;
		})()
	} ]
};

var bar = {
	title : {
		x : 'center',
		text : 'ECharts例子个数统计',
		subtext : 'Rainbow bar example',
		link : 'http://echarts.baidu.com/doc/example.html'
	},
	tooltip : {
		trigger : 'item'
	},
	toolbox : {
		show : true,
		feature : {
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
	grid : {
		borderWidth : 0,
		y : 80,
		y2 : 60
	},
	xAxis : [ {
		type : 'category',
		show : false,
		data : [ 'Line', 'Bar', 'Scatter', 'K', 'Pie', 'Radar', 'Chord',
				'Force', 'Map', 'Gauge', 'Funnel' ]
	} ],
	yAxis : [ {
		type : 'value',
		show : false
	} ],
	series : [ {
		name : 'ECharts例子个数统计',
		type : 'bar',
		itemStyle : {
			normal : {
				color : function(params) {
					// build a color map as your need.
					var colorList = [ '#C1232B', '#B5C334', '#FCCE10',
							'#E87C25', '#27727B', '#FE8463', '#9BCA63',
							'#FAD860', '#F3A43B', '#60C0DD', '#D7504B',
							'#C6E579', '#F4E001', '#F0805A', '#26C0C0' ];
					return colorList[params.dataIndex]
				},
				label : {
					show : true,
					position : 'top',
					formatter : '{b}\n{c}'
				}
			}
		},
		data : [ 12, 21, 10, 4, 12, 5, 6, 5, 25, 23, 7 ],
		markPoint : {
			tooltip : {
				trigger : 'item',
				backgroundColor : 'rgba(0,0,0,0)',
				formatter : function(params) {
					return '<img src="'
							+ params.data.symbol.replace('image://', '')
							+ '"/>';
				}
			},
			data : [ {
				xAxis : 0,
				y : 350,
				name : 'Line',
				symbolSize : 20,
				symbol : 'image://../asset/ico/折线图.png'
			}, {
				xAxis : 1,
				y : 350,
				name : 'Bar',
				symbolSize : 20,
				symbol : 'image://../asset/ico/柱状图.png'
			}, {
				xAxis : 2,
				y : 350,
				name : 'Scatter',
				symbolSize : 20,
				symbol : 'image://../asset/ico/散点图.png'
			}, {
				xAxis : 3,
				y : 350,
				name : 'K',
				symbolSize : 20,
				symbol : 'image://../asset/ico/K线图.png'
			}, {
				xAxis : 4,
				y : 350,
				name : 'Pie',
				symbolSize : 20,
				symbol : 'image://../asset/ico/饼状图.png'
			}, {
				xAxis : 5,
				y : 350,
				name : 'Radar',
				symbolSize : 20,
				symbol : 'image://../asset/ico/雷达图.png'
			}, {
				xAxis : 6,
				y : 350,
				name : 'Chord',
				symbolSize : 20,
				symbol : 'image://../asset/ico/和弦图.png'
			}, {
				xAxis : 7,
				y : 350,
				name : 'Force',
				symbolSize : 20,
				symbol : 'image://../asset/ico/力导向图.png'
			}, {
				xAxis : 8,
				y : 350,
				name : 'Map',
				symbolSize : 20,
				symbol : 'image://../asset/ico/地图.png'
			}, {
				xAxis : 9,
				y : 350,
				name : 'Gauge',
				symbolSize : 20,
				symbol : 'image://../asset/ico/仪表盘.png'
			}, {
				xAxis : 10,
				y : 350,
				name : 'Funnel',
				symbolSize : 20,
				symbol : 'image://../asset/ico/漏斗图.png'
			}, ]
		}
	} ]
};

var scatter = {
	title : {
		text : '男性女性身高体重分布',
		subtext : '抽样调查来自: Heinz  2003'
	},
	tooltip : {
		trigger : 'axis',
		showDelay : 0,
		formatter : function(params) {
			if (params.value.length > 1) {
				return params.seriesName + ' :<br/>' + params.value[0] + 'cm '
						+ params.value[1] + 'kg ';
			} else {
				return params.seriesName + ' :<br/>' + params.name + ' : '
						+ params.value + 'kg ';
			}
		},
		axisPointer : {
			show : true,
			type : 'cross',
			lineStyle : {
				type : 'dashed',
				width : 1
			}
		}
	},
	legend : {
		data : [ '女性', '男性' ]
	},
	toolbox : {
		show : true,
		feature : {
			mark : {
				show : true
			},
			dataZoom : {
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
	xAxis : [ {
		type : 'value',
		scale : true,
		axisLabel : {
			formatter : '{value} cm'
		}
	} ],
	yAxis : [ {
		type : 'value',
		scale : true,
		axisLabel : {
			formatter : '{value} kg'
		}
	} ],
	series : [
			{
				name : '女性',
				type : 'scatter',
				data : [ [ 161.2, 51.6 ], [ 167.5, 59.0 ], [ 159.5, 49.2 ],
						[ 157.0, 63.0 ], [ 155.8, 53.6 ], [ 170.0, 59.0 ],
						[ 159.1, 47.6 ], [ 166.0, 69.8 ], [ 176.2, 66.8 ],
						[ 160.2, 75.2 ], [ 172.5, 55.2 ], [ 170.9, 54.2 ],
						[ 172.9, 62.5 ], [ 153.4, 42.0 ], [ 160.0, 50.0 ],
						[ 147.2, 49.8 ], [ 168.2, 49.2 ], [ 175.0, 73.2 ],
						[ 157.0, 47.8 ], [ 167.6, 68.8 ], [ 159.5, 50.6 ],
						[ 175.0, 82.5 ], [ 166.8, 57.2 ], [ 176.5, 87.8 ],
						[ 170.2, 72.8 ], [ 174.0, 54.5 ], [ 173.0, 59.8 ],
						[ 179.9, 67.3 ], [ 170.5, 67.8 ], [ 160.0, 47.0 ],
						[ 154.4, 46.2 ], [ 162.0, 55.0 ], [ 176.5, 83.0 ],
						[ 160.0, 54.4 ], [ 152.0, 45.8 ], [ 162.1, 53.6 ],
						[ 170.0, 73.2 ], [ 160.2, 52.1 ], [ 161.3, 67.9 ],
						[ 166.4, 56.6 ], [ 168.9, 62.3 ], [ 163.8, 58.5 ],
						[ 167.6, 54.5 ], [ 160.0, 50.2 ], [ 161.3, 60.3 ],
						[ 167.6, 58.3 ], [ 165.1, 56.2 ], [ 160.0, 50.2 ],
						[ 170.0, 72.9 ], [ 157.5, 59.8 ], [ 167.6, 61.0 ],
						[ 160.7, 69.1 ], [ 163.2, 55.9 ], [ 152.4, 46.5 ],
						[ 157.5, 54.3 ], [ 168.3, 54.8 ], [ 180.3, 60.7 ],
						[ 165.5, 60.0 ], [ 165.0, 62.0 ], [ 164.5, 60.3 ],
						[ 156.0, 52.7 ], [ 160.0, 74.3 ], [ 163.0, 62.0 ],
						[ 165.7, 73.1 ], [ 161.0, 80.0 ], [ 162.0, 54.7 ],
						[ 166.0, 53.2 ], [ 174.0, 75.7 ], [ 172.7, 61.1 ],
						[ 167.6, 55.7 ], [ 151.1, 48.7 ], [ 164.5, 52.3 ],
						[ 163.5, 50.0 ], [ 152.0, 59.3 ], [ 169.0, 62.5 ],
						[ 164.0, 55.7 ], [ 161.2, 54.8 ], [ 155.0, 45.9 ],
						[ 170.0, 70.6 ], [ 176.2, 67.2 ], [ 170.0, 69.4 ],
						[ 162.5, 58.2 ], [ 170.3, 64.8 ], [ 164.1, 71.6 ],
						[ 169.5, 52.8 ], [ 163.2, 59.8 ], [ 154.5, 49.0 ],
						[ 159.8, 50.0 ], [ 173.2, 69.2 ], [ 170.0, 55.9 ],
						[ 161.4, 63.4 ], [ 169.0, 58.2 ], [ 166.2, 58.6 ],
						[ 159.4, 45.7 ], [ 162.5, 52.2 ], [ 159.0, 48.6 ],
						[ 162.8, 57.8 ], [ 159.0, 55.6 ], [ 179.8, 66.8 ],
						[ 162.9, 59.4 ], [ 161.0, 53.6 ], [ 151.1, 73.2 ],
						[ 168.2, 53.4 ], [ 168.9, 69.0 ], [ 173.2, 58.4 ],
						[ 171.8, 56.2 ], [ 178.0, 70.6 ], [ 164.3, 59.8 ],
						[ 163.0, 72.0 ], [ 168.5, 65.2 ], [ 166.8, 56.6 ],
						[ 172.7, 105.2 ], [ 163.5, 51.8 ], [ 169.4, 63.4 ],
						[ 167.8, 59.0 ], [ 159.5, 47.6 ], [ 167.6, 63.0 ],
						[ 161.2, 55.2 ], [ 160.0, 45.0 ], [ 163.2, 54.0 ],
						[ 162.2, 50.2 ], [ 161.3, 60.2 ], [ 149.5, 44.8 ],
						[ 157.5, 58.8 ], [ 163.2, 56.4 ], [ 172.7, 62.0 ],
						[ 155.0, 49.2 ], [ 156.5, 67.2 ], [ 164.0, 53.8 ],
						[ 160.9, 54.4 ], [ 162.8, 58.0 ], [ 167.0, 59.8 ],
						[ 160.0, 54.8 ], [ 160.0, 43.2 ], [ 168.9, 60.5 ],
						[ 158.2, 46.4 ], [ 156.0, 64.4 ], [ 160.0, 48.8 ],
						[ 167.1, 62.2 ], [ 158.0, 55.5 ], [ 167.6, 57.8 ],
						[ 156.0, 54.6 ], [ 162.1, 59.2 ], [ 173.4, 52.7 ],
						[ 159.8, 53.2 ], [ 170.5, 64.5 ], [ 159.2, 51.8 ],
						[ 157.5, 56.0 ], [ 161.3, 63.6 ], [ 162.6, 63.2 ],
						[ 160.0, 59.5 ], [ 168.9, 56.8 ], [ 165.1, 64.1 ],
						[ 162.6, 50.0 ], [ 165.1, 72.3 ], [ 166.4, 55.0 ],
						[ 160.0, 55.9 ], [ 152.4, 60.4 ], [ 170.2, 69.1 ],
						[ 162.6, 84.5 ], [ 170.2, 55.9 ], [ 158.8, 55.5 ],
						[ 172.7, 69.5 ], [ 167.6, 76.4 ], [ 162.6, 61.4 ],
						[ 167.6, 65.9 ], [ 156.2, 58.6 ], [ 175.2, 66.8 ],
						[ 172.1, 56.6 ], [ 162.6, 58.6 ], [ 160.0, 55.9 ],
						[ 165.1, 59.1 ], [ 182.9, 81.8 ], [ 166.4, 70.7 ],
						[ 165.1, 56.8 ], [ 177.8, 60.0 ], [ 165.1, 58.2 ],
						[ 175.3, 72.7 ], [ 154.9, 54.1 ], [ 158.8, 49.1 ],
						[ 172.7, 75.9 ], [ 168.9, 55.0 ], [ 161.3, 57.3 ],
						[ 167.6, 55.0 ], [ 165.1, 65.5 ], [ 175.3, 65.5 ],
						[ 157.5, 48.6 ], [ 163.8, 58.6 ], [ 167.6, 63.6 ],
						[ 165.1, 55.2 ], [ 165.1, 62.7 ], [ 168.9, 56.6 ],
						[ 162.6, 53.9 ], [ 164.5, 63.2 ], [ 176.5, 73.6 ],
						[ 168.9, 62.0 ], [ 175.3, 63.6 ], [ 159.4, 53.2 ],
						[ 160.0, 53.4 ], [ 170.2, 55.0 ], [ 162.6, 70.5 ],
						[ 167.6, 54.5 ], [ 162.6, 54.5 ], [ 160.7, 55.9 ],
						[ 160.0, 59.0 ], [ 157.5, 63.6 ], [ 162.6, 54.5 ],
						[ 152.4, 47.3 ], [ 170.2, 67.7 ], [ 165.1, 80.9 ],
						[ 172.7, 70.5 ], [ 165.1, 60.9 ], [ 170.2, 63.6 ],
						[ 170.2, 54.5 ], [ 170.2, 59.1 ], [ 161.3, 70.5 ],
						[ 167.6, 52.7 ], [ 167.6, 62.7 ], [ 165.1, 86.3 ],
						[ 162.6, 66.4 ], [ 152.4, 67.3 ], [ 168.9, 63.0 ],
						[ 170.2, 73.6 ], [ 175.2, 62.3 ], [ 175.2, 57.7 ],
						[ 160.0, 55.4 ], [ 165.1, 104.1 ], [ 174.0, 55.5 ],
						[ 170.2, 77.3 ], [ 160.0, 80.5 ], [ 167.6, 64.5 ],
						[ 167.6, 72.3 ], [ 167.6, 61.4 ], [ 154.9, 58.2 ],
						[ 162.6, 81.8 ], [ 175.3, 63.6 ], [ 171.4, 53.4 ],
						[ 157.5, 54.5 ], [ 165.1, 53.6 ], [ 160.0, 60.0 ],
						[ 174.0, 73.6 ], [ 162.6, 61.4 ], [ 174.0, 55.5 ],
						[ 162.6, 63.6 ], [ 161.3, 60.9 ], [ 156.2, 60.0 ],
						[ 149.9, 46.8 ], [ 169.5, 57.3 ], [ 160.0, 64.1 ],
						[ 175.3, 63.6 ], [ 169.5, 67.3 ], [ 160.0, 75.5 ],
						[ 172.7, 68.2 ], [ 162.6, 61.4 ], [ 157.5, 76.8 ],
						[ 176.5, 71.8 ], [ 164.4, 55.5 ], [ 160.7, 48.6 ],
						[ 174.0, 66.4 ], [ 163.8, 67.3 ] ],
				markPoint : {
					data : [ {
						type : 'max',
						name : '最大值'
					}, {
						type : 'min',
						name : '最小值'
					} ]
				},
				markLine : {
					data : [ {
						type : 'average',
						name : '平均值'
					} ]
				}
			},
			{
				name : '男性',
				type : 'scatter',
				data : [ [ 174.0, 65.6 ], [ 175.3, 71.8 ], [ 193.5, 80.7 ],
						[ 186.5, 72.6 ], [ 187.2, 78.8 ], [ 181.5, 74.8 ],
						[ 184.0, 86.4 ], [ 184.5, 78.4 ], [ 175.0, 62.0 ],
						[ 184.0, 81.6 ], [ 180.0, 76.6 ], [ 177.8, 83.6 ],
						[ 192.0, 90.0 ], [ 176.0, 74.6 ], [ 174.0, 71.0 ],
						[ 184.0, 79.6 ], [ 192.7, 93.8 ], [ 171.5, 70.0 ],
						[ 173.0, 72.4 ], [ 176.0, 85.9 ], [ 176.0, 78.8 ],
						[ 180.5, 77.8 ], [ 172.7, 66.2 ], [ 176.0, 86.4 ],
						[ 173.5, 81.8 ], [ 178.0, 89.6 ], [ 180.3, 82.8 ],
						[ 180.3, 76.4 ], [ 164.5, 63.2 ], [ 173.0, 60.9 ],
						[ 183.5, 74.8 ], [ 175.5, 70.0 ], [ 188.0, 72.4 ],
						[ 189.2, 84.1 ], [ 172.8, 69.1 ], [ 170.0, 59.5 ],
						[ 182.0, 67.2 ], [ 170.0, 61.3 ], [ 177.8, 68.6 ],
						[ 184.2, 80.1 ], [ 186.7, 87.8 ], [ 171.4, 84.7 ],
						[ 172.7, 73.4 ], [ 175.3, 72.1 ], [ 180.3, 82.6 ],
						[ 182.9, 88.7 ], [ 188.0, 84.1 ], [ 177.2, 94.1 ],
						[ 172.1, 74.9 ], [ 167.0, 59.1 ], [ 169.5, 75.6 ],
						[ 174.0, 86.2 ], [ 172.7, 75.3 ], [ 182.2, 87.1 ],
						[ 164.1, 55.2 ], [ 163.0, 57.0 ], [ 171.5, 61.4 ],
						[ 184.2, 76.8 ], [ 174.0, 86.8 ], [ 174.0, 72.2 ],
						[ 177.0, 71.6 ], [ 186.0, 84.8 ], [ 167.0, 68.2 ],
						[ 171.8, 66.1 ], [ 182.0, 72.0 ], [ 167.0, 64.6 ],
						[ 177.8, 74.8 ], [ 164.5, 70.0 ], [ 192.0, 101.6 ],
						[ 175.5, 63.2 ], [ 171.2, 79.1 ], [ 181.6, 78.9 ],
						[ 167.4, 67.7 ], [ 181.1, 66.0 ], [ 177.0, 68.2 ],
						[ 174.5, 63.9 ], [ 177.5, 72.0 ], [ 170.5, 56.8 ],
						[ 182.4, 74.5 ], [ 197.1, 90.9 ], [ 180.1, 93.0 ],
						[ 175.5, 80.9 ], [ 180.6, 72.7 ], [ 184.4, 68.0 ],
						[ 175.5, 70.9 ], [ 180.6, 72.5 ], [ 177.0, 72.5 ],
						[ 177.1, 83.4 ], [ 181.6, 75.5 ], [ 176.5, 73.0 ],
						[ 175.0, 70.2 ], [ 174.0, 73.4 ], [ 165.1, 70.5 ],
						[ 177.0, 68.9 ], [ 192.0, 102.3 ], [ 176.5, 68.4 ],
						[ 169.4, 65.9 ], [ 182.1, 75.7 ], [ 179.8, 84.5 ],
						[ 175.3, 87.7 ], [ 184.9, 86.4 ], [ 177.3, 73.2 ],
						[ 167.4, 53.9 ], [ 178.1, 72.0 ], [ 168.9, 55.5 ],
						[ 157.2, 58.4 ], [ 180.3, 83.2 ], [ 170.2, 72.7 ],
						[ 177.8, 64.1 ], [ 172.7, 72.3 ], [ 165.1, 65.0 ],
						[ 186.7, 86.4 ], [ 165.1, 65.0 ], [ 174.0, 88.6 ],
						[ 175.3, 84.1 ], [ 185.4, 66.8 ], [ 177.8, 75.5 ],
						[ 180.3, 93.2 ], [ 180.3, 82.7 ], [ 177.8, 58.0 ],
						[ 177.8, 79.5 ], [ 177.8, 78.6 ], [ 177.8, 71.8 ],
						[ 177.8, 116.4 ], [ 163.8, 72.2 ], [ 188.0, 83.6 ],
						[ 198.1, 85.5 ], [ 175.3, 90.9 ], [ 166.4, 85.9 ],
						[ 190.5, 89.1 ], [ 166.4, 75.0 ], [ 177.8, 77.7 ],
						[ 179.7, 86.4 ], [ 172.7, 90.9 ], [ 190.5, 73.6 ],
						[ 185.4, 76.4 ], [ 168.9, 69.1 ], [ 167.6, 84.5 ],
						[ 175.3, 64.5 ], [ 170.2, 69.1 ], [ 190.5, 108.6 ],
						[ 177.8, 86.4 ], [ 190.5, 80.9 ], [ 177.8, 87.7 ],
						[ 184.2, 94.5 ], [ 176.5, 80.2 ], [ 177.8, 72.0 ],
						[ 180.3, 71.4 ], [ 171.4, 72.7 ], [ 172.7, 84.1 ],
						[ 172.7, 76.8 ], [ 177.8, 63.6 ], [ 177.8, 80.9 ],
						[ 182.9, 80.9 ], [ 170.2, 85.5 ], [ 167.6, 68.6 ],
						[ 175.3, 67.7 ], [ 165.1, 66.4 ], [ 185.4, 102.3 ],
						[ 181.6, 70.5 ], [ 172.7, 95.9 ], [ 190.5, 84.1 ],
						[ 179.1, 87.3 ], [ 175.3, 71.8 ], [ 170.2, 65.9 ],
						[ 193.0, 95.9 ], [ 171.4, 91.4 ], [ 177.8, 81.8 ],
						[ 177.8, 96.8 ], [ 167.6, 69.1 ], [ 167.6, 82.7 ],
						[ 180.3, 75.5 ], [ 182.9, 79.5 ], [ 176.5, 73.6 ],
						[ 186.7, 91.8 ], [ 188.0, 84.1 ], [ 188.0, 85.9 ],
						[ 177.8, 81.8 ], [ 174.0, 82.5 ], [ 177.8, 80.5 ],
						[ 171.4, 70.0 ], [ 185.4, 81.8 ], [ 185.4, 84.1 ],
						[ 188.0, 90.5 ], [ 188.0, 91.4 ], [ 182.9, 89.1 ],
						[ 176.5, 85.0 ], [ 175.3, 69.1 ], [ 175.3, 73.6 ],
						[ 188.0, 80.5 ], [ 188.0, 82.7 ], [ 175.3, 86.4 ],
						[ 170.5, 67.7 ], [ 179.1, 92.7 ], [ 177.8, 93.6 ],
						[ 175.3, 70.9 ], [ 182.9, 75.0 ], [ 170.8, 93.2 ],
						[ 188.0, 93.2 ], [ 180.3, 77.7 ], [ 177.8, 61.4 ],
						[ 185.4, 94.1 ], [ 168.9, 75.0 ], [ 185.4, 83.6 ],
						[ 180.3, 85.5 ], [ 174.0, 73.9 ], [ 167.6, 66.8 ],
						[ 182.9, 87.3 ], [ 160.0, 72.3 ], [ 180.3, 88.6 ],
						[ 167.6, 75.5 ], [ 186.7, 101.4 ], [ 175.3, 91.1 ],
						[ 175.3, 67.3 ], [ 175.9, 77.7 ], [ 175.3, 81.8 ],
						[ 179.1, 75.5 ], [ 181.6, 84.5 ], [ 177.8, 76.6 ],
						[ 182.9, 85.0 ], [ 177.8, 102.5 ], [ 184.2, 77.3 ],
						[ 179.1, 71.8 ], [ 176.5, 87.9 ], [ 188.0, 94.3 ],
						[ 174.0, 70.9 ], [ 167.6, 64.5 ], [ 170.2, 77.3 ],
						[ 167.6, 72.3 ], [ 188.0, 87.3 ], [ 174.0, 80.0 ],
						[ 176.5, 82.3 ], [ 180.3, 73.6 ], [ 167.6, 74.1 ],
						[ 188.0, 85.9 ], [ 180.3, 73.2 ], [ 167.6, 76.3 ],
						[ 183.0, 65.9 ], [ 183.0, 90.9 ], [ 179.1, 89.1 ],
						[ 170.2, 62.3 ], [ 177.8, 82.7 ], [ 179.1, 79.1 ],
						[ 190.5, 98.2 ], [ 177.8, 84.1 ], [ 180.3, 83.2 ],
						[ 180.3, 83.2 ] ],
				markPoint : {
					data : [ {
						type : 'max',
						name : '最大值'
					}, {
						type : 'min',
						name : '最小值'
					} ]
				},
				markLine : {
					data : [ {
						type : 'average',
						name : '平均值'
					} ]
				}
			} ]
};

var pie = {
	title : {
		text : '某站点用户访问来源',
		subtext : '纯属虚构',
		x : 'center'
	},
	tooltip : {
		trigger : 'item',
		formatter : "{a} <br/>{b} : {c} ({d}%)"
	},
	legend : {
		orient : 'vertical',
		x : 'left',
		data : [ '直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎' ]
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
			magicType : {
				show : true,
				type : [ 'pie', 'funnel' ],
				option : {
					funnel : {
						x : '25%',
						width : '50%',
						funnelAlign : 'left',
						max : 1548
					}
				}
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
	series : [ {
		name : '访问来源',
		type : 'pie',
		radius : '55%',
		center : [ '50%', '60%' ],
		data : [ {
			value : 335,
			name : '直接访问'
		}, {
			value : 310,
			name : '邮件营销'
		}, {
			value : 234,
			name : '联盟广告'
		}, {
			value : 135,
			name : '视频广告'
		}, {
			value : 1548,
			name : '搜索引擎'
		} ]
	} ]
};

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

var gauge = {
	tooltip : {
		formatter : "{a} <br/>{c} {b}"
	},
	toolbox : {
		show : true,
		feature : {
			mark : {
				show : true
			},
			restore : {
				show : true
			},
			saveAsImage : {
				show : true
			}
		}
	},
	series : [
			{
				name : '速度',
				type : 'gauge',
				z : 3,
				min : 0,
				max : 220,
				splitNumber : 11,
				axisLine : { // 坐标轴线
					lineStyle : { // 属性lineStyle控制线条样式
						width : 10
					}
				},
				axisTick : { // 坐标轴小标记
					length : 15, // 属性length控制线长
					lineStyle : { // 属性lineStyle控制线条样式
						color : 'auto'
					}
				},
				splitLine : { // 分隔线
					length : 20, // 属性length控制线长
					lineStyle : { // 属性lineStyle（详见lineStyle）控制线条样式
						color : 'auto'
					}
				},
				title : {
					textStyle : { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
						fontWeight : 'bolder',
						fontSize : 20,
						fontStyle : 'italic'
					}
				},
				detail : {
					textStyle : { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
						fontWeight : 'bolder'
					}
				},
				data : [ {
					value : 40,
					name : 'km/h'
				} ]
			},
			{
				name : '转速',
				type : 'gauge',
				center : [ '25%', '55%' ], // 默认全局居中
				radius : '50%',
				min : 0,
				max : 7,
				endAngle : 45,
				splitNumber : 7,
				axisLine : { // 坐标轴线
					lineStyle : { // 属性lineStyle控制线条样式
						width : 8
					}
				},
				axisTick : { // 坐标轴小标记
					length : 12, // 属性length控制线长
					lineStyle : { // 属性lineStyle控制线条样式
						color : 'auto'
					}
				},
				splitLine : { // 分隔线
					length : 20, // 属性length控制线长
					lineStyle : { // 属性lineStyle（详见lineStyle）控制线条样式
						color : 'auto'
					}
				},
				pointer : {
					width : 5
				},
				title : {
					offsetCenter : [ 0, '-30%' ], // x, y，单位px
				},
				detail : {
					textStyle : { // 其余属性默认使用全局文本样式，详见TEXTSTYLE
						fontWeight : 'bolder'
					}
				},
				data : [ {
					value : 1.5,
					name : 'x1000 r/min'
				} ]
			},
			{
				name : '油表',
				type : 'gauge',
				center : [ '75%', '50%' ], // 默认全局居中
				radius : '50%',
				min : 0,
				max : 2,
				startAngle : 135,
				endAngle : 45,
				splitNumber : 2,
				axisLine : { // 坐标轴线
					lineStyle : { // 属性lineStyle控制线条样式
						color : [ [ 0.2, '#ff4500' ], [ 0.8, '#48b' ],
								[ 1, '#228b22' ] ],
						width : 8
					}
				},
				axisTick : { // 坐标轴小标记
					splitNumber : 5,
					length : 10, // 属性length控制线长
					lineStyle : { // 属性lineStyle控制线条样式
						color : 'auto'
					}
				},
				axisLabel : {
					formatter : function(v) {
						switch (v + '') {
						case '0':
							return 'E';
						case '1':
							return 'Gas';
						case '2':
							return 'F';
						}
					}
				},
				splitLine : { // 分隔线
					length : 15, // 属性length控制线长
					lineStyle : { // 属性lineStyle（详见lineStyle）控制线条样式
						color : 'auto'
					}
				},
				pointer : {
					width : 2
				},
				title : {
					show : false
				},
				detail : {
					show : false
				},
				data : [ {
					value : 0.5,
					name : 'gas'
				} ]
			},
			{
				name : '水表',
				type : 'gauge',
				center : [ '75%', '50%' ], // 默认全局居中
				radius : '50%',
				min : 0,
				max : 2,
				startAngle : 315,
				endAngle : 225,
				splitNumber : 2,
				axisLine : { // 坐标轴线
					lineStyle : { // 属性lineStyle控制线条样式
						color : [ [ 0.2, '#ff4500' ], [ 0.8, '#48b' ],
								[ 1, '#228b22' ] ],
						width : 8
					}
				},
				axisTick : { // 坐标轴小标记
					show : false
				},
				axisLabel : {
					formatter : function(v) {
						switch (v + '') {
						case '0':
							return 'H';
						case '1':
							return 'Water';
						case '2':
							return 'C';
						}
					}
				},
				splitLine : { // 分隔线
					length : 15, // 属性length控制线长
					lineStyle : { // 属性lineStyle（详见lineStyle）控制线条样式
						color : 'auto'
					}
				},
				pointer : {
					width : 2
				},
				title : {
					show : false
				},
				detail : {
					show : false
				},
				data : [ {
					value : 0.5,
					name : 'gas'
				} ]
			} ]
};

var relationShip = {
	title : {
		text : '人物关系：乔布斯',
		subtext : '数据来自人立方',
		x : 'right',
		y : 'bottom'
	},
	tooltip : {
		trigger : 'item',
		formatter : '{a} : {b}'
	},
	toolbox : {
		show : true,
		feature : {
			restore : {
				show : true
			},
			magicType : {
				show : true,
				type : [ 'force', 'chord' ]
			},
			saveAsImage : {
				show : true
			}
		}
	},
	legend : {
		x : 'left',
		data : [ '家人', '朋友' ]
	},
	series : [ {
		type: 'graph',
        layout: 'force',
		name : "人物关系",
		ribbonType : false,
		categories : [ {
			name : '人物'
		}, {
			name : '家人'
		}, {
			name : '朋友'
		} ],
		itemStyle : {
			normal : {
				label : {
					show : true,
					textStyle : {
						color : '#333'
					}
				},
				nodeStyle : {
					brushType : 'both',
					borderColor : 'rgba(255,215,0,0.4)',
					borderWidth : 1
				},
				linkStyle : {
					type : 'curve'
				}
			},
			emphasis : {
				label : {
					show : false
				// textStyle: null // 默认使用全局文本样式，详见TEXTSTYLE
				},
				nodeStyle : {
				 r: 30
				},
				linkStyle : {}
			}
		},
		useWorker : false,
		minRadius : 15,
		maxRadius : 25,
		gravity : 1.1,
		scaling : 1.1,
		roam : 'true',
		nodes : [ {
			category : 0,
			name : '乔布斯',
			value : 10,
			label : '乔布斯\n（主要）'
		}, {
			category : 1,
			name : '丽萨-乔布斯',
			value : 2
		}, {
			category : 1,
			name : '保罗-乔布斯',
			value : 3
		}, {
			category : 1,
			name : '克拉拉-乔布斯',
			value : 3
		}, {
			category : 1,
			name : '劳伦-鲍威尔',
			value : 7
		}, {
			category : 2,
			name : '史蒂夫-沃兹尼艾克',
			value : 5
		}, {
			category : 2,
			name : '奥巴马',
			value : 8
		}, {
			category : 2,
			name : '比尔-盖茨',
			value : 9
		}, {
			category : 2,
			name : '乔纳森-艾夫',
			value : 4
		}, {
			category : 2,
			name : '蒂姆-库克',
			value : 4
		}, {
			category : 2,
			name : '龙-韦恩',
			value : 1
		}, ],
		links : [ {
			source : '丽萨-乔布斯',
			target : '乔布斯',
			weight : 1,
			name : '女儿'
		}, {
			source : '保罗-乔布斯',
			target : '乔布斯',
			weight : 2,
			name : '父亲'
		}, {
			source : '克拉拉-乔布斯',
			target : '乔布斯',
			weight : 1,
			name : '母亲'
		}, {
			source : '劳伦-鲍威尔',
			target : '乔布斯',
			weight : 2
		}, {
			source : '史蒂夫-沃兹尼艾克',
			target : '乔布斯',
			weight : 3,
			name : '合伙人'
		}, {
			source : '奥巴马',
			target : '乔布斯',
			weight : 1
		}, {
			source : '比尔-盖茨',
			target : '乔布斯',
			weight : 6,
			name : '竞争对手'
		}, {
			source : '乔纳森-艾夫',
			target : '乔布斯',
			weight : 1,
			name : '爱将'
		}, {
			source : '蒂姆-库克',
			target : '乔布斯',
			weight : 1
		}, {
			source : '龙-韦恩',
			target : '乔布斯',
			weight : 1
		}, {
			source : '克拉拉-乔布斯',
			target : '保罗-乔布斯',
			weight : 1
		}, {
			source : '奥巴马',
			target : '保罗-乔布斯',
			weight : 1
		}, {
			source : '奥巴马',
			target : '克拉拉-乔布斯',
			weight : 1
		}, {
			source : '奥巴马',
			target : '劳伦-鲍威尔',
			weight : 1
		}, {
			source : '奥巴马',
			target : '史蒂夫-沃兹尼艾克',
			weight : 1
		}, {
			source : '比尔-盖茨',
			target : '奥巴马',
			weight : 6
		}, {
			source : '比尔-盖茨',
			target : '克拉拉-乔布斯',
			weight : 1
		}, {
			source : '蒂姆-库克',
			target : '奥巴马',
			weight : 1
		} ]
	} ]
};

