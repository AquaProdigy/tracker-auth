package org.example.trackerauth.config.jwt;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "jwt")
@Configuration
@Validated
@Getter
@Setter
public class JwtProperties {
    @NotBlank
    private String secret;

    @Positive
    private long expiration;
}
