package AdventOfCode.Solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Utilities {

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    static List<String> getInputStrings() {
        List<String> inputList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String inputString = sc.next();

            if (inputString.trim().equalsIgnoreCase("exit"))
                break;

            inputList.add(inputString);
        }
        sc.close();
        return inputList;
    }

    static long convertToDecimal(String binaryNumArray) {
        long decimal = (long) 0;
        for (int i = binaryNumArray.length() - 1; i >= 0; i--) {
            int temp = binaryNumArray.charAt(i)=='1' ? 1 : 0;
            decimal += (long) (temp * Math.pow(2, binaryNumArray.length() - i - 1));
        }
        return decimal;
    }
    
}
