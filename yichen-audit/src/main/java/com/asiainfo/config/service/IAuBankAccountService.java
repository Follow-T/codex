package com.asiainfo.config.service;

import com.asiainfo.config.domain.AuBankAccount;
import java.util.List;

/**
 * 银行账户 服务层
 * 
 * @author changtong
 * @date 2019-07-16
 */
public interface IAuBankAccountService 
{
	/**
     * 查询银行账户信息
     * 
     * @param id 银行账户ID
     * @return 银行账户信息
     */
	public AuBankAccount selectAuBankAccountById(Long id);
	
	/**
     * 查询银行账户列表
     * 
     * @param auBankAccount 银行账户信息
     * @return 银行账户集合
     */
	public List<AuBankAccount> selectAuBankAccountList(AuBankAccount auBankAccount);
	
	/**
     * 新增银行账户
     * 
     * @param auBankAccount 银行账户信息
     * @return 结果
     */
	public int insertAuBankAccount(AuBankAccount auBankAccount);
	
	/**
     * 修改银行账户
     * 
     * @param auBankAccount 银行账户信息
     * @return 结果
     */
	public int updateAuBankAccount(AuBankAccount auBankAccount);
		
	/**
     * 删除银行账户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAuBankAccountByIds(String ids);
	
}
