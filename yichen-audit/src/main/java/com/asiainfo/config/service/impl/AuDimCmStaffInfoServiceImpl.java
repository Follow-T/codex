package com.asiainfo.config.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asiainfo.config.mapper.AuDimCmStaffInfoMapper;
import com.asiainfo.config.domain.AuDimCmStaffInfo;
import com.asiainfo.config.service.IAuDimCmStaffInfoService;
import com.asiainfo.common.core.text.Convert;

/**
 * 客户 服务层实现
 * 
 * @author changtong
 * @date 2019-07-18
 */
@Service
public class AuDimCmStaffInfoServiceImpl implements IAuDimCmStaffInfoService 
{
	@Autowired
	private AuDimCmStaffInfoMapper auDimCmStaffInfoMapper;

	/**
     * 查询客户信息
     * 
     * @param id 客户ID
     * @return 客户信息
     */
    @Override
	public AuDimCmStaffInfo selectAuDimCmStaffInfoById(Long id)
	{
	    return auDimCmStaffInfoMapper.selectAuDimCmStaffInfoById(id);
	}
	
	/**
     * 查询客户列表
     * 
     * @param auDimCmStaffInfo 客户信息
     * @return 客户集合
     */
	@Override
	public List<AuDimCmStaffInfo> selectAuDimCmStaffInfoList(AuDimCmStaffInfo auDimCmStaffInfo)
	{
	    return auDimCmStaffInfoMapper.selectAuDimCmStaffInfoList(auDimCmStaffInfo);
	}
	
    /**
     * 新增客户
     * 
     * @param auDimCmStaffInfo 客户信息
     * @return 结果
     */
	@Override
	public int insertAuDimCmStaffInfo(AuDimCmStaffInfo auDimCmStaffInfo)
	{
	    return auDimCmStaffInfoMapper.insertAuDimCmStaffInfo(auDimCmStaffInfo);
	}
	
	/**
     * 修改客户
     * 
     * @param auDimCmStaffInfo 客户信息
     * @return 结果
     */
	@Override
	public int updateAuDimCmStaffInfo(AuDimCmStaffInfo auDimCmStaffInfo)
	{
	    return auDimCmStaffInfoMapper.updateAuDimCmStaffInfo(auDimCmStaffInfo);
	}

	/**
     * 删除客户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAuDimCmStaffInfoByIds(String ids)
	{
		return auDimCmStaffInfoMapper.deleteAuDimCmStaffInfoByIds(Convert.toStrArray(ids));
	}
	
}
