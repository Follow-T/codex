var prefix = ctx + 'audit/levelOne';

var levelOne = {
	init : function() {
		this.initLayUI();
		this.initTable();
		this.bindEvent();
	},
	/**
	 * 初始化layui组件
	 */
	initLayUI : function() {
		layui.use([ 'form', 'laydate', 'tree' ], function() {
			var form = layui.form, 
					laydate = layui.laydate, 
					tree = layui.tree;

			// 日期范围
			laydate.render({
				elem : '#dateRange',
				range : '~', // 自定义分割字符
				max : 'nowTime'
			});

			levelOne.initCompanyTree(tree);

			// 监听提交
			form.on('submit(levleOneForm)', function(data) {
				var params = data.field;
				params.company = $('.companyBlock').data('id');

				console.log('最终的提交信息:', params);
				var opt = {
	        url: prefix + "/list",
	        silent: true,
	        query: params
		    };
				
				//带参数 刷新
		    $("#levelOneTable").bootstrapTable('refresh', opt);
				
				return false;
			});
		})
	},
	/**
	 * 初始化单位树
	 */
	initCompanyTree : function(tree) {
		// 手风琴模式
		tree.render({
			elem : '#companyTree',
			data : [ {
				id : '0',
				title : '有限公司',
				children : [ {
					id : '1',
					title : '甘孜电信',
					children : [ {
						id : '1-1',
						title : '甘孜州财务部（四级）',
						children : [ {
							id : '1-1-1',
							title : '甘孜州企业信息化部（三级）',
							children : [ {
								id : '1-1-1-1',
								title : '甘孜州公众客户部（二级）',
								children : [ {
									id : '1-1-1-1-1',
									title : '康定现业中心营业厅（一级）',
								} ]
							} ]
						} ]
					} ]
				} ]
			} ],
			accordion : true, // 开启手风琴模式
			click : function(obj) {
				$('.companyBlock').val(obj.data.title).attr('data-id', obj.data.id);
				$('#companyTree').addClass('hide');
			}
		});
	},
	/**
	 * 初始化表格
	 */
	initTable : function() {
		var options = {
			id: 'levelOneTable',
			url: prefix + "/list",
			configUrl: prefix + "/edit/{seq_id}",
			sortName : "dateNo",
			sortOrder : "desc",
			modalName : "一级稽核",
			showExport : false,
			search: false,
			showSearch: false,
			showPageGo: false,
			showRefresh: false,
			showColumns: false,
			showToggle: false,
			height: 440,
			queryParams: function(params) {
				// 传递参数查询参数
				var tmp = {
					pageSize: params.limit,
					pageNum: params.offset / params.limit + 1,
					orderByColumn: params.sort,
					isAsc: params.order
				}
				return tmp;
			},
			columns: [
				{
					checkbox: true
				},
				{
					field: 'date_no',
					title: '日期',
					formatter: function(value, row, index) {
						var paid = '<a style="text-decoration: underline;" onclick="levelOne.viewEdit(\'' + row.seq_id +'\')">'+ value +'</a>';
						return paid;
					}
				},
				{
					field: 'latn_name',
					title: '单位',
					sortable: false
				},
				{
					field: 'chn_code',
					title: '店厅编码',
					sortable: false
				},
				{
					field: 'chn_name',
					title: '店厅名称',
					sortable: false
				},
				{
					field: 'chn_type_name',
					title: '类型',
					sortable: false
				},
				{
					field: 'audit_status_cn',
					title: '状态',
					sortable: false
				},
				{
					field: 'bossin_rcb',
					title: '系统内应收',
					sortable: false
				},
				{
					field: 'bossin_rcb',
					title: '系统外应收',
					sortable: false
				},
				{
					field: 'factnet_Paid',
					title: '实缴',
					sortable: false,
					formatter: function(value, row, index) {
						var paid = value;
						if(value >0) {
							paid = '<a style="text-decoration: underline;" onclick="levelOne.factnetPaidView(\'' + row.seq_id +'\')">'+ value +'</a>';
						}
						return paid;
					}
				},
				{
					field: 'factnet_rpts',
					title: '实收',
					sortable: false
				},
				{
					field: 'long_rpts',
					title: '长款',
					sortable: false
				},
				{
					field: 'short_rpts',
					title: '短款',
					sortable: false
				},
				{
					field: 'deal_cnt',
					title: '差异处理次数',
					sortable: false
				},
				{
					title: '操作',
					align: 'center',
					width: 80,
					formatter: function (value, row, index) {
						var actions = [];
						actions.push('<a class="' + editFlag + '" onclick="levelOne.dailyEdit(\'' + row.seq_id +'\')"><i class="fa fa-edit edit-icon"></i></a> ');
						actions.push('<a class="' + checkFlag + '" onclick="levelOne.dailyCheck(\'' + row.seq_id +'\')"><i class="fa fa-check-square-o check-icon"></i></a>');
						return actions.join('');
					}
				}
			]
		};
		$.table.init(options);
	},
	/**
	 * 编辑日报
	 */
	dailyEdit: function(id) {
		var params = {
			url: 	prefix + "/edit/" + id,
			title: '编辑营业日报',
			btnArray: ['取消', '确定', '通过一级稽核'], // 按钮数组,
			callback1: function(index, layero) { // 确定按钮的回调
				console.log("编辑日报：确定", window.parent.writeOffTable, window.parent.editRemark)
			},
			callback2: function(index, layero) { // 第三个按钮的回调
				console.log("编辑日报：通过一级稽核", window.parent.writeOffTable, window.parent.editRemark)
			}
		}
		console.log(window.parent);
		$.modal.editOpen(params);
	},
	/**
	 * 日报通过
	 */
	dailyCheck: function(row) {
		$.modal.confirm('', '确认通过稽核？', function() {
			console.log('通过稽核:', row)
			// TODO
		})
	},
	/**
	 * 查看实缴
	 */
	factnetPaidView: function(id) {
		var params = {
			url: 	prefix + "/factnetPaidView/",
			title: '查看实缴',
			btnArray: ['确定'], // 按钮数组
		}
		$.modal.editOpen(params);
	},
	/**
	 * 查看日报
	 */
	viewEdit: function(id) {
		var params = {
			url: 	prefix + "/viewEdit/",
			title: '查看营业日报',
			btnArray: ['取消', '确定', '通过一级稽核'], // 按钮数组,
			callback1: function(index, layero) { // 确定按钮的回调
				console.log("编辑日报：确定")
			},
			callback2: function(index, layero) { // 第三个按钮的回调
				console.log("编辑日报：通过一级稽核")
			}
		}
		console.log(window.parent);
		$.modal.editOpen(params);
	},
	/**
	 * 单位input事件绑定
	 */
	companyBlock : function(e) {
		e = e || window.event;
		e.stopPropagation();
		if ($('#companyTree').hasClass('hide')) {
			$('#companyTree').removeClass('hide');

			// 点击$('#companyTree') 以外的区域隐藏 $('#companyTree')
			$(document).click(function() {
				$('#companyTree').addClass('hide');
			});
			$('#companyTree').click(function(event) {
				event = event || window.event;
				event.stopPropagation();
			});
		} else {
			$('#companyTree').addClass('hide');
		}
	},
	/**
	 * 事件绑定
	 */
	bindEvent : function() {
		publicFnc.addEvent('.companyBlock', 'click', levelOne.companyBlock);
	}
}

$(function() {
	levelOne.init();
});
