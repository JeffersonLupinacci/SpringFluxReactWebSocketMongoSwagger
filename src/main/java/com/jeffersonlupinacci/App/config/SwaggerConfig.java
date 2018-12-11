package com.jeffersonlupinacci.App.config;

import com.jeffersonlupinacci.App.controller.PersonRestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Config
 *
 * @author jeffersonlupinacci
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

  @Value("${app.name}")
  private String name;

  @Value("${app.version}")
  private String version;

  @Value("${app.description}")
  private String description;

  /**
   * The Swagger API
   */
  @Bean
  public Docket swaggerApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage(PersonRestController.class.getPackage().getName()))
        .build()
        .apiInfo(metaData());
  }

  /**
   * Get the Swagger MetaData
   */
  private ApiInfo metaData() {
    return new ApiInfoBuilder()
        .title(name)
        .description(description)
        .version(version)
        .build();
  }

  /**
   * The Resource Handlers
   *
   * @param registry the Registry
   */
  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");

    registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
}
