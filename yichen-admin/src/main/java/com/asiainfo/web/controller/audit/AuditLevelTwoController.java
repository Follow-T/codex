package com.asiainfo.web.controller.audit;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.audit.service.IAuditLevelTwoService;
import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.framework.util.ShiroUtils;
import com.asiainfo.system.domain.SysUser;

/**  
 * All rights Reserved, XXX
 * @Title: 二级稽核controller   
 * @Package audit.levelTwo   
 * @Description:    controller
 * @createAuthor: changtong
 * @fixAuthor: 
 * @date:   2019-07-10   
 * @version V1.0 
 */
@Controller
@RequestMapping("/audit/levelTwo")
public class AuditLevelTwoController extends BaseController{
	private String prefix = "audit/levelTwo";
	@Autowired
	private IAuditLevelTwoService levelTwoService;
	
	@RequiresPermissions("audit:levelTwo:view")
    @GetMapping()
	public String levelTwo()
    {
		//获取当前session的user
        SysUser user = ShiroUtils.getSysUser();
        //获取当前对象的role，0表示没有绑定role
        long roleId = ShiroUtils.getRoleId();
        return prefix + "/levelTwo";
    }
}
