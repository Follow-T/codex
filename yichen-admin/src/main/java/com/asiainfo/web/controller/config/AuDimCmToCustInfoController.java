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
import com.asiainfo.config.domain.AuDimCmToCustInfo;
import com.asiainfo.config.service.IAuDimCmToCustInfoService;
import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.common.core.page.TableDataInfo;
import com.asiainfo.common.core.domain.AjaxResult;
import com.asiainfo.common.utils.poi.ExcelUtil;

/**
 * 客户管理 信息操作处理
 * 
 * @author changtong
 * @date 2019-07-18
 */
@Controller
@RequestMapping("/config/auDimCmToCustInfo")
public class AuDimCmToCustInfoController extends BaseController
{
    private String prefix = "config/auDimCmToCustInfo";
	
	@Autowired
	private IAuDimCmToCustInfoService auDimCmToCustInfoService;
	
	@RequiresPermissions("config:auDimCmToCustInfo:view")
	@GetMapping()
	public String auDimCmToCustInfo()
	{
	    return prefix + "/auDimCmToCustInfo";
	}
	
	/**
	 * 查询客户管理列表
	 */
	@RequiresPermissions("config:auDimCmToCustInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(AuDimCmToCustInfo auDimCmToCustInfo)
	{
		startPage();
        List<AuDimCmToCustInfo> list = auDimCmToCustInfoService.selectAuDimCmToCustInfoList(auDimCmToCustInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出客户管理列表
	 */
	@RequiresPermissions("config:auDimCmToCustInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AuDimCmToCustInfo auDimCmToCustInfo)
    {
    	List<AuDimCmToCustInfo> list = auDimCmToCustInfoService.selectAuDimCmToCustInfoList(auDimCmToCustInfo);
        ExcelUtil<AuDimCmToCustInfo> util = new ExcelUtil<AuDimCmToCustInfo>(AuDimCmToCustInfo.class);
        return util.exportExcel(list, "auDimCmToCustInfo");
    }
	
	/**
	 * 新增客户管理
	 */
	@GetMapping("/add/{id}")
	public String add(@PathVariable("id") Long id, ModelMap mmap)
	{
		AuDimCmToCustInfo auDimCmToCustInfo = new AuDimCmToCustInfo();
		auDimCmToCustInfo.setOrgid(id);
		mmap.put("auDimCmToCustInfo", auDimCmToCustInfo);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存客户管理
	 */
	@RequiresPermissions("config:auDimCmToCustInfo:add")
	@Log(title = "客户管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(AuDimCmToCustInfo auDimCmToCustInfo)
	{		
		return toAjax(auDimCmToCustInfoService.insertAuDimCmToCustInfo(auDimCmToCustInfo));
	}

	/**
	 * 修改客户管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		AuDimCmToCustInfo auDimCmToCustInfo = auDimCmToCustInfoService.selectAuDimCmToCustInfoById(id);
		mmap.put("auDimCmToCustInfo", auDimCmToCustInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存客户管理
	 */
	@RequiresPermissions("config:auDimCmToCustInfo:edit")
	@Log(title = "客户管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(AuDimCmToCustInfo auDimCmToCustInfo)
	{		
		return toAjax(auDimCmToCustInfoService.updateAuDimCmToCustInfo(auDimCmToCustInfo));
	}
	
	/**
	 * 删除客户管理
	 */
	@RequiresPermissions("config:auDimCmToCustInfo:remove")
	@Log(title = "客户管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(auDimCmToCustInfoService.deleteAuDimCmToCustInfoByIds(ids));
	}
	
}
