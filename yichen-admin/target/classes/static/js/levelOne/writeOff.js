/*******************************************************************************
 * 一级稽核 日报编辑 -- 长短款冲销
 */
var writeOff = {
	checkRows: [],
	init: function() {
		writeOff.initLayUI();
		writeOff.initWriteOffTable();
	},
	/**
	 * 初始化layui组件
	 */
	initLayUI : function() {
		layui.use([ 'form', 'laydate' ], function() {
			var form = layui.form, 
					laydate = layui.laydate;

			// 日期
			laydate.render({
				elem : '#writeOffDate',
				max : 'nowTime'
			});

			// 监听提交
			form.on('submit(writeOffForm)', function(data) {
				var params = data.field;

				console.log('最终的提交信息:', params);
				
				return false;
			});
		})
	},
	/**
	 * 初始化长短款表格
	 */
	initWriteOffTable: function() {
		var options = {
				//id : 'auditTable',
				//url : prefix + "/listSj",
				data: [
					{
						id: '1',
						dateNo: '2019-07-17',
						status: '长款',
						money: '3012',
						moneyAge: '2',
						remarks: ''
					},
					{
						id: '2',
						dateNo: '2019-07-17',
						status: '长款',
						money: '3012',
						moneyAge: '2',
						remarks: ''
					}
				],
				showExport : false,
				search : false,
				showSearch : false,
				showPageGo : false,
				showRefresh : false,
				showColumns : false,
				showToggle : false,
				height : 300,
				queryParams : function(params) {
					// 传递参数查询参数
					
					return params;
				},
				columns : [ {
					checkbox: true
				}, {
					field : 'dateNo',
					title : '日期',
					sortable : false
				}, {
					field : 'status',
					title : '状态',
					sortable : false
				}, {
					field : 'money',
					title : '金额',
					sortable : false
				}, {
					field : 'moneyAge',
					title : '款龄',
					sortable : false
				},
				{
					field : 'remarks',
					title : '备注',
					sortable : false
				}],
				onCheck: function(row, ele) { // 选中
					writeOff.checkRows.push(row);
					window.parent.writeOffTable = writeOff.checkRows;
					console.log("最终选择结果:", window.parent.writeOffTable)
				},
				onUncheck: function(row, ele) {// 取消选中
					writeOff.queryCheck(row);
				},
				onCheckAll: function(rows) {// 全选
					for(var i=0; i<rows.length; i++) {
						writeOff.checkRows.push(rows[i]);
					}
					writeOff.checkRows = Array.from(new Set(writeOff.checkRows));
					window.parent.writeOffTable = writeOff.checkRows;
					console.log("最终选择结果:", window.parent.writeOffTable)
				},
				onUncheckAll: function(rows) {// 取消全选
					writeOff.queryCheck(rows);
				}
			};
			$('#writeOffTable').bootstrapTable(options);
	},
	/**
	 * 处理表格选择参数
	 */
	queryCheck: function(rows) {
		if(rows.length >0) {
			for(var i=0; i<rows.length; i++) {
				writeOff.checkRows.remove(rows[i], 'id');
			}
		}else {
			writeOff.checkRows.remove(rows, 'id');
		}
		window.parent.writeOffTable = writeOff.checkRows;
		console.log("最终选择结果:", window.parent.writeOffTable)
	}
}

Array.prototype.remove = function(o,prop) {
  var val;
  if(typeof(o) === "object") {
    val = o[prop];
    for(var i=0; i<this.length; i++) {
    	if(this[i][prop] == val) {
    		this.splice(i, 1);
    	}
    }
  }
};

$(function() {
	console.log('writeOff');
	writeOff.init();
});