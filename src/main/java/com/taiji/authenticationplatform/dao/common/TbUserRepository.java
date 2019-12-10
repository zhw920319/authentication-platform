package com.taiji.authenticationplatform.dao.common;

import com.taiji.authenticationplatform.model.common.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbUserRepository extends JpaRepository<TbUser,Integer> {
    public TbUser findTbUserByUsername(String username);
}
