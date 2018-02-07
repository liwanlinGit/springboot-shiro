package com.study.mapper;

import java.util.List;
import java.util.Map;




import com.study.model.Dictionarydata;
import com.study.util.MyMapper;

public interface DictionarydataMapper extends MyMapper<Dictionarydata> {
  public List<Dictionarydata> selectDictdataByParentId(Map<String, Object> map);
  
}