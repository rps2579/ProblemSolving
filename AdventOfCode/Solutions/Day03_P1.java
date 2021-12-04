package AdventOfCode.Solutions;

import java.util.Scanner;

public class Day03_P1 {
    private static int[] onesCount;
    private static int[] epsilon;
    private static int[] gamma;
    private static int totalInputs = 0;

    public static void main(String[] args) {
        takeInput();

        findGammaAndEpsilonBinaryNumbers();

        System.out.println("Answer: "+ convertToDecimal(gamma) * convertToDecimal(epsilon));
    }

    private static long convertToDecimal(int[] binaryNumArray) {
        long decimal = (long) 0;
        for (int i = binaryNumArray.length-1; i >= 0; i--) {
                int temp = binaryNumArray[i]; 
                decimal += (long) (temp*Math.pow(2, binaryNumArray.length-i-1));
        }  
        return decimal;
    }

    private static void findGammaAndEpsilonBinaryNumbers() {
        for (int i = 0; i < onesCount.length; i++) {
            int currMost = findMostFreqForCurrBit(onesCount[i]);
            gamma[i] = currMost;
            epsilon[i] = (currMost==1) ? 0:1;
        }
    }

    private static int findMostFreqForCurrBit(int currOneCount) {
        return (currOneCount < totalInputs/2) ? 0 : 1;
    }

    private static void takeInput() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();

            if (input.equalsIgnoreCase("exit"))
                break;

            totalInputs += 1;
            if (onesCount == null) {
                onesCount = new int[input.length()];
                gamma = new int[input.length()];
                epsilon = new int[input.length()];
            }

            for (int i = 0; i < input.length(); i++) {
                onesCount[i] += (input.charAt(i)=='1') ? 1 : 0;
            }
        }

        sc.close();
    }


}
