package com.taiji.authenticationplatform.model.sysuser;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "department", schema = "sys_user", catalog = "")
@Data
@ToString
public class Department implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "dept")
    private String dept;

    @NotNull
    @Column(name = "userId")
    private String  userId;

    @Column(name = "leader")//数据库的字段名，数据库 不区分大小写
    private String leader;
    /*@NotNull
    @JSONField(name = "createTime", format="yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;*/

}
