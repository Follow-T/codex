package com.asiainfo.config.domain;

import com.asiainfo.common.core.domain.BaseEntity;

public class AuChannelSigning extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String code;
	private String name;
	private Long orgid;
	private String signid;
	private String accountno;
	private String accountname;
	private String openbankname;
	private Long accountid;
	private String remark;
	private Long orgclassid;
	private int enable;
	private String signing;
	private String useraccountno;
	private String companyaccountname;
	private String banklogin;
	
	private AuHall auHall;
	private AuChannelSigningAccount auChannelSigningAccount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getOrgid() {
		return orgid;
	}
	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}
	public String getSignid() {
		return signid;
	}
	public void setSignid(String signid) {
		this.signid = signid;
	}
	public String getAccountno() {
		return accountno;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public String getOpenbankname() {
		return openbankname;
	}
	public void setOpenbankname(String openbankname) {
		this.openbankname = openbankname;
	}
	public Long getAccountid() {
		return accountid;
	}
	public void setAccountid(Long accountid) {
		this.accountid = accountid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getOrgclassid() {
		return orgclassid;
	}
	public void setOrgclassid(Long orgclassid) {
		this.orgclassid = orgclassid;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public String getSigning() {
		return signing;
	}
	public void setSigning(String signing) {
		this.signing = signing;
	}
	public String getUseraccountno() {
		return useraccountno;
	}
	public void setUseraccountno(String useraccountno) {
		this.useraccountno = useraccountno;
	}
	public String getCompanyaccountname() {
		return companyaccountname;
	}
	public void setCompanyaccountname(String companyaccountname) {
		this.companyaccountname = companyaccountname;
	}
	public String getBanklogin() {
		return banklogin;
	}
	public void setBanklogin(String banklogin) {
		this.banklogin = banklogin;
	}
	public AuHall getAuHall() {
		return auHall;
	}
	public void setAuHall(AuHall auHall) {
		this.auHall = auHall;
	}
	public AuChannelSigningAccount getAuChannelSigningAccount() {
		return auChannelSigningAccount;
	}
	public void setAuChannelSigningAccount(AuChannelSigningAccount auChannelSigningAccount) {
		this.auChannelSigningAccount = auChannelSigningAccount;
	}
	
	
	
	
	
	
	
}