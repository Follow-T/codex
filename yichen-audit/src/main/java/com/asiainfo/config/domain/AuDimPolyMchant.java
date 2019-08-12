package com.asiainfo.config.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.asiainfo.common.core.domain.BaseEntity;

/**
 * 聚合支付表 AU_DIM_POLY_MCHANT
 * 
 * @author changtong
 * @date 2019-07-17
 */
public class AuDimPolyMchant extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 所属机构ID */
	private Integer orgId;
	/** 机构名称 */
	private String orgName;
	/** 聚合支付商户号 */
	private String mchantId;
	/** 银行结算账户 */
	private Long settlementBankAcct;

	public void setOrgId(Integer orgId) 
	{
		this.orgId = orgId;
	}

	public Integer getOrgId() 
	{
		return orgId;
	}
	public void setOrgName(String orgName) 
	{
		this.orgName = orgName;
	}

	public String getOrgName() 
	{
		return orgName;
	}
	public void setMchantId(String mchantId) 
	{
		this.mchantId = mchantId;
	}

	public String getMchantId() 
	{
		return mchantId;
	}
	public void setSettlementBankAcct(Long settlementBankAcct) 
	{
		this.settlementBankAcct = settlementBankAcct;
	}

	public Long getSettlementBankAcct() 
	{
		return settlementBankAcct;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orgId", getOrgId())
            .append("orgName", getOrgName())
            .append("mchantId", getMchantId())
            .append("settlementBankAcct", getSettlementBankAcct())
            .toString();
    }
}
