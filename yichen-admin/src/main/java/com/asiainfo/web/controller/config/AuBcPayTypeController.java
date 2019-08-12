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
import com.asiainfo.config.domain.AuBcPayType;
import com.asiainfo.config.service.IAuBcPayTypeService;
import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.common.core.page.TableDataInfo;
import com.asiainfo.common.core.domain.AjaxResult;
import com.asiainfo.common.utils.poi.ExcelUtil;

/**
 * 缴款类型 信息操作处理
 * 
 * @author changtong
 * @date 2019-07-16
 */
@Controller
@RequestMapping("/config/auBcPayType")
public class AuBcPayTypeController extends BaseController
{
    private String prefix = "config/auBcPayType";
	
	@Autowired
	private IAuBcPayTypeService auBcPayTypeService;
	
	@RequiresPermissions("config:auBcPayType:view")
	@GetMapping()
	public String auBcPayType()
	{
	    return prefix + "/auBcPayType";
	}
	
	/**
	 * 查询缴款类型列表
	 */
	@RequiresPermissions("config:auBcPayType:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(AuBcPayType auBcPayType)
	{
		startPage();
        List<AuBcPayType> list = auBcPayTypeService.selectAuBcPayTypeList(auBcPayType);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出缴款类型列表
	 */
	@RequiresPermissions("config:auBcPayType:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AuBcPayType auBcPayType)
    {
    	List<AuBcPayType> list = auBcPayTypeService.selectAuBcPayTypeList(auBcPayType);
        ExcelUtil<AuBcPayType> util = new ExcelUtil<AuBcPayType>(AuBcPayType.class);
        return util.exportExcel(list, "auBcPayType");
    }
	
	/**
	 * 新增缴款类型
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存缴款类型
	 */
	@RequiresPermissions("config:auBcPayType:add")
	@Log(title = "缴款类型", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(AuBcPayType auBcPayType)
	{		
		return toAjax(auBcPayTypeService.insertAuBcPayType(auBcPayType));
	}

	/**
	 * 修改缴款类型
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		AuBcPayType auBcPayType = auBcPayTypeService.selectAuBcPayTypeById(id);
		mmap.put("auBcPayType", auBcPayType);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存缴款类型
	 */
	@RequiresPermissions("config:auBcPayType:edit")
	@Log(title = "缴款类型", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(AuBcPayType auBcPayType)
	{		
		return toAjax(auBcPayTypeService.updateAuBcPayType(auBcPayType));
	}
	
	/**
	 * 删除缴款类型
	 */
	@RequiresPermissions("config:auBcPayType:remove")
	@Log(title = "缴款类型", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(auBcPayTypeService.deleteAuBcPayTypeByIds(ids));
	}
	
}
