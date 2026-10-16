public class ConsoleColors {
    public static final String reset = "\u001B[0m";//resets terminal color to normal
    //foreground colors
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    public static String color (String input, String color) {
        return color + input + reset;
    }

}
