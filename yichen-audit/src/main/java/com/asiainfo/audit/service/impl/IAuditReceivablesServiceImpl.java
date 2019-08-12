package com.asiainfo.audit.service.impl;

import com.asiainfo.audit.mapper.AuditReceivablesMapper;
import com.asiainfo.common.constant.BusinessConstants;
import com.asiainfo.common.exception.BusinessException;
import com.asiainfo.common.utils.DateUtils;
import com.asiainfo.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.audit.service.IAuditReceivablesService;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.RelationType;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName IAuditReceivablesServiceImpl
 * @Description 应收业务接口
 * @Author zhaolijun
 * @Date 2019/7/15 10:13
 * @Version 1.0
 **/
@Service
public class IAuditReceivablesServiceImpl implements IAuditReceivablesService{

    @Autowired
    private AuditReceivablesMapper auditReceivablesMapper;

    @Override
    public List<Map<String, Object>> selectReceivableList(Map<String, Object> paramMap) {
        return auditReceivablesMapper.selectReceivableList(paramMap);
    }

    @Override
    public Map<String, Object> selectReceivableById(Map<String, Object> paramMap) {
        return auditReceivablesMapper.selectReceivableById(paramMap);
    }

    @Override
    public List<Map<String, Object>> selectYsSysByCnd(Map<String, Object> paramMap) {
        return auditReceivablesMapper.selectYsSysByCnd(paramMap);
    }

    @Override
    public List<Map<String, Object>> selectDtInfoByPage(Map<String, Object> paramMap) {
        return auditReceivablesMapper.selectDtInfoByPage(paramMap);
    }

    @Override
    public List<Map<String, Object>> findProjects() {
        return auditReceivablesMapper.findProjects();
    }

    @Transactional
    @Override
    public void insertAuRcbBossOut(Map<String, Object> paramMap) {
        Date now= DateUtils.getNowDate();
        paramMap.put("templetsid",10018);
        paramMap.put("auditstate", BusinessConstants.AUDIT_CHECK_STATE_INIT);
        paramMap.put("enable",BusinessConstants.ENABLE);
        paramMap.put("createTime",now);
        paramMap.put("lastupdateby",paramMap.get("createBy"));
        paramMap.put("lastupdatetime",now);
        try{
            int count=auditReceivablesMapper.selectDtRegisterCount(paramMap);
            if(count>=1){
                throw new BusinessException("该店厅已在"+paramMap.get("yyDate")+"登记,不能重复登记");
            }
            auditReceivablesMapper.insertAuRcbBossOut(paramMap);
           List<Map<String, Object>> proList= (List<Map<String, Object>>) paramMap.get("proList");
           for(Map<String, Object> map:proList){
               map.put("createBy",paramMap.get("createBy"));
               map.put("createTime",now);
               map.put("bossoutid",paramMap.get("id"));
               map.put("enable",BusinessConstants.ENABLE);
           }
            auditReceivablesMapper.insertAuRcbBossOutLineBatch(proList);
        }catch (BusinessException e){
            e.printStackTrace();
            throw e;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("保存登记应收信息失败");
        }
    }

    @Transactional
    @Override
    public void deleteYsDetailHand(String id) {
         try{
             auditReceivablesMapper.deleteYsDetailLineHand(id);
             auditReceivablesMapper.deleteYsDetailHand(id);
         }catch (Exception e){
             e.printStackTrace();
             throw new BusinessException("删除失败");
         }
    }

    @Override
    public List<Map<String,Object>> selectSysInProjMoneyList(Map<String, Object> map) {
        String projId= (String) map.get("projId");
        String tableName=SysInTableNameEnum.getTableName(projId);
        map.put("tableName",tableName);
        return auditReceivablesMapper.selectSysInProjMoneyList(map);
    }

    @Override
    public Map<String, Object> findYsHandInfoById(String id) {
        return auditReceivablesMapper.findYsHandInfoById(id);
    }

    @Override
    public List<Map<String, Object>> findYsHandProsInfoById(String id) {
        return auditReceivablesMapper.findYsHandProsInfoById(id);
    }

    @Override
    public void updateAuRcbBossOut(Map<String, Object> paramMap) {
        String id= String.valueOf(paramMap.get("id"));
        String userId= String.valueOf(paramMap.get("createBy"));
        try {
            Date now = DateUtils.getNowDate();
            paramMap.put("lastupdateby", userId);
            paramMap.put("lastupdatetime", now);
            auditReceivablesMapper.updateAuRcbBossOut(paramMap);

            //再删除子项
            auditReceivablesMapper.deleteYsDetailLineHand(id);
            //插入子项
            List<Map<String, Object>> proList= (List<Map<String, Object>>) paramMap.get("proList");
            for(Map<String, Object> map:proList){
                map.put("createBy",userId);
                map.put("createTime",now);
                map.put("bossoutid",id);
                map.put("enable",BusinessConstants.ENABLE);
            }
            auditReceivablesMapper.insertAuRcbBossOutLineBatch(proList);
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("修改登记应收信息失败");
        }

    }

    /**
     * 系统内的id和表映射关系
     */
     enum SysInTableNameEnum {
        AU_RCB_HALL_BILL_BOSSIN_DETAIL("10000", "AU_RCB_HALL_BILL_BOSSIN_DETAIL"),
        AU_RCB_HALL_CRM_BOSSIN_DETAIL("10001", "AU_RCB_HALL_CRM_BOSSIN_DETAIL"),
        AU_RCB_HALL_BANK_COLL_BOSSIN_DETAIL("99999", "AU_RCB_HALL_BANK_COLL_BOSSIN_DETAIL"),
        AU_RCB_HALL_LJH_BOSSIN_DETAIL("10680", "AU_RCB_HALL_LJH_BOSSIN_DETAIL");

        private String id;
        private String name;

         SysInTableNameEnum(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
        public static String getTableName(String id) {
            for (SysInTableNameEnum enums : SysInTableNameEnum.values()) {
                if (StringUtils.equals(enums.getId(),id)) {
                    return enums.getName();
                }
            }
            return "";
        }
    }
}
