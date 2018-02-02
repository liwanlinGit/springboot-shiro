package com.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.study.mapper.DeptMapper;
import com.study.model.Dept;
import com.study.service.DeptService;
import com.study.util.PageBeanUtil;
import com.study.util.bean.PageBean;
@Service("deptService")
public class DeptServiceImpl extends BaseService<Dept> implements DeptService {
  @Autowired
  private DeptMapper deptMapper;
  @Override
  public List<Dept> selectAllDept(Dept dept,PageBean bean) {
    if(PageBeanUtil.pageBeanIsNotEmpty(bean)){
      PageHelper.startPage(bean.getPage(), bean.getRows());
    }
    List<Dept> selectAllDept = deptMapper.selectAllDept(dept);
    return selectAllDept;
  }

}
