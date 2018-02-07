package com.study.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.study.model.Dictionary;
import com.study.service.DictionaryService;
import com.study.util.ResultUtil;
import com.study.util.bean.DataGridResultInfo;
import com.study.util.bean.PageBean;


@Api(value="DictController",description="字典类别操作API")
@RestController
@Controller
public class DictController {
  @Autowired
  private DictionaryService dictionaryService;
  
  @ApiOperation(value="获取所有的字典类别数据",notes="回去所有的字典类别数据，返回grid")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "dictName", value = "类别名称", required = false ,dataType = "string" ,paramType = "query"),
    @ApiImplicitParam(name="rows",value="一页多少条",required=true,dataType="int",paramType="query"),
    @ApiImplicitParam(name = "page", value = "当前页码", required = true,dataType = "int" ,paramType = "query"),
  })
  @RequestMapping(value="/dict/getData",method={RequestMethod.GET})
  public DataGridResultInfo getData(@RequestParam(value="dictName",required=false)String dictName,PageBean bean){
    List<Dictionary> selectDictAll = dictionaryService.selectDictAll(dictName, bean);
    PageInfo<Dictionary> info=new PageInfo<Dictionary>(selectDictAll);
    return ResultUtil.createDataGridResult(info.getTotal(), info.getList());
  }
  
  @ApiOperation(value="添加保存",notes="添加保存API")
  @RequestMapping(value="/dict/add",method={RequestMethod.POST})
  public String add(@ModelAttribute Dictionary dictionary){
    try {
      dictionaryService.save(dictionary);
      return "success";
    } catch (Exception e) {
      e.printStackTrace();
      return "fail";
    }
    
  }
  @ApiOperation(value="修改保存",notes="修改保存API")
  @RequestMapping(value="/dict/edit",method={RequestMethod.POST})
  public String edit(@ModelAttribute Dictionary dictionary){
    try {
      dictionaryService.updateNotNull(dictionary);
      return "success";
    } catch (Exception e) {
      e.printStackTrace();
      return "fail";
    }
    
  }
  @ApiOperation(value="字典类别", notes="删除类别API")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "ids", value = "类别id", required = true ,dataType = "string" ,paramType = "query")
  })
  @RequestMapping(value = "/dict/delete",method={RequestMethod.DELETE})
  public String delete(@RequestParam(value="ids") String ids){
      try{
         if(ids!=null){
           String[] idsArry=ids.split(",");
           for (String id : idsArry) {
             dictionaryService.delete(Integer.parseInt(id));
          }
         }
          return "success";
      }catch (Exception e){
          e.printStackTrace();
          return "fail";
      }
  }
  @ApiOperation(value="字典类别ztree", notes="字典类别ztree")
  @RequestMapping(value="/dict/getDataTree",method={RequestMethod.GET})
  public List<Dictionary> getDataTree(){
    List<Dictionary> selectDictAll = dictionaryService.selectDictAll(null, null);
    return selectDictAll;
  }
}
