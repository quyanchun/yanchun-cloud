package com.yanchun.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author quyanchun
 * @Date 2019/8/5
 */
@Controller
public class BackController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getHtml1() {
        return "back/login";
    }
}
