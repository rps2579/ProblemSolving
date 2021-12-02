package AdventOfCode.Solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2_P1 {

    static List<String> inputCommands;
    private static int horizontalCoordinate = 0;
    private static int verticalCoordinate = 0;
    public static void main(String[] args) {
        getInput();

        executeCommands();

        System.out.println("Answer: " + horizontalCoordinate*verticalCoordinate);
    }

    private static void executeCommands() {
        for (String command : inputCommands) {
            executeCommand(command);
        }
    }

    private static void executeCommand(String command) {
        String[] splits = command.split(" ");

        if (splits[0].equalsIgnoreCase("forward"))
            horizontalCoordinate += Integer.parseInt(splits[1]);
        else if (splits[0].equalsIgnoreCase("down"))
            verticalCoordinate += Integer.parseInt(splits[1]);
        else if (splits[0].equalsIgnoreCase("up"))
            verticalCoordinate -= Integer.parseInt(splits[1]);
    }

    private static void getInput() {
        Scanner sc = new Scanner(System.in);

        inputCommands = new ArrayList<>();
        String inputString;

        while (sc.hasNext()) {
            inputString = sc.nextLine();
            
            if (inputString.trim().equals("exit")) 
                break;

            inputCommands.add(inputString.trim());
        }

        sc.close();
    }
}
