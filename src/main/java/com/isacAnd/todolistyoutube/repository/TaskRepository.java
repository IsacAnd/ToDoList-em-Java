package com.isacAnd.todolistyoutube.repository;

import com.isacAnd.todolistyoutube.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
