package com.yanchun.jpa.dao;

import com.yanchun.jpa.entity.Passport;
import com.yanchun.token.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author quyanchun
 * @Date 2019/8/5
 */
@Repository
public interface PassportRepository extends JpaRepository<Passport,Long> {

    Passport findByPhone(String phone);
}
