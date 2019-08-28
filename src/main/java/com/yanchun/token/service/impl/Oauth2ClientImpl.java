package com.yanchun.token.service.impl;

import com.yanchun.token.service.Oauth2Client;
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
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Map;

/**
 * @Author quyanchun
 * @Date 2019/8/13
 */
@Service
public class Oauth2ClientImpl implements Oauth2Client {
    private Logger _LOG = LoggerFactory.getLogger(this.getClass());

    private TokenGranter tokenGranter;
    @Override
    public Map<String, Object> postAccessToken(Map<String, String> parameters) {
//        TokenRequest tokenRequest = this.getOAuth2RequestFactory().createTokenRequest(parameters, authenticatedClient);
//        if (!StringUtils.hasText(tokenRequest.getGrantType())) {
//            throw new InvalidRequestException("Missing grant type");
//        } else if (tokenRequest.getGrantType().equals("implicit")) {
//            throw new InvalidGrantException("Implicit grant type not supported from token endpoint");
//        } else {
//            if (this.isAuthCodeRequest(parameters) && !tokenRequest.getScope().isEmpty()) {
//                this._LOG.debug("Clearing scope of incoming token request");
//                tokenRequest.setScope(Collections.emptySet());
//            }
//
//            if (this.isRefreshTokenRequest(parameters)) {
//                tokenRequest.setScope(OAuth2Utils.parseParameterList((String)parameters.get("scope")));
//            }
//
//            OAuth2AccessToken token = this.getTokenGranter().grant(tokenRequest.getGrantType(), tokenRequest);
//            if (token == null) {
//                throw new UnsupportedGrantTypeException("Unsupported grant type: " + tokenRequest.getGrantType());
//            } else {
//
//            }
//        }
        return null;
    }
    protected TokenGranter getTokenGranter() {
        return this.tokenGranter;
    }
    private boolean isAuthCodeRequest(Map<String, String> parameters) {
        return "authorization_code".equals(parameters.get("grant_type")) && parameters.get("code") != null;
    }

    private boolean isRefreshTokenRequest(Map<String, String> parameters) {
        return "refresh_token".equals(parameters.get("grant_type")) && parameters.get("refresh_token") != null;
    }
    @Override
    public void removeToken(String access_token) {

    }
}
