var prefix=ctx+'audit/receivables';
$(function() {
    receivables.bindEvent();
    receivables.initTable();
});

var receivables={
    /**
     * 绑定事件
     */
    bindEvent:function(){
        $("#registerBen").click(function(){
            receivables.showAddDialog();
        });
    },
    /**
     * 刷新主表
     */
    refreshTable:function(){
        $.table.search("receiveables-form");
     },
    initTable: function(){
                var options = {
                	url: prefix + "/list",
                    createUrl:prefix+"/add",
                    sortName: "code_",
                    sortOrder: "desc",
                    modalName: "应收",
                    showExport : false,
                    search: false,
                    showSearch: false,
                    showPageGo: false,
                    showRefresh: false,
                    showColumns: false,
                    showToggle: false,
                    columns: [{
                        checkbox: true
                    },
                        {
                            field: 'hallid_',
                            title: 'ID',
                            visible: false
                        },
                        {
                            field: 'hall_type_name',
                            title: '类型'
                        },
                        {
                            field: 'code_',
                            title: '店厅编码',
                            sortable: true
                        },
                        {
                            field: 'name_',
                            title: '店厅名称'
                        },
                        {
                            field: 'businessdate_',
                            title: '营业厅日期'
                        },
                        {
                            field: 'amount_',
                            title: '应收',
                            formatter: function (value, row, index) {
                                return '<a href="javascript:void(0);" class="addr-url" onclick="receivables.showYsDetailDialog(\''+row.hallid_+'\',\''+row.businessdate_+'\',1)">'+value+'</a>'
                            }
                        },
                        {
                            field: 'incomeamount_',
                            title: '收入金额'
                        },
                        {
                            field: 'backamount_',
                            title: '补退金额'
                        },{
                            field: 'auditstate_cn',
                            title: '状态'
                        },{
                            field: 'auditstate_',
                            title: '业业稽核',
                            formatter: function (value, row, index) {
                                return '<a href="javascript:void(0);" class="addr-url" onclick="receivables.showYsDetailDialog(\''+row.hallid_+'\',\''+row.businessdate_+'\',2)">'+value+'</a>'
                            }
                        },
                        {
                            field: 'auditstate_',
                            title: '备注'
                        }]
                };
                $.table.init(options);
            },
    showYsDetailDialog:function(id,dateNo,type){
        $.modal.openWin({
            type:2,
            title:type==1?"应收查看":"业业稽核查看",
            btn: ['关闭'],
            content: prefix+"/detail/"+id+"/"+dateNo,
            yes: function(index, layero){
                layer.close(index);
                $.table.search("receiveables-form");

            },
            cancel:function(index, layero){
                layer.close(index);
                $.table.search("receiveables-form");
            },
        });
    },
    /**
     * 验证和保存登记数据到库里
     */
    addRegisterToDb:function(index){
        var recordInfo={},flag=true,inSum=0;outSum=0
        recordInfo.dtCode=$("#dtNameSel").data("code");
        recordInfo.yyDate=$("#yyDate").val();
        recordInfo.sumMoney=$("#sumMoney").val();
        if($.common.isEmpty(recordInfo.dtCode)){
            $.modal.msgError("请选择选择厅店");
           return false;
        }
        if($.common.isEmpty(recordInfo.yyDate)){
            $.modal.msgError("请选择营业日期");
            return false;
        }
        var datas=$('#outerSysRecordTable').bootstrapTable('getData',false);
        recordInfo.prosJson=JSON.stringify(datas);
        for(var i=0;i<datas.length;i++){
            if($.common.isEmpty(datas[i].proId)){
                flag=false;
                break;
            }
            inSum+=parseFloat(datas[i].incomeAmount);
            outSum+=parseFloat(datas[i].backAmount);
        }
        if(!flag){
            $.modal.msgError("请选择项目");
            return false;
        }
        recordInfo.inSum=inSum;
        recordInfo.outSum=outSum;
        $.modal.loading("正在保存，请稍后...");
        $.post(prefix+"/insertAuRcbBossOut", recordInfo, function (result) {
            if(result.code == web_status.SUCCESS) {
                $.modal.msgSuccess("登记成功！");
                layer.close(index);
                $.table.search("receiveables-form");
            } else {
                $.modal.msgError(result.msg);
            }
            $.modal.closeLoading();
        });
    },
    showAddDialog:function(){
        $.modal.openWin({
            type:1,
            title:"登记",
            area:['900px',($(window).height() - 50)+"px"],
            btn: ['确定','关闭'],
            zIndex:11,
            content: '<div id="registerbox"></div>',
            yes: function(index, layero){
                //获取register的数据
                receivables.addRegisterToDb(index);
            },
            cancel:function(index, layero){
                layer.close(index);
            },
            success:function(){
                $("#registerbox").load(prefix+'/add');
            }
        });
    },
    /**
     * 显示应收查看二级详情页面
     */
    showYsSubDetail:function(dateNo,dtId,projId){
        $.modal.openWin({
            type:2,
            title:"明细查看",
            btn: ['关闭'],
            content: prefix+"/subDetail/"+dateNo+"/"+dtId+"/"+projId,
            yes: function(index, layero){
                layer.close(index);
            }
        });
    }
}