package com.sgzs.springsecurity.oauth.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: jianyufeng
 * @description:
 * @date: 2020/6/1 17:21
 */
@Data
public class MyUser implements Serializable {
    private static final long serialVersionUID = 3497935890426858541L;

    private String userName;
    private String password;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked= true;
    private boolean credentialsNonExpired= true;
    private boolean enabled= true;
}
