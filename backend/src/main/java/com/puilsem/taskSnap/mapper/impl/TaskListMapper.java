package com.puilsem.taskSnap.mapper.impl;

import com.puilsem.taskSnap.domain.dto.*;
import com.puilsem.taskSnap.domain.entity.*;
import com.puilsem.taskSnap.mapper.*;

import java.util.*;

public class TaskListMapper implements ITaskListMapper {

    private ITaskMapper iTaskMapper;

    public TaskListMapper(ITaskMapper iTaskMapper) {
        this.iTaskMapper = iTaskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        if (null == taskListDto)
            throw new IllegalArgumentException("Task List Dto cannot be null");

        return new TaskList(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                null,
                null,
                taskListDto.taskDtos() != null
                    ? taskListDto.taskDtos()
                        .stream()
                        .map((taskDto) -> iTaskMapper.fromDto(taskDto))
                        .toList()
                    : new ArrayList<>()
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        if (null == taskList)
            throw new IllegalArgumentException("Task List cannot be null");

        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                taskList.getTasks() != null
                    ? taskList.getTasks()
                        .stream()
                        .map((task) -> iTaskMapper.toDto(task))
                        .toList()
                    : new ArrayList<>(),
                countTasksOfTaskList(taskList),
                calculateProgressOfTaskList(taskList)
        );
    }

    private int countTasksOfTaskList(TaskList taskList){
        return taskList.getTasks().size();
    }

    private double calculateProgressOfTaskList(TaskList taskList){
        int tasksCompleted = 0;
        for(Task t : taskList.getTasks()){
            if(t.getTaskStatus() == TaskStatus.CLOSED)
                tasksCompleted++;
        }
        return (double) tasksCompleted / countTasksOfTaskList(taskList);
    }


}
