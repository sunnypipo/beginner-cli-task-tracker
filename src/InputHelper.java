package src;
import java.util.Scanner;

public class InputHelper {
    static Scanner inp = new Scanner(System.in);

    //user input helper
    public static String readString(String msg){
        System.out.print(msg);
        return inp.nextLine();
    }
    //valid command detector
    public static boolean validCommand(String input, String command){
        return input.equals(command) || input.startsWith(command + " ");       
    }

    //check for valid number for selcting the tasknumber and prints some error message
    public static int numDetect(TaskCommands tc ,String input){
        while(true){
            try{
                String[] chop = input.split(" ",3);
                if(chop.length<2){
                    System.out.println("include a tasknumber");
                    return - 1;
                }
                int number = Integer.parseInt(chop[1]);
                if(number <= tc.getSizeOfTasks() && number>=1){
                    return number;
                }
                else{
                    System.out.println("number must be 1 to " + tc.getSizeOfTasks());
                    return -1;
                }
            }
            catch (NumberFormatException e){
                System.out.println("please enter valid tasknumber");
                return -1;
            }
            
        }
    }
    //split description for every spaces from user input for updatetask
    public static String updateDescriptionSplit(String input){
        String[] chop = input.split(" ",3);
        String description;
        if(chop.length>=3){
            description = chop[2];
        }
        else{
            description = "";
        }
        return description;
    }

    //error for update when tasknumber invalid
    public static boolean updateTaskNumberError(int input){
        if(input == -1){
            return true;
        }
        return false;
    }

    //split description for every spaces from user input for addtask
    public static String addDescriptionSplit(String input){
        String[] chop = input.split(" ", 2);
        return chop[1];
    }

    //erro for add when task description is not provided
    public static boolean addDescriptionError(String input){
        String[] chop = input.split(" ", 2);
        if(chop.length < 2){
            System.out.println("provide task description");
            return true;
        }
        return false;
    }
}
