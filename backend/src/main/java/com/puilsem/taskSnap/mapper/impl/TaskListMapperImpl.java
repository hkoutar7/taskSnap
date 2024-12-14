package com.puilsem.taskSnap.mapper.impl;

import org.springframework.stereotype.*;

import com.puilsem.taskSnap.domain.entity.*;
import com.puilsem.taskSnap.domain.dto.*;
import com.puilsem.taskSnap.mapper.*;

import java.util.*;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDtoRequest taskListDtoRequest) {
        return new TaskList(
            null,
            taskListDtoRequest.title(),
            taskListDtoRequest.description(),
            null,
            null,
            null
        );
    }

    @Override
    public TaskListDtoResponse toDto(TaskList taskList) {
        List<TaskDtoResponse> taskDtos = taskList.getTasks() != null
                ? taskList.getTasks().stream().map(taskMapper::toDto).toList()
                : new ArrayList<>();

        return new TaskListDtoResponse(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                taskDtos,
                calculateTaskListTotal(taskList),
                calculateTaskListProgress(taskList)
        );
    }

    private int calculateTaskListTotal(TaskList taskList){
        return taskList.getTasks() != null ? taskList.getTasks().size() : 0;
    }

    private double calculateTaskListProgress(TaskList taskList){
        int tasksAll = 0;
        int tasksCompleted = 0;

        for (Task t: taskList.getTasks()){
            if(t.getTaskStatus() == TaskStatus.CLOSED)
                tasksCompleted++;
            tasksAll++;
        }
        return tasksAll == 0 ? 0.0 : (double) tasksCompleted / tasksAll;
    }

}
