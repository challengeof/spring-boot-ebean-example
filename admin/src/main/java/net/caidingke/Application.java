package net.caidingke;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author bowen.
 */
@SpringBootApplication
@EnableTransactionManagement
@Slf4j
public class Application extends SpringBootServletInitializer {
    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager) {
        log.info(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
