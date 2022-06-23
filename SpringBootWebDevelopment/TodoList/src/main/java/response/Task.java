package response;

public class Task {
    private int id;                     //id задачи
    private String taskName;            //название задачи
    private boolean isDone = false;     //состояние задачи (выполнено/не выполнено)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean getDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
