package com.puilsem.taskSnap.domain.dto;

import com.puilsem.taskSnap.domain.entity.*;
import jakarta.validation.constraints.*;

import java.time.*;

public record TaskDtoRequest(

        @NotBlank(message = "Title is required and cannot be null nor empty.")
        String title,
        String description,
        LocalDateTime dueDate,
        @NotNull(message = "Task proprity is required and cannot be null.")
        TaskPriority taskPriority,
        @NotNull(message = "Task Status is required and cannot be null.")
        TaskStatus taskStatus
) {
}
