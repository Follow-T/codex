package com.asiainfo.config.mapper;

import com.asiainfo.config.domain.AuDimCmStaffInfo;
import java.util.List;	

/**
 * 客户 数据层
 * 
 * @author changtong
 * @date 2019-07-18
 */
public interface AuDimCmStaffInfoMapper 
{
	/**
     * 查询客户信息
     * 
     * @param id 客户ID
     * @return 客户信息
     */
	public AuDimCmStaffInfo selectAuDimCmStaffInfoById(Long id);
	
	/**
     * 查询客户列表
     * 
     * @param auDimCmStaffInfo 客户信息
     * @return 客户集合
     */
	public List<AuDimCmStaffInfo> selectAuDimCmStaffInfoList(AuDimCmStaffInfo auDimCmStaffInfo);
	
	/**
     * 新增客户
     * 
     * @param auDimCmStaffInfo 客户信息
     * @return 结果
     */
	public int insertAuDimCmStaffInfo(AuDimCmStaffInfo auDimCmStaffInfo);
	
	/**
     * 修改客户
     * 
     * @param auDimCmStaffInfo 客户信息
     * @return 结果
     */
	public int updateAuDimCmStaffInfo(AuDimCmStaffInfo auDimCmStaffInfo);
	
	/**
     * 删除客户
     * 
     * @param id 客户ID
     * @return 结果
     */
	public int deleteAuDimCmStaffInfoById(Long id);
	
	/**
     * 批量删除客户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAuDimCmStaffInfoByIds(String[] ids);
	
}