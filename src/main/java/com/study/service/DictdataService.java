package com.study.service;

import java.util.List;
import java.util.Map;

import com.study.model.Dictionarydata;
import com.study.util.bean.PageBean;

public interface DictdataService extends IService<Dictionarydata> {
   public List<Dictionarydata> selectDictdataByParentId(Map<String, Object> map,PageBean bean);
}
