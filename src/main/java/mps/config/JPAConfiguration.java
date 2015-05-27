package mps.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("mps.repositories")
@EnableTransactionManagement // similiar to <tx:annotation-driven/>

public class JPAConfiguration {
	private static final String JAVAX_JDBC = "javax.persistence.jdbc.";
	private static final String ENTITY_BASE = "mps.entities";
	
	public static final String[] PROPERTIES_TO_COPY = {
		"javax.persistence.schema-generation.database.action",
        "javax.persistence.schema-generation.create-source",
        "javax.persistence.sql-load-script-source"
	};

	@Autowired(required = false)
	private PersistenceUnitManager persistenceUnitManager;
	
	@Autowired
	private Environment environment; // this provides the values of our property source, e.g. application.properties

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		Map<String, Object> jpaProperties = new HashMap<>();
		for(String p: PROPERTIES_TO_COPY) {
			String v = environment.getProperty(p);
			if(v!=null) jpaProperties.put(p,v);
		}
		return entityManagerFactory(jpaProperties);
	}
	
	protected LocalContainerEntityManagerFactoryBean entityManagerFactory(Map<String, Object> jpaProperties) {
		//String[] packagesToScan = new String[]{Topic.class.getPackage().getName()};
		String[] packagesToScan = new String[]{ENTITY_BASE};
		AbstractJpaVendorAdapter jpaVendor = new HibernateJpaVendorAdapter();
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		if (persistenceUnitManager != null) {
			factory.setPersistenceUnitManager(persistenceUnitManager);
		}
		factory.setJpaPropertyMap(jpaProperties);
		factory.setJpaVendorAdapter(jpaVendor);
		factory.setPackagesToScan(packagesToScan);
		factory.setDataSource(dataSource());
		return factory;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty(JAVAX_JDBC+"driver"));
        dataSource.setUrl(environment.getRequiredProperty(JAVAX_JDBC+"url"));
        dataSource.setUsername(environment.getRequiredProperty(JAVAX_JDBC+"user"));
        dataSource.setPassword(environment.getRequiredProperty(JAVAX_JDBC+"password"));
		return dataSource;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
}