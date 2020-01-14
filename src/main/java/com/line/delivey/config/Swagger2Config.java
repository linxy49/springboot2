package com.line.delivey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

  /**
   * swagger2.
   * @return
   */
  @Bean
  public Docket swaggerSpringMvcPlugin() {
    return new Docket(DocumentationType.SWAGGER_2)
        .useDefaultResponseMessages(false)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.regex("/v1.*"))
        .build()
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Springboot Delivery API")
        .description("Eメール、SlackとLineWorkの送信など.")
        .version("beta")
        .contact(new Contact("name", "URL", "email"))
        .license("license")
        .licenseUrl("license URL")
        .termsOfServiceUrl("")
        .build();
  }

  /**
   * swagger2ui.
   * @return
   */
  @Bean
  public UiConfiguration uiConfig() {
    return UiConfigurationBuilder.builder()
        .displayRequestDuration(true)
        .validatorUrl("")
        .build();
  }
}
