package com.asiainfo.config.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asiainfo.config.mapper.AuBankAccountMapper;
import com.asiainfo.config.domain.AuBankAccount;
import com.asiainfo.config.service.IAuBankAccountService;
import com.asiainfo.common.core.text.Convert;

/**
 * 银行账户 服务层实现
 * 
 * @author changtong
 * @date 2019-07-16
 */
@Service
public class AuBankAccountServiceImpl implements IAuBankAccountService 
{
	@Autowired
	private AuBankAccountMapper auBankAccountMapper;

	/**
     * 查询银行账户信息
     * 
     * @param id 银行账户ID
     * @return 银行账户信息
     */
    @Override
	public AuBankAccount selectAuBankAccountById(Long id)
	{
	    return auBankAccountMapper.selectAuBankAccountById(id);
	}
	
	/**
     * 查询银行账户列表
     * 
     * @param auBankAccount 银行账户信息
     * @return 银行账户集合
     */
	@Override
	public List<AuBankAccount> selectAuBankAccountList(AuBankAccount auBankAccount)
	{
	    return auBankAccountMapper.selectAuBankAccountList(auBankAccount);
	}
	
    /**
     * 新增银行账户
     * 
     * @param auBankAccount 银行账户信息
     * @return 结果
     */
	@Override
	public int insertAuBankAccount(AuBankAccount auBankAccount)
	{
	    return auBankAccountMapper.insertAuBankAccount(auBankAccount);
	}
	
	/**
     * 修改银行账户
     * 
     * @param auBankAccount 银行账户信息
     * @return 结果
     */
	@Override
	public int updateAuBankAccount(AuBankAccount auBankAccount)
	{
	    return auBankAccountMapper.updateAuBankAccount(auBankAccount);
	}

	/**
     * 删除银行账户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAuBankAccountByIds(String ids)
	{
		return auBankAccountMapper.deleteAuBankAccountByIds(Convert.toStrArray(ids));
	}
	
}
