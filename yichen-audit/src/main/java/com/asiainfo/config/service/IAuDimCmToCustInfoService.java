package com.asiainfo.config.service;

import com.asiainfo.config.domain.AuDimCmToCustInfo;
import java.util.List;

/**
 * 客户管理 服务层
 * 
 * @author changtong
 * @date 2019-07-18
 */
public interface IAuDimCmToCustInfoService 
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
     * 删除客户管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAuDimCmToCustInfoByIds(String ids);
	
}
