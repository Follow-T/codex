package com.asiainfo.config.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.asiainfo.config.domain.AuChannelSigning;
import com.asiainfo.config.mapper.AuChannelSigningMapper;
import com.asiainfo.config.service.AuChannelSigningService;

public class AuChannelSigningServiceImpl implements AuChannelSigningService{
	
	@Autowired
	private AuChannelSigningMapper auChannelSigningMapper;

	@Override
	public List<AuChannelSigning> selectAuChannelSigningsList(AuChannelSigning auChannelSigning) {
		return auChannelSigningMapper.selectAuChannelSigningsList(auChannelSigning);
	}
	
}
