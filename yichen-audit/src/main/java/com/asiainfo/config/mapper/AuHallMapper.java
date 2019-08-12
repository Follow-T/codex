package com.asiainfo.config.mapper;

import java.util.List;

import com.asiainfo.config.domain.AuHall;

public interface AuHallMapper {
	
	public List<AuHall> selectAuHallsList(AuHall auHall);
	
}
