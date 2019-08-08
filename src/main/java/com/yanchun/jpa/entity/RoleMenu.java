package com.yanchun.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Author quyanchun
 * @Date 2019/8/8
 */
@Entity
@Table(name = "role_menu")
public class RoleMenu implements Serializable {
    private int roleId;
    private int menuId;

    @Id
    @Column(name = "roleId")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "menuId")
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleMenu roleMenu = (RoleMenu) o;
        return roleId == roleMenu.roleId &&
                menuId == roleMenu.menuId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, menuId);
    }
}
