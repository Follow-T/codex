package com.asiainfo.web.controller.config;

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
import com.asiainfo.config.domain.AuDimCmStaffInfo;
import com.asiainfo.config.service.IAuDimCmStaffInfoService;
import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.common.core.page.TableDataInfo;
import com.asiainfo.common.core.domain.AjaxResult;
import com.asiainfo.common.utils.poi.ExcelUtil;

/**
 * 客户 信息操作处理
 * 
 * @author changtong
 * @date 2019-07-18
 */
@Controller
@RequestMapping("/config/auDimCmStaffInfo")
public class AuDimCmStaffInfoController extends BaseController
{
    private String prefix = "config/auDimCmStaffInfo";
	
	@Autowired
	private IAuDimCmStaffInfoService auDimCmStaffInfoService;
	
	@RequiresPermissions("config:auDimCmStaffInfo:view")
	@GetMapping()
	public String auDimCmStaffInfo()
	{
	    return prefix + "/auDimCmStaffInfo";
	}
	
	/**
	 * 查询客户列表
	 */
	@RequiresPermissions("config:auDimCmStaffInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(AuDimCmStaffInfo auDimCmStaffInfo)
	{
		startPage();
        List<AuDimCmStaffInfo> list = auDimCmStaffInfoService.selectAuDimCmStaffInfoList(auDimCmStaffInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出客户列表
	 */
	@RequiresPermissions("config:auDimCmStaffInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AuDimCmStaffInfo auDimCmStaffInfo)
    {
    	List<AuDimCmStaffInfo> list = auDimCmStaffInfoService.selectAuDimCmStaffInfoList(auDimCmStaffInfo);
        ExcelUtil<AuDimCmStaffInfo> util = new ExcelUtil<AuDimCmStaffInfo>(AuDimCmStaffInfo.class);
        return util.exportExcel(list, "auDimCmStaffInfo");
    }
	
	/**
	 * 新增客户
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存客户
	 */
	@RequiresPermissions("config:auDimCmStaffInfo:add")
	@Log(title = "客户", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(AuDimCmStaffInfo auDimCmStaffInfo)
	{		
		return toAjax(auDimCmStaffInfoService.insertAuDimCmStaffInfo(auDimCmStaffInfo));
	}

	/**
	 * 修改客户
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		AuDimCmStaffInfo auDimCmStaffInfo = auDimCmStaffInfoService.selectAuDimCmStaffInfoById(id);
		mmap.put("auDimCmStaffInfo", auDimCmStaffInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存客户
	 */
	@RequiresPermissions("config:auDimCmStaffInfo:edit")
	@Log(title = "客户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(AuDimCmStaffInfo auDimCmStaffInfo)
	{		
		return toAjax(auDimCmStaffInfoService.updateAuDimCmStaffInfo(auDimCmStaffInfo));
	}
	
	/**
	 * 删除客户
	 */
	@RequiresPermissions("config:auDimCmStaffInfo:remove")
	@Log(title = "客户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(auDimCmStaffInfoService.deleteAuDimCmStaffInfoByIds(ids));
	}
	
}
