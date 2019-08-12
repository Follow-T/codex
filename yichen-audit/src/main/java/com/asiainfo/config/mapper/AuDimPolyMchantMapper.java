package com.asiainfo.config.mapper;

import com.asiainfo.config.domain.AuDimPolyMchant;
import java.util.List;	

/**
 * 聚合支付 数据层
 * 
 * @author changtong
 * @date 2019-07-17
 */
public interface AuDimPolyMchantMapper 
{
	/**
     * 查询聚合支付信息
     * 
     * @param orgId 聚合支付ID
     * @return 聚合支付信息
     */
	public AuDimPolyMchant selectAuDimPolyMchantById(Integer orgId);
	
	/**
     * 查询聚合支付列表
     * 
     * @param auDimPolyMchant 聚合支付信息
     * @return 聚合支付集合
     */
	public List<AuDimPolyMchant> selectAuDimPolyMchantList(AuDimPolyMchant auDimPolyMchant);
	
	/**
     * 新增聚合支付
     * 
     * @param auDimPolyMchant 聚合支付信息
     * @return 结果
     */
	public int insertAuDimPolyMchant(AuDimPolyMchant auDimPolyMchant);
	
	/**
     * 修改聚合支付
     * 
     * @param auDimPolyMchant 聚合支付信息
     * @return 结果
     */
	public int updateAuDimPolyMchant(AuDimPolyMchant auDimPolyMchant);
	
	/**
     * 删除聚合支付
     * 
     * @param orgId 聚合支付ID
     * @return 结果
     */
	public int deleteAuDimPolyMchantById(Integer orgId);
	
	/**
     * 批量删除聚合支付
     * 
     * @param orgIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteAuDimPolyMchantByIds(String[] orgIds);
	
}