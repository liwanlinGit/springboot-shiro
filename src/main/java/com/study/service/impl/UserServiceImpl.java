package com.study.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.mapper.UserMapper;
import com.study.mapper.UserRoleMapper;
import com.study.model.User;
import com.study.model.UserRole;
import com.study.service.UserService;
import com.study.util.PageBeanUtil;
import com.study.util.bean.PageBean;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService{
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public User selectByUsername(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        List<User> userList = selectByExample(example);
        if(userList.size()>0){
            return userList.get(0);
        }
            return null;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void delUser(Integer userid) {
        //删除用户表
        mapper.deleteByPrimaryKey(userid);
        //删除用户角色表
        Example example = new Example(UserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userid",userid);
        userRoleMapper.deleteByExample(example);
    }

    @Override
    public List<User> selectUserByDeptId(Map<String, Object> map,PageBean bean) {
      if(PageBeanUtil.pageBeanIsNotEmpty(bean)){
        PageHelper.startPage(bean.getPage(), bean.getRows());
      }
      List<User> selectUserByDeptId = userMapper.selectUserByDeptId(map);
      return selectUserByDeptId;
    }
}
