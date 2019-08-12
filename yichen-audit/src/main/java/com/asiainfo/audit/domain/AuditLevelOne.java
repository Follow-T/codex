package com.asiainfo.audit.domain;

import com.asiainfo.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 一级稽核实体
 */
public class AuditLevelOne extends BaseEntity {

    /** 主键ID */
    private int id;
    /** 日期 */
    private String dateNo;
    /** 单位 */
    private String latnName;
    /** 店厅编码 */
    private String chnCode;
    /** 店厅名称 */
    private String chnName;
    /** 类型 */
    private String chnTypeName;
    /** 状态 */
    private String auditState;
    /** 系统内应收 */
    private Double bossinRcb;
    /** 系统外应收 */
    private Double bossoutRcb;
    /** 实缴 */
    private Double factnetPaid;
    /** 实收 */
    private Double factnetRpts;
    /** 长款 */
    private Double longRpts;
    /** 短款 */
    private Double shortRpts;
    /** 差异处理次数 */
    private Integer dealCnt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateNo(String dateNo)
    {
        this.dateNo = dateNo;
    }

    public String getDateNo()
    {
        return dateNo;
    }
    public void setLatnName(String latnName)
    {
        this.latnName = latnName;
    }

    public String getLatnName()
    {
        return latnName;
    }
    public void setChnCode(String chnCode)
    {
        this.chnCode = chnCode;
    }

    public String getChnCode()
    {
        return chnCode;
    }
    public void setChnName(String chnName)
    {
        this.chnName = chnName;
    }

    public String getChnName()
    {
        return chnName;
    }
    public void setChnTypeName(String chnTypeName)
    {
        this.chnTypeName = chnTypeName;
    }

    public String getChnTypeName()
    {
        return chnTypeName;
    }
    public void setAuditState(String auditState)
    {
        this.auditState = auditState;
    }

    public String getAuditState()
    {
        return auditState;
    }
    public void setBossinRcb(Double bossinRcb)
    {
        this.bossinRcb = bossinRcb;
    }

    public Double getBossinRcb()
    {
        return bossinRcb;
    }
    public void setBossoutRcb(Double bossoutRcb)
    {
        this.bossoutRcb = bossoutRcb;
    }

    public Double getBossoutRcb()
    {
        return bossoutRcb;
    }
    public void setFactnetPaid(Double factnetPaid)
    {
        this.factnetPaid = factnetPaid;
    }

    public Double getFactnetPaid()
    {
        return factnetPaid;
    }
    public void setFactnetRpts(Double factnetRpts)
    {
        this.factnetRpts = factnetRpts;
    }

    public Double getFactnetRpts()
    {
        return factnetRpts;
    }
    public void setLongRpts(Double longRpts)
    {
        this.longRpts = longRpts;
    }

    public Double getLongRpts()
    {
        return longRpts;
    }
    public void setShortRpts(Double shortRpts)
    {
        this.shortRpts = shortRpts;
    }

    public Double getShortRpts()
    {
        return shortRpts;
    }
    public void setDealCnt(Integer dealCnt)
    {
        this.dealCnt = dealCnt;
    }

    public Integer getDealCnt()
    {
        return dealCnt;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("dateNo", getDateNo())
                .append("latnName", getLatnName())
                .append("chnCode", getChnCode())
                .append("chnName", getChnName())
                .append("chnTypeName", getChnTypeName())
                .append("auditState", getAuditState())
                .append("bossinRcb", getBossinRcb())
                .append("bossoutRcb", getBossoutRcb())
                .append("factnetPaid", getFactnetPaid())
                .append("factnetRpts", getFactnetRpts())
                .append("longRpts", getLongRpts())
                .append("shortRpts", getShortRpts())
                .append("dealCnt", getDealCnt())
                .toString();
    }
}
