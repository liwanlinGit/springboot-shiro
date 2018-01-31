package com.study.controller.view;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.model.Role;
import com.study.service.RoleService;

@Api(value="RoleViewController",description="角色页面")
@Controller
public class RoleViewController {
  @Resource
  private RoleService roleService;
  
  @ApiOperation(value="角色页面",notes="角色列表页")
  @RequestMapping(value="/rolesPage",method={RequestMethod.GET})
  public String rolesPage() {
      return "role/roles";
  }
  @ApiOperation(value="角色添加、修改页面",notes="角色添加、修改页面")
  @ApiImplicitParams({
    @ApiImplicitParam(name="id",value="角色id",required=false,dataType="int",paramType="query")
  })
  @RequestMapping(value="/roles/add",method = RequestMethod.GET)
  public String add(@RequestParam(value="id",required=false) Integer id,HttpServletRequest request) {
      if(id!=null){
        Role role = roleService.selectByKey(id);
        request.setAttribute("role", role);
        return "role/roles_edit";
      }else{
        return "role/roles_add";
      }
      
  }
  @RequestMapping(value="/roles/resource_tree",method = RequestMethod.GET)
  public String resource_tree(String rid,HttpServletRequest request){
    request.setAttribute("rid", rid);
    return "role/roles_tree";
  }
  

}
