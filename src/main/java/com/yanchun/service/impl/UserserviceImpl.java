package com.yanchun.service.impl;

import com.yanchun.jpa.entity.Passport;
import com.yanchun.jpa.repository.PassportRepository;
import com.yanchun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author quyanchun
 * @Date 2019/8/5
 */
@Service
public class UserserviceImpl implements UserService {

    @Autowired
    private PassportRepository passportRepositor;
    @Override
    public Passport getPassportByPhone(String phone) throws Exception {
        Passport passport = passportRepositor.findByPhone(phone);
        return passport;
    }
}
