package com.puilsem.taskSnap.mapper;

import com.puilsem.taskSnap.domain.entity.*;
import com.puilsem.taskSnap.domain.dto.*;

public interface ITaskListMapper {
    TaskListDto toDto(TaskList taskList);
    TaskList fromDto(TaskListDto taskListDto);
}
