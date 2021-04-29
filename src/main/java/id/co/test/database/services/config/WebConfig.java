package id.co.test.database.services.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@PropertySource("classpath:application.properties")
public class WebConfig extends WebMvcConfigurerAdapter{

}
