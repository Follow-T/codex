/**
 *@JS edit.js
 *@Description TODO
 *@Author zhaolijun
 *@Date 2019/7/15 19:33
 *@Version 1.0
 **/
var dtEditObj={
    config:{
        prefix:ctx+'audit/receivables',
        index:0,
        projectOptions:""
    },

    /**
     * 统一厅店绑定事件
     */
    bindEvent:function(){
        $("#searchDtBtn").click(function(){
            dtEditObj.showDtDialog();
        });
        $("#projectAddBtn").click(function(){
            dtEditObj.addOneProjectRow();
        });

        //绑定输入框与table 字段的关系
        $("#outerSysRecordTable").delegate("input",'blur',function(){
            var name=$(this).attr('name');
            var uniqueId=$($(this).parentsUntil('tbody')[1]).data("uniqueid");
            var row=$('#outerSysRecordTable').bootstrapTable('getRowByUniqueId',uniqueId);
            row[name]=$(this).val();
            if(name=='ysAmount'){
                var datas=$('#outerSysRecordTable').bootstrapTable('getData',false);
                var sum=0;
                $.each(datas,function(i,v){
                    sum+=parseFloat(v.ysAmount);
                });
                $("#sumMoney").val(sum);
            }
        });
        //绑定输入框与table 字段的关系
        $("#outerSysRecordTable").delegate("select",'change',function(){
            var name=$(this).attr('name');
            var uniqueId=$($(this).parentsUntil('tbody')[1]).data("uniqueid");
            var row=$('#outerSysRecordTable').bootstrapTable('getRowByUniqueId',uniqueId);
            row[name]=$(this).val();
        })
    },
    /**
     * 初始化layui元素
     */
    initEle:function(){
        layui.use('laydate', function(){
            var laydate = layui.laydate;

            //执行一个laydate实例
            laydate.render({
                elem: '#yyDate' //指定元素
            });
        });
    },
    /**
     * 显示厅店搜索弹窗
     */
    showDtDialog:function(){
        $.modal.openWin({
            type:1,
            title:"店厅查询",
            area:['600px','450px'],
            btn: ['确定','关闭'],
            zIndex:11,
            content: '<div id="dtContent"></div>',
            yes: function(index, layero){
                //获取选择的店厅
                var sels=$("#dtTable").bootstrapTable('getSelections');
                if(sels && sels.length==1) {
                    $("#dtNameSel").val(sels[0].dtName);
                    $("#dtNameSel").data('code',sels[0].dtCode);
                }
                layer.close(index);

            },
            cancel:function(index, layero){
                layer.close(index);
            },
            success:function(){
                $("#dtContent").load(prefix+'/getDtSearchHtml');
            }
        });
    },
    initOuterSysRecordTable:function(){
        var cols= [
                {
                    field: 'id',
                    title: '序号',
                    formatter:function(value,row,index){
                        return index+1;
                    }
                },
                {
                    field: 'proId',
                    title: '项目名称',
                    width: 150,
                    formatter:function(value,row,index){
                        if(type == '2'){
                            return row.proName;
                        }else {
                            var arr = [
                                ' <select class="pro-sel layui-input form-control" name="proId"  id="proName' + row.id + '" >',
                                '<option value="">请选择</option>',
                                dtEditObj.getProjectOptions(),
                                '</select>'
                            ]
                            return arr.join(' ');
                        }
                    }
                },
                {
                    field: 'ysAmount',
                    title: '系统应收款',
                    formatter:function(value,row,index){
                        if(type == '2'){
                            return value;
                        }else {
                            return '<input type="number" name="ysAmount" class="layui-input table-input form-control" value="' + (value ? value : 0) + '">';
                        }
                    }
                },
                {
                    field: 'incomeAmount',
                    title: '收款金额',
                    formatter:function(value,row,index){
                        if(type == '2'){
                            return value;
                        }else {
                            return '<input type="number" name="incomeAmount" class="layui-input table-input form-control" value="' + (value ? value : 0) + '">';

                        }
                    }

                },
                {
                    field: 'backAmount',
                    title: '退款金额',
                    formatter:function(value,row,index){
                        if(type == '2'){
                            return value;
                        }else {
                            return '<input type="number" name="backAmount" class="layui-input table-input form-control" value="' + (value ? value : 0) + '">';
                        }
                    }
                },
                {
                    field: 'paytype',
                    title: '收款方式',
                    formatter:function(value,row,index){
                        if(type == '2'){
                            return value;
                        }else {
                            return '<input type="text" name="paytype" class="layui-input table-input form-control" value="' + (value ? value : '') + '">';

                        }
                    }
                },
                {
                    field: 'remark',
                    title: '备注',
                    formatter:function(value,row,index){
                        if(type == '2'){
                            return value;
                        }else {
                            return '<input type="text" name="remark" class="layui-input table-input form-control" value="' + (value ? value : '') + '">';
                        }
                    }
                }];

         if(type=='3'){
             cols.push({
                    field: 'id',
                    title: '操作',
                    formatter:function(value,row,index){
                        return '<a href="javascript:void(0);" id="projectAddBtn" onclick="dtEditObj.removeOneProjectRow(\''+value+'\')"><i class="fa fa-minus-square-o project-minus" aria-hidden="true" style="float:right"></i> </a>';
                    }
                });
        }
        $('#outerSysRecordTable').bootstrapTable({
            data:propsInfo,
            height:300,
            cache: false,                                       // 是否使用缓存
            striped: false,                           // 是否显示行间隔色
            sortable: true,                                     // 是否启用排序
            sortStable: true,                                   // 设置为 true
            // desc
            pagination: false,                     // 是否显示分页（*）
            escape: false,                             // 转义HTML字符串
            showFooter: false,                     // 是否显示表尾
            uniqueId:'id',
            columns:cols,
            onPostBody:function(datas){
                    if(datas) {
                        $.each(datas, function (i, v) {
                            if (v.proId) {
                                $("#proName" + v.id).val(v.proId);
                            }
                        });
                    }
            }
        });
    },
    removeOneProjectRow:function(id){
        var datas=$('#outerSysRecordTable').bootstrapTable('getData',false);
        if(datas.length==1){
            $.modal.msgError("至少要有一条项目信息");
            return false;
        }
        $('#outerSysRecordTable').bootstrapTable('removeByUniqueId',id);
    },
    addOneProjectRow:function(){
        //初始化一条记录
        dtEditObj.config.index=dtEditObj.config.index+1;
        console.log( dtEditObj.config.index);
        $('#outerSysRecordTable').bootstrapTable('insertRow',{
            index:dtEditObj.config.index,
            row:{
                id:dtEditObj.config.index,
                proId:"",
                ysAmount:0,
                incomeAmount:0,
                backAmount:0,
                paytype:'',
                remark:''
            }
        });
        /*   layui.use('form', function(){
               var form = layui.form;
               //根据的type类型修改
               form.render('select','proName'+dtEditObj.config.index);
           });*/
    },
    getProjectOptions:function(){
        if($.common.isNotEmpty(dtEditObj.config.projectOptions)){
            return dtEditObj.config.projectOptions;
        }else{
            var arr=[];
            $.each(projects,function(i,v){
                arr.push('<option value="'+v.code+'">'+v.name+'</option>');
            });
            dtEditObj.config.projectOptions=arr.join('');
            return dtEditObj.config.projectOptions;
        }
    },
    /**
     * 提交注册修改
     */
    submitRegisterUpdate:function(layerIndex){
        var recordInfo={},flag=true,inSum=0,outSum=0,sumMoney=0;
        recordInfo.id=id;
        var datas=$('#outerSysRecordTable').bootstrapTable('getData',false);
        recordInfo.prosJson=JSON.stringify(datas);
        for(var i=0;i<datas.length;i++){
            if($.common.isEmpty(datas[i].proId)){
                flag=false;
                break;
            }
            inSum+=parseFloat(datas[i].incomeAmount);
            outSum+=parseFloat(datas[i].backAmount);
            sumMoney+=parseFloat(datas[i].ysAmount);
        }
        if(!flag){
            $.modal.msgError("请选择项目");
            return false;
        }
        recordInfo.sumMoney=sumMoney;
        recordInfo.inSum=inSum;
        recordInfo.outSum=outSum;
        console.log(recordInfo);
        $.modal.loading("正在保存，请稍后...");
        $.post(dtEditObj.config.prefix+"/updateAuRcbBossOut", recordInfo, function (result) {
            if(result.code == web_status.SUCCESS) {
                $.modal.msgSuccess("修改成功！");
                    var childWin = parent.document.getElementsByTagName('iframe')[0].contentWindow;
                    //调用兄弟页面对象
                    childWin.ysDetail.refreshTable();
                    parent.layer.close(layerIndex);
            } else {
                $.modal.msgError(result.msg);
            }
            $.modal.closeLoading();
        });
    }
}
$(function(){
    dtEditObj.initEle();
    dtEditObj.bindEvent();
    dtEditObj.initOuterSysRecordTable();
    dtEditObj.config.index=propsInfo.length+1;
});