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
        return optionalTask.map(task -> new ResponseEntity(task, HttpStatus.OK)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    //удалить задачу
    @DeleteMapping("/tasks/{id}")
    public HttpStatus delete(@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            return HttpStatus.NOT_FOUND;
        }
        taskRepository.delete(optionalTask.get());
        return HttpStatus.OK;
    }

    //удалить все задачи
    @DeleteMapping("/tasks/")
    public HttpStatus deleteAll() {
        taskRepository.deleteAll();
        return HttpStatus.OK;
    }

    //редактировать статус задачи
    @PutMapping("/tasks/{id}")
    public ResponseEntity editStatus(@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Task task = optionalTask.get();
        task.setDone(true);
        taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    //редактировать задачу
    @PutMapping("/tasks/")
    public ResponseEntity editTask(Task newTask) {
        Optional<Task> optionalTask = taskRepository.findById(newTask.getId());
        if (optionalTask.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        taskRepository.save(newTask);
        return ResponseEntity.status(HttpStatus.OK).body(newTask);
    }
}
