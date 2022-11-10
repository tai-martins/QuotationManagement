package br.inatel.idp.quotationmanagement.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfiguration Class. 
 * 
 * @author Tainara Martins.
 * @since November 2022
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	/**
	 * method that Sets up a swagger documentation web page
	 * 
	 * @return docket
	 */
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build();
    }
}
