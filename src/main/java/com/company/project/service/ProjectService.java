package com.company.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.company.project.entity.ProjectEntity;

/**
 * @author jiangtingxiwang
 * @email *****@mail.com
 * @date 2022-07-24 16:36:59
 */
public interface ProjectService extends IService<ProjectEntity> {

    /**
     * 初始化参数
     *
     * @param project
     * @return
     */
    ProjectEntity init(ProjectEntity project);

    /**
     * 根据项目编号查询
     *
     * @param projectNo
     * @return
     */
    ProjectEntity queryByProjectNo(String projectNo);
}

