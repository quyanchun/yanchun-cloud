package com.yanchun.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Author quyanchun
 * @Date 2019/8/8
 */
@Entity
@Data
@Table(name = "role_menu")
public class RoleMenu implements Serializable {
    @Id
    @Column(name = "role_id")
    private int roleId;
    @Id
    @Column(name = "menu_id")
    private int menuId;

}
