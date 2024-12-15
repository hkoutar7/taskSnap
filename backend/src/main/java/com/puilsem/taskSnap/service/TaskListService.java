package com.puilsem.taskSnap.service;

import com.puilsem.taskSnap.domain.entity.*;

import java.util.*;

public interface TaskListService {

    public List<TaskList> getAllTaskLists();
    public Optional<TaskList> getTaskListById(UUID id);
    public TaskList storeTaskList(TaskList taskList);
    public TaskList updateTaskList(TaskList taskListExist, TaskList taskList);
    public void deleteTaskListById(UUID id);

}
