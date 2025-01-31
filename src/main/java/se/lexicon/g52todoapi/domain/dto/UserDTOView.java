package se.lexicon.g52todoapi.domain.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record UserDTOView(String email, Set<RoleDTOView> roles) {
}
