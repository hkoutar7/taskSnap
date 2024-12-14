package com.puilsem.taskSnap.mapper;

import com.puilsem.taskSnap.domain.dto.*;
import com.puilsem.taskSnap.domain.entity.*;

public interface TaskListMapper {

    TaskList fromDto(TaskListDtoRequest taskListDtoRequest);
    TaskListDtoResponse toDto(TaskList taskList);

}
