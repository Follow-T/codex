/**
 *@JS subDetail.js
 *@Description TODO
 *@Author zhaolijun
 *@Date 2019/7/17 11:34
 *@Version 1.0
 **/
$(function(){
    $("#searchBtn").click(function(){
        var dtCode=$("#dtCodeInput").val();
        var lsh=$("#lsh").val();
        var yyygh=$("#yyygh").val();
        var param={
            "dateNo":dateNo,
            "projId":projId,
            "dtId":dtId,
            "dtCode":dtCode,
            "type":"1",
            "lsh":lsh,
            "yyygh":yyygh
        };
        $("#incomeTable").bootstrapTable('refresh', param);
        param.type="2";
        $("#outTable").bootstrapTable('refresh', param);
    });
    //渲染收入表
    subDetail.initIncomeTable(1);
    subDetail.initIncomeTable(2);
});
var subDetail={
    config:{
        prefix:ctx+'audit/receivables'
    },
    initIncomeTable:function(type){
        var eleId=type==1?"#incomeTable":"#outTable";
        $(eleId).bootstrapTable({
            url:subDetail.config.prefix+"/listInOutMoneys",
            contentType: "application/x-www-form-urlencoded",   // 编码类型
            method: 'post',                                     // 请求方式（*）
            pagination: true,                     // 是否显示分页（*）
            sidePagination: "client",
            pageNumber: 1,                                      // 初始化加载第一页，默认第一页
            pageSize: 5,                         // 每页的记录行数（*）
            pageList: [5, 10],
            cache: false,                                       // 是否使用缓存
            striped: false,                           // 是否显示行间隔色
            sortable: true,                                     // 是否启用排序
            sortStable: true,                                   // 设置为 true
            escape: false,                             // 转义HTML字符串
            showFooter: false,                     // 是否显示表尾
              queryParams:function (params){
                  var dtCode=$("#dtCodeInput").val();
                  var lsh=$("#lsh").val();
                  var yyygh=$("#yyygh").val();
                var map={
                    "dateNo":dateNo,
                    "projId":projId,
                    "dtId":dtId,
                    "dtCode":dtCode,
                    "lsh":lsh,
                    "yyygh":yyygh,
                    "type":type==1?"1":"2"
                }
                return map;
              },
            columns: [
                {
                    title: '序号',
                    formatter:function(value,row,index){
                        return index+1;
                    }
                },
                {
                    field: 'businessdate_',
                    title: '日期'
                },
                {
                    field: 'code_',
                    title: '渠道编码'
                },
                {
                    field: 'name_',
                    title: '渠道名称'
                },
                {
                    field: 'staff_id',
                    title: '营业员工号'
                },
                {
                    field: 'staff_name',
                    title: '营业员名称'
                },
                {
                    field: 'itemname_',
                    title: '款项类别'
                },
                {
                    field: 'amount_',
                    title: '全额'
                },
                {
                    field: 'pay_type_name',
                    title: '款项方式'
                },
                {
                    field: 'mobile_no',
                    title: '手机号'
                },
                {
                    field: 'tradeno',
                    title: '流水号'
                },
                {
                    field: 'order_no',
                    title: '购物车号'
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
    }
}
