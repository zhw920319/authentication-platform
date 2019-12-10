package com.taiji.authenticationplatform.dao.sysuser;

import com.taiji.authenticationplatform.model.sysuser.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}
