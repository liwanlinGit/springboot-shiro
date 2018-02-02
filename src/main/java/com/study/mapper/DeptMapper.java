package com.study.mapper;

import java.util.List;

import com.study.model.Dept;
import com.study.util.MyMapper;

public interface DeptMapper extends MyMapper<Dept> {
  
   public List<Dept> selectAllDept(Dept dept);
}