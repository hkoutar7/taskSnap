package com.puilsem.taskSnap.controller;

import org.springframework.http.*;

import com.puilsem.taskSnap.domain.dto.*;
import com.puilsem.taskSnap.utils.*;

import java.util.*;

public interface TaskListController {

    public ResponseEntity<ResponseApi<List<TaskListDtoResponse>>> getAllTaskLists();
    public ResponseEntity<ResponseApi<TaskListDtoResponse>> getTaskListById(UUID id);
    public ResponseEntity<ResponseApi<TaskListDtoResponse>> storeTaskList(TaskListDtoRequest taskListDtoRequest);
    public ResponseEntity<ResponseApi<TaskListDtoResponse>> updateTaskList(UUID id, TaskListDtoRequest taskListDtoRequest);
    public ResponseEntity<ResponseApi<TaskListDtoResponse>> deleteTaskListById(UUID id);

}
