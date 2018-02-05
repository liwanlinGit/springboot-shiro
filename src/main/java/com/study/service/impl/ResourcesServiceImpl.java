package com.study.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.study.mapper.ResourcesMapper;
import com.study.model.Resources;
import com.study.model.User;
import com.study.service.ResourcesService;
import com.study.util.PageBeanUtil;
import com.study.util.bean.PageBean;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

@Service("resourcesService")
public class ResourcesServiceImpl extends BaseService<Resources> implements ResourcesService {
   @Resource
    private ResourcesMapper resourcesMapper;


    @Override
    public List<Resources> queryAll(){
        return resourcesMapper.queryAll();
    }

    @Override
    //@Cacheable(cacheNames="resources",key="#map['userid'].toString()+#map['type']")
    public List<Resources> loadUserResources(Map<String, Object> map) {
        return resourcesMapper.loadUserResources(map);
    }

    @Override
    public List<Resources> queryResourcesListWithSelected(Integer rid) {
        return resourcesMapper.queryResourcesListWithSelected(rid);
    }

    @Override
    public List<Resources> queryByType(Resources resources,PageBean pageBean) {
      if(PageBeanUtil.pageBeanIsNotEmpty(pageBean)){
        PageHelper.startPage(pageBean.getPage(), pageBean.getRows());
      }
      return resourcesMapper.queryByType(resources);
    }
}
