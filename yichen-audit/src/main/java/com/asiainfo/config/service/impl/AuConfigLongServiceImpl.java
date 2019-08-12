package com.asiainfo.config.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.common.core.text.Convert;
import com.asiainfo.config.domain.AuConfigLong;
import com.asiainfo.config.mapper.AuConfigLongMapper;
import com.asiainfo.config.service.IAuConfigLongService;

/**
 * 长短款配置说明 服务层实现
 * 
 * @author genghz
 * @date 2019-07-16
 */
@Service
public class AuConfigLongServiceImpl implements IAuConfigLongService 
{
	@Autowired
	private AuConfigLongMapper auConfigLongMapper;

	/**
     * 查询长短款配置说明信息
     * 
     * @param costType 长短款配置说明ID
     * @return 长短款配置说明信息
     */
    @Override
	public AuConfigLong selectAuConfigLongById(String costType)
	{
	    return auConfigLongMapper.selectAuConfigLongById(costType);
	}
	
	/**
     * 查询长短款配置说明列表
     * 
     * @param auConfigLong 长短款配置说明信息
     * @return 长短款配置说明集合
     */
	@Override
	public List<AuConfigLong> selectAuConfigLongList(AuConfigLong auConfigLong)
	{
	    return auConfigLongMapper.selectAuConfigLongList(auConfigLong);
	}
	
    /**
     * 新增长短款配置说明
     * 
     * @param auConfigLong 长短款配置说明信息
     * @return 结果
     */
	@Override
	public int insertAuConfigLong(AuConfigLong auConfigLong)
	{
	    return auConfigLongMapper.insertAuConfigLong(auConfigLong);
	}
	
	/**
     * 修改长短款配置说明
     * 
     * @param auConfigLong 长短款配置说明信息
     * @return 结果
     */
	@Override
	public int updateAuConfigLong(AuConfigLong auConfigLong)
	{
	    return auConfigLongMapper.updateAuConfigLong(auConfigLong);
	}

	/**
     * 删除长短款配置说明对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAuConfigLongByIds(String ids)
	{
		return auConfigLongMapper.deleteAuConfigLongByIds(Convert.toStrArray(ids));
	}
	
}
