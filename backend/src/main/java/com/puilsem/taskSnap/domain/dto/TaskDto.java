package com.puilsem.taskSnap.domain.dto;

import com.puilsem.taskSnap.domain.entity.*;

import java.time.*;
import java.util.*;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskStatus taskStatus,
        TaskPriority taskPriority
) {
}
