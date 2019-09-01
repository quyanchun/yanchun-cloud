package com.yanchun.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.yanchun.constants.CredentialType;
import com.yanchun.formBean.LoginFormBean;
import com.yanchun.jpa.entity.Passport;
import com.yanchun.service.UserService;
import com.yanchun.token.model.LoginAppUser;
import com.yanchun.token.model.SystemClientInfo;
import com.yanchun.token.service.Oauth2Client;
import com.yanchun.token.utils.AppUserUtil;
import com.yanchun.utils.CommonResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author quyanchun
 * @Date 2019/8/5
 */
@RestController
public class UserController {
    private Logger _LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @Autowired
    private Oauth2Client oauth2Client;

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



    /**
     * 当前登录用户 LoginAppUser
     */
    @GetMapping("/user/current")
    public LoginAppUser getLoginAppUser() {
        return AppUserUtil.getLoginAppUser();
    }



}
