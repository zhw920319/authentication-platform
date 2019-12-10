package com.taiji.authenticationplatform.dao.common;

import com.taiji.authenticationplatform.model.common.TbRole;
import com.taiji.authenticationplatform.model.sysuser.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TbRoleRepository extends JpaRepository<TbRole,Integer> {

}
