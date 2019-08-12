package com.asiainfo.audit.service.impl;

import com.asiainfo.audit.domain.AuditLevelOne;
import com.asiainfo.audit.mapper.AuditLevelOneMapper;
import com.asiainfo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.audit.service.IAuditLevelOneService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 一级稽核业务层
 */
@Service
public class AuditLevelOneServiceImpl implements IAuditLevelOneService {

    @Autowired
    private AuditLevelOneMapper auditLevelOneMapper;

    @Override
    public List<Map<String,Object>> selectAuditLevelOneList(AuditLevelOne auditLevelOne) {
        return auditLevelOneMapper.selectAuditLevelOneList(auditLevelOne);
    }

    @Override
    public Map<String,Object> selectOneLevelById(int id) {
        return auditLevelOneMapper.selectOneLevelById(id);
    }

    @Override
    public List<Map<String, Object>> selectYsListByCnd(AuditLevelOne auditLevelOne) {
        return auditLevelOneMapper.selectYsListByCnd(auditLevelOne);
    }

    @Override
    public List<Map<String, Object>> selectSjListByCnd(AuditLevelOne auditLevelOne) {
        return auditLevelOneMapper.selectSjListByCnd(auditLevelOne);
    }

    @Override
    public List<Map<String, Object>> selectCdListByCnd(Map<String, Object> param) {
        return auditLevelOneMapper.selectCdListByCnd(param);
    }

    @Override
    public List<Map<String, Object>> selectOneLevelCheckHisInfo(int id) {
        return auditLevelOneMapper.selectOneLevelCheckHisInfo(id);
    }

    @Override
    public void saveOneLevelCheck(Map<String, Object> param) {
        Date now= DateUtils.getNowDate();
        param.put("create_time",now);
        param.put("update_time",now);
        auditLevelOneMapper.saveOneLevelCheck(param);
    }
}
