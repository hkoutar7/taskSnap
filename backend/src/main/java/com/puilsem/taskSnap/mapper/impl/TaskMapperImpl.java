package com.puilsem.taskSnap.mapper.impl;

import org.springframework.stereotype.*;

import com.puilsem.taskSnap.domain.entity.*;
import com.puilsem.taskSnap.domain.dto.*;
import com.puilsem.taskSnap.mapper.*;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromDto(TaskDtoRequest taskDtoRequest) {
        return new Task(
            null,
            taskDtoRequest.title(),
            taskDtoRequest.description(),
            taskDtoRequest.dueDate(),
            taskDtoRequest.taskStatus(),
            taskDtoRequest.taskPriority(),
            null,
            null,
            null
        );
    }

    @Override
    public TaskDtoResponse toDto(Task task) {
        return new TaskDtoResponse(
          task.getId(),
          task.getTitle(),
          task.getDescription(),
          task.getDueDate(),
          task.getTaskPriority(),
          task.getTaskStatus()
        );
    }

}
