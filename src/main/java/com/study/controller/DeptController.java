package com.study.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.study.model.Dept;
import com.study.service.DeptService;
import com.study.service.impl.DeptServiceImpl;
import com.study.util.ResultUtil;
import com.study.util.bean.DataGridResultInfo;
import com.study.util.bean.PageBean;

@Api(value="Deptcontroller",description="部门操作API")
@RestController
@RequestMapping("/dept")
public class DeptController {

  @Autowired
  private DeptServiceImpl deptService;
  
  @ApiOperation(value="获取所有部门",notes="获取所有部门API")
  @RequestMapping(value="/getData",method={RequestMethod.GET})
  public DataGridResultInfo getData(HttpServletRequest request,@ModelAttribute PageBean bean,@ModelAttribute Dept dept){
    List<Dept> selectAllDept = deptService.selectAllDept(dept, bean);
    PageInfo<Dept> pageInfo=new PageInfo<Dept>(selectAllDept);
    return ResultUtil.createDataGridResult(pageInfo.getTotal(), pageInfo.getList());
  }
  
  @ApiOperation(value="获取所有部门树",notes="获取所有部门树API")
  @RequestMapping(value="/getDataTree",method={RequestMethod.GET})
  public List<Dept> getDataTree(HttpServletRequest request,@ModelAttribute PageBean bean,@ModelAttribute Dept dept){
    List<Dept> selectAllDept = deptService.selectAllDept(dept, bean);
    return selectAllDept;
  }
  
  
  @ApiOperation(value="添加部门",notes="保存添加API")
  @RequestMapping(value="/add",method={RequestMethod.POST})
  public String add(HttpServletRequest request,@ModelAttribute Dept dept){
    try {
      deptService.save(dept);
      return "success";
    } catch (Exception e) {
      e.printStackTrace();
      return "fail";
    }
  }
  @ApiOperation(value="修改部门",notes="保存修改API")
  @RequestMapping(value="/edit",method={RequestMethod.POST})
  public String edit(HttpServletRequest request,@ModelAttribute Dept dept){
    try {
      deptService.updateNotNull(dept);
      return "success";
    } catch (Exception e) {
      e.printStackTrace();
      return "fail";
    }
  }
  @ApiOperation(value="删除部门",notes="根据id删除API")
  @ApiImplicitParams({
    @ApiImplicitParam(name="ids",value="部门id",required=true,dataType="string",paramType="query")
  })
  @RequestMapping(value="delete",method={RequestMethod.DELETE})
  public String delete(HttpServletRequest request,@RequestParam(value="ids")String ids){
    try{
      if(ids!=null){
        String[] idsArry=ids.split(",");
        for (String id : idsArry) {
          deptService.delete(Integer.parseInt(id));
        }
      }
      return "success";
    }catch(Exception e){
      e.printStackTrace();
      return "fail";
    }
  }
  
  
  
  
}
