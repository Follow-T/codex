var prefix=ctx+'audit/capitalPool';
		$(function() {
			initTable();
		});
		
		function initTable(){
			var options = {
				url: prefix + "/list",
                configUrl: prefix + "/edit/{dateNo}/{chnCode}",
			  //  createUrl: prefix + "/add",

			   // removeUrl: prefix + "/remove",
			  //  exportUrl: prefix + "/export",
			   // importUrl: prefix + "/importData",
			   // importTemplateUrl: prefix + "/importTemplate",
			    sortName: "dateNo",
			    sortOrder: "desc",
                modalName: "共有资金池",
                showExport: true,
                columns: [ {
                    field : 'latnName',
                    title : '单位',
                    sortable: true
                },
                    {
                        field : 'dateNo',
                        title : '交易日期',
                        visible: true
                    },
                   
                    {
                        field : 'chnCode',
                        title : '银行',
                        sortable: true
                    },
                    {
                        field : 'chnName',
                        title : '开户行',
                        sortable: true
                    },
                    {
                        field : 'chnTypeName',
                        title : '银行账号',
                        sortable: true
                    },
                    {
                        field : 'auditState',
                        title : '金额',
                        sortable: true
                    },
                    {
                        field : 'bossinRcb',
                        title : '资金用途',
                        sortable: true
                    },
                    {
                        field : 'bossoutRcb',
                        title : '备注',
                        sortable: true
                    },
                    {
                        field : 'factnetPaid',
                        title : '对方户名',
                        sortable: true
                    },
                    {
                        field : 'factnetRpts',
                        title : '对方账号',
                        sortable: true
                    },
                    {
                        field : 'longRpts',
                        title : '认领状态',
                        sortable: true
                    },
                    {
                        field : 'shortRpts',
                        title : '认领金额',
                        sortable: true
                    },
                    {
                        field : 'dealCnt',
                        title : '未认领金额',
                        sortable: true
                    },
                    {
                        field : 'dealCnt',
                        title : '款龄',
                        sortable: true
                    },
                    {
                        field : 'dealCnt',
                        title : '来源'
                    },
                    {
                        title: '操作',
                        align: 'center',
                        formatter: function(value, row, index) {
                            var actions = [];
                            actions.push('<a class="btn btn-success btn-xs ' + editFlag + '" href="#" onclick="$.operate.config(\'编辑营业日报\',\'' + row.dateNo + '\',\''+row.chnCode+'\')"><i class="fa fa-edit"></i>编辑</a> ');
                            return actions.join('');
                        }
                    }]
			    };
			    $.table.init(options);
		}