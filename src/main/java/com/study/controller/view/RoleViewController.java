package com.study.controller.view;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.model.Role;
import com.study.service.RoleService;
import com.study.util.bean.MenuBean;

@Api(value="RoleViewController",description="角色页面")
@Controller
public class RoleViewController {
  @Resource
  private RoleService roleService;
  @ApiOperation(value="角色添加、修改页面",notes="角色添加、修改页面")
  @ApiImplicitParams({
    @ApiImplicitParam(name="id",value="角色id",required=false,dataType="int",paramType="query"),
    @ApiImplicitParam(name="menuName",value="当前tab名称",required=false,dataType="string",paramType="query"),
    @ApiImplicitParam(name="parentMenuName",value="父页面tab名称",required=false,dataType="string",paramType="query")
  })
  @RequestMapping(value="/roles/add",method = RequestMethod.GET)
  public String add(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request,@ModelAttribute MenuBean bean) {
    request.setAttribute("menu", bean);  
    if(id!=null){
        Role role = roleService.selectByKey(id);
        request.setAttribute("role", role);
        return "roles/roles_edit";
      }else{
        return "roles/roles_add";
      }
      
  }
  @RequestMapping(value="/roles/resource_tree",method = RequestMethod.GET)
  public String resource_tree(String rid,HttpServletRequest request){
    request.setAttribute("rid", rid);
    return "roles/roles_tree";
  }
  

}
