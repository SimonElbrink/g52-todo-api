package se.lexicon.g52todoapi.domain.dto;

import lombok.Builder;

@Builder
public record PersonDTOView(Long id, String name) {

}
