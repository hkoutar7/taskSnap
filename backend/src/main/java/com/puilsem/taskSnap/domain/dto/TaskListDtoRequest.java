package com.puilsem.taskSnap.domain.dto;

import jakarta.validation.constraints.*;

public record TaskListDtoRequest(
        @NotBlank(message = "Title is required and cannot be null nor empty.")

        String title,
        String description
) {
}
