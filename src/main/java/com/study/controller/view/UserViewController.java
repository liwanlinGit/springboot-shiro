package com.study.controller.view;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.study.model.Dept;
import com.study.model.Role;
import com.study.model.RoleResources;
import com.study.model.User;
import com.study.model.UserRole;
import com.study.service.RoleResourcesService;
import com.study.service.RoleService;
import com.study.service.UserService;
import com.study.service.impl.DeptServiceImpl;
import com.study.service.impl.UserServiceImpl;
import com.study.util.bean.MenuBean;

@Api(value="UserViewController",description="用户展示页面")
@Controller
public class UserViewController {
  @Autowired
  private DeptServiceImpl deptService;
  @Autowired
  private UserService userService;
  @Resource
  private RoleService roleService;
  
  
  
  @ApiOperation(value="用户修改、添加页面",notes="用户修改、添加页面")
  @ApiImplicitParams({
    @ApiImplicitParam(name="id",value="用户id",required=false,dataType="int",paramType="query"),
    @ApiImplicitParam(name="deptId",value="部门id",required=true,dataType="int",paramType="query"),
    @ApiImplicitParam(name="menuName",value="当前tab名称",required=false,dataType="string",paramType="query"),
    @ApiImplicitParam(name="parentMenuName",value="父页面tab名称",required=false,dataType="string",paramType="query")
  })
  @RequestMapping(value="users/add",method={RequestMethod.GET})
  public String add(HttpServletRequest request,@RequestParam(value="id",required=false) Integer id,@RequestParam(value="deptId",required=true)Integer deptId,@ModelAttribute MenuBean bean){
    List<Dept> selectAllDept = deptService.selectAllDept(null, null);
    request.setAttribute("depts", selectAllDept);
    request.setAttribute("deptId", deptId);
    request.setAttribute("menu", bean);
    if(id!=null){
      User user = userService.selectByKey(id);
      Role role = roleService.queryRoleListWithSelected(id);
      request.setAttribute("user", user);
      request.setAttribute("roles", role);
      return "users/users_edit";
    }else{
      return "users/users_add";
    }
    
  }
  
  
}
