package com.puilsem.taskSnap.mapper.impl;

import org.springframework.stereotype.*;

import com.puilsem.taskSnap.domain.entity.*;
import com.puilsem.taskSnap.domain.dto.*;
import com.puilsem.taskSnap.mapper.*;

@Component
public class TaskMapper implements ITaskMapper {

    @Override
    public TaskDto toDto(Task task) {
        if (null == task)
            throw new IllegalArgumentException("Task cannot be null .");

        return new TaskDto(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getDueDate(),
            task.getTaskStatus(),
            task.getTaskPriority()
        );
    }

    @Override
    public Task fromDto(TaskDto taskDto) {
        if (null == taskDto)
            throw  new IllegalArgumentException("Task dto cannot be null .");

        return new Task(
            taskDto.id(),
            taskDto.title(),
            taskDto.description(),
            taskDto.dueDate(),
            taskDto.taskStatus(),
            taskDto.taskPriority(),
            null,
            null,
            null
        );
    }
}
