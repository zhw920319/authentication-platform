package com.taiji.authenticationplatform.controller.sysuser;



import com.taiji.authenticationplatform.common.ServerResponse;
import com.taiji.authenticationplatform.model.sysuser.User;
import com.taiji.authenticationplatform.service.sysuser.SysDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhw
 */
@Api(value = "",tags = {"部门管理模块"})
@RestController
@RequestMapping("/sys_department")
public class SysDepartmentController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private SysDepartmentService sysDepartmentService;

    @ApiOperation(value="查询单位", notes="分页查询单位,条件有名称、排序、分页、单位。")
    @GetMapping("/list")
    public ServerResponse getList(String name, String sortField , Integer instId, Integer page , Integer size ) throws Exception{
        stringRedisTemplate.opsForValue().set("zhanghongwei", "张洪伟");
        stringRedisTemplate.delete("zhanghongwei");
        String name11 = stringRedisTemplate.opsForValue().get("zhanghongwei");
        System.out.println(name11);
        User user = sysDepartmentService.getUserByUsername("zhang");
        System.out.println(user.toString());
        List<Object[]> list = sysDepartmentService.queryPersonnelInfo("zhang");
        list.forEach(a->{

        });
        return new ServerResponse(200, "当前没有用户登陆!", null);
    }
}
