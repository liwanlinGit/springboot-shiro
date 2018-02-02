package com.study.mapper;

import com.study.model.Role;
import com.study.util.MyMapper;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {
    public Role queryRoleListWithSelected(Integer id);
}