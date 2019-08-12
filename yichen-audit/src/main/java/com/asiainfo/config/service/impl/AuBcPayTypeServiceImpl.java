package com.asiainfo.config.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asiainfo.config.mapper.AuBcPayTypeMapper;
import com.asiainfo.config.domain.AuBcPayType;
import com.asiainfo.config.service.IAuBcPayTypeService;
import com.asiainfo.common.core.text.Convert;

/**
 * 缴款类型 服务层实现
 * 
 * @author changtong
 * @date 2019-07-16
 */
@Service
public class AuBcPayTypeServiceImpl implements IAuBcPayTypeService 
{
	@Autowired
	private AuBcPayTypeMapper auBcPayTypeMapper;

	/**
     * 查询缴款类型信息
     * 
     * @param id 缴款类型ID
     * @return 缴款类型信息
     */
    @Override
	public AuBcPayType selectAuBcPayTypeById(Long id)
	{
	    return auBcPayTypeMapper.selectAuBcPayTypeById(id);
	}
	
	/**
     * 查询缴款类型列表
     * 
     * @param auBcPayType 缴款类型信息
     * @return 缴款类型集合
     */
	@Override
	public List<AuBcPayType> selectAuBcPayTypeList(AuBcPayType auBcPayType)
	{
	    return auBcPayTypeMapper.selectAuBcPayTypeList(auBcPayType);
	}
	
    /**
     * 新增缴款类型
     * 
     * @param auBcPayType 缴款类型信息
     * @return 结果
     */
	@Override
	public int insertAuBcPayType(AuBcPayType auBcPayType)
	{
	    return auBcPayTypeMapper.insertAuBcPayType(auBcPayType);
	}
	
	/**
     * 修改缴款类型
     * 
     * @param auBcPayType 缴款类型信息
     * @return 结果
     */
	@Override
	public int updateAuBcPayType(AuBcPayType auBcPayType)
	{
	    return auBcPayTypeMapper.updateAuBcPayType(auBcPayType);
	}

	/**
     * 删除缴款类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAuBcPayTypeByIds(String ids)
	{
		return auBcPayTypeMapper.deleteAuBcPayTypeByIds(Convert.toStrArray(ids));
	}
	
}
