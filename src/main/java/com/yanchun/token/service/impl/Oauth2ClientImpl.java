package com.yanchun.token.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yanchun.token.service.Oauth2Client;
import com.yanchun.utils.HttpClient;
import com.yanchun.utils.HttpClientUtills;
import org.apache.http.client.methods.HttpPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.InvalidRequestException;
import org.springframework.security.oauth2.common.exceptions.UnsupportedGrantTypeException;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author quyanchun
 * @Date 2019/8/13
 */
@Service
public class Oauth2ClientImpl implements Oauth2Client {
    private Logger _LOG = LoggerFactory.getLogger(this.getClass());

    @Override
    public Map<String, Object> postAccessToken(Map<String, String> parameters) {
        String param = JSON.toJSONString(parameters);
        String s = HttpClientUtills.httpPost("http://localhost:10002/oauth/token", param);
//        JSONObject jsonObject = HttpClientUtills.httpGet("http://localhost:10002/oauth/token");
        return null;
    }

    @Override
    public void removeToken(String access_token) {

    }
}
