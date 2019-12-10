package com.taiji.authenticationplatform.dao.sysuser;

import com.taiji.authenticationplatform.model.sysuser.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {
    public User findUserByUsername(String username);
    @Query(value = "select u,d from User u,Department d where u.userId = d.userId AND username = ?1")
    public List<Object[]> queryPersonnelInfo(String name);
}
