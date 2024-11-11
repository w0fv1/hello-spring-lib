package dev.w0fv1.hello.spring;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HellorProperties.class)
public class HellorAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Hellor hellor(HellorProperties properties) {
        return new Hellor(properties.getContent());
    }
}