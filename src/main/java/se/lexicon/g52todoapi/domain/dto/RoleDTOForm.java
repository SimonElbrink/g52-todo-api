package se.lexicon.g52todoapi.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record RoleDTOForm(
        @PositiveOrZero(message = "Id must be a positive number or zero")
        Long id,

        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 255, message = "Name must be between 2 and 255 characters")
        String name) {
}
