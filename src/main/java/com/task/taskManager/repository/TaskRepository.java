package com.task.taskManager.repository;

import com.task.taskManager.models.task.Task;
import com.task.taskManager.models.user.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {

    List<Task> findByUser(ApplicationUser user);


}
