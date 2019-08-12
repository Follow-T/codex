package com.asiainfo.audit.service;

import com.asiainfo.audit.domain.AuditLevelOne;

import java.util.List;
import java.util.Map;

public interface IAuditLevelOneService {

    /**
     * 分页查询一级稽核
     * @param auditLevelOne
     * @return
     */
    List<Map<String,Object>> selectAuditLevelOneList(AuditLevelOne auditLevelOne);

    /**
     * 根据ID查询一级稽核信息表
     * @param id 主键ID
     * @return
     */
    Map<String,Object> selectOneLevelById(int id);

    /**
     * 分页查询一级稽核----应收列表
     * @param auditLevelOne
     * @return
     */
    List<Map<String,Object>> selectYsListByCnd(AuditLevelOne auditLevelOne);

    /**
     * 分页-查询某个厅店某天的实缴集合
     * @param auditLevelOne 查询条件
     * @return 实缴集合
     */
    List<Map<String,Object>> selectSjListByCnd(AuditLevelOne auditLevelOne);

    /**
     * 分页-查询长短款集合
     * @param param
     * @return
     */
    List<Map<String,Object>>  selectCdListByCnd(Map<String,Object> param);

    /**
     * 查询一级稽核-审批历史信息
     * @param id
     * @return
     */
    List<Map<String,Object>>  selectOneLevelCheckHisInfo(int id);

    /**
     * 保存稽核状态
     * @param param 稽核信息
     */
    void saveOneLevelCheck(Map<String,Object> param);
}
