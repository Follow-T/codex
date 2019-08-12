package com.asiainfo.web.controller.audit;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.audit.service.IAuditCapitalPoolService;
import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.framework.util.ShiroUtils;
import com.asiainfo.system.domain.SysUser;

/**  
 * All rights Reserved, XXX
 * @Title:  共有资金池controller   
 * @Package audit.capitalPool   
 * @Description:    controller
 * @createAuthor: changtong
 * @fixAuthor: 
 * @date:   2019-07-10   
 * @version V1.0 
 */
@Controller
@RequestMapping("/audit/capitalPool")
public class AuditCapitalPoolController extends BaseController{
	private String prefix = "audit/pool/capitalPool";
	@Autowired
	private IAuditCapitalPoolService capitalPoolService;
	
	@RequiresPermissions("audit:capitalPool:view")
    @GetMapping()
	public String capitalPool()
    {
		//获取当前session的user
        SysUser user = ShiroUtils.getSysUser();
        //获取当前对象的role，0表示没有绑定role
        long roleId = ShiroUtils.getRoleId();
        return prefix + "/capitalPool";
    }
}
