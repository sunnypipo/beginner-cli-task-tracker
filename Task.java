import java.time.LocalDate;

public class Task {
   private int id;
   private String description;
   private String status;
   private String createdAt;
   private String updatedAt;
   private LocalDate date = LocalDate.now();

   public Task(int id, String description){
    this.id = id;
    this.description = description;
    this.status = "to do";
    this.createdAt = date.toString();
   }
   
   // get properties
   public int getId(){
    return id;
   }
   public String getDescription(){
    return description;
   }

   public String getStatus(){
    return status;
   }

   public String getCreatedAt(){
    return createdAt;
   }

   public String getUpdatedAt(){
    return updatedAt;
   }

   // set properties
   public void setDescription(String description){
    this.description = description;
   }

   public void setUpdatedAt(String dt){
    this.updatedAt = dt;
   }

   // set status
   public void setStatusDone(){
    this.status = "done";
   }

   public void setStatusToDo(){
    this.status = "to do";
   }

   public void setStatusInProgress(){
    this.status = "in progress";
   }
}
