package com.puilsem.taskSnap.mapper;

import com.puilsem.taskSnap.domain.dto.*;
import com.puilsem.taskSnap.domain.entity.*;

public interface ITaskMapper {
    public TaskDto toDto(Task task);
    public Task fromDto(TaskDto taskDto);

}
