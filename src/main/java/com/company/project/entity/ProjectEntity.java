package com.company.project.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.company.project.entity.BaseEntity;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 *
 * @author jiangtingxiwang
 * @email *****@mail.com
 * @date 2022-07-24 16:36:59
 */
@Data
@TableName("project")
public class ProjectEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId("id")
	private String id;

	/**
	 * 项目编码
	 */
	@TableField("project_no")
	private String projectNo;

	/**
	 * 项目名称
	 */
	@TableField("name")
	private String name;

	/**
	 * 项目类型
	 */
	@TableField("type")
	private String type;

	/**
	 * 负责人ID
	 */
	@TableField("manager_id")
	private String managerId;

	/**
	 * 未处理BUG数量
	 */
	@TableField("bug_num")
	private Integer bugNum;

	/**
	 * 总BUG数量
	 */
	@TableField("bug_sum")
	private Integer bugSum;

	/**
	 * 未处理需求数量
	 */
	@TableField("feature_num")
	private Integer featureNum;

	/**
	 * 总需求数量
	 */
	@TableField("feature_sum")
	private Integer featureSum;

	/**
	 * 状态(1-正常 2-BUG 3-需求 0-无需维护)
	 */
	@TableField("status")
	private Integer status;

	/**
	 * 优先级(0-优先 1-较高 2-正常)
	 */
	@TableField("level")
	private Integer level;

	/**
	 * 创建时间
	 */
	@TableField("create_time")
	private Date createTime;

	/**
	 * 更新时间
	 */
	@TableField("update_time")
	private Date updateTime;

	/**
	 * 是否删除(1未删除；0已删除)
	 */
	@TableField("deleted")
	private Integer deleted;


}
