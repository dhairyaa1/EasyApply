package com.workspace.userservice.configuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "workspaceEntityManagerFactory",
        transactionManagerRef = "workspaceTransactionManager",
        basePackages = {"com.workspace.userservice.repositories"}
)

public class Configuration {


    @Bean("workspaceEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean createWorkspaceEntityManagerFactory(@Qualifier("workspaceDataSource") DataSource dataSource) {
       var entityManager = new LocalContainerEntityManagerFactoryBean();
       entityManager.setDataSource(dataSource);
        var properties = new Properties();
        properties.setProperty("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        properties.setProperty("hibernate.physical_naming_strategy", CamelCaseToUnderscoresNamingStrategy.class.getName());

        entityManager.setJpaProperties(properties);
       entityManager.setPackagesToScan("com.workspace.userservice.entities");
        entityManager.setPersistenceUnitName("myPersistenceUnit");

       var vendorAdapter = new HibernateJpaVendorAdapter();
       vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
       entityManager.setJpaVendorAdapter(vendorAdapter);
       return entityManager;
    }
    @Bean(name = "workspaceEntityManager")
    public EntityManager entityManager( EntityManagerFactory workspaceEntityManagerFactory) {
        return workspaceEntityManagerFactory.createEntityManager();
    }

    @Bean("workspaceTransactionManager")
    public JpaTransactionManager transactionManager(EntityManagerFactory workspaceEntityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(workspaceEntityManagerFactory);
        return transactionManager;
    }
    @Bean
    protected Properties buildHibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        hibernateProperties.setProperty("hibernate.physical_naming_strategy", PhysicalNamingStrategy.class.getName());

        return hibernateProperties;
    }
    @Bean("workspaceDataSourceProperties")
    @ConfigurationProperties("spring.datasource.workspace")
    public DataSourceProperties dataSourceProperties()
    {
        return new DataSourceProperties();
    }
    @Bean("workspaceDataSource")
    public DataSource workspaceDataSource(@Qualifier("workspaceDataSourceProperties") DataSourceProperties dataSourceProperties)
    {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

}
