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
                description = "Notification Service APIs Documentation",
                title = "OpenApi specification - Justedlevhub Notification APIs",
                version = "v1",
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                )
        ),
        servers = {
                @Server(
                        description = "Gateway ENV",
                        url = "${configuration.service.url}"
                ),
        },
        security = {
                @SecurityRequirement(name = "OAuth2"),
                @SecurityRequirement(name = "bearer-auth"),
        }
)
@SecurityScheme(
        name = "OAuth2",
        description = "Authentication by OAuth2 protocol",
        scheme = "bearer",
        type = SecuritySchemeType.OAUTH2,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.COOKIE,
        flows = @OAuthFlows(
                password = @OAuthFlow(
                        tokenUrl = "${keycloak.token-uri}",
                        refreshUrl = "${keycloak.token-uri}"
                ),
                clientCredentials = @OAuthFlow(
                        tokenUrl = "${keycloak.token-uri}",
                        refreshUrl = "${keycloak.token-uri}"
                )
        )
)
@SecurityScheme(
        name = "bearer-auth",
        description = "Authentication by JWT",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfiguration {
}
