package com.puilsem.taskSnap.domain.dto;

import com.puilsem.taskSnap.domain.entity.*;

import java.time.*;
import java.util.*;

public record TaskDtoResponse(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority taskPriority,
        TaskStatus taskStatus
) {
}
