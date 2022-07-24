package com.company.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.company.project.common.content.ProjectContent;
import com.company.project.entity.SysDictDetailEntity;
import com.company.project.entity.SysUserRole;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.company.project.mapper.ProjectMapper;
import com.company.project.entity.ProjectEntity;
import com.company.project.service.ProjectService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service("projectService")
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, ProjectEntity> implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public ProjectEntity init(ProjectEntity project) {
        Date now = new Date();
        project.setBugNum(ProjectContent.INIT_NUM);
        project.setBugSum(ProjectContent.INIT_NUM);
        project.setFeatureNum(ProjectContent.INIT_NUM);
        project.setFeatureSum(ProjectContent.INIT_NUM);
        project.setDeleted(ProjectContent.NOT_DELETE);
        project.setCreateTime(now);
        project.setUpdateTime(now);
        return project;
    }

    @Override
    public ProjectEntity queryByProjectNo(String projectNo) {
        LambdaQueryWrapper<ProjectEntity> queryWrapper =
                Wrappers.<ProjectEntity>lambdaQuery().select(ProjectEntity::getProjectNo).eq(ProjectEntity::getProjectNo,projectNo);
        ProjectEntity projectEntity = projectMapper.selectOne(queryWrapper);
        return projectEntity;
    }
}