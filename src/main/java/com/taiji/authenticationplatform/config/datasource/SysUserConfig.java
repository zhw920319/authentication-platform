package com.taiji.authenticationplatform.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * Author wzy
 * Date 2018/1/15 13:56
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactorySysUser",
        transactionManagerRef="transactionManagerSysUser",//事务工厂
        basePackages= { "com.taiji.authenticationplatform.dao.sysuser" }) //设置Repository所在位置
public class SysUserConfig {
    @Autowired
    private HibernateProperties hibernateProperties;
    @Autowired
    @Qualifier("sysUserDataSource")
    private DataSource sysUserDataSource;

    @Primary
    @Bean(name = "entityManagerUser")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryUser(builder).getObject().createEntityManager();
    }

    @Autowired
    private JpaProperties jpaProperties;

//    private Map<String, Object> getVendorProperties() {
//        return jpaProperties.getHibernateProperties(new HibernateSettings());
//    }
    /**
     * 设置实体类所在位置
     */
    @Primary
    @Bean(name = "entityManagerFactorySysUser")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryUser (EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());
        return builder.
                dataSource(sysUserDataSource)
                .properties(properties)
                .packages("com.taiji.authenticationplatform.model.sysuser") //设置实体类所在位置
                .persistenceUnit("sysuserPersistenceUnit")
                .build();
    }

    @Primary
    @Bean(name = "transactionManagerSysUser")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryUser(builder).getObject());
    }
}
