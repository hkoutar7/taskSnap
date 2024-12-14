package com.puilsem.taskSnap.service.impl;

import org.springframework.stereotype.*;

import com.puilsem.taskSnap.domain.entity.*;
import com.puilsem.taskSnap.repository.*;
import com.puilsem.taskSnap.service.*;

import java.util.*;

@Service
public class TaskServiceImpl implements TaskService {

    private final ITaskRepository iTaskRepository;

    public TaskServiceImpl(ITaskRepository iTaskRepository) {
        this.iTaskRepository = iTaskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return iTaskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(UUID id) {
        return iTaskRepository.findById(id);
    }

    @Override
    public Task storeTask(Task task) {
        return iTaskRepository.save(task);
    }

    @Override
    public Task updateTask(UUID id, Task task) {
        task.setId(id);
        return iTaskRepository.save(task);
    }

    @Override
    public void deleteTaskById(UUID id) {
        iTaskRepository.deleteById(id);
    }


}
