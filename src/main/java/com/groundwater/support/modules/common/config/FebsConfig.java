package com.groundwater.support.modules.common.config;

import com.groundwater.support.modules.common.properties.FebsProperties;
import com.groundwater.support.modules.common.properties.SwaggerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
* @author wx
*/
@Configuration
public class FebsConfig {
//    @Autowired
//    private FebsProperties properties;
//
//    @Bean
//    public Docket swaggerApi() {
//        SwaggerProperties swagger = properties.getSwagger();
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(swagger.getBasePackage()))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo(swagger));
//    }
//
//    private ApiInfo apiInfo(SwaggerProperties swagger) {
//        return new ApiInfo(
//                swagger.getTitle(),
//                swagger.getDescription(),
//                swagger.getVersion(),
//                null,
//                new Contact(swagger.getAuthor(), swagger.getUrl(), swagger.getEmail()),
//                swagger.getLicense(), swagger.getLicenseUrl(), Collections.emptyList());
//    }
}
