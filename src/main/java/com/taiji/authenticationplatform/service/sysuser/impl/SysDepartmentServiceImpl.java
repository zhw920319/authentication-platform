package com.taiji.authenticationplatform.service.sysuser.impl;

import com.taiji.authenticationplatform.dao.sysuser.UserRepository;
import com.taiji.authenticationplatform.model.sysuser.User;
import com.taiji.authenticationplatform.service.sysuser.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDepartmentServiceImpl implements SysDepartmentService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
    public List<Object[]> queryPersonnelInfo(String username){
        return userRepository.queryPersonnelInfo(username);
    }
}
