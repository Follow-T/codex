package com.asiainfo.config.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.asiainfo.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 客户管理表 AU_DIM_CM_TO_CUST_INFO
 * 
 * @author changtong
 * @date 2019-07-18
 */
public class AuDimCmToCustInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 系统ID */
	private Long id;
	/** 所属机构ID */
	private Long orgid;
	/** 客户经理姓名 */
	private String customermanager;
	/** 电信银行账号 */
	private String bankaaccount;
	/** 客户单位名称 */
	private String customerunitname;
	/** 客户单位银行账号 */
	private String customerbankaccount;
	/** 客户单位银行账户名 */
	private String customeraccname;
	/** 合同号 */
	private Long pactno;
	/** 合同名称 */
	private String pactname;
	/** 资金首选用途 */
	private String firstuse;
	/** 备注信息 */
	private String remark;
	/** 创建人 */
	private Long createby;
	/** 创建时间 */
	private Date createtime;
	/** 更新人 */
	private Long lastupdateby;
	/** 更新时间 */
	private Date lastupdatetime;
	/** 可用状态标识 */
	private Integer enable;
	
	private String orgName;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setOrgid(Long orgid) 
	{
		this.orgid = orgid;
	}

	public Long getOrgid() 
	{
		return orgid;
	}
	public String getCustomermanager() {
		return customermanager;
	}

	public void setCustomermanager(String customermanager) {
		this.customermanager = customermanager;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public void setBankaaccount(String bankaaccount) 
	{
		this.bankaaccount = bankaaccount;
	}

	public String  getBankaaccount() 
	{
		return bankaaccount;
	}
	public void setCustomerunitname(String customerunitname) 
	{
		this.customerunitname = customerunitname;
	}

	public String getCustomerunitname() 
	{
		return customerunitname;
	}
	public void setCustomerbankaccount(String customerbankaccount) 
	{
		this.customerbankaccount = customerbankaccount;
	}

	public String getCustomerbankaccount() 
	{
		return customerbankaccount;
	}
	public void setCustomeraccname(String customeraccname) 
	{
		this.customeraccname = customeraccname;
	}

	public String getCustomeraccname() 
	{
		return customeraccname;
	}
	public void setPactno(Long pactno) 
	{
		this.pactno = pactno;
	}

	public Long getPactno() 
	{
		return pactno;
	}
	public void setPactname(String pactname) 
	{
		this.pactname = pactname;
	}

	public String getPactname() 
	{
		return pactname;
	}
	public void setFirstuse(String firstuse) 
	{
		this.firstuse = firstuse;
	}

	public String getFirstuse() 
	{
		return firstuse;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setCreateby(Long createby) 
	{
		this.createby = createby;
	}

	public Long getCreateby() 
	{
		return createby;
	}
	public void setCreatetime(Date createtime) 
	{
		this.createtime = createtime;
	}

	public Date getCreatetime() 
	{
		return createtime;
	}
	public void setLastupdateby(Long lastupdateby) 
	{
		this.lastupdateby = lastupdateby;
	}

	public Long getLastupdateby() 
	{
		return lastupdateby;
	}
	public void setLastupdatetime(Date lastupdatetime) 
	{
		this.lastupdatetime = lastupdatetime;
	}

	public Date getLastupdatetime() 
	{
		return lastupdatetime;
	}
	public void setEnable(Integer enable) 
	{
		this.enable = enable;
	}

	public Integer getEnable() 
	{
		return enable;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orgid", getOrgid())
            .append("customermanager", getCustomermanager())
            .append("bankaaccount", getBankaaccount())
            .append("customerunitname", getCustomerunitname())
            .append("customerbankaccount", getCustomerbankaccount())
            .append("customeraccname", getCustomeraccname())
            .append("pactno", getPactno())
            .append("pactname", getPactname())
            .append("firstuse", getFirstuse())
            .append("remark", getRemark())
            .append("createby", getCreateby())
            .append("createtime", getCreatetime())
            .append("lastupdateby", getLastupdateby())
            .append("lastupdatetime", getLastupdatetime())
            .append("enable", getEnable())
            .toString();
    }
}
