package com.puilsem.taskSnap.mapper;

import com.puilsem.taskSnap.domain.entity.*;
import com.puilsem.taskSnap.domain.dto.*;

public interface TaskMapper {

    Task fromDto(TaskDtoRequest taskDtoRequest);
    TaskDtoResponse toDto(Task task);

}
