package com.yanchun.jpa.dao;

import com.yanchun.jpa.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;
@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {

    @Query("select t from Menu t " +
            " inner join RoleMenu r on r.menuId = t.id" +
            " where "+
            " r.roleId in ?1")
    List<Menu> findMenusByRoleIds(@RequestParam Set<Integer> roleIds);

}
