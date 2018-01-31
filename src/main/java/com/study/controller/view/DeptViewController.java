package com.study.controller.view;

import io.swagger.annotations.Api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value="DeptViewController",description="部门页面展示")
@Controller
public class DeptViewController {

  @RequestMapping("/deptPage")
  public String page(){
    return "dept/depts";
  }
  
}
