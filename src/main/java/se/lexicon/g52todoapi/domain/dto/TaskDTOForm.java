package se.lexicon.g52todoapi.domain.dto;

import java.time.LocalDate;

public record TaskDTOForm(
        Long id,
        String title,
        String description,
        LocalDate deadline,
        boolean done,
        PersonDTOForm person
) {
}