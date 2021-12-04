package AdventOfCode.Solutions;

import java.util.Scanner;

public class Day01_P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalDips = 0;

        int currNum;
        String inputString = sc.next();
        currNum = Integer.parseInt(inputString);

        int prev3Sum = currNum;

        inputString = sc.next();
        currNum = Integer.parseInt(inputString);

        prev3Sum += currNum;
        int prev2Sum = currNum;

        inputString = sc.next();
        currNum = Integer.parseInt(inputString);

        prev3Sum += currNum;
        prev2Sum += currNum;
        int prevElement = currNum;
        
        while(sc.hasNext()) {
            inputString = sc.next();
            if (inputString.trim().equals("exit"))
                break;

            currNum = Integer.parseInt(inputString);

            if (prev3Sum < prev2Sum+currNum)
                totalDips++;

            prev3Sum = prev2Sum + currNum;
            prev2Sum = prevElement + currNum;
            prevElement = currNum;
        }

        System.out.println("Answer: " + totalDips);
        sc.close();
    }
}
