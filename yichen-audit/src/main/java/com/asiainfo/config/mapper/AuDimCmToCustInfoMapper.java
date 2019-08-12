package com.asiainfo.config.mapper;

import com.asiainfo.config.domain.AuDimCmToCustInfo;
import java.util.List;	

/**
 * 客户管理 数据层
 * 
 * @author changtong
 * @date 2019-07-18
 */
public interface AuDimCmToCustInfoMapper 
{
	/**
     * 查询客户管理信息
     * 
     * @param id 客户管理ID
     * @return 客户管理信息
     */
	public AuDimCmToCustInfo selectAuDimCmToCustInfoById(Long id);
	
	/**
     * 查询客户管理列表
     * 
     * @param auDimCmToCustInfo 客户管理信息
     * @return 客户管理集合
     */
	public List<AuDimCmToCustInfo> selectAuDimCmToCustInfoList(AuDimCmToCustInfo auDimCmToCustInfo);
	
	/**
     * 新增客户管理
     * 
     * @param auDimCmToCustInfo 客户管理信息
     * @return 结果
     */
	public int insertAuDimCmToCustInfo(AuDimCmToCustInfo auDimCmToCustInfo);
	
	/**
     * 修改客户管理
     * 
     * @param auDimCmToCustInfo 客户管理信息
     * @return 结果
     */
	public int updateAuDimCmToCustInfo(AuDimCmToCustInfo auDimCmToCustInfo);
	
	/**
     * 删除客户管理
     * 
     * @param id 客户管理ID
     * @return 结果
     */
	public int deleteAuDimCmToCustInfoById(Long id);
	
	/**
     * 批量删除客户管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAuDimCmToCustInfoByIds(String[] ids);
	
}