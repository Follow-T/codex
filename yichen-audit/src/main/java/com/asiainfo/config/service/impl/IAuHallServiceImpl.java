package com.asiainfo.config.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.config.domain.AuHall;
import com.asiainfo.config.mapper.AuHallMapper;
import com.asiainfo.config.service.IAuHallService;

@Service
public class IAuHallServiceImpl implements IAuHallService{
	
	@Autowired
	private AuHallMapper auHallMapper;
	
	@Override
	public List<AuHall> selectAuHallsList(AuHall auHall) {
		return auHallMapper.selectAuHallsList(auHall);
	}

}
