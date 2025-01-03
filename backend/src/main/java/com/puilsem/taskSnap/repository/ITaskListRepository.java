package com.puilsem.taskSnap.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import com.puilsem.taskSnap.domain.entity.*;

import java.util.*;

@Repository
public interface ITaskListRepository extends JpaRepository<TaskList, UUID> {
}
