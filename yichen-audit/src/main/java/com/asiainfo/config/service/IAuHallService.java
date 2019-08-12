package com.asiainfo.config.service;

import java.util.List;

import com.asiainfo.config.domain.AuHall;

public interface IAuHallService {
	
	public List<AuHall> selectAuHallsList(AuHall auHall);
	
}
