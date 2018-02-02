package com.study.mapper;

import java.util.List;
import java.util.Map;

import com.study.model.User;
import com.study.util.MyMapper;

public interface UserMapper extends MyMapper<User> {
  
  public List<User> selectUserByDeptId(Map<String, Object> map);
}