package com.asiainfo.web.controller.audit;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.audit.service.IAuditLevelThreeService;
import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.framework.util.ShiroUtils;
import com.asiainfo.system.domain.SysUser;

/**  
 * All rights Reserved, XXX
 * @Title:  三级稽核controller   
 * @Package audit.levelThree  
 * @Description:    controller
 * @createAuthor: changtong
 * @fixAuthor: 
 * @date:   2019-07-10   
 * @version V1.0 
 */
@Controller
@RequestMapping("/audit/levelThree")
public class AuditLevelThreeController extends BaseController{
	private String prefix = "audit/levelThree";
	@Autowired
	private IAuditLevelThreeService LevelThreeService;
	
	@RequiresPermissions("audit:income:view")
    @GetMapping()
	public String levelThree()
    {
		//获取当前session的user
        SysUser user = ShiroUtils.getSysUser();
        //获取当前对象的role，0表示没有绑定role
        long roleId = ShiroUtils.getRoleId();
        return prefix + "/levelThree";
    }
}
