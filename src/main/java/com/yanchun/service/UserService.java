package com.yanchun.service;

import com.yanchun.jpa.entity.Passport;

public interface UserService {
    /**
     * 获取用户passport
     * @param phone
     * @return
     * @throws Exception
     */
    Passport getPassportByPhone(String phone)throws Exception;
}
