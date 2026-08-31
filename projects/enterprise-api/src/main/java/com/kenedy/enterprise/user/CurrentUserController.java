package com.kenedy.enterprise.user;

import java.util.Map;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/me")
public class CurrentUserController {

    @GetMapping
    public Map<String, Object> me(JwtAuthenticationToken authentication) {
        return Map.of(
            "subject", authentication.getToken().getSubject(),
            "email", authentication.getToken().getClaimAsString("email"),
            "role", authentication.getToken().getClaimAsString("role")
        );
    }
}
