package com.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.study.model.Dictionarydata;
import com.study.service.DictdataService;
import com.study.util.ResultUtil;
import com.study.util.bean.DataGridResultInfo;
import com.study.util.bean.PageBean;
@Api(value="DictdataController",description="字典数据操作API")
@RestController
public class DictdataController {

  @Autowired
  private DictdataService dictdataService;
  
  @ApiOperation(value="获取所有的字典数据",notes="回去所有的字典数据，返回grid")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "dictdataName", value = "名称", required = false ,dataType = "string" ,paramType = "query"),
    @ApiImplicitParam(name="rows",value="一页多少条",required=true,dataType="int",paramType="query"),
    @ApiImplicitParam(name = "page", value = "当前页码", required = true,dataType = "int" ,paramType = "query"),
    @ApiImplicitParam(name = "dictId", value = "字典类别id", required = true,dataType = "int" ,paramType = "query"),
  })
  @RequestMapping(value="/dictdata/getData",method=RequestMethod.GET)
  public DataGridResultInfo getData(@RequestParam(value="dictId",required=true)Integer dictId,@RequestParam(value="dictdataName",required=false)String dictdataName,@ModelAttribute PageBean bean){
    Map<String, Object> map=new HashMap<String, Object>();
    map.put("dictId", dictId);
    map.put("dictdataName", dictdataName);
    List<Dictionarydata> dicts = dictdataService.selectDictdataByParentId(map, bean);
    PageInfo<Dictionarydata> info=new PageInfo<Dictionarydata>(dicts);
    return ResultUtil.createDataGridResult(info.getTotal(),info.getList());
  }
  @ApiOperation(value="添加保存",notes="添加保存API")
  @RequestMapping(value="/dictdata/add",method=RequestMethod.POST)
  public String add(@ModelAttribute Dictionarydata dictionarydata){
    try {
      dictdataService.save(dictionarydata);
      return "success";
    } catch (Exception e) {
      e.printStackTrace();
      return "fail";
    }
  }
  @ApiOperation(value="修改保存",notes="修改保存API")
  @RequestMapping(value="/dictdata/edit",method=RequestMethod.POST)
  public String edit(@ModelAttribute Dictionarydata dictionarydata){
    try {
      dictdataService.updateNotNull(dictionarydata);
      return "success";
    } catch (Exception e) {
      e.printStackTrace();
      return "fail";
    }
  }
  @ApiOperation(value="字典数据类别", notes="删除字典数据API")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "ids", value = "数据id", required = true ,dataType = "string" ,paramType = "query")
  })
  @RequestMapping(value = "/dictdata/delete",method={RequestMethod.DELETE})
  public String delete(@RequestParam(value="ids") String ids){
      try{
         if(ids!=null){
           String[] idsArry=ids.split(",");
           for (String id : idsArry) {
             dictdataService.delete(Integer.parseInt(id));
          }
         }
          return "success";
      }catch (Exception e){
          e.printStackTrace();
          return "fail";
      }
  }
}
