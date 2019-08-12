package com.asiainfo.controller;

import com.asiainfo.common.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/socket")
public class OpenDiagoModelController extends BaseController {

    private String prefix = "socket/diag";

    @RequestMapping("/open")
    public String OpenDiag()
    {
        return prefix+"/socket";
    }

}
