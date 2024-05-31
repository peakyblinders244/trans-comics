package com.transcomics.transcomics.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Le-Hong-Quan
 * Date: 28/05/2024
 * Time: 15:20
 */
@Configuration
public class MessageSourceConfig {
    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        MultipleMessageSource messageSource
                = new MultipleMessageSource();
        messageSource.setFileWildCard("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
