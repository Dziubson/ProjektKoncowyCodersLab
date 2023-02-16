package pl.coderslab.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Validator;

@Configuration
@EnableWebMvc
@ComponentScan
@EnableTransactionManagement
@EnableJpaRepositories
public class AppConfig {
    //definicje beanów
    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }
}
