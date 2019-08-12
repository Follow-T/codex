package com.asiainfo.config.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asiainfo.config.mapper.AuDimPolyMchantMapper;
import com.asiainfo.config.domain.AuDimPolyMchant;
import com.asiainfo.config.service.IAuDimPolyMchantService;
import com.asiainfo.common.core.text.Convert;

/**
 * 聚合支付 服务层实现
 * 
 * @author changtong
 * @date 2019-07-17
 */
@Service
public class AuDimPolyMchantServiceImpl implements IAuDimPolyMchantService 
{
	@Autowired
	private AuDimPolyMchantMapper auDimPolyMchantMapper;

	/**
     * 查询聚合支付信息
     * 
     * @param orgId 聚合支付ID
     * @return 聚合支付信息
     */
    @Override
	public AuDimPolyMchant selectAuDimPolyMchantById(Integer orgId)
	{
	    return auDimPolyMchantMapper.selectAuDimPolyMchantById(orgId);
	}
	
	/**
     * 查询聚合支付列表
     * 
     * @param auDimPolyMchant 聚合支付信息
     * @return 聚合支付集合
     */
	@Override
	public List<AuDimPolyMchant> selectAuDimPolyMchantList(AuDimPolyMchant auDimPolyMchant)
	{
	    return auDimPolyMchantMapper.selectAuDimPolyMchantList(auDimPolyMchant);
	}
	
    /**
     * 新增聚合支付
     * 
     * @param auDimPolyMchant 聚合支付信息
     * @return 结果
     */
	@Override
	public int insertAuDimPolyMchant(AuDimPolyMchant auDimPolyMchant)
	{
	    return auDimPolyMchantMapper.insertAuDimPolyMchant(auDimPolyMchant);
	}
	
	/**
     * 修改聚合支付
     * 
     * @param auDimPolyMchant 聚合支付信息
     * @return 结果
     */
	@Override
	public int updateAuDimPolyMchant(AuDimPolyMchant auDimPolyMchant)
	{
	    return auDimPolyMchantMapper.updateAuDimPolyMchant(auDimPolyMchant);
	}

	/**
     * 删除聚合支付对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAuDimPolyMchantByIds(String ids)
	{
		return auDimPolyMchantMapper.deleteAuDimPolyMchantByIds(Convert.toStrArray(ids));
	}
	
}
