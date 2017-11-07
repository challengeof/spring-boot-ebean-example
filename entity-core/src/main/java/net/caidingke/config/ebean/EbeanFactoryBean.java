package net.caidingke.config.ebean;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import io.ebean.spring.txn.SpringJdbcTransactionManager;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author bowen
 */
@Component
public class EbeanFactoryBean implements FactoryBean<EbeanServer> {

    @Autowired
    private CurrentUser currentUser;
    
    @Autowired
    private DataSource dataSource;

    @Override
    public EbeanServer getObject() throws Exception {
        ServerConfig config = new ServerConfig();
        config.setName("db");
        config.setCurrentUserProvider(currentUser);
        config.setDataSource(dataSource);
        config.setExternalTransactionManager(new SpringJdbcTransactionManager());
        config.loadFromProperties();
        config.setDefaultServer(true);
        config.setDdlGenerate(true);
//        config.setDdlRun(true);
        config.setRegister(true);
        return EbeanServerFactory.create(config);
    }

    @Override
    public Class<?> getObjectType() {
        return EbeanServer.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
