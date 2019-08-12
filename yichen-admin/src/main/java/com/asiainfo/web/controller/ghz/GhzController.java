package com.asiainfo.web.controller.ghz;

import com.asiainfo.common.annotation.Log;
import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.common.core.domain.AjaxResult;
import com.asiainfo.common.core.page.TableDataInfo;
import com.asiainfo.common.core.text.Convert;
import com.asiainfo.common.enums.BusinessType;
import com.asiainfo.common.utils.poi.ExcelUtil;
import com.asiainfo.framework.util.ShiroUtils;
import com.asiainfo.test.mapper.TyTestMapper;
import com.asiainfo.test.domain.TyTestUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/ghz")
public class GhzController extends BaseController {

    @Autowired
    private TyTestMapper tyTestMapper;

    @RequestMapping()
    public String index() {
        return "/ghz/list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public TableDataInfo list(TyTestUser user) {
        startPage();
        return getDataTable(tyTestMapper.queryAll());
    }

    @RequestMapping("/add")
    public String add(ModelMap mmap) {
        return "/ghz/add";
    }

    /**
     * 新增保存参数配置
     */
    @RequiresPermissions("system:config:add")
    @Log(title = "新增保存测试", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TyTestUser user)
    {
        return toAjax(tyTestMapper.insert(user));
    }


    @RequestMapping("/edit/{userName}")
    public String edit(@PathVariable("userName") Integer userId, ModelMap mmap) {
        TyTestUser user = tyTestMapper.selectByPrimaryKey(userId);
        mmap.put("user",user);
        return "/ghz/edit";
    }

    @Log(title = "修改保存测试", businessType = BusinessType.UPDATE)
    @RequestMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TyTestUser user) {
        return toAjax(tyTestMapper.updateByPrimaryKey(user));
    }


    @RequiresPermissions("system:user:remove")
    @Log(title = "删除保存测试", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {

        try
        {
            Integer[] idArray = Convert.toIntArray(ids);
            for(Integer id : idArray) {
                tyTestMapper.deleteUserByIds(id);
            }
            return toAjax(idArray.length);
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:user:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TyTestUser user)
    {
        List<TyTestUser> list = tyTestMapper.queryAll();
        ExcelUtil<TyTestUser> util = new ExcelUtil<TyTestUser>(TyTestUser.class);
        return util.exportExcel(list, "测试数据");
    }

    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:user:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<TyTestUser> util = new ExcelUtil<TyTestUser>(TyTestUser.class);
        List<TyTestUser> userList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = "成功";
        //String message = userService.importUser(userList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("system:user:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<TyTestUser> util = new ExcelUtil<TyTestUser>(TyTestUser.class);
        return util.importTemplateExcel("测试数据");
    }
}
