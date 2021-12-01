package AdventOfCode.Solutions;

import java.util.Scanner;

public class Day1_P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int prevNum = sc.nextInt();
        int totalDips = 0;

        while(sc.hasNext()) {
            String input = sc.next();
            if (input.trim().equals("exit"))
                break;

            int currNum = Integer.parseInt(input);

            if (prevNum < currNum) 
                totalDips++;

            prevNum = currNum;
        }

        System.out.println("Answer: " + totalDips);
        sc.close();
    }
}
