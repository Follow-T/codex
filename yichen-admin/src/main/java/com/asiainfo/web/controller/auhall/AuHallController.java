package com.asiainfo.web.controller.auhall;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.common.core.page.TableDataInfo;
import com.asiainfo.config.domain.AuHall;
import com.asiainfo.config.service.IAuHallService;

@Controller
@RequestMapping("/config/channelSigning")
public class AuHallController extends BaseController{
	
	@Autowired
	private IAuHallService iAuHallService;
	
	 private String prefix = "config/channelSigning";
	
	@GetMapping()
    public String channelSigning()
    {
        return prefix + "/channelSigning";
    }
	
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AuHall auHall)
    {
        startPage();
        //System.out.println(111);
       List<AuHall> list=iAuHallService.selectAuHallsList(auHall);
        System.out.println(list.size());
        return getDataTable(list);
    }
    
    @GetMapping("/{id}/account")
    public String account()
    {
        return prefix + "/bindingAccount/account";
    }
    
}
