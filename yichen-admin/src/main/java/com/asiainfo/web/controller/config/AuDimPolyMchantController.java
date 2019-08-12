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
import com.asiainfo.config.domain.AuDimPolyMchant;
import com.asiainfo.config.service.IAuDimPolyMchantService;
import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.common.core.page.TableDataInfo;
import com.asiainfo.common.core.domain.AjaxResult;
import com.asiainfo.common.utils.poi.ExcelUtil;

/**
 * 聚合支付 信息操作处理
 * 
 * @author changtong
 * @date 2019-07-17
 */
@Controller
@RequestMapping("/config/auDimPolyMchant")
public class AuDimPolyMchantController extends BaseController
{
    private String prefix = "config/auDimPolyMchant";
	
	@Autowired
	private IAuDimPolyMchantService auDimPolyMchantService;
	
	@RequiresPermissions("config:auDimPolyMchant:view")
	@GetMapping()
	public String auDimPolyMchant()
	{
	    return prefix + "/auDimPolyMchant";
	}
	
	/**
	 * 查询聚合支付列表
	 */
	@RequiresPermissions("config:auDimPolyMchant:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(AuDimPolyMchant auDimPolyMchant)
	{
		startPage();
        List<AuDimPolyMchant> list = auDimPolyMchantService.selectAuDimPolyMchantList(auDimPolyMchant);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出聚合支付列表
	 */
	@RequiresPermissions("config:auDimPolyMchant:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AuDimPolyMchant auDimPolyMchant)
    {
    	List<AuDimPolyMchant> list = auDimPolyMchantService.selectAuDimPolyMchantList(auDimPolyMchant);
        ExcelUtil<AuDimPolyMchant> util = new ExcelUtil<AuDimPolyMchant>(AuDimPolyMchant.class);
        return util.exportExcel(list, "auDimPolyMchant");
    }
	
	/**
	 * 新增聚合支付
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存聚合支付
	 */
	@RequiresPermissions("config:auDimPolyMchant:add")
	@Log(title = "聚合支付", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(AuDimPolyMchant auDimPolyMchant)
	{		
		return toAjax(auDimPolyMchantService.insertAuDimPolyMchant(auDimPolyMchant));
	}

	/**
	 * 修改聚合支付
	 */
	@GetMapping("/edit/{orgId}")
	public String edit(@PathVariable("orgId") Integer orgId, ModelMap mmap)
	{
		AuDimPolyMchant auDimPolyMchant = auDimPolyMchantService.selectAuDimPolyMchantById(orgId);
		mmap.put("auDimPolyMchant", auDimPolyMchant);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存聚合支付
	 */
	@RequiresPermissions("config:auDimPolyMchant:edit")
	@Log(title = "聚合支付", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(AuDimPolyMchant auDimPolyMchant)
	{		
		return toAjax(auDimPolyMchantService.updateAuDimPolyMchant(auDimPolyMchant));
	}
	
	/**
	 * 删除聚合支付
	 */
	@RequiresPermissions("config:auDimPolyMchant:remove")
	@Log(title = "聚合支付", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(auDimPolyMchantService.deleteAuDimPolyMchantByIds(ids));
	}
	
}
