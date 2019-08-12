package com.asiainfo.web.controller.audit;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.audit.service.IAuditIncomeListService;
import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.framework.util.ShiroUtils;
import com.asiainfo.system.domain.SysUser;
/**  
 * All rights Reserved, XXX
 * @Title:  银行台账controller   
 * @Package audit.income   
 * @Description:    controller
 * @createAuthor: changtong
 * @fixAuthor:
 * @date:   2019-07-10   
 * @version V1.0 
 */
@Controller
@RequestMapping("/audit/incomeList")
public class AuditIncomeListController extends BaseController{
	private String prefix = "audit/incomeList";
	@Autowired
	private IAuditIncomeListService incomeListService;
	
	@RequiresPermissions("audit:incomeList:view")
    @GetMapping()
	public String incomeList()
    {
		//获取当前session的user
        SysUser user = ShiroUtils.getSysUser();
        //获取当前对象的role，0表示没有绑定role
        long roleId = ShiroUtils.getRoleId();
        return prefix + "/incomeList";
    }
}
