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
import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.common.core.domain.AjaxResult;
import com.asiainfo.common.core.page.TableDataInfo;
import com.asiainfo.common.enums.BusinessType;
import com.asiainfo.common.utils.poi.ExcelUtil;
import com.asiainfo.config.domain.AuConfigLong;
import com.asiainfo.config.service.IAuConfigLongService;

/**
 * 长短款配置说明 信息操作处理
 * 
 * @author changtong
 * @date 2019-07-16
 */
@Controller
@RequestMapping("/config/auConfigLong")
public class AuConfigLongController extends BaseController
{
    private String prefix = "config/long";
	
	@Autowired
	private IAuConfigLongService auConfigLongService;
	
	@RequiresPermissions("config:auConfigLong:view")
	@GetMapping()
	public String auConfigLong()
	{
	    return prefix + "/auConfigLong";
	}
	
	/**
	 * 查询长短款配置说明列表
	 */
	@RequiresPermissions("config:auConfigLong:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(AuConfigLong auConfigLong)
	{
		startPage();
        List<AuConfigLong> list = auConfigLongService.selectAuConfigLongList(auConfigLong);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出长短款配置说明列表
	 */
	@RequiresPermissions("config:auConfigLong:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AuConfigLong auConfigLong)
    {
    	List<AuConfigLong> list = auConfigLongService.selectAuConfigLongList(auConfigLong);
        ExcelUtil<AuConfigLong> util = new ExcelUtil<AuConfigLong>(AuConfigLong.class);
        return util.exportExcel(list, "auConfigLong");
    }
	
	/**
	 * 新增长短款配置说明
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存长短款配置说明
	 */
	@RequiresPermissions("config:auConfigLong:add")
	@Log(title = "长短款配置说明", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(AuConfigLong auConfigLong)
	{		
		return toAjax(auConfigLongService.insertAuConfigLong(auConfigLong));
	}

	/**
	 * 修改长短款配置说明
	 */
	@GetMapping("/edit/{costType}")
	public String edit(@PathVariable("costType") String costType, ModelMap mmap)
	{
		AuConfigLong auConfigLong = auConfigLongService.selectAuConfigLongById(costType);
		mmap.put("auConfigLong", auConfigLong);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存长短款配置说明
	 */
	@RequiresPermissions("config:auConfigLong:edit")
	@Log(title = "长短款配置说明", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(AuConfigLong auConfigLong)
	{		
		return toAjax(auConfigLongService.updateAuConfigLong(auConfigLong));
	}
	
	/**
	 * 删除长短款配置说明
	 */
	@RequiresPermissions("config:auConfigLong:remove")
	@Log(title = "长短款配置说明", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(auConfigLongService.deleteAuConfigLongByIds(ids));
	}
	
}
