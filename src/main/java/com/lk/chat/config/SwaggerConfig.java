package com.lk.chat.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openApi(
            @Value("${springdoc.version}") String version,
            @Value("${springdoc.title}") String title,
            @Value("${springdoc.description}") String description
    ) {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .version(version)
                        .title(title)
                        .description(description)
                );
    }

}
