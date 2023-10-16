package com.example.library.configure;


import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfiguration {

    @Bean
    public Docket apiDocket(TypeResolver typeResolver) {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.example.library"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());

        //.additionalModels(typeResolver.resolve());
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "library",
                "by : Amirhossein Javid",
                "1",
                "",
                new Contact("Amirhossein Javid", "google.com", "amirhoseinjavid@aol.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                Collections.emptyList()
        );
    }
}
