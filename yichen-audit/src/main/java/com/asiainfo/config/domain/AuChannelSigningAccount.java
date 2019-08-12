package com.asiainfo.config.domain;

import com.asiainfo.common.core.domain.BaseEntity;

public class AuChannelSigningAccount extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long channelsigningid;
	private String accountno;
	private String accountname;
	private String openbankname;
	private int isdefault;
	
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
	public int getIsdefault() {
		return isdefault;
	}
	public void setIsdefault(int isdefault) {
		this.isdefault = isdefault;
	}
	
	

}
