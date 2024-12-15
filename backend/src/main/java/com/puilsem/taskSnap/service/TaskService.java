package com.puilsem.taskSnap.service;

import com.puilsem.taskSnap.domain.entity.*;

import java.util.*;

public interface TaskService {

    public List<Task> getAllTasks();
    public Optional<Task> getTaskById(UUID id);
    public Task storeTask(Task task);
    public Task updateTask(UUID id, Task task);
    public void deleteTaskById(UUID id);

}
