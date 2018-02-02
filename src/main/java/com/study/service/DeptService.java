package com.study.service;

import java.util.List;

import com.study.model.Dept;
import com.study.util.bean.PageBean;

public interface DeptService {
  public List<Dept> selectAllDept(Dept dept,PageBean bean);
  
}
