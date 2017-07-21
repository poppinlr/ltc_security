package com.leapstack.ltc.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by zhuochen on 2017/7/10.
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {

    //swagger-ui.html
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.leapstack.ltc.controller"))
//                .useDefaultResponseMessages(false)
//                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ltc security API list")
                .description("")
//                .contact(new Contact("name", "url", "email"))
                .contact("zhuochen@leapstack.cn")
//                .termsOfServiceUrl("https://swagger.io/specification/")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("2.0")
                .build();
    }

//    @Component
//    @Primary
//    public class CustomObjectMapper extends ObjectMapper {
//        public CustomObjectMapper() {
//            setSerializationInclusion(JsonInclude.Include.NON_NULL);
//            configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//            configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            enable(SerializationFeature.INDENT_OUTPUT);
//        }
//    }

}
