package AdventOfCode.Solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2_P2 {

    static List<String> inputCommands;
    private static int horizontalCoordinate = 0;
    private static int verticalCoordinate = 0;
    private static int aim = 0;
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

        if (splits[0].equalsIgnoreCase("forward")) {
            int currNum = Integer.parseInt(splits[1]);

            horizontalCoordinate += currNum;
            verticalCoordinate += aim*currNum;
        }
        else if (splits[0].equalsIgnoreCase("down"))
            aim += Integer.parseInt(splits[1]);
        else if (splits[0].equalsIgnoreCase("up"))
            aim -= Integer.parseInt(splits[1]);
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
