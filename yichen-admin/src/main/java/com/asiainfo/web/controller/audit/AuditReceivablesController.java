package com.asiainfo.web.controller.audit;

import com.asiainfo.audit.service.IAuditReceivablesService;
import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.common.core.domain.AjaxResult;
import com.asiainfo.common.core.page.TableDataInfo;
import com.asiainfo.common.exception.BusinessException;
import com.asiainfo.framework.util.ShiroUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.google.common.collect.Maps;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/audit/receivables")
/**
 * @Title:  实收controller   
 * @Package audit.receivables   
 * @Description:    controller
 * @author: zhaolijun
 * @date:   2019-07-10   
 * @version V1.0 
 */
public class AuditReceivablesController extends BaseController{

    private static final String prefix = "audit/receivables";

	@Autowired
	private IAuditReceivablesService receivablesService;
	
	@RequiresPermissions("audit:receivables:view")
    @GetMapping()
	public String receivables(ModelMap modelMap)
    {
        List<Map<String,Object>> projects = receivablesService.findProjects();
        modelMap.put("projects",projects);
        return prefix + "/receivables";
    }


    /**
     * 分页查询应收
     * @return  应收集合
     */
    @RequiresPermissions("audit:receivables:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list() {
        Map<String, Object> paramMap = getFormMap();
        startPage();
        List<Map<String,Object>> list = receivablesService.selectReceivableList(paramMap);
        return getDataTable(list);
    }

    /**
     * 跳转详情页
     * @return
     */
    @RequiresPermissions("audit:receivables:view")
    @GetMapping("/detail/{id}/{yyDate}")
    public String detail(@PathVariable String id,@PathVariable String yyDate,ModelMap modelMap)
    {
        Map<String, Object> paramp = Maps.newHashMap();
        paramp.put("id",id);
        paramp.put("yyDate",yyDate);
        Map<String,Object> ysInfo = receivablesService.selectReceivableById(paramp);
        if ( null == ysInfo || ysInfo.isEmpty() ) {
            throw new BusinessException("查询应收数据不存在");
        } else {
            modelMap.put("ysInfo", ysInfo);
        }
        return prefix + "/detail";
    }

    /**
     * 分页查询应收明细
     * @return  应收集合
     */
    @RequiresPermissions("audit:receivables:view")
    @PostMapping("/listYsSys")
    @ResponseBody
    public TableDataInfo listYsSys() {
        Map<String, Object> paramMap = getFormMap();
        List<Map<String,Object>> list = receivablesService.selectYsSysByCnd(paramMap);
        return getDataTable(list);
    }

    /**
     * 新增应收信息
     * @param mmap
     * @return
     */
    @RequiresPermissions("audit:receivables:add")
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        return prefix + "/add";
    }

    /**
     * 修改应收信息
     * @param mmap
     * @return
     */
    @GetMapping("/edit/{id}/{type}")
    public String edit(@PathVariable("id")  String id,@PathVariable("type") String type,ModelMap mmap)
    {
        mmap.put("id",id);
        mmap.put("type",type);
        //获取应收信息
        Map<String, Object> mainInfo = receivablesService.findYsHandInfoById(id);
        List<Map<String, Object>> propsInfo = receivablesService.findYsHandProsInfoById(id);
        List<Map<String,Object>> projects = receivablesService.findProjects();
        mmap.put("projects",projects);
        mmap.put("mainInfo",mainInfo);
        mmap.put("propsInfo",propsInfo);
        return prefix + "/edit";
    }


    @RequiresPermissions("audit:receivables:add")
    @PostMapping("/findProjects")
    @ResponseBody
    public  AjaxResult findProjects() {
        List<Map<String,Object>> list = receivablesService.findProjects();
        AjaxResult data = success().put("data", list);
        return data;
    }

    /**
     * 手工登记应收
     * @return
     */
    @RequiresPermissions("audit:receivables:add")
    @PostMapping("/insertAuRcbBossOut")
    @ResponseBody
    public  AjaxResult insertAuRcbBossOut() {
        Map<String, Object> paramMap = getFormMap();
        try {
            paramMap.put("createBy",ShiroUtils.getSysUser().getUserId());
            String pros= (String) paramMap.get("prosJson");
            List<Map<String, Object>> proList = parseListMap(pros);
            paramMap.put("proList",proList);
            receivablesService.insertAuRcbBossOut(paramMap);
            return success("登记成功");
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    /**
     * 手工登记应收修改
     * @return
     */
    @RequiresPermissions("audit:receivables:edit")
    @PostMapping("/updateAuRcbBossOut")
    @ResponseBody
    public  AjaxResult updateAuRcbBossOut() {
        Map<String, Object> paramMap = getFormMap();
        try {
            paramMap.put("createBy",ShiroUtils.getSysUser().getUserId());
            String pros= (String) paramMap.get("prosJson");
            List<Map<String, Object>> proList = parseListMap(pros);
            paramMap.put("proList",proList);
            receivablesService.updateAuRcbBossOut(paramMap);
            return success("修改成功");
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    /**
     * 分页查询应收
     * @return  应收集合
     */
    @RequiresPermissions("audit:receivables:add")
    @PostMapping("/selectDtInfoByPage")
    @ResponseBody
    public TableDataInfo selectDtInfoByPage() {
        Map<String, Object> paramMap = getFormMap();
        startPage();
        List<Map<String,Object>> list = receivablesService.selectDtInfoByPage(paramMap);
        return getDataTable(list);
    }

    @RequiresPermissions("audit:receivables:add")
    @GetMapping("/getDtSearchHtml")
    public String getDtSearchHtml()
    {
        return prefix + "/dt_search.html";
    }

    @RequiresPermissions("audit:receivables:view")
    @GetMapping("/subDetail/{dateNo}/{dtId}/{projId}")
    public String subDetail(@PathVariable String dateNo,@PathVariable String dtId,@PathVariable String projId,ModelMap modelMap)
    {
        Map<String,Object> map=Maps.newHashMap();
        map.put("id",dtId);
        map.put("yyDate",dateNo);
        map.put("projId",projId);
        List<Map<String,Object>> list = receivablesService.selectYsSysByCnd(map);

        modelMap.put("dateNo",dateNo);
        modelMap.put("dtId",dtId);
        modelMap.put("projId",projId);
        modelMap.put("sumInfo",list.get(0));
        return prefix + "/subDetail";
    }

    /**
     * 分页查询应收明细
     * @return  应收集合
     */
    @RequiresPermissions("audit:receivables:view")
    @PostMapping("/listInOutMoneys")
    @ResponseBody
    public TableDataInfo listInOutMoneys() {
        Map<String, Object> map = getFormMap();
        List<Map<String, Object>> inLists = receivablesService.selectSysInProjMoneyList(map);
        return getDataTable(inLists);
    }

    /**
     *  删除手工登记的应收数据
     * @return
     */
    @RequiresPermissions("audit:receivables:remove")
    @PostMapping("/deleteYsDetailHand/{id}")
    @ResponseBody
    public  AjaxResult deleteYsDetailHand(@PathVariable String id) {
        try {
            receivablesService.deleteYsDetailHand(id);
            return success("登记成功");
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    private List<Map<String,Object>> parseListMap(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CollectionLikeType type = objectMapper.getTypeFactory().constructCollectionLikeType(List.class, Map.class);
        List<Map<String,Object>>  list = null;
        try {
            list = objectMapper.readValue(json, type);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("解析参数失败");
        }
        return list;
    }
}
