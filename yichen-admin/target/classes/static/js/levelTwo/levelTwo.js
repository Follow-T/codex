	var prefix=ctx+'audit/levelTwo';
        
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
                modalName: "一级稽核",
                showExport: true,
                columns: [{
                    checkbox: true
                },
                    {
                        field : 'dateNo',
                        title : '日期',
                        visible: true
                    },{
                        field : 'latnName',
                        title : '类型',
                        sortable: true
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
                        title : '状态',
                        sortable: true
                    },
                    {
                        field : 'bossinRcb',
                        title : '系统内应收',
                        sortable: true
                    },
                    {
                        field : 'bossoutRcb',
                        title : '系统外应收',
                        sortable: true
                    },
                    {
                        field : 'factnetPaid',
                        title : '实缴',
                        sortable: true
                    },
                    {
                        field : 'factnetRpts',
                        title : '实收',
                        sortable: true
                    },
                    {
                        field : 'longRpts',
                        title : '长款',
                        sortable: true
                    },
                    {
                        field : 'shortRpts',
                        title : '短款',
                        sortable: true
                    },{
                        field : 'dealCnt',
                        title : '短款天数',
                        sortable: true
                    },
                    {
                        field : 'dealCnt',
                        title : '差异处理次数',
                        sortable: true
                    }]
			    };
			    $.table.init(options);
		}