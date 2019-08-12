var prefix = ctx + 'audit/levelOne';

var initViewEdit = {
	init: function() {
		this.initReceivableTable();
		this.initPaidTable();
		this.initCDTable();
		this.initAuditTable();
	},
	/***
	 * 初始化应收表格
	 */
	initReceivableTable : function() {
		var options = {
			id : 'receivableTable',
			url : prefix + "/listYs",
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
				var tmp = {
					pageSize : params.limit,
					pageNum : params.offset / params.limit + 1
				}
				return tmp;
			},
			columns : [ {
				field : 'rowNum',
				title : '序号'
			/*
			 * formatter: function (value, row, index) { var pageSize =
			 * $('#receivableTable').bootstrapTable('getOptions').pageSize;
			 * //通过table的#id 得到每页多少条 var pageNumber =
			 * $('#receivableTable').bootstrapTable('getOptions').pageNumber;
			 * //通过table的#id 得到当前第几页 return pageSize * (pageNumber - 1) + index + 1; //
			 * 返回每条的序号： 每页条数 *（当前页 - 1 ）+ 序号 }
			 */
			}, {
				field : 'date_no',
				title : '营业日期',
				sortable : false
			}, {
				field : 'cus_name',
				title : '客户名称',
				sortable : false
			}, {
				field : 'business_short_desc',
				title : '业务简介',
				sortable : false
			}, {
				field : 'bosstotal',
				title : '应收金额',
				sortable : false
			}, {
				field : 'business_manage_dept',
				title : '业务管理部门',
				sortable : false
			}, {
				field : 'note',
				title : '备注',
				sortable : false
			} ]
		};
		$.table.init(options);
	},
	/***
	 * 初始化实缴表格
	 */
	initPaidTable : function() {
		var options = {
			id : 'paidTable',
			url : prefix + "/listSj",
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
				var tmp = {
					pageSize : params.limit,
					pageNum : params.offset / params.limit + 1
				}
				return tmp;
			},
			columns : [ {
				field : 'rowNum',
				title : '序号'
			}, {
				field : 'factnet_Paid_type',
				title : '实缴类型',
				sortable : false
			}, {
				field : 'jy_date',
				title : '交易发生日期',
				sortable : false
			}, {
				field : 'yy_date',
				title : '营业日期',
				sortable : false
			}, {
				field : 'BANK_ACCT',
				title : '银行账号',
				sortable : false
			}, {
				field : 'factnet_Paid',
				title : '金额',
				sortable : false
			}]
		};
		$.table.init(options);
	},
	/***
	 * 初始化长短款表格
	 */
	initCDTable: function() {
		var options = {
			//id : 'auditTable',
			//url : prefix + "/listSj",
			data: [],
			showExport : false,
			search : false,
			showSearch : false,
			showPageGo : false,
			showRefresh : false,
			showColumns : false,
			showToggle : false,
			height : 100,
			queryParams : function(params) {
				// 传递参数查询参数
				var tmp = {
					pageSize : params.limit,
					pageNum : params.offset / params.limit + 1
				}
				return tmp;
			},
			columns : [ {
				field : 'rowNum',
				title : '序号'
			}, {
				field : 'date',
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
				field : 'money-age',
				title : '款龄',
				sortable : false
			}, {
				field : 'note',
				title : '备注',
				sortable : false
			}]
		};
		$('#cdTable').bootstrapTable(options);
		//$.table.init(options);
	},
	/***
	 * 初始化稽核人员表格
	 */
	initAuditTable: function() {
		var options = {
			//id : 'auditTable',
			//url : prefix + "/listSj",
			data: [],
			showExport : false,
			search : false,
			showSearch : false,
			showPageGo : false,
			showRefresh : false,
			showColumns : false,
			showToggle : false,
			height : 100,
			queryParams : function(params) {
				// 传递参数查询参数
				var tmp = {
					pageSize : params.limit,
					pageNum : params.offset / params.limit + 1
				}
				return tmp;
			},
			columns : [ {
				field : 'rowNum',
				title : '序号'
			}, {
				field : 'factnet_Paid_type',
				title : '稽核员',
				sortable : false
			}, {
				field : 'jy_date',
				title : '岗位',
				sortable : false
			}, {
				field : 'yy_date',
				title : '内容',
				sortable : false
			}, {
				field : 'BANK_ACCT',
				title : '操作时间',
				sortable : false
			}]
		};
		$('#auditTable').bootstrapTable(options);
		//$.table.init(options);
	},
}

$(function() {
	console.log('viewEdit');
	initViewEdit.init();
});