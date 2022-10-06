package org.aibles.i18n.configuration;

import org.aibles.i18n.util.HeaderLocalResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class I18nConfiguration implements WebMvcConfigurer {

  @Bean
  public LocaleResolver localeResolver() {
    return new HeaderLocalResolver();
  }

  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource
        = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename(
        "classpath:/i18n/messages"
    );
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }
}
