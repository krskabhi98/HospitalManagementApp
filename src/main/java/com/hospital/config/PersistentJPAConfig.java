package com.hospital.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.apache.tomcat.jdbc.pool.DataSourceProxy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class PersistentJPAConfig {
    private static final String[] strAllPackage = new String[]{"com.hospital.model"};
    private static final String COMMA = ",";
    private static Properties properties=new Properties();

    @Value("${spring.datasource.driverClassName}")
    private String dbDriverClass;
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbUser;
    @Value("${spring.datasource.password}")
    private String dbPassword;
    @Value("${spring.jpa.show-sql}")
    private Boolean showSql;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String hbm2ddl;


    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
        em.setDataSource(dataSource());
        em.setPackagesToScan(strAllPackage);
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(jpaProperties());

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
    @Bean
    public DataSource dataSource() {
        int initialPoolSize = 5;
        int maxPoolSize = 50;
        int minPoolSize = 5;
        int maxPoolTime = 3000;

        ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();

        try {
            pooledDataSource.setDriverClass(dbDriverClass);
        } catch (PropertyVetoException ex) {
//                LOG.ERROR(ex);
        }

        pooledDataSource.setJdbcUrl(dbUrl);
        pooledDataSource.setUser(dbUser);
        pooledDataSource.setPassword(dbPassword);
        pooledDataSource.setInitialPoolSize(initialPoolSize);
        pooledDataSource.setMaxPoolSize(maxPoolSize);
        pooledDataSource.setMinPoolSize(minPoolSize);
        pooledDataSource.setMaxIdleTime(maxPoolTime);

        return pooledDataSource;
    }

    Properties jpaProperties(){
        properties.setProperty("hibernate.show.sql",showSql.toString());
        properties.setProperty("hibernate.hbm2ddl.auto",hbm2ddl);

        List<String> importFileList=new ArrayList<>(150);
        importFileList.add("static_data/DOCTORS.sql");
        importFileList.add("static_data/PATIENTS.sql");
        importFileList.add("static_data/RECEPTIONISTS.sql");
        importFileList.add("static_data/USERS.sql");
        importFileList.add("static_data/APPOINTMENTS.sql");

        setImportFileProperty(importFileList,properties);


        return properties;

    }

    private void setImportFileProperty(List<String> importFileList, Properties properties) {
        StringBuilder importFileString=new StringBuilder();
        int iterationCount=0;
        for(String s: importFileList){
            iterationCount++;
            if(iterationCount==1){
                importFileString.append(s);
            }
            else{
                importFileString.append(COMMA).append(s);
            }
        }
        properties.setProperty("hibernate.hbm2ddl.import_files",importFileString.toString());
    }


}
