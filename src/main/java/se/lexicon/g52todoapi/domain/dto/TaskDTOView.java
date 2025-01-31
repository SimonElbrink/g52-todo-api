package se.lexicon.g52todoapi.domain.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record TaskDTOView(
        Long id,
        String title,
        String description,
        LocalDate deadline,
        boolean done,
        PersonDTOView person
) {
}
