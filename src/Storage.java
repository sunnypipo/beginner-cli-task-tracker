package src;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Storage {
    public void saveTask(ArrayList<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("storage.json"))) {
            writer.write("[\n");

            for (int i = 0; i < tasks.size(); i++) {
                Task t = tasks.get(i);
                writer.write("    {\n");
                writer.write("        \"id\": " + t.getId() + ",\n");
                writer.write("        \"description\": \"" + t.getDescription() + "\",\n");
                writer.write("        \"status\": \"" + t.getStatus() + "\",\n");
                writer.write("        \"createdAt\": \"" + t.getCreatedAt() + "\",\n");
                writer.write("        \"updatedAt\": \"" + t.getUpdatedAt() + "\"\n");
                writer.write("    }");
                if (i < tasks.size() - 1)
                    writer.write(",");
                writer.write("\n");
            }
            writer.write("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Task> loadTask() {
        ArrayList<Task> tasks = new ArrayList<>();
        jsonhelper jh = new jsonhelper();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("storage.json"));
            String line;
            Integer id = null;
            String description = "";
            String status = "";
            String createdAt = "";
            String updatedAt = "";

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("\"id\"")) {
                    id = jh.number(line);
                } else if (line.startsWith("\"description\"")) {
                    description = jh.text(line);
                } else if (line.startsWith("\"status\"")) {
                    status = jh.text(line);
                } else if (line.startsWith("\"createdAt\"")) {
                    createdAt = jh.text(line);
                } else if (line.startsWith("\"updatedAt\"")) {
                    updatedAt = jh.text(line);
                }

                if (!description.isEmpty() && !status.isEmpty() && !createdAt.isEmpty()) {
                    Task t = new Task(id, description);
                    if (status.equals("done"))
                        t.setStatusDone();
                    else if (status.equals("to do"))
                        t.setStatusToDo();
                    else if (status.equals("in progress"))
                        t.setStatusInProgress();
                    tasks.add(t);

                    description = "";
                    status = "";
                    createdAt = "";
                    updatedAt = "";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }

}
