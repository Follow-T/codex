package com.asiainfo.audit.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface IAuditIncomeService {

    /**
     * 条件分页-查询实缴列表
     * @param param
     * @return
     */
    List<Map<String,Object>> selectIncomeList(Map<String,Object> param);

}
