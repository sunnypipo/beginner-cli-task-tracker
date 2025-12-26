public class jsonhelper {
    public int number(String input){
        return Integer.parseInt(input.split(":")[1].replace(",", "").trim());
    }

    public String text(String input){
        return input.split(":")[1].replace("\"", "").replace(",", "").trim();
    }
}
