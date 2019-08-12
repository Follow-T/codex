package com.asiainfo.config.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.asiainfo.common.core.domain.BaseEntity;

/**
 * 银行账户表 AU_BANK_ACCOUNT
 * 
 * @author changtong
 * @date 2019-07-16
 */
public class AuBankAccount extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 自增序列ID */
	private Long id;
	/** 账户号 */
	private String accno;
	/** 开户人名称 */
	private String name;
	/** 部门ID */
	private Long orgid;
	/** 银行编号 */
	private Long bankid;
	/** 开户行名称 */
	private String openbankname;
	/** parentmode_ */
	private String parentmode;
	/** currencyid_ */
	private Long currencyid;
	/** areaid_ */
	private Long areaid;
	/** accattributeid_ */
	private Long accattributeid;
	/** accounttype_ */
	private String accounttype;
	/** parentbankaccid_ */
	private Long parentbankaccid;
	/** isopenwebbank_ */
	private String isopenwebbank;
	/** accstate_ */
	private String accstate;
	/** 余额 */
	private BigDecimal balance;
	/** initdate_ */
	private Date initdate;
	/** 备注 */
	private String remark;
	/** 创建人 */
	private Long createby;
	/** 创建时间 */
	private Date createtime;
	/** 更新人 */
	private Long lastupdateby;
	/** 更新时间 */
	private Date lastupdatetime;
	/** 可用标识 */
	private Integer enable;
	/** warnuserids_ */
	private String warnuserids;
	/** misaccountname_ */
	private String misaccountname;
	/** biinitdate_ */
	private Date biinitdate;
	/** bibalance_ */
	private BigDecimal bibalance;
	/** allowsplit_ */
	private Integer allowsplit;
	
	private String orgName;
	
	private String bankName;
	
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setAccno(String accno) 
	{
		this.accno = accno;
	}

	public String getAccno() 
	{
		return accno;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setOrgid(Long orgid) 
	{
		this.orgid = orgid;
	}

	public Long getOrgid() 
	{
		return orgid;
	}
	public void setBankid(Long bankid) 
	{
		this.bankid = bankid;
	}

	public Long getBankid() 
	{
		return bankid;
	}
	public void setOpenbankname(String openbankname) 
	{
		this.openbankname = openbankname;
	}

	public String getOpenbankname() 
	{
		return openbankname;
	}
	public void setParentmode(String parentmode) 
	{
		this.parentmode = parentmode;
	}

	public String getParentmode() 
	{
		return parentmode;
	}
	public void setCurrencyid(Long currencyid) 
	{
		this.currencyid = currencyid;
	}

	public Long getCurrencyid() 
	{
		return currencyid;
	}
	public void setAreaid(Long areaid) 
	{
		this.areaid = areaid;
	}

	public Long getAreaid() 
	{
		return areaid;
	}
	public void setAccattributeid(Long accattributeid) 
	{
		this.accattributeid = accattributeid;
	}

	public Long getAccattributeid() 
	{
		return accattributeid;
	}
	public void setAccounttype(String accounttype) 
	{
		this.accounttype = accounttype;
	}

	public String getAccounttype() 
	{
		return accounttype;
	}
	public void setParentbankaccid(Long parentbankaccid) 
	{
		this.parentbankaccid = parentbankaccid;
	}

	public Long getParentbankaccid() 
	{
		return parentbankaccid;
	}
	public void setIsopenwebbank(String isopenwebbank) 
	{
		this.isopenwebbank = isopenwebbank;
	}

	public String getIsopenwebbank() 
	{
		return isopenwebbank;
	}
	public void setAccstate(String accstate) 
	{
		this.accstate = accstate;
	}

	public String getAccstate() 
	{
		return accstate;
	}
	public void setBalance(BigDecimal balance) 
	{
		this.balance = balance;
	}

	public BigDecimal getBalance() 
	{
		return balance;
	}
	public void setInitdate(Date initdate) 
	{
		this.initdate = initdate;
	}

	public Date getInitdate() 
	{
		return initdate;
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
	public void setWarnuserids(String warnuserids) 
	{
		this.warnuserids = warnuserids;
	}

	public String getWarnuserids() 
	{
		return warnuserids;
	}
	public void setMisaccountname(String misaccountname) 
	{
		this.misaccountname = misaccountname;
	}

	public String getMisaccountname() 
	{
		return misaccountname;
	}
	public void setBiinitdate(Date biinitdate) 
	{
		this.biinitdate = biinitdate;
	}

	public Date getBiinitdate() 
	{
		return biinitdate;
	}
	public void setBibalance(BigDecimal bibalance) 
	{
		this.bibalance = bibalance;
	}

	public BigDecimal getBibalance() 
	{
		return bibalance;
	}
	public void setAllowsplit(Integer allowsplit) 
	{
		this.allowsplit = allowsplit;
	}

	public Integer getAllowsplit() 
	{
		return allowsplit;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("accno", getAccno())
            .append("name", getName())
            .append("orgid", getOrgid())
            .append("bankid", getBankid())
            .append("openbankname", getOpenbankname())
            .append("parentmode", getParentmode())
            .append("currencyid", getCurrencyid())
            .append("areaid", getAreaid())
            .append("accattributeid", getAccattributeid())
            .append("accounttype", getAccounttype())
            .append("parentbankaccid", getParentbankaccid())
            .append("isopenwebbank", getIsopenwebbank())
            .append("accstate", getAccstate())
            .append("balance", getBalance())
            .append("initdate", getInitdate())
            .append("remark", getRemark())
            .append("createby", getCreateby())
            .append("createtime", getCreatetime())
            .append("lastupdateby", getLastupdateby())
            .append("lastupdatetime", getLastupdatetime())
            .append("enable", getEnable())
            .append("warnuserids", getWarnuserids())
            .append("misaccountname", getMisaccountname())
            .append("biinitdate", getBiinitdate())
            .append("bibalance", getBibalance())
            .append("allowsplit", getAllowsplit())
            .toString();
    }
}
