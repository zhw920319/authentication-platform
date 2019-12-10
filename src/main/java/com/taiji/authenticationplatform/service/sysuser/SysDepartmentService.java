package com.taiji.authenticationplatform.service.sysuser;

import com.taiji.authenticationplatform.model.sysuser.User;

import java.util.List;

public interface SysDepartmentService {
    public User getUserByUsername(String username);
    public List<Object[]> queryPersonnelInfo(String username);
}
