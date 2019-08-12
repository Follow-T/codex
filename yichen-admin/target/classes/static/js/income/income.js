	var prefix=ctx+'audit/income';
       
		$(function() {
			initTable();
		});
		
		function initTable(){
			var options = {
				url: prefix + "/list",
			    sortName: "businessdate_",
			    sortOrder: "desc",
                modalName: "实缴",
                showExport: true,
                columns: [{
                    checkbox: true
                },
                    {
                        field : 'hall_type_name',
                        title : '类型',
                        visible: true
                    },
                    {
                        field : 'code_',
                        title : '店厅编码',
                        sortable: true
                    },
                    {
                        field : 'hall_name',
                        title : '店厅名称',
                        sortable: true
                    },
                    {
                        field : 'businessdate_',
                        title : '营业日期',
                        sortable: true
                    },
                    {
                        field : 'amount_',
                        title : '实缴款',
                        sortable: true
                    },
                    {
                        field : 'dict_label',
                        title : '状态',
                        sortable: true
                    },
                    {
                        field : 'system_src',
                        title : '来源'
                    }]
			    };
			    $.table.init(options);
		}