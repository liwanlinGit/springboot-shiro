package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.model.User;
import com.study.model.UserRole;
import com.study.service.UserRoleService;
import com.study.service.UserService;
import com.study.util.PasswordHelper;
import com.study.util.ResultUtil;
import com.study.util.bean.DataGridResultInfo;
import com.study.util.bean.PageBean;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private UserRoleService userRoleService;

    @ApiOperation(value="查看部门下的人员",notes="根据部门查看多有人员")
    @ApiImplicitParams({
      @ApiImplicitParam(name="deptId",value="部门id",required=true,dataType="int",paramType="query"),
      @ApiImplicitParam(name="username",value="登录名",required=false,dataType="string",paramType="query"),
      @ApiImplicitParam(name="name",value="姓名",required=false,dataType="string",paramType="query"),
      @ApiImplicitParam(name="page",value="当前页",required=true,dataType="int",paramType="query"),
      @ApiImplicitParam(name="rows",value="一页条数",required=true,dataType="int",paramType="query")
    })
    @RequestMapping(value="/getData",method={RequestMethod.GET})
    public DataGridResultInfo getData(HttpServletRequest request,@RequestParam(value="deptId",required=true)Integer deptId,@RequestParam(value="username",required=false)String username,@RequestParam(value="name",required=false)String name,@ModelAttribute PageBean bean){
      Map<String, Object> map=new HashMap<String, Object>();
      map.put("deptId", deptId);
      map.put("name", name);
      map.put("username", username);
      List<User> userList = userService.selectUserByDeptId(map, bean);
      PageInfo<User> info=new PageInfo<User>(userList);
      return ResultUtil.createDataGridResult(info.getTotal(), info.getList());
      
    }

    /**
     * 保存用户角色
     * @param userRole 用户角色
     *  	  此处获取的参数的角色id是以 “,” 分隔的字符串
     * @return
     */
    @RequestMapping("/saveUserRoles")
    public String saveUserRoles(UserRole userRole){
        if(StringUtils.isEmpty(userRole.getUserid()))
            return "error";
        try {
            userRoleService.addUserRole(userRole);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @ApiOperation(value="添加保存",notes="添加保存")
    @RequestMapping(value = "/add",method={RequestMethod.POST})
    public String add(@ModelAttribute User user) {
        User u = userService.selectByUsername(user.getUsername());
        if(u != null)
            return "error";
        try {
            user.setEnable(1);
            PasswordHelper passwordHelper = new PasswordHelper();
            passwordHelper.encryptPassword(user);
            userService.save(user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    @ApiOperation(value="修改保存",notes="修改保存")
    @RequestMapping(value = "/edit",method={RequestMethod.POST})
    public String edit(@ModelAttribute User user) {
        try {
            userService.updateNotNull(user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @ApiOperation(value="删除用户",notes="根据id删除用户,同时删除当前用户关联角色")
    @ApiImplicitParams({
      @ApiImplicitParam(name="ids",value="用户id",required=true,dataType="string",paramType="query")
    })
    @RequestMapping(value = "/delete",method={RequestMethod.DELETE})
    public String delete(@RequestParam(value="ids",required=true)String ids){
      try{
        if(ids!=null){
          String[] id_s=ids.split(",");
          for (String id : id_s) {
            userService.delUser(Integer.parseInt(id));
          }
        }
          return "success";
      }catch (Exception e){
          e.printStackTrace();
          return "fail";
      }
    }

}
