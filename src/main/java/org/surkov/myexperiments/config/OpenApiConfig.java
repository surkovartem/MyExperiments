package org.surkov.myexperiments.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "MyExperiments",
        description = "All in clusive", version = "1.0.0",
        contact = @Contact(
            name = "Surkov Artem",
            email = "artym.surkov@mail.ru"
        )
    )
)
public class OpenApiConfig {

}
