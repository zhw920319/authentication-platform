package com.taiji.authenticationplatform.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        entityManagerFactoryRef="entityManagerFactoryCommon",
        transactionManagerRef="transactionManagerCommon",//事务工厂
        basePackages= { "com.taiji.authenticationplatform.dao.common" }) //设置Repository所在位置y
public class CommonConfig {
    @Autowired
    private HibernateProperties hibernateProperties;
    @Autowired
    @Qualifier("commonDataSource")
    private DataSource commonDataSource;

    @Bean(name = "entityManagerCommon")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryCommon(builder).getObject().createEntityManager();
    }

    @Autowired
    private JpaProperties jpaProperties;

//    private Map<String, Object> getVendorProperties() {
//        return jpaProperties.getHibernateProperties(new HibernateSettings());
//    }

    @Bean(name = "entityManagerFactoryCommon")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryCommon (EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());
        return builder.
                dataSource(commonDataSource)
                .properties(properties)
                .packages("com.taiji.authenticationplatform.model.common") //设置实体类所在位置
                .persistenceUnit("commonPersistenceUnit")
                .build();
    }

    @Bean(name = "transactionManagerCommon")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryCommon(builder).getObject());
    }

}
