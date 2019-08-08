package com.yanchun.service;

import com.yanchun.jpa.entity.Menu;

import java.util.List;
import java.util.Set;

public interface MenuService {

    List<Menu> findByRoles(Set<Integer> roleIds);
}
