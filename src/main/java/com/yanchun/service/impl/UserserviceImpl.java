package com.yanchun.service.impl;

import com.yanchun.jpa.entity.Passport;
import com.yanchun.jpa.dao.PassportRepository;
import com.yanchun.service.UserService;
import com.yanchun.token.model.AppUser;
import com.yanchun.token.model.LoginAppUser;
import com.yanchun.token.model.SysRole;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public LoginAppUser findByUsername(String username) {
        Passport passport = passportRepositor.findByPhone(username);
        AppUser appUser = new AppUser();
        appUser.setUsername(passport.getPhone());
        appUser.setPassword(passport.getPassword());
        appUser.setNickname(passport.getNickName());
        appUser.setEnabled(passport.getStatus()==1?true:false);
        if (appUser != null) {
            LoginAppUser loginAppUser = new LoginAppUser();
            BeanUtils.copyProperties(appUser, loginAppUser);

//            Set<SysRole> sysRoles = userRoleDao.findRolesByUserId(appUser.getId());
//            loginAppUser.setSysRoles(sysRoles);// 设置角色
//
//            if (!CollectionUtils.isEmpty(sysRoles)) {
//                Set<Long> roleIds = sysRoles.parallelStream().map(SysRole::getId).collect(Collectors.toSet());
//                Set<SysPermission> sysPermissions = sysPermissionService.findByRoleIds(roleIds);
//                if (!CollectionUtils.isEmpty(sysPermissions)) {
//                    Set<String> permissions = sysPermissions.parallelStream().map(SysPermission::getPermission)
//                            .collect(Collectors.toSet());
//
//                    loginAppUser.setPermissions(permissions);// 设置权限集合
//                }
//
//            }

            return loginAppUser;
        }
        return null;
    }
}
