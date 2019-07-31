package com.yanchun.controller.page;

import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author quyanchun
 * @Date 2019/2/14
 */
@Controller
public class MyController {

    @RequestMapping(value = "/my/index1", method = RequestMethod.GET)
    public String getHtml1() {
        return "my/new1";
    }

    @RequestMapping(value = "/my/index2", method = RequestMethod.GET)
    public String getHtml2() {
        return "my/new2";
    }

    @RequestMapping(value = "/my/index", method = RequestMethod.GET)
    public String getHtml() {
        return "my/index";
    }
}
