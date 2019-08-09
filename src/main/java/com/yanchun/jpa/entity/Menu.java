package com.yanchun.jpa.entity;





import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author quyanchun
 * @Date 2019/8/8
 */
@Entity
@Data
public class Menu {
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "parent_id")
    private Long parentId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "css")
    private String css;
    @Basic
    @Column(name = "url")
    private String url;
    @Basic
    @Column(name = "sort")
    private Integer sort;
    @Basic
    @Column(name = "create_time")
    private Timestamp createTime;
    @Basic
    @Column(name = "update_time")
    private Timestamp updateTime;

    @Transient
    private List<Menu> child;
}
