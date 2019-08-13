package com.yanchun.jpa.dao;

import com.yanchun.jpa.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author quyanchun
 * @Date 2019/8/5
 */
@Repository
public interface PassportRepository extends JpaRepository<Passport,Long> {

    Passport findByPhone(String phone);
}
