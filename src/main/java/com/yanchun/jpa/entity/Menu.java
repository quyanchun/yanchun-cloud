package com.yanchun.jpa.entity;





import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author quyanchun
 * @Date 2019/8/8
 */
@Entity
public class Menu {
    private Long id;
    private Long parentId;
    private String name;
    private String css;
    private String url;
    private Integer sort;
    private Timestamp createTime;
    private Timestamp updateTime;
    private List<Menu> child;
    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "parentId")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "css")
    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    @Basic
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Transient
    public List<Menu> getChild() {
        return child;
    }

    public void setChild(List<Menu> child) {
        this.child = child;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return id == menu.id &&
                parentId == menu.parentId &&
                sort == menu.sort &&
                Objects.equals(name, menu.name) &&
                Objects.equals(url, menu.url) &&
                Objects.equals(css, menu.css) &&
                Objects.equals(createTime, menu.createTime) &&
                Objects.equals(updateTime, menu.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentId, name, url, css, sort, createTime, updateTime);
    }
}
