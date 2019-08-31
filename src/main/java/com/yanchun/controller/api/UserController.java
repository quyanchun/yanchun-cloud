package com.yanchun.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.yanchun.constants.CredentialType;
import com.yanchun.formBean.LoginFormBean;
import com.yanchun.jpa.entity.Passport;
import com.yanchun.service.UserService;
import com.yanchun.token.model.SystemClientInfo;
import com.yanchun.token.service.Oauth2Client;
import com.yanchun.utils.CommonResult;
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
    private TokenEndpoint tokenEndpoint;
    @Autowired
    private Oauth2Client oauth2Client;
    /**
     * login
     * @param loginFormBean
     * @return
     */
    @RequestMapping(value = "user/login",method = RequestMethod.POST)
    public ResponseEntity<CommonResult> login(@RequestBody LoginFormBean loginFormBean, Principal principal){
        CommonResult commonResult = new CommonResult();
        try {
//            Passport passportByPhone = userService.getPassportByPhone(loginFormBean.getUserName());
            commonResult.setCode(1000);
            commonResult.setMessage("success");
            Map<String, String> parameters = new HashMap<>();
            parameters.put(OAuth2Utils.GRANT_TYPE, "password");
            parameters.put(OAuth2Utils.CLIENT_ID, SystemClientInfo.CLIENT_ID);
            parameters.put("client_secret", SystemClientInfo.CLIENT_SECRET);
            parameters.put(OAuth2Utils.SCOPE, SystemClientInfo.CLIENT_SCOPE);
            parameters.put("username", loginFormBean.getUserName() + "|" + CredentialType.USERNAME.name());
            parameters.put("password", loginFormBean.getPassWord());
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null) {
                if (authentication instanceof OAuth2Authentication) {
                    OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
                    String access_token = details.getTokenValue();
                    System.out.println(access_token);
                }
            }
            JSONObject map = oauth2Client.postAccessToken(parameters);
            commonResult.setResult(map);
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
