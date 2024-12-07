package com.puilsem.taskSnap.domain.dto;

import java.util.*;

public record TaskListDto(
        UUID id,
        String title,
        String description,
        List<TaskDto> taskDtos,
        Integer count,
        Double progress
) {
}
