package com.asiainfo.web.controller.audit;

import com.asiainfo.audit.domain.AuditLevelOne;
import com.asiainfo.common.constant.Constants;
import com.asiainfo.common.core.domain.AjaxResult;
import com.asiainfo.common.core.page.TableDataInfo;
import com.asiainfo.common.exception.BusinessException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.asiainfo.audit.service.IAuditLevelOneService;
import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.framework.util.ShiroUtils;
import com.asiainfo.system.domain.SysUser;

import java.util.List;
import java.util.Map;

/**
 * 一级稽核控制层
 */
@Controller
@RequestMapping("/audit/levelOne")
public class AuditLevelOneContoller extends BaseController {
    //默认制定模板的路径
    //path:/yichen-admin/src/main/resources/templates/audit/levelOne/levelOne.html
    private static final String prefix = "audit/levelOne";

    @Autowired
    private IAuditLevelOneService levelOneService;

    //shiro的权限管理注解，根据sys_menu的perms字段判断是否具有该访问权限
    @RequiresPermissions("audit:levelOne:view")
    @GetMapping()
    public String levelOne() {
        //获取当前session的user
        SysUser user = ShiroUtils.getSysUser();
        //获取当前对象的role，0表示没有绑定role
        long roleId = ShiroUtils.getRoleId();
        return prefix + "/levelOne";
    }

    /**
     * 分页查询一级稽核
     *
     * @param auditLevelOne 条件
     * @return
     */
    @RequiresPermissions("audit:levelOne:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AuditLevelOne auditLevelOne) {
        startPage();
        List<Map<String,Object>> list = levelOneService.selectAuditLevelOneList(auditLevelOne);
        return getDataTable(list);
    }

    /**
     * 查询一级稽核---应收列表
     *
     * @param auditLevelOne
     * @return
     */
    @RequiresPermissions("audit:levelOne:edit")
    @PostMapping("/listYs")
    @ResponseBody
    public TableDataInfo listYs(AuditLevelOne auditLevelOne) {
        startPage();
        List<Map<String, Object>> list = levelOneService.selectYsListByCnd(auditLevelOne);
        return getDataTable(list);
    }

    /**
     * 查询一级稽核---实缴列表
     *
     * @param auditLevelOne
     * @return
     */
    @RequiresPermissions("audit:levelOne:edit")
    @PostMapping("/listSj")
    @ResponseBody
    public TableDataInfo listSj(AuditLevelOne auditLevelOne) {
        startPage();
        List<Map<String, Object>> list = levelOneService.selectSjListByCnd(auditLevelOne);
        return getDataTable(list);
    }

    /**
     * 查询一级稽核---长短款稽核
     * @return
     */
    @RequiresPermissions("audit:levelOne:edit")
    @PostMapping("/listCd")
    @ResponseBody
    public TableDataInfo listCd() {
        Map<String, Object> paramMap = getFormMap();
        startPage();
        List<Map<String, Object>> list = levelOneService.selectCdListByCnd(paramMap);
        return getDataTable(list);
    }


    /**
     * 跳转一级稽核编辑和查询稽核信息
     *
     * @param id   主键id
     * @param modelMap 模型容器
     * @return
     */
    @RequiresPermissions("audit:levelOne:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, ModelMap modelMap) {
        Map<String,Object> auditOneLevel = levelOneService.selectOneLevelById(id);
        if ( null == auditOneLevel ) {
            throw new BusinessException("查询一级稽核数据不存在");
        } else {
            //查询历史审核记录
            List<Map<String, Object>> checkHisInfo = levelOneService.selectOneLevelCheckHisInfo(id);
            modelMap.put("checkHisInfo", checkHisInfo);
            modelMap.put("autditOneLevel", auditOneLevel);
        }
        return prefix + "/edit";
    }

    /**
     * 跳转一级稽核编辑二级弹窗
     * @param modelMap 模型容器
     * @return
     */
    @RequiresPermissions("audit:levelOne:edit")
    @GetMapping("/editSubDetail")
    public String editSubDetail( ModelMap modelMap) {

        return prefix + "/writeOff";
    }

    /**
     * 跳转一级稽核编辑二级弹窗
     * @param modelMap 模型容器
     * @return
     */
    @RequiresPermissions("audit:levelOne:view")
    @GetMapping("/viewEdit")
    public String viewEdit( ModelMap modelMap) {

        return prefix + "/viewEdit";
    }

    /**
     * 跳转一级稽核编辑二级弹窗
     * @param modelMap 模型容器
     * @return
     */
    @RequiresPermissions("audit:levelOne:view")
    @GetMapping("/factnetPaidView")
    public String factnetPaidView( ModelMap modelMap) {

        return prefix + "/factnetPaidView";
    }
    /**
     * 审核-一级稽核
     * @return
     */
    @RequiresPermissions("audit:levelOne:edit")
    @PostMapping("/checkOneLevel")
    @ResponseBody
    public AjaxResult checkOneLevel() {
        AjaxResult result=null;
        Map<String, Object> paramMap = getFormMap();
        if(paramMap.containsKey("check_seq")) {
            SysUser user = ShiroUtils.getSysUser();
            Long u_id = user.getUserId();
            paramMap.put("create_by", u_id);
            paramMap.put("update_by", u_id);
            paramMap.put("auditter_dept", user.getDept().getDeptName());
            try {
                levelOneService.saveOneLevelCheck(paramMap);
                result = success("一级稽核审核成功");
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("审核一级稽核{0}失败", paramMap.get("check_seq"));
                result = error("一级稽核审核失败，后台异常！");
            }
        }else{
            result = error("一级稽核审核失败，信息不足！");
        }
        return result;
    }
}
