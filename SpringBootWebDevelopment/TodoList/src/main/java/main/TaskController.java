package main;

import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    //получить список задач
    @GetMapping("/tasks/")
    public List<Task> list() {
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            tasks.add(task);
        }
        return tasks;
    }

    //добавить задачу
    @PostMapping("/tasks/")
    public int add(Task task) {
        Task newTask = taskRepository.save(task);
        return newTask.getId();
    }

    //получить задачу по id
    @GetMapping("/tasks/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalTask.get(), HttpStatus.OK);
    }

    //удалить задачу
    @DeleteMapping("/tasks/{id}")
    public HttpStatus delete(@PathVariable int id) {
        if (Storage.getTask(id) == null) {
            return HttpStatus.NOT_FOUND;
        }
        Storage.deleteTask(id);
        return HttpStatus.OK;
    }

    //удалить все задачи
    @DeleteMapping("/tasks/")
    public List<Task> deleteAll() {
        return Storage.deleteAllTasks();
    }

    //редактировать статус задачи
    @PutMapping("/tasks/{id}")
    public Task editStatus(@PathVariable int id) {
        return Storage.editTaskStatus(id);
    }

    //редактировать задачу
    @PutMapping("/tasks/")
    public Task editTask(Task newTask) {
        return Storage.editTask(newTask);
    }
}
