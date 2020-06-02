package com.sgzs.springsecurity.oauth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jianyufeng
 * @description:
 * @date: 2020/6/1 21:02
 */
@RestController
public class UserController {

    @GetMapping("index")
    public Object index(Authentication authentication){
        return authentication;
    }
}
