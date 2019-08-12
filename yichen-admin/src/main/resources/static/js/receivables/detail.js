/**
 *@JS detail.js
 *@Description TODO
 *@Author zhaolijun
 *@Date 2019/7/15 14:52
 *@Version 1.0
 **/

$(function(){
    ysDetail.initTable();
});

var ysDetail={
    config:{
        prefix:ctx+'audit/receivables'
    },
    refreshTable:function(){
        $("#ysSystemTable").bootstrapTable('refresh', {});
    },
    showYsSubDetail:function(projId,type){
        if(type==1){
            parent.receivables.showYsSubDetail(dateNo,dtId,projId);
        }else{
            ysDetail.showYsHandlePage(projId,type);
        }
    },
    showYsHandlePage:function(id,type){
        if(type==2){
            $.modal.openWinParent({
                type:2,
                title:"查看(手工登记)",
                area:['900px',($(parent.window).height() - 50)+"px"],
                btn: ['关闭'],
                content: ysDetail.config.prefix+"/edit/"+id+"/"+type,
                yes: function(index, layero){
                    parent.layer.close(index);
                },
                cancel:function(index, layero){
                    parent.layer.close(index);
                },
            });
        }else{
            $.modal.openWinParent({
                type:2,
                title:"修改(手工登记)",
                area:['900px',($(parent.window).height() - 50)+"px"],
                btn: ['确定','关闭'],
                content: ysDetail.config.prefix+"/edit/"+id+"/"+type,
                yes: function(index, layero){
                    var childWin = parent.document.getElementsByTagName('iframe')[1].contentWindow;
                    //调用子页面对象
                    childWin.dtEditObj.submitRegisterUpdate(index);
                },
                cancel:function(index, layero){
                    parent.layer.close(index);
                },
            });
        }
    },
    initTable:function(){
        $('#ysSystemTable').bootstrapTable({
            url: ysDetail.config.prefix+"/listYsSys",                                   // 请求后台的URL（*）
            contentType: "application/x-www-form-urlencoded",   // 编码类型
            method: 'post',                                     // 请求方式（*）
            cache: false,                                       // 是否使用缓存
            striped: false,                           // 是否显示行间隔色
            sortable: true,                                     // 是否启用排序
            sortStable: true,                                   // 设置为 true
            // desc
            pagination: false,                     // 是否显示分页（*）
            escape: false,                             // 转义HTML字符串
            showFooter: false,                     // 是否显示表尾
            uniqueId:'id',
            queryParams:{
                "id":dtId,
                "yyDate":dateNo
            },
            columns: [
                {
                    title: '序号',
                    formatter:function(value,row,index){
                        return index+1;
                    }
                },
                {
                    field: 'itemname_',
                    title: '项目名称'
                },
                {
                    field: 'amount_',
                    title: '系统应收款',
                    formatter: function (value, row, index) {
                        if(row.data_src=='系统外'){
                            return '<a href="javascript:void(0);" class="addr-url" onclick="ysDetail.showYsSubDetail(\''+row.id+'\',2)">'+value+'</a>'
                        }else{
                            return '<a href="javascript:void(0);" class="addr-url" onclick="ysDetail.showYsSubDetail(\''+row.itemid_+'\',1)">'+value+'</a>'
                        }

                    }
                },
                {
                    field: 'incomeamount_',
                    title: '收款金额'
                },
                {
                    field: 'backamount_',
                    title: '补退金额'
                },
                {
                    field: 'data_src',
                    title: '数据来源'
                },
                {
                    title: '操作',
                    formatter: function (value, row, index) {
                        if(row.data_src=='系统外'){
                        var html=[
                            '<div class="flex-sp-vcenter">',
                            '<a class="'+editFlag+'" onclick="ysDetail.showYsSubDetail(\''+row.id+'\',3)"><i class="fa fa-edit edit-icon"></i></a>',
                            '<a class="'+removeFlag+'" onclick="ysDetail.removeYs(\''+row.id+'\')"><i class="fa fa-remove remove-icon"></i></a>',
                            '</div>',
                        ];
                        return html.join('');
                        }else{
                            return '-';
                        }
                    }
                }],
            responseHandler:  function (res) {
                if(res.code == 0) {
                    return res.rows;
                } else {
                    $.modal.alertWarning(res.msg);
                    return { rows: [], total: 0 };
                }
            }
        });
    },
    /**
     * 刪除手工应收
     * @param id 主键ID
     */
    removeYs:function(id){
        $.modal.confirm("确定删除该条登记信息吗？", function () {
            $.post(ysDetail.config.prefix+"/deleteYsDetailHand/"+id, null, function (result) {
                if(result.code == web_status.SUCCESS) {
                    $.modal.msgSuccess("删除成功！");
                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(index); //再执行关闭
                    $("#ysSystemTable").bootstrapTable('refresh', {});
                } else {
                    $.modal.msgError(result.msg);
                }
                $.modal.closeLoading();
            });
        });
    }
}