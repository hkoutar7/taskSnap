package com.puilsem.taskSnap.controller;

import org.springframework.http.*;

import com.puilsem.taskSnap.domain.dto.*;
import com.puilsem.taskSnap.utils.*;

import java.util.*;

public interface TaskController {

    public ResponseEntity<ResponseApi<List<TaskDtoResponse>>> getAllTasks();
    public ResponseEntity<ResponseApi<TaskDtoResponse>> getTaskById(UUID id);
    public ResponseEntity<ResponseApi<TaskDtoResponse>> storeTask(TaskDtoRequest taskDtoRequest);
    public ResponseEntity<ResponseApi<TaskDtoResponse>> updateTask(UUID id, TaskDtoRequest taskDtoRequest);
    public ResponseEntity<ResponseApi<TaskDtoResponse>> deleteTaskById(UUID id);
}
