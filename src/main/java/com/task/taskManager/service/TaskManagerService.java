package com.task.taskManager.service;


import com.task.taskManager.models.task.Task;
import com.task.taskManager.models.task.TaskDTO;
import com.task.taskManager.models.user.ApplicationUser;
import com.task.taskManager.repository.TaskRepository;
import com.task.taskManager.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskManagerService {


    private final TaskRepository taskRepository;

    public final UserRepository userRepository;

    public TaskManagerService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }


    public TaskDTO createTask(TaskDTO taskDTO){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        Optional<ApplicationUser> userOP = userRepository.findByUserName(userName);
        Task task = new Task();
        task.setTaskId(0);
        task.setTaskName(taskDTO.getTaskName());
        task.setTaskDescription(taskDTO.getTaskDescription());
        task.setTaskDate(taskDTO.getTaskDate());
        task.setTaskEndDate(taskDTO.getTaskEndDate());
        task.setTaskStatus(taskDTO.getTaskStatus());
        task.setUser(userOP.get());

         taskRepository.save(task);
         return  taskDTO;
    }

     public List<Task> getAllTask(String offset, String limit){


        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

         Optional<ApplicationUser> userOP = userRepository.findByUserName(userName);

         if(!userOP.isPresent()){
             throw new IllegalArgumentException("user with "+userName+" not found");
         }
        return taskRepository.findByUser(userOP.get());

//
//         int intLimit = 10;
//         int intOffset = 1;
//        if(limit != null && offset != null) {
//             intLimit = Integer.valueOf(limit);
//            intOffset = Integer.valueOf(offset);
//
//            if (intLimit == 0) {
//                intLimit = 10;
//            }
//        }
//
//         Pageable pageable = PageRequest.of(intOffset,intLimit);
//        List<Task> tasks  = taskRepository.findAll();
//        return tasks;
     }


     public Task updateTask(Task task){

         Optional<Task> taskOP = taskRepository.findById(task.getTaskId());
         if(!taskOP.isPresent()){
            throw new IllegalArgumentException("Task with given Id not found");
         }
         System.out.println("we are here");
         Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
         String userName = authentication.getName();
         System.out.println("authenticated user Name : "+userName);
         if(!taskOP.get().getUser().getUsername().equals(userName)){
             System.out.println("You are trying to update wrong task which does not belongs to you");
             throw new RuntimeException("This task does not belongs to you please update tasks which belongs to you");
         }
         Task task1 = taskOP.get();
         task1.setTaskStatus(task.getTaskStatus());
         task1.setTaskDescription(task.getTaskDescription());
         task1.setTaskName(task.getTaskName());

         taskRepository.save(task1);

        return task1;
     }

     public void deleteTask(int taskId){
         Optional<Task> taskOP = taskRepository.findById(taskId);
         if(!taskOP.isPresent()){
             throw new IllegalArgumentException("Task with given Id not found");
         }
         System.out.println("we are here");
         Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
         String userName = authentication.getName();
         if(!taskOP.get().getUser().getUsername().equals(userName)){
             System.out.println("You are trying to update wrong task which does not belongs to you");
             throw new RuntimeException("This task does not belongs to you please update tasks which belongs to you");
         }
          taskRepository.deleteById(taskId);
     }

}
