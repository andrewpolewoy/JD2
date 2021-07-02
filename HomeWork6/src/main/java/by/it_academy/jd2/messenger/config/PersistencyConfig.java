package by.it_academy.jd2.messenger.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/** Класс для создания подключения к базе данных */
@Configuration
@EnableJpaRepositories("by.it_academy.jd2.messenger.storage")
@EnableTransactionManagement
public class PersistencyConfig {

    /**
     * Создает пул подключений
     * @return Объект класса DataSource
     * @throws PropertyVetoException когда свойство представляет недопустимое значение
     */
    @Bean
    public DataSource dataSource() throws PropertyVetoException {

        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("org.postgresql.Driver");
        cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/messenger");
        cpds.setUser("postgres");
        cpds.setPassword("postgres");
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(180);

        return cpds;
    }

    /**
     * Конфигурирует интерфейс {@link EntityManagerFactory}
     * @param dataSource Объект класса {@link DataSource}
     * @return  {@link EntityManagerFactory} в контексте приложения Spring
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(false);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("by.it_academy.jd2.messenger.model");
        factory.setDataSource(dataSource);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.spatial.dialect.postgis.PostgisPG10Dialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("show_sql", "true");
        properties.setProperty("hibernate.default_schema", "hibernate");

        factory.setJpaProperties(properties);
        return factory;
    }

    /**
     * Создает менеджер для создания, фиксации или отката транзакций.
     * @param entityManagerFactory Объект класса {@link EntityManagerFactory}
     * @return Объект класса {@link JpaTransactionManager}
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
