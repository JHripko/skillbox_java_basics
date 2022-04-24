package main;

import response.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private static int currentId = 1;
    private static HashMap<Integer, Task> tasks = new HashMap<>();

    public static List<Task> getAllTasks() {
        ArrayList<Task> taskList = new ArrayList<>();
        taskList.addAll(tasks.values());
        return taskList;
    }

    public static int addTask(Task task) {
        int id = currentId++;
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    public static Task getTask(int id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id);
        }

        return null;
    }
}
