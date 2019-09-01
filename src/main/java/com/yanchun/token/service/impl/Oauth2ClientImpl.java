package com.yanchun.token.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yanchun.token.service.Oauth2Client;
import com.yanchun.utils.HttpClientUtills;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Set;

/**
 * @Author quyanchun
 * @Date 2019/8/13
 */
@Service
public class Oauth2ClientImpl implements Oauth2Client {
    private Logger _LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ConsumerTokenServices tokenServices;
    @Override
    public JSONObject postAccessToken(Map<String, String> parameters) {
        String s = this.mapToString(parameters);
        String s1 = HttpClientUtills.httpPost("http://localhost:10002/oauth/token", s);
        JSONObject jsonObject = JSONObject.parseObject(s1);
        return jsonObject;
    }

    @Override
    public void removeToken(String access_token) {
        boolean b = tokenServices.revokeToken(access_token);
    }

    private String mapToString(Map<String, String> parameters){
        String value="";
        for(String s: parameters.keySet()){
            value+=s+"="+parameters.get(s)+"&";
        }
        return value;
    }



}
