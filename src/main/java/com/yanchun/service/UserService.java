package com.yanchun.service;

import com.yanchun.jpa.entity.Passport;
import com.yanchun.token.model.LoginAppUser;

public interface UserService {
    /**
     * 获取用户passport
     * @param phone
     * @return
     * @throws Exception
     */
    Passport getPassportByPhone(String phone)throws Exception;

    /**
     * 查询登录用户
     * @param username
     * @return
     */
    LoginAppUser findByUsername(String username);
}
