package com.asiainfo.config.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.asiainfo.common.core.domain.BaseEntity;


public class AuHall extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long channelsigningid;
	private String code;
	private String name;
	private int orgId;
	private int hallTypeId;
	private int agentId;
	private int auditPeriod;
	private Date initAuditDate;
	private Date currentAuditDate;
	private Date companyAuditDate;
	private BigDecimal initMantiSsa;
	private BigDecimal currentMantiSsa;
	private BigDecimal initArrearAmount;
	private BigDecimal correntArrearAmount;
	private String dutyUserName;
	private String dutyPhone;
	private String isDelete;
	private String auditMethod;
	private String deductFlag;
	
	private int enable;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getChannelsigningid() {
		return channelsigningid;
	}
	public void setChannelsigningid(Long channelsigningid) {
		this.channelsigningid = channelsigningid;
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
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public int getHallTypeId() {
		return hallTypeId;
	}
	public void setHallTypeId(int hallTypeId) {
		this.hallTypeId = hallTypeId;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public int getAuditPeriod() {
		return auditPeriod;
	}
	public void setAuditPeriod(int auditPeriod) {
		this.auditPeriod = auditPeriod;
	}
	public Date getInitAuditDate() {
		return initAuditDate;
	}
	public void setInitAuditDate(Date initAuditDate) {
		this.initAuditDate = initAuditDate;
	}
	public Date getCurrentAuditDate() {
		return currentAuditDate;
	}
	public void setCurrentAuditDate(Date currentAuditDate) {
		this.currentAuditDate = currentAuditDate;
	}
	public Date getCompanyAuditDate() {
		return companyAuditDate;
	}
	public void setCompanyAuditDate(Date companyAuditDate) {
		this.companyAuditDate = companyAuditDate;
	}
	public BigDecimal getInitMantiSsa() {
		return initMantiSsa;
	}
	public void setInitMantiSsa(BigDecimal initMantiSsa) {
		this.initMantiSsa = initMantiSsa;
	}
	public BigDecimal getCurrentMantiSsa() {
		return currentMantiSsa;
	}
	public void setCurrentMantiSsa(BigDecimal currentMantiSsa) {
		this.currentMantiSsa = currentMantiSsa;
	}
	public BigDecimal getInitArrearAmount() {
		return initArrearAmount;
	}
	public void setInitArrearAmount(BigDecimal initArrearAmount) {
		this.initArrearAmount = initArrearAmount;
	}
	public BigDecimal getCorrentArrearAmount() {
		return correntArrearAmount;
	}
	public void setCorrentArrearAmount(BigDecimal correntArrearAmount) {
		this.correntArrearAmount = correntArrearAmount;
	}
	public String getDutyUserName() {
		return dutyUserName;
	}
	public void setDutyUserName(String dutyUserName) {
		this.dutyUserName = dutyUserName;
	}
	public String getDutyPhone() {
		return dutyPhone;
	}
	public void setDutyPhone(String dutyPhone) {
		this.dutyPhone = dutyPhone;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public String getAuditMethod() {
		return auditMethod;
	}
	public void setAuditMethod(String auditMethod) {
		this.auditMethod = auditMethod;
	}
	public String getDeductFlag() {
		return deductFlag;
	}
	public void setDeductFlag(String deductFlag) {
		this.deductFlag = deductFlag;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
