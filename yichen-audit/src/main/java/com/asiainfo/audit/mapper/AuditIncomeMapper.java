package com.asiainfo.audit.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName AuditIncomeMapper
 * @Description 实缴Dao层
 * @Author zhaolijun
 * @Date 2019/7/19 9:53
 * @Version 1.0
 **/
@Repository
public interface AuditIncomeMapper {

    /**
     * 条件分页-查询实缴列表
     * @param param
     * @return
     */
    List<Map<String,Object>> selectIncomeList(Map<String,Object> param);
}
