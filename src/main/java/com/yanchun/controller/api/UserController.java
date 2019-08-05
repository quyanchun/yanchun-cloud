package com.yanchun.controller.api;

import com.yanchun.formBean.LoginFormBean;
import com.yanchun.jpa.entity.Passport;
import com.yanchun.service.UserService;
import com.yanchun.utils.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author quyanchun
 * @Date 2019/8/5
 */
@RestController
public class UserController {
    private Logger _LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    /**
     * login
     * @param loginFormBean
     * @return
     */
    @RequestMapping(value = "user/login",method = RequestMethod.POST)
    public ResponseEntity<CommonResult> login(@RequestBody LoginFormBean loginFormBean){
        CommonResult commonResult = new CommonResult();
        try {
            Passport passportByPhone = userService.getPassportByPhone(loginFormBean.getUserName());
            commonResult.setCode(1000);
            commonResult.setMessage("success");
            commonResult.setResult(passportByPhone);
            return ResponseEntity.ok(commonResult);
        }catch (Exception e){
            _LOG.error("=====login失败：",e);
        }
        return ResponseEntity.ok(commonResult);
    }

    @RequestMapping("user/test")
    public ResponseEntity<CommonResult> tset(@RequestParam String phone){
        CommonResult commonResult = new CommonResult();
        try {
            Passport passportByPhone = userService.getPassportByPhone(phone);
            commonResult.setCode(1000);
            commonResult.setMessage("success");
            commonResult.setResult(passportByPhone);
            return ResponseEntity.ok(commonResult);
        }catch (Exception e){
            _LOG.error("=====test失败：",e);
        }
        return ResponseEntity.ok(commonResult);
    }
}
