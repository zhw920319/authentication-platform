package com.taiji.authenticationplatform.model.sysuser;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "user", schema = "sys_user", catalog = "")
@Data
@ToString
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "password")
    private String  password;

    @Column(name = "user_id")//数据库的字段名，数据库 不区分大小写
    private String userId;
    /*@NotNull
    @JSONField(name = "createTime", format="yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;*/

}
