package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.model.Resources;
import com.study.model.Role;
import com.study.model.RoleResources;
import com.study.model.User;
import com.study.service.RoleResourcesService;
import com.study.service.RoleService;
import com.study.util.ResultUtil;
import com.study.util.bean.DataGridResultInfo;
import com.study.util.bean.PageBean;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value="RoleController",description="角色操作")
@RestController
@RequestMapping("/roles")
public class RoleController {
    @Resource
    private RoleService roleService;
    @Resource
    private RoleResourcesService roleResourcesService;

    @ApiOperation(value="获取角色",notes="获取角色")
    @ApiImplicitParams({
      @ApiImplicitParam(name="roledesc",value="角色名称",required=false,dataType="string",paramType="query"),
      @ApiImplicitParam(name="page",value="当前页码",required=true,dataType="int",paramType="query"),
      @ApiImplicitParam(name="rows",value="一页多少条",required=true,dataType="int",paramType="query")
    })
    @RequestMapping(value="/getData",method={RequestMethod.GET})
    public DataGridResultInfo getData(HttpServletRequest request, HttpServletResponse response,@ModelAttribute PageBean page,@ModelAttribute Role role){
      List<Role> selectByPage = roleService.selectByPage(role, page);
      PageInfo<Role> pageInfo=new PageInfo<Role>(selectByPage);
      return ResultUtil.createDataGridResult(pageInfo.getTotal(), pageInfo.getList());
    }


    //分配角色
    @ApiOperation(value="保存权限",notes="保存角色对应的权限")
    @RequestMapping(value="/saveRoleResources",method={RequestMethod.GET})
    public String saveRoleResources(@ModelAttribute RoleResources roleResources){
        if(StringUtils.isEmpty(roleResources.getRoleid()))
            return "error";
        try {
            roleResourcesService.addRoleResources(roleResources);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    @ApiOperation(value="角色添加",notes="保存角色")
    @RequestMapping(value = "/add",method=RequestMethod.POST)
    public String add(Role role) {
        try {
            roleService.save(role);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @ApiOperation(value="删除角色",notes="根据id删除角色")
    @ApiImplicitParams({
      @ApiImplicitParam(name="ids",value="角色id",required=true,dataType="string",paramType="query")
    })
    @RequestMapping(value = "/delete",method={RequestMethod.DELETE})
    public String delete(@RequestParam(value="ids",required=true)String ids){
        try{
            if(ids!=null){
              String[] id_s=ids.split(",");
              for (String id : id_s) {
                roleService.delRole(Integer.parseInt(id));
              }
            }
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
    @ApiOperation(value="角色修改",notes="保存修改角色")
    @RequestMapping(value = "/edit" ,method = RequestMethod.POST)
    public String edit(Role role){
        try{
            roleService.updateAll(role);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @ApiOperation(value="获取所有角色",notes="获取所有角色")
    @RequestMapping(value="/getUserData",method={RequestMethod.GET})
    public List<Role> getUserData(HttpServletRequest request, HttpServletResponse response){
      List<Role> selectByPage = roleService.selectByPage(null, null);
      return selectByPage;
    }
}
