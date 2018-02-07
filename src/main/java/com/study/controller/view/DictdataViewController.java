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
import org.springframework.web.bind.annotation.RequestParam;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.study.model.Dictionary;
import com.study.model.Dictionarydata;
import com.study.service.DictdataService;
import com.study.service.DictionaryService;
import com.study.util.bean.MenuBean;


@Api(value="DictdataController",description="字典数据操作API")
@Controller
public class DictdataViewController {
  @Autowired
  private DictdataService dictdataService;
  @Autowired
  private DictionaryService dictionaryService;
  
  @ApiOperation(value="跳转添加、修改",notes="跳转添加、修改")
  @ApiImplicitParams({
    @ApiImplicitParam(name="id",value="字典数据id",required=false,dataType="int",paramType="query"),
    @ApiImplicitParam(name="dictId",value="字典类别id",required=true,dataType="int",paramType="query"),
    @ApiImplicitParam(name="menuName",value="当前tab名称",required=false,dataType="string",paramType="query"),
    @ApiImplicitParam(name="parentMenuName",value="父页面tab名称",required=false,dataType="string",paramType="query")
  })
  @RequestMapping(value="/dictdata/add")
  public String add(HttpServletRequest request,@RequestParam(value="id",required=false)Integer id,@RequestParam(value="dictId",required=true)Integer dictId,@ModelAttribute MenuBean bean){
    List<Dictionary> dicts = dictionaryService.selectDictAll(null, null);
    request.setAttribute("dicts", dicts);
    request.setAttribute("menu", bean);
    if(dictId!=null&&dictId==2){
      Example example=new Example(Dictionarydata.class);
      Criteria createCriteria = example.createCriteria();
      createCriteria.andEqualTo("dictId", 1);
      List<Dictionarydata> dictds = dictdataService.selectByExample(example);
      request.setAttribute("dictds", dictds);
    }else if(dictId!=null&&dictId==3){
      Example example=new Example(Dictionarydata.class);
      Criteria createCriteria = example.createCriteria();
      createCriteria.andEqualTo("dictId", 2);
      List<Dictionarydata> dictds = dictdataService.selectByExample(example);
      request.setAttribute("dictds", dictds);
    }
    if(id!=null){
      Dictionarydata dictdata = dictdataService.selectByKey(id);
      request.setAttribute("dictdata", dictdata);
      return "dictdatas/dictdatas_edit";
    }else{
      request.setAttribute("dictId", dictId);
      return "dictdatas/dictdatas_add";
    }
  }
  
  
}
