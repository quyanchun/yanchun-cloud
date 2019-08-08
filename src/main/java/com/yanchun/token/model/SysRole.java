package com.yanchun.token.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色
 */
@Data
public class SysRole implements Serializable {

	private static final long serialVersionUID = -2054359538140713354L;

	private Integer id;
	private String code;
	private String name;
	private Date createTime;
	private Date updateTime;
}
