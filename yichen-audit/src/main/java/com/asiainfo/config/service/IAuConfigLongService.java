package com.asiainfo.config.service;

import java.util.List;

import com.asiainfo.config.domain.AuConfigLong;

/**
 * 长短款配置说明 服务层
 * 
 * @author genghz
 * @date 2019-07-16
 */
public interface IAuConfigLongService 
{
	/**
     * 查询长短款配置说明信息
     * 
     * @param costType 长短款配置说明ID
     * @return 长短款配置说明信息
     */
	public AuConfigLong selectAuConfigLongById(String costType);
	
	/**
     * 查询长短款配置说明列表
     * 
     * @param auConfigLong 长短款配置说明信息
     * @return 长短款配置说明集合
     */
	public List<AuConfigLong> selectAuConfigLongList(AuConfigLong auConfigLong);
	
	/**
     * 新增长短款配置说明
     * 
     * @param auConfigLong 长短款配置说明信息
     * @return 结果
     */
	public int insertAuConfigLong(AuConfigLong auConfigLong);
	
	/**
     * 修改长短款配置说明
     * 
     * @param auConfigLong 长短款配置说明信息
     * @return 结果
     */
	public int updateAuConfigLong(AuConfigLong auConfigLong);
		
	/**
     * 删除长短款配置说明信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAuConfigLongByIds(String ids);
	
}
