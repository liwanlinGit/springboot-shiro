package com.study.controller.view;

import java.util.List;

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

import com.study.model.Dictionary;
import com.study.service.DictionaryService;
import com.study.util.bean.MenuBean;
@Api(value="DictViewController",description="字段类别页面跳转")
@Controller
public class DictViewController {
  @Autowired
  private DictionaryService dictionaryService;
  
  @ApiOperation(value="跳转至添加、修改页面",notes="跳转至添加、修改页面")
  @ApiImplicitParams({
    @ApiImplicitParam(name="id",value="类别id",required=false,dataType="int",paramType="query"),
    @ApiImplicitParam(name="menuName",value="当前tab名称",required=false,dataType="string",paramType="query"),
    @ApiImplicitParam(name="parentMenuName",value="父页面tab名称",required=false,dataType="string",paramType="query")
  })
  @RequestMapping(value="/dict/add",method={RequestMethod.GET})
  public String add(HttpServletRequest request,@RequestParam(value="id",required=false)Integer id,@ModelAttribute MenuBean bean){
    request.setAttribute("menu", bean);
    if(id!=null){
      Dictionary selectByKey = dictionaryService.selectByKey(id);
      request.setAttribute("dicts", selectByKey);
      return "dicts/dicts_edit";
    }else{
      return "dicts/dicts_add";
    }
  }

}
