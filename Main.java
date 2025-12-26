
public class Main {
    public static void main(String[] args) {
        boolean running = true;
        TaskCommands tc = new TaskCommands();
        while(running){
            String input = InputHelper.readString("").trim();

            if(InputHelper.validCommand(input, "add")){
                if(InputHelper.addDescriptionError(input)) continue;
                tc.addTask(InputHelper.addDescriptionSplit(input));
                System.out.println("task added");
            }

            if(InputHelper.validCommand(input, "update")){
                if(InputHelper.updateTaskNumberError(InputHelper.numDetect(tc,input)))continue;
                tc.updateTask(InputHelper.numDetect(tc,input), InputHelper.updateDescriptionSplit(input));
                System.out.println("changes saved");
            }

            if(InputHelper.validCommand(input, "delete")){
                tc.deleteTask(InputHelper.numDetect(tc,input));
                System.out.println("task Removed");
            }

            if(InputHelper.validCommand(input, "mark-in-progress")){
                tc.markInProgress(InputHelper.numDetect(tc,input));
                System.out.println("changes saved");
            }

            if(InputHelper.validCommand(input, "mark-done")){
                tc.markDone(InputHelper.numDetect(tc,input));
                System.out.println("changes saved");
            }

            if(InputHelper.validCommand(input, "mark-to-do")){
                tc.markToDo(InputHelper.numDetect(tc,input));
                System.out.println("changes saved");
            }

            if(input.equals("list")){
                tc.listAll();
            }

            if(InputHelper.validCommand(input, "list done")){
                tc.listDone();
            }

            if(InputHelper.validCommand(input, "list to-do")){
                tc.listToDo();
            }

            if(InputHelper.validCommand(input, "list in-progress")){
                tc.listInProgress();
            }

            if(InputHelper.validCommand(input, "exit")){
                break;
            }
        }
    }
}
