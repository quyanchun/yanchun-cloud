package com.yanchun.adapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 默认的访问页面
 * @author  quyanchun
 * @date    2019/7/29
 */

@Configuration
public class DefaultView extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry reg) {
        reg.addViewController("/").setViewName("redirect:http://http://www.gushishop.top/");//默认访问页面
        reg.setOrder(Ordered.HIGHEST_PRECEDENCE);//最先执行过滤
        super.addViewControllers(reg);
    }
}
