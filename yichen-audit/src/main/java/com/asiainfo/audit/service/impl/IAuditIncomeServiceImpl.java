package com.asiainfo.audit.service.impl;

import com.asiainfo.audit.mapper.AuditIncomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.audit.service.IAuditIncomeService;

import java.util.List;
import java.util.Map;

@Service
public class IAuditIncomeServiceImpl implements IAuditIncomeService {

    @Autowired
    private AuditIncomeMapper auditIncomeMapper;

    @Override
    public List<Map<String, Object>> selectIncomeList(Map<String, Object> param) {
        return auditIncomeMapper.selectIncomeList(param);
    }
}
