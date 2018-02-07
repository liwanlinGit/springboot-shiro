package com.study.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.study.mapper.DictionarydataMapper;
import com.study.model.Dictionarydata;
import com.study.service.DictdataService;
import com.study.util.PageBeanUtil;
import com.study.util.bean.PageBean;
@Service("dictdataService")
public class DictdataServiceImpl extends BaseService<Dictionarydata> implements DictdataService {

  @Autowired
  private DictionarydataMapper dictionarydataMapper;
  @Override
  public List<Dictionarydata> selectDictdataByParentId(
      Map<String, Object> map, PageBean bean) {
     if(PageBeanUtil.pageBeanIsNotEmpty(bean)){
       PageHelper.startPage(bean.getPage(), bean.getRows());
     }
     List<Dictionarydata> dictdatas = dictionarydataMapper.selectDictdataByParentId(map);
    return dictdatas;
  }

}
