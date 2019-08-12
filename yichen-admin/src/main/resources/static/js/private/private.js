var prefix=ctx+'audit/privateCapitalPool';
        
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
                modalName: "私有资金池",
                showExport: true,
                columns: [{
                    checkbox: true
                },
                    {
                        field : 'dateNo',
                        title : '营业日期',
                        visible: true
                    },
                    {
                        field : 'latnName',
                        title : '单位',
                        sortable: true
                    },
                    {
                        field : 'chnCode',
                        title : '店厅编码',
                        sortable: true
                    },
                    {
                        field : 'chnName',
                        title : '店厅名称',
                        sortable: true
                    },
                    {
                        field : 'chnTypeName',
                        title : '核销金额',
                        sortable: true
                    },
                    {
                        field : 'auditState',
                        title : '核销状态',
                        sortable: true
                    },
                    {
                        field : 'bossinRcb',
                        title : '收款账户',
                        sortable: true
                    },
                    {
                        field : 'bossoutRcb',
                        title : '收款开户行',
                        sortable: true
                    },
                    {
                        field : 'factnetPaid',
                        title : '记账日期',
                        sortable: true
                    },
                    {
                        field : 'factnetRpts',
                        title : '资金用途',
                        sortable: true
                    },
                    {
                        field : 'longRpts',
                        title : '来源',
                        sortable: true
                    },
                    {
                        field : 'shortRpts',
                        title : '款龄',
                        sortable: true
                    },
                    {
                        field : 'dealCnt',
                        title : '备注',
                        sortable: true
                    },
                    {
                        title: '操作',
                        align: 'center',
                        formatter: function(value, row, index) {
                            var actions = [];
                            if(row){
                            	
                            }else{
                            	
                            }
                            actions.push('<a class="btn btn-success btn-xs ' + editFlag + '" href="#" onclick="$.operate.config(\'编辑营业日报\',\'' + row.dateNo + '\',\''+row.chnCode+'\')"><i class="fa fa-edit"></i>编辑</a> ');
                            actions.push('<a class="btn btn-danger btn-xs ' + removeFlag + '" href="#" onclick="$.operate.remove(\'' + row.dateNo + '\')"><i class="fa fa-remove"></i>审核</a>');
                            return actions.join('');
                        }
                    }]
			    };
			    $.table.init(options);
		}