package com.asiainfo.web.controller.audit;

import com.asiainfo.audit.service.IAuditIncomeService;
import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.common.core.page.TableDataInfo;
import com.asiainfo.framework.util.ShiroUtils;
import com.asiainfo.system.domain.SysUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, XXX
 * @Title:  实缴controller   
 * @Package audit.income   
 * @Description:    controller
 * @createAuthor: changtong
 * @fixAuthor: 
 * @date:   2019-07-10   
 * @version V1.0 
 */
@Controller
@RequestMapping("/audit/income")
public class AuditIncomeController extends BaseController{

	private static final String prefix = "audit/income";

	@Autowired
	private IAuditIncomeService auditIncomeService;
	
	@RequiresPermissions("audit:income:view")
    @GetMapping()
	public String income()
    {
		//获取当前session的user
        SysUser user = ShiroUtils.getSysUser();
        //获取当前对象的role，0表示没有绑定role
        long roleId = ShiroUtils.getRoleId();
        return prefix + "/income";
    }

    /**
     * 分页查询实缴
     * @return
     */
    @RequiresPermissions("audit:income:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo listCd() {
        Map<String, Object> paramMap = getFormMap();
        startPage();
        List<Map<String, Object>> list = auditIncomeService.selectIncomeList(paramMap);
        return getDataTable(list);
    }
}
