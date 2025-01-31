package se.lexicon.g52todoapi.domain.dto;

import java.util.Set;

public record UserDTOForm(
        String email,
        String password,
        Set<RoleDTOForm> roles
) {
}
