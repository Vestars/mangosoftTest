package mangosoft.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class AppPropertiesConfig {

    @Value("${jdbc.driverClassName}")
    public String jdbcDriver;

    @Value("${jdbc.url}")
    public String jdbcUrl;

    @Value("${jdbc.username}")
    public String jdbcUsername;

    @Value("${jdbc.password}")
    public String jdbcPass;

    @Value("${hibernate.hbm2ddl.auto}")
    public String hibernateHbm2ddlAuto;

    @Value("${hibernate.dialect}")
    public String hibernateDialect;

}
