package com.asiainfo.config.mapper;

import com.asiainfo.config.domain.AuBcPayType;
import java.util.List;	

/**
 * 缴款类型 数据层
 * 
 * @author changtong
 * @date 2019-07-16
 */
public interface AuBcPayTypeMapper 
{
	/**
     * 查询缴款类型信息
     * 
     * @param id 缴款类型ID
     * @return 缴款类型信息
     */
	public AuBcPayType selectAuBcPayTypeById(Long id);
	
	/**
     * 查询缴款类型列表
     * 
     * @param auBcPayType 缴款类型信息
     * @return 缴款类型集合
     */
	public List<AuBcPayType> selectAuBcPayTypeList(AuBcPayType auBcPayType);
	
	/**
     * 新增缴款类型
     * 
     * @param auBcPayType 缴款类型信息
     * @return 结果
     */
	public int insertAuBcPayType(AuBcPayType auBcPayType);
	
	/**
     * 修改缴款类型
     * 
     * @param auBcPayType 缴款类型信息
     * @return 结果
     */
	public int updateAuBcPayType(AuBcPayType auBcPayType);
	
	/**
     * 删除缴款类型
     * 
     * @param id 缴款类型ID
     * @return 结果
     */
	public int deleteAuBcPayTypeById(Long id);
	
	/**
     * 批量删除缴款类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAuBcPayTypeByIds(String[] ids);
	
}