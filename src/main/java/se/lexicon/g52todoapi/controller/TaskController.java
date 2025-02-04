package se.lexicon.g52todoapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.g52todoapi.domain.dto.TaskDTOForm;
import se.lexicon.g52todoapi.domain.dto.TaskDTOView;
import se.lexicon.g52todoapi.domain.entity.Task;
import se.lexicon.g52todoapi.service.TaskService;
import se.lexicon.g52todoapi.service.impl.TaskServiceImpl;

@RequestMapping("/api/v1/task")
@RestController
public class TaskController {
    //Todo: Implement Controller

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping("/create") //ok, added person_id for join table in taskServiceImpl in order to get it working
    public ResponseEntity<TaskDTOView> createTask(@RequestBody TaskDTOForm taskDTOForm) {
        TaskDTOView taskDTOView = taskService.create(taskDTOForm);

        return new ResponseEntity<>(taskDTOView, HttpStatus.CREATED);
    }

    //@GetMapping("/{id}")
    @GetMapping()
    public ResponseEntity<TaskDTOView> getTask(@RequestParam Long id) {
        TaskDTOView taskDTOView = taskService.findById(id);
        //if (taskDTOView == null) {
          //  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //}

        return ResponseEntity.ok(taskDTOView);
    }

    /*
    TaskDTOView findById(Long taskId);

    void update(TaskDTOForm taskDTOForm);

    void delete(Long id);

    List<TaskDTOView> findTasksByPersonId(Long personId);

    List<TaskDTOView> findTasksBetweenStartAndEndDate(LocalDate start, LocalDate end);

    List<TaskDTOView> findAllUnassignedTodoItems();

    List<TaskDTOView> findAllUnfinishedAndOverdue();

    TaskDTOView addTaskToPerson(Long personId, TaskDTOForm taskDTOForm);
     */
}
