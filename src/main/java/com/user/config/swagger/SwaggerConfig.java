package com.user.config.swagger;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket customDocket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().globalOperationParameters(getParameterList());
    }

    private ApiInfo apiInfo() {
        // springfox.documentation.service.Contact
        Contact contact = new Contact("团队名", "www.my.com", "my@my.com");
        return new ApiInfoBuilder()
                .title("用户中心")
                .description("用户中心")
                .contact(contact)   // 联系方式
                .version("1.1.0")  // 版本
                .build();
    }

    public List<Parameter> getParameterList() {
        ParameterBuilder token = new ParameterBuilder();
        List<Parameter> params = new ArrayList<>();
        token.name("token")											//这个是请求头的名字，
                .description("令牌")				 				//在文档中的中文描述
                .modelRef(new ModelRef("string"))
                .parameterType("header")						//这个参数的类型
                .required(false)									 //是否必填
                .build();
        params.add(token.build());
        return params;
    }
}