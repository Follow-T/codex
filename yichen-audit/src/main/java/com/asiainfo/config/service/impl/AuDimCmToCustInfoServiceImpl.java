package com.asiainfo.config.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asiainfo.config.mapper.AuDimCmToCustInfoMapper;
import com.asiainfo.config.domain.AuDimCmToCustInfo;
import com.asiainfo.config.service.IAuDimCmToCustInfoService;
import com.asiainfo.common.core.text.Convert;

/**
 * 客户管理 服务层实现
 * 
 * @author changtong
 * @date 2019-07-18
 */
@Service
public class AuDimCmToCustInfoServiceImpl implements IAuDimCmToCustInfoService 
{
	@Autowired
	private AuDimCmToCustInfoMapper auDimCmToCustInfoMapper;

	/**
     * 查询客户管理信息
     * 
     * @param id 客户管理ID
     * @return 客户管理信息
     */
    @Override
	public AuDimCmToCustInfo selectAuDimCmToCustInfoById(Long id)
	{
	    return auDimCmToCustInfoMapper.selectAuDimCmToCustInfoById(id);
	}
	
	/**
     * 查询客户管理列表
     * 
     * @param auDimCmToCustInfo 客户管理信息
     * @return 客户管理集合
     */
	@Override
	public List<AuDimCmToCustInfo> selectAuDimCmToCustInfoList(AuDimCmToCustInfo auDimCmToCustInfo)
	{
	    return auDimCmToCustInfoMapper.selectAuDimCmToCustInfoList(auDimCmToCustInfo);
	}
	
    /**
     * 新增客户管理
     * 
     * @param auDimCmToCustInfo 客户管理信息
     * @return 结果
     */
	@Override
	public int insertAuDimCmToCustInfo(AuDimCmToCustInfo auDimCmToCustInfo)
	{
	    return auDimCmToCustInfoMapper.insertAuDimCmToCustInfo(auDimCmToCustInfo);
	}
	
	/**
     * 修改客户管理
     * 
     * @param auDimCmToCustInfo 客户管理信息
     * @return 结果
     */
	@Override
	public int updateAuDimCmToCustInfo(AuDimCmToCustInfo auDimCmToCustInfo)
	{
	    return auDimCmToCustInfoMapper.updateAuDimCmToCustInfo(auDimCmToCustInfo);
	}

	/**
     * 删除客户管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAuDimCmToCustInfoByIds(String ids)
	{
		return auDimCmToCustInfoMapper.deleteAuDimCmToCustInfoByIds(Convert.toStrArray(ids));
	}
	
}
