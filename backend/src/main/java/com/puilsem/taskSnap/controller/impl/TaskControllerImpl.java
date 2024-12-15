package com.puilsem.taskSnap.controller.impl;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import jakarta.validation.*;

import com.puilsem.taskSnap.domain.entity.*;
import com.puilsem.taskSnap.domain.dto.*;
import com.puilsem.taskSnap.mapper.*;
import com.puilsem.taskSnap.controller.*;
import com.puilsem.taskSnap.service.*;
import com.puilsem.taskSnap.utils.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/tasks")

public class TaskControllerImpl implements TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskControllerImpl(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping("")
    @Override
    public ResponseEntity<ResponseApi<List<TaskDtoResponse>>> getAllTasks() {
        List<TaskDtoResponse> taskDtoResponseList = taskService.getAllTasks()
                .stream()
                .map(taskMapper::toDto)
                .toList();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseApi<>(HttpStatus.OK.value(), "All Tasks have been retrieved successfully", taskDtoResponseList));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ResponseApi<TaskDtoResponse>> getTaskById(@PathVariable UUID id) {
        Optional<Task> optionalTask = taskService.getTaskById(id);
        if (optionalTask.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ResponseApi<>(HttpStatus.NOT_FOUND.value(), "The Task with this id is not found. ", null));

        Task taskExist = optionalTask.get();
        TaskDtoResponse taskDtoResponse = taskMapper.toDto(taskExist);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseApi<>(HttpStatus.OK.value(), "Task Have been retrieved successfully by id", taskDtoResponse));
    }

    @Override
    @PostMapping("")
    public ResponseEntity<ResponseApi<TaskDtoResponse>> storeTask(@RequestBody @Valid TaskDtoRequest taskDtoRequest) {
        Task task = taskService.storeTask(taskMapper.fromDto(taskDtoRequest));
        TaskDtoResponse taskDtoResponse = taskMapper.toDto(task);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseApi<>(HttpStatus.CREATED.value(), "Task Have been created successfully", taskDtoResponse));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ResponseApi<TaskDtoResponse>> updateTask(@PathVariable UUID id, @RequestBody @Valid TaskDtoRequest taskDtoRequest) {
        Optional<Task> optionalTask = taskService.getTaskById(id);
        if (optionalTask.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ResponseApi<>(HttpStatus.NOT_FOUND.value(), "The Task with this id is not found. ", null));

        Task task = taskService.updateTask(id, taskMapper.fromDto(taskDtoRequest));
        TaskDtoResponse taskDtoResponse = taskMapper.toDto(task);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseApi<>(HttpStatus.CREATED.value(), "Task Have been updated successfully", taskDtoResponse));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseApi<TaskDtoResponse>> deleteTaskById(@PathVariable UUID id) {
        Optional<Task> optionalTask = taskService.getTaskById(id);
        if (optionalTask.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ResponseApi<>(HttpStatus.NOT_FOUND.value(), "The Task with this id is not found. ", null));

        Task taskExist = optionalTask.get();
        TaskDtoResponse taskDtoResponse = taskMapper.toDto(taskExist);

        taskService.deleteTaskById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseApi<>(HttpStatus.OK.value(), "Task Have been deleted successfully by id", taskDtoResponse));
    }


}
