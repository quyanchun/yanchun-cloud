package com.yanchun.token.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface Oauth2Client {

    /**
     * 获取access_token<br>
     * 这是spring-security-oauth2底层的接口，类TokenEndpoint<br>
     * 感兴趣可看下视频章节05.5 生成access_token的核心源码
     *
     * @param parameters
     * @return
     * @see org.springframework.security.oauth2.provider.endpoint.TokenEndpoint
     */
    JSONObject postAccessToken(Map<String, String> parameters);

    /**
     * 删除access_token和refresh_token<br>
     * 认证中心的OAuth2Controller方法removeToken
     *
     * @param access_token
     */
    void removeToken(String access_token);

}
