package com.asiainfo.audit.mapper;

import com.asiainfo.audit.domain.AuditLevelOne;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Component
public interface AuditLevelOneMapper {

    /**
     * 分页条件：获取一级稽核列表
     * @param auditLevelOne 查询条件
     * @return  一级稽核列表
     */
    List<Map<String,Object>> selectAuditLevelOneList(AuditLevelOne auditLevelOne);

    /**
     * 根据ID查询一级稽核信息表
     * @param id 主键id
     * @return
     */
    Map<String,Object> selectOneLevelById(@Param("id") int id);

    /**
     * 分页-查询某个厅店某天的应收集合
     * @param auditLevelOne 查询条件
     * @return 应收集合
     */
    List<Map<String,Object>> selectYsListByCnd(AuditLevelOne auditLevelOne);

    /**
     * 分页-查询某个厅店某天的实缴集合
     * @param auditLevelOne 查询条件
     * @return 实缴集合
     */
    List<Map<String,Object>> selectSjListByCnd(AuditLevelOne auditLevelOne);

    /**
     * 分页-查询长短款冲销集合
     * @param param
     * @return
     */
    List<Map<String,Object>>  selectCdListByCnd(Map<String,Object> param);

    /**
     * 查询一级稽核-审批历史信息
     * @param id
     * @return
     */
    List<Map<String,Object>>  selectOneLevelCheckHisInfo(@Param("id") int id);

    /**
     * 保存稽核状态
     * @param param 稽核信息
     */
    void saveOneLevelCheck(Map<String,Object> param);

}
