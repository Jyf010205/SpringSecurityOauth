package com.sgzs.springsecurity.oauth.config;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;

/**
 * @author: jianyufeng
 * @description:
 * @date: 2020/6/2 12:25
 */
public class JWTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("message","hello world");
        DefaultOAuth2AccessToken defaultOAuth2AccessToken = new DefaultOAuth2AccessToken("jianyufeng");
        defaultOAuth2AccessToken.setAdditionalInformation(info);
        return defaultOAuth2AccessToken;
    }
}
