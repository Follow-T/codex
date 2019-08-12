package com.asiainfo.web.controller.config;

import java.util.Date;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.asiainfo.common.annotation.Log;
import com.asiainfo.common.enums.BusinessType;
import com.asiainfo.config.domain.AuBankAccount;
import com.asiainfo.config.service.IAuBankAccountService;
import com.asiainfo.framework.util.ShiroUtils;
import com.asiainfo.system.domain.SysUser;
import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.common.core.page.TableDataInfo;
import com.asiainfo.common.core.domain.AjaxResult;
import com.asiainfo.common.utils.poi.ExcelUtil;

/**
 * 银行账户 信息操作处理
 * 
 * @author changtong
 * @date 2019-07-16
 */
@Controller
@RequestMapping("/config/bankAccount")
public class AuBankAccountController extends BaseController
{
    private String prefix = "config/bankAccount";
	
	@Autowired
	private IAuBankAccountService auBankAccountService;
	
	@RequiresPermissions("config:bankAccount:view")
	@GetMapping()
	public String auBankAccount()
	{
	    return prefix + "/auBankAccount";
	}
	
	/**
	 * 查询银行账户列表
	 */
	@RequiresPermissions("config:bankAccount:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(AuBankAccount auBankAccount)
	{
		startPage();
        List<AuBankAccount> list = auBankAccountService.selectAuBankAccountList(auBankAccount);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出银行账户列表
	 */
	@RequiresPermissions("config:bankAccount:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AuBankAccount auBankAccount)
    {
    	List<AuBankAccount> list = auBankAccountService.selectAuBankAccountList(auBankAccount);
        ExcelUtil<AuBankAccount> util = new ExcelUtil<AuBankAccount>(AuBankAccount.class);
        return util.exportExcel(list, "auBankAccount");
    }
	
	/**
	 * 新增银行账户
	 */
	@GetMapping("/add/{id}")
	public String add(@PathVariable("id") Long id, ModelMap mmap)
	{
		AuBankAccount au= new AuBankAccount();
		au.setOrgid(id);
		mmap.put("auBankAccount", au);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存银行账户
	 */
	@RequiresPermissions("config:bankAccount:add")
	@Log(title = "银行账户", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(AuBankAccount auBankAccount)
	{		
		SysUser user = ShiroUtils.getSysUser();
		auBankAccount.setCreateby(user.getUserId());
		auBankAccount.setCreatetime(new Date());
		auBankAccount.setLastupdateby(user.getUserId());
		auBankAccount.setLastupdatetime(new Date());
		return toAjax(auBankAccountService.insertAuBankAccount(auBankAccount));
	}

	/**
	 * 修改银行账户
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		AuBankAccount auBankAccount = auBankAccountService.selectAuBankAccountById(id);
		mmap.put("auBankAccount", auBankAccount);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存银行账户
	 */
	@RequiresPermissions("config:bankAccount:edit")
	@Log(title = "银行账户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(AuBankAccount auBankAccount)
	{		
		return toAjax(auBankAccountService.updateAuBankAccount(auBankAccount));
	}
	
	/**
	 * 删除银行账户
	 */
	@RequiresPermissions("config:bankAccount:remove")
	@Log(title = "银行账户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(auBankAccountService.deleteAuBankAccountByIds(ids));
	}
	/**
	 * 普通银行页面
	 */
	@GetMapping("/account")
	public String account()
	{
	    return prefix + "/account";
	}
}
