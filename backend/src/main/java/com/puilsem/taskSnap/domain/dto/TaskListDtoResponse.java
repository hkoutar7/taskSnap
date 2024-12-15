package com.puilsem.taskSnap.domain.dto;

import java.util.*;

public record TaskListDtoResponse(
        UUID id,
        String title,
        String description,
        List<TaskDtoResponse> tasks,
        Integer tasksTotal,
        Double tasksProgress
) {
}
