package com.puilsem.taskSnap.controller.impl;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import jakarta.validation.*;

import com.puilsem.taskSnap.domain.entity.*;
import com.puilsem.taskSnap.domain.dto.*;
import com.puilsem.taskSnap.controller.*;
import com.puilsem.taskSnap.service.*;
import com.puilsem.taskSnap.mapper.*;
import com.puilsem.taskSnap.utils.*;

import java.util.*;


@RestController
@RequestMapping("/api/v1/task-lists")

public class TaskListControllerImpl implements TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListControllerImpl(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping("")
    @Override
    public ResponseEntity<ResponseApi<List<TaskListDtoResponse>>> getAllTaskLists() {
         List<TaskListDtoResponse> taskListDtoResponses = taskListService.getAllTaskLists()
                 .stream()
                 .map(taskListMapper::toDto)
                 .toList();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseApi<>(HttpStatus.OK.value(), "All Tasks Lists have been retrieved successfully", taskListDtoResponses));
    }


    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ResponseApi<TaskListDtoResponse>> getTaskListById(@PathVariable UUID id) {
        Optional<TaskList> taskListOptional =  taskListService.getTaskListById(id);
        if (taskListOptional.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ResponseApi<>(HttpStatus.NOT_FOUND.value(), "Task List with id not found", null));

        TaskList taskListExist = taskListOptional.get();
        TaskListDtoResponse taskListDtoResponse = taskListMapper.toDto(taskListExist);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseApi<>(HttpStatus.OK.value(), "Task List with id have been retrieved successfully", taskListDtoResponse));
    }

    @PostMapping("")
    @Override
    public ResponseEntity<ResponseApi<TaskListDtoResponse>> storeTaskList(@RequestBody @Valid TaskListDtoRequest taskListDtoRequest) {
        TaskList taskList = taskListMapper.fromDto(taskListDtoRequest);
        TaskList taskListCreated = taskListService.storeTaskList(taskList);
        TaskListDtoResponse taskListDtoResponse = taskListMapper.toDto(taskListCreated);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseApi<>(HttpStatus.CREATED.value(), "Task List have been created successfully", taskListDtoResponse));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ResponseApi<TaskListDtoResponse>> updateTaskList(@PathVariable UUID id, @RequestBody @Valid TaskListDtoRequest taskListDtoRequest) {
        Optional<TaskList> taskListOptional =  taskListService.getTaskListById(id);
        if (taskListOptional.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ResponseApi<>(HttpStatus.NOT_FOUND.value(), "Task List with id not found", null));

        TaskList taskListExist = taskListOptional.get();
        TaskList taskList = taskListMapper.fromDto(taskListDtoRequest);

        TaskList taskListUpdated = taskListService.updateTaskList(taskListExist, taskList);
        TaskListDtoResponse taskListDtoResponseUpdated = taskListMapper.toDto(taskListUpdated);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseApi<>(HttpStatus.CREATED.value(), "Task List with id have been updated successfully", taskListDtoResponseUpdated));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<ResponseApi<TaskListDtoResponse>> deleteTaskListById(@PathVariable UUID id) {
        Optional<TaskList> taskListOptional =  taskListService.getTaskListById(id);
        if (taskListOptional.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ResponseApi<>(HttpStatus.NOT_FOUND.value(), "Task List with id not found", null));

        TaskList taskListExist = taskListOptional.get();
        TaskListDtoResponse taskListDtoResponse = taskListMapper.toDto(taskListExist);

        taskListService.deleteTaskListById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseApi<>(HttpStatus.OK.value(), "Task List with id have been deleted successfully.", taskListDtoResponse));
    }



}
