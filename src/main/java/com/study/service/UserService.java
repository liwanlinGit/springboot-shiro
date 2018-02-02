package com.study.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.study.model.User;
import com.study.model.UserRole;
import com.study.util.bean.PageBean;

public interface UserService extends IService<User>{
    public List<User> selectUserByDeptId(Map<String, Object> map,PageBean bean);

    User selectByUsername(String username);

    void delUser(Integer userid);

}
