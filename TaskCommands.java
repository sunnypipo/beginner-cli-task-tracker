import java.util.ArrayList;
import java.time.LocalDate;

public class TaskCommands{
    private ArrayList<Task> tasks =  new ArrayList<>();
    private LocalDate date = LocalDate.now();//date for the current day
    private void outputConstrutor(int x){
        System.out.println("task:" + tasks.get(x).getDescription() + " status:" + tasks.get(x).getStatus() + " created:" + tasks.get(x).getCreatedAt() + " update:" + tasks.get(x).getUpdatedAt());
    }

    //the number of tasks
    public int getSizeOfTasks(){
        return tasks.size();
    }
    // functions
    public void addTask(String description){
        tasks.add(new Task(description));
    }

    public void updateTask(int taskId,String description){
        tasks.get(taskId-1).setDescription(description);
        tasks.get(taskId-1).setUpdatedAt(date.toString());
    }

    public void deleteTask(int taskId){
        tasks.remove(taskId-1);
    }

    //marks the status
    public void markDone(int taskId){
        tasks.get(taskId-1).setStatusDone();
    }

    public void markToDo(int taskId){
        tasks.get(taskId-1).setStatusToDo();
    }

    public void markInProgress(int taskId){
        tasks.get(taskId-1).setStatusInProgress();
    }

    //task status filter
    public void filter(String stat){
        for(int i = 0; i<tasks.size(); i++){
            String status = tasks.get(i).getStatus();
            if(status == stat){
                outputConstrutor(i);
            }
        }
    }

    //prints the filtered task
    public void listDone(){
        filter("done");
    }

    public void listToDo(){
        filter("to do");
    }

    public void listInProgress(){
        filter("in progress");
    }
 
    public void listAll(){
        for(int i = 0; i<tasks.size(); i++){
            outputConstrutor(i);
        }
    }
}