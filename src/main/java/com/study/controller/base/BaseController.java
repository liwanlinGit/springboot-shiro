package com.study.controller.base;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.study.model.Resources;
import com.study.service.ResourcesService;

@Api(value="BaseController",description="所有菜单首页页面")
@Controller
public class BaseController {
  @Resource
  private ResourcesService resourcesService;
  
  
  @ApiOperation(value="page_index页面",notes="所有菜单的首页")
  @ApiImplicitParams({
    @ApiImplicitParam(name="path",value="url地址",required=false,dataType="string",paramType="path"),
    @ApiImplicitParam(name="menuName",value="菜单名称",required=false,dataType="string",paramType="path")
  })
  @RequestMapping(value="/page/{path}/{menuName}/{id}",method={RequestMethod.GET})
  public String page(@PathVariable String path,@PathVariable String menuName,@PathVariable Integer id,HttpServletRequest request){
    Example example=new Example(Resources.class);
    Criteria createCriteria = example.createCriteria();
    createCriteria.andEqualTo("type", 2);
    createCriteria.andEqualTo("parentid", id);
    List<Resources> buttons = resourcesService.selectByExample(example);
    request.setAttribute("buttons", buttons);
    request.setAttribute("menuName", menuName);
    return path+"/"+path;
  }
}
