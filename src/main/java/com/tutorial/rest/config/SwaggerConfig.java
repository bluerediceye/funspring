package com.tutorial.rest.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.paths.AbsoluteSwaggerPathProvider;
import com.mangofactory.swagger.paths.SwaggerPathProvider;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 23/02/15
 *
 * @author Ming Li
 */
@Configuration
@EnableSwagger //Loads the spring beans required by the framework
public class SwaggerConfig {

    @Autowired
    private SpringSwaggerConfig springSwaggerConfig;

    @Value(value = "http://localhost:8080/rest")
    private String applicationPath;

    @Value(value = "http://localhost:8080/rest/api-docs")
    private String documentationPath;

    /**
     * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc framework - allowing for multiple
     * swagger groups i.e. same code base multiple swagger resource listings.
     */
    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(springSwaggerConfig)
                .pathProvider(swaggerPathProvider())
                ;
    }

    @Bean
    public SwaggerPathProvider swaggerPathProvider() {
        return new AbsoluteSwaggerPathProvider() {
            @Override
            protected String applicationPath() {
                return SwaggerConfig.this.applicationPath;
            }

            @Override
            protected String getDocumentationPath() {
                return SwaggerConfig.this.documentationPath;
            }
        };
    }
}