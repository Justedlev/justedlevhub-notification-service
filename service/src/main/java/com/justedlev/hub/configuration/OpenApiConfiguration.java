package com.justedlev.hub.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Justedlev",
                        email = "justedlevhub@gmail.com"
                ),
                description = "Documentation",
                title = "OpenApi specification - Justedlevhub",
                version = "1.0",
                license = @License(
                        name = "Apache 2.0",
                        url = "https://springdoc.org"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                ),
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.OAUTH2,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER,
        flows = @OAuthFlows(
                password = @OAuthFlow(
                        tokenUrl = "http://localhost:9321/realms/justedlevhub/protocol/openid-connect/token",
                        refreshUrl = "http://localhost:9321/realms/justedlevhub/protocol/openid-connect/token"
                ),
                clientCredentials = @OAuthFlow(
                        tokenUrl = "http://localhost:9321/realms/justedlevhub/protocol/openid-connect/token",
                        refreshUrl = "http://localhost:9321/realms/justedlevhub/protocol/openid-connect/token"
                )
        )
)
public class OpenApiConfiguration {
//    @Bean
//    public OpenAPI customOpenAPI() {
//        final var securitySchemeName = "bearer-token";
//
//        return new OpenAPI()
//                .addSecurityItem(new SecurityRequirement()
//                        .addList(securitySchemeName))
//                .components(new Components()
//                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
//                                .name(securitySchemeName)
//                                .type(SecurityScheme.Type.HTTP)
//                                .scheme("bearer")
//                                .bearerFormat("JWT")))
//                .info(getInfo());
//    }
//
//    private Info getInfo() {
//        return new Info()
//                .title("JAccount Service APIs")
//                .version("0.0.1")
//                .description("Justedlev Services APIs")
//                .termsOfService("swagger.io/terms/")
//                .license(getLicense());
//    }
//
//    private License getLicense() {
//        return new License().name("Apache 2.0").url("springdoc.org");
//    }
}
