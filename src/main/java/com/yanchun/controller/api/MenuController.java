package com.yanchun.controller.api;

import com.yanchun.jpa.entity.Menu;
import com.yanchun.service.MenuService;
import com.yanchun.token.model.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api-b/menus")
public class MenuController {

	@Autowired
	private MenuService menuService;

	/**
	 * 当前登录用户的菜单
	 * 
	 * @return
	 */
	@GetMapping("/me")
	public List<Menu> findMyMenu() {
//		LoginAppUser loginAppUser = AppUserUtil.getLoginAppUser();
//		Set<SysRole> roles = loginAppUser.getSysRoles();
//		if (CollectionUtils.isEmpty(roles)) {
//			return Collections.emptyList();
//		}
		Set<SysRole> roles = new HashSet<>();
		SysRole sysRole = new SysRole();
		sysRole.setId(1);
		roles.add(sysRole);
		List<Menu> menus = menuService
				.findByRoles(roles.parallelStream().map(SysRole::getId).collect(Collectors.toSet()));

		List<Menu> firstLevelMenus = menus.stream().filter(m -> m.getParentId().equals(0L))
				.collect(Collectors.toList());
		firstLevelMenus.forEach(m -> {
			setChild(m, menus);
		});

		return firstLevelMenus;
	}

	private void setChild(Menu menu, List<Menu> menus) {
		List<Menu> child = menus.stream().filter(m -> m.getParentId().equals(menu.getId()))
				.collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(child)) {
			menu.setChild(child);
			// 2018.06.09递归设置子元素，多级菜单支持
			child.parallelStream().forEach(c -> {
				setChild(c, menus);
			});
		}
	}



}
