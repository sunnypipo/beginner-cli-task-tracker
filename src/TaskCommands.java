package src;
import java.util.ArrayList;
import java.time.LocalDate;

public class TaskCommands {
    private ArrayList<Task> tasks = new ArrayList<>();
    Storage st = new Storage();
    private int currentId;
    private LocalDate date = LocalDate.now();// date for the current day

    private void outputConstrutor(int x) {
        System.out.println("id:" + tasks.get(x).getId() + " task:" + tasks.get(x).getDescription() + " status:"
                + tasks.get(x).getStatus() + " created:" + tasks.get(x).getCreatedAt() + " update:"
                + tasks.get(x).getUpdatedAt());
    }

    public TaskCommands() {
        tasks = st.loadTask();
        currentId = tasks.size() > 0 ? tasks.get(tasks.size() - 1).getId() + 1 : 1;
    }

    // the number of tasks
    public int getSizeOfTasks() {
        return tasks.size();
    }

    // functions
    public void addTask(String description) {
        tasks.add(new Task(currentId++, description));
        st.saveTask(tasks);
    }

    public void updateTask(int taskId, String description) {
        tasks.get(taskId - 1).setDescription(description);
        tasks.get(taskId - 1).setUpdatedAt(date.toString());
        st.saveTask(tasks);
    }

    public void deleteTask(int taskId) {
        tasks.remove(taskId - 1);
        st.saveTask(tasks);
    }

    // marks the status
    public void markDone(int taskId) {
        tasks.get(taskId - 1).setStatusDone();
        st.saveTask(tasks);
    }

    public void markToDo(int taskId) {
        tasks.get(taskId - 1).setStatusToDo();
        st.saveTask(tasks);
    }

    public void markInProgress(int taskId) {
        tasks.get(taskId - 1).setStatusInProgress();
        st.saveTask(tasks);
    }

    // task status filter
    public void filter(String stat) {
        for (int i = 0; i < tasks.size(); i++) {
            String status = tasks.get(i).getStatus();
            if (status.equals(stat)) {
                outputConstrutor(i);
            }
        }
    }

    // prints the filtered task
    public void listDone() {
        filter("done");
    }

    public void listToDo() {
        filter("to do");
    }

    public void listInProgress() {
        filter("in progress");
    }

    public void listAll() {
        for (int i = 0; i < tasks.size(); i++) {
            outputConstrutor(i);
        }
    }
}