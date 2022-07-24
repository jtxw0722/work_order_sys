package com.company.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.Objects;

import com.company.project.common.utils.DataResult;

import com.company.project.entity.ProjectEntity;
import com.company.project.service.ProjectService;



/**
 * 
 *
 * @author jiangtingxiwang
 * @email *****@mail.com
 * @date 2022-07-24 16:36:59
 */
@Controller
@RequestMapping("/")
public class ProjectController {
    @Autowired
    private ProjectService projectService;


    /**
    * 跳转到页面
    */
    @GetMapping("/index/project")
    public String project() {
        return "project/list";
        }

    @ApiOperation(value = "新增")
    @PostMapping("project/add")
    @RequiresPermissions("project:add")
    @ResponseBody
    public DataResult add(@RequestBody ProjectEntity project){
        ProjectEntity queryByProjectNo = projectService.queryByProjectNo(project.getProjectNo());
        if (Objects.nonNull(queryByProjectNo)) {
            return DataResult.fail("项目编号已存在");
        }
        ProjectEntity projectEntity = projectService.init(project);

        projectService.save(projectEntity);
        return DataResult.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("project/delete")
    @RequiresPermissions("project:delete")
    @ResponseBody
    public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids){
        projectService.removeByIds(ids);
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("project/update")
    @RequiresPermissions("project:update")
    @ResponseBody
    public DataResult update(@RequestBody ProjectEntity project){
        projectService.updateById(project);
        return DataResult.success();
    }

    @ApiOperation(value = "查询分页数据")
    @PostMapping("project/listByPage")
    @RequiresPermissions("project:list")
    @ResponseBody
    public DataResult findListByPage(@RequestBody ProjectEntity project){
        LambdaQueryWrapper<ProjectEntity> queryWrapper = Wrappers.lambdaQuery();
        ////查询条件示例
        //if (!StringUtils.isBlank(project.getId()) && !"null".equals(project.getId())) {
        //    queryWrapper.eq(ProjectEntity::getId, project.getId());
        //}
        queryWrapper.orderByDesc(ProjectEntity::getId);
        IPage<ProjectEntity> iPage = projectService.page(project.getQueryPage(), queryWrapper);
        return DataResult.success(iPage);
    }

}
