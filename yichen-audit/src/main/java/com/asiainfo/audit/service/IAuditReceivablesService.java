package com.asiainfo.audit.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * @InterfaceName IAuditReceivablesService
 * @Description 应收业务接口
 * @Author zhaolijun
 * @Date 2019/7/15 10:13
 * @Version 1.0
 **/
public interface IAuditReceivablesService {

    /**
     * 应收分页查询
     * @param paramMap
     * @return
     */
    List<Map<String,Object>> selectReceivableList(Map<String,Object> paramMap);

    /**
     * 根据厅店id和营业时间查询应收信息
     * @param paramMap
     * @return 应收信息
     */
    Map<String,Object> selectReceivableById(Map<String,Object> paramMap);

    /**
     * 分系统查询应收明细
     * @param paramMap
     * @return
     */
    List<Map<String,Object>> selectYsSysByCnd(Map<String,Object> paramMap);


    /**
     * 分页模糊查询厅店信息
     * @param paramMap
     * @return
     */
    List<Map<String,Object>> selectDtInfoByPage(Map<String,Object> paramMap);

    /**
     * 查询应收登记的项目
     * @return
     */
    List<Map<String,Object>> findProjects();

    /**
     * 保存应收手工登记信息
     * @param paramMap
     */
    void insertAuRcbBossOut(Map<String,Object> paramMap);

    /**
     * 删除手工登记的应收数据
     * @param id 主键ID
     */
    void deleteYsDetailHand(@Param("id") String id);

    /**
     * 查询收入列表和补退列表
     * @param map
     * @return
     */
    List<Map<String,Object>> selectSysInProjMoneyList(Map<String,Object> map);


    /**
     * 根据id查询手工工等级信息
     * @param id 主键ID
     * @return
     */
    Map<String,Object> findYsHandInfoById(@Param("id") String id);

    /**
     * 查询项目信息
     * @param id
     * @return
     */
    List<Map<String,Object>> findYsHandProsInfoById(@Param("id") String id);

    /**
     * 修改应收手工登记信息
     * @param map
     */
    void updateAuRcbBossOut(Map<String,Object> map);
}
