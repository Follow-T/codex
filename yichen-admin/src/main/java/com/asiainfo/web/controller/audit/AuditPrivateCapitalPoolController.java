package com.asiainfo.web.controller.audit;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.audit.service.IAuditPrivateCapitalPoolService;
import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.framework.util.ShiroUtils;
import com.asiainfo.system.domain.SysUser;

/**  
 * All rights Reserved, XXX
 * @Title:  私有资金池controller   
 * @Package audit.privateCapitalPool   
 * @Description:    controller
 * @createAuthor: changtong
 * @fixAuthor: 
 * @date:   2019-07-10   
 * @version V1.0 
 */
@Controller
@RequestMapping("/audit/privateCapitalPool")
public class AuditPrivateCapitalPoolController extends BaseController{
	private String prefix = "audit/pool/private";
	@Autowired
	private IAuditPrivateCapitalPoolService privateCapitalPoolService;
	
	@RequiresPermissions("audit:privateCapitalPool:view")
    @GetMapping()
	public String privateCapitalPool()
    {
		//获取当前session的user
        SysUser user = ShiroUtils.getSysUser();
        //获取当前对象的role，0表示没有绑定role
        long roleId = ShiroUtils.getRoleId();
        return prefix + "/private";
    }
}
