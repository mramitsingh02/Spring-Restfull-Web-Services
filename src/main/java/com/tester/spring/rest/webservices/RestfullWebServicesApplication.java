package com.tester.spring.rest.webservices;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tester.spring.rest.webservices.services", "com.tester.spring.rest.webservices.config"
})
public class RestfullWebServicesApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RestfullWebServicesApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
//		SpringApplication.run(RestfullWebServicesApplication.class, args);

        System.out.println("Hello world");
    }

    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

	/*@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver localeResolver= new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return  localeResolver;
	}*/
/*
@Bean
public ResourceBundleMessageSource messageSource(){
	ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
	resourceBundleMessageSource.setBasename("messages");
	return resourceBundleMessageSource;

}
*/


}
