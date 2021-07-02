package by.it_academy.jd2.messenger.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Определение конфигурации для веб-компонентов */
@Configuration
@ComponentScan("by.it_academy.jd2.messenger.controller")
public class WebConfig implements WebMvcConfigurer {

}
