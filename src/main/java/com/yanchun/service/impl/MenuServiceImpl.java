package com.yanchun.service.impl;

import com.yanchun.jpa.entity.Menu;
import com.yanchun.jpa.dao.MenuRepository;
import com.yanchun.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Author quyanchun
 * @Date 2019/8/8
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Override
    public List<Menu> findByRoles(Set<Integer> roleIds) {
        List<Menu> menusByRoleIds = menuRepository.findMenusByRoleIds(roleIds);
        return menusByRoleIds;
    }
}
