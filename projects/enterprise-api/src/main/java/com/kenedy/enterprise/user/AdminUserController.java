package com.kenedy.enterprise.user;

import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/users")
@PreAuthorize("hasRole('ADMIN')")
public class AdminUserController {
    private final UserAccountRepository users;

    public AdminUserController(UserAccountRepository users) {
        this.users = users;
    }

    @GetMapping
    public List<UserSummary> list(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "20") int size) {
        int safeSize = Math.min(Math.max(size, 1), 100);
        return users.findAll(PageRequest.of(Math.max(page, 0), safeSize))
            .stream()
            .map(UserSummary::from)
            .toList();
    }

    public record UserSummary(UUID id, String email, Role role, boolean active) {
        static UserSummary from(UserAccount user) {
            return new UserSummary(user.getId(), user.getEmail(), user.getRole(), user.isActive());
        }
    }
}
