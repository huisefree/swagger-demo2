package com.sly.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author slystart
 * @date 2022/7/12 - 15:58
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //配置了Swagger的Docket的bean实例
    //enable是否启用Swagger，如果是false则不能在浏览器中访问Swagger
    @Bean
    public Docket docket(Environment environment){

        //设置要显示的Swagger环境
            Profiles profiles = Profiles.of("dev","test");
        //通过environment.acceptsProfiles(profiles)判断是否出在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);
        System.out.println(flag);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("sly")
                .enable(flag)
                .select()
                //RequestHandlerSelectors,配置要扫描接口的方式
                //basePackage:指定要扫描的包
                //any():全部扫描
                //none():不扫描
                //withClassAnnotation:扫描类上的注解，参数是一个注解的反射对象
                //withMethodAnnotation:扫描方法类上的注解
                .apis(RequestHandlerSelectors.basePackage("com.sly.swagger.controller"))
                //paths():过滤
                //paths(PathSelectors.ant("/sly/**"))
                .build();

    }

    //配置Swagger信息=apiInfo
    private ApiInfo apiInfo(){

        //作者信息
        Contact contact =  new Contact("", "", "");
        return  new ApiInfo("拧螺丝的Swagger文档日常",
                "Api Documentation",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
