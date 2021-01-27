package com.p5.ls.web.config.db;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.p5.ls.web.util.Const;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.p5.ls.web.dao"})
@EnableJpaAuditing
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfig {

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(Const.DB_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(Const.DB_URL));
		dataSource.setUsername(env.getRequiredProperty(Const.DB_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(Const.DB_PASSWORD));
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
		emfBean.setDataSource(dataSource());
		emfBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		emfBean.setPackagesToScan(env.getRequiredProperty(Const.ENTITYMANAGER_PACKAGES_TO_SCAN));
		emfBean.setJpaProperties(hibernateProperties());
		return emfBean;
	}

	@Bean(name= {"jpaTxMgr","transactionManager"})
	public JpaTransactionManager jpaTxMgr() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}


	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(env.getRequiredProperty(Const.ENTITYMANAGER_PACKAGES_TO_SCAN));
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public PlatformTransactionManager hbTxMgr() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory().getObject());
		//transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory().getObject());
	}


	private Properties hibernateProperties() { 
		Properties props = new Properties();
		props.put(Const.HB_DIALECT, env.getRequiredProperty(Const.HB_DIALECT));
		props.put(Const.HB_SHOW_SQL, env.getRequiredProperty(Const.HB_SHOW_SQL));
		props.put(Const.HB_FORMAT_SQL, env.getRequiredProperty(Const.HB_FORMAT_SQL));
		props.put(Const.HB_HBM2DDL_AUTO, env.getRequiredProperty(Const.HB_HBM2DDL_AUTO));
		props.put(Const.HB_MIN_SIZE, env.getProperty(Const.HB_MIN_SIZE));
		props.put(Const.HB_MAX_SIZE, env.getProperty(Const.HB_MAX_SIZE));
		props.put(Const.HB_ACQUIRE_INCREMENT, env.getProperty(Const.HB_ACQUIRE_INCREMENT));
		props.put(Const.HB_TIMEOUT, env.getProperty(Const.HB_TIMEOUT));
		props.put(Const.HB_MAX_STATEMENTS, env.getProperty(Const.HB_MAX_STATEMENTS));
		return props;
	}
	
}
