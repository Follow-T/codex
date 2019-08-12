package com.asiainfo.config.mapper;

import java.util.List;

import com.asiainfo.config.domain.AuChannelSigningAccount;


public interface AuChannelSigningAccountMapper {
	
	public List<AuChannelSigningAccount> selectAuChannelSigningAccountsList(AuChannelSigningAccount auChannelSigningAccount);
	
}
