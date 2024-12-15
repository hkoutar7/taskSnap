package com.puilsem.taskSnap.service.impl;

import org.springframework.stereotype.*;

import com.puilsem.taskSnap.domain.entity.*;
import com.puilsem.taskSnap.service.*;
import com.puilsem.taskSnap.repository.*;

import java.util.*;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final ITaskListRepository iTaskListRepository;

    public TaskListServiceImpl(ITaskListRepository iTaskListRepository) {
        this.iTaskListRepository = iTaskListRepository;
    }

    @Override
    public List<TaskList> getAllTaskLists() {
        return iTaskListRepository.findAll();
    }

    @Override
    public Optional<TaskList> getTaskListById(UUID id) {
        return iTaskListRepository.findById(id);
    }

    @Override
    public TaskList storeTaskList(TaskList taskList) {
        return iTaskListRepository.save(taskList);
    }

    @Override
    public TaskList updateTaskList(TaskList taskListExist, TaskList taskList) {
        taskListExist.setTitle(taskList.getTitle());
        taskListExist.setDescription(taskList.getDescription());
        iTaskListRepository.save(taskListExist);

        return taskListExist;
    }

    @Override
    public void deleteTaskListById(UUID id) {
        iTaskListRepository.deleteById(id);
    }

}
