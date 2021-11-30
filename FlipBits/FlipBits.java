package FlipBits;

import java.util.*;

public class FlipBits {

    static int n;
    static int[] arr;

    static int consecutive_ones_count = 0;
    static int consecutive_zeros_count = 0;
    static boolean isPreviousElement1 = false;

    static List<Integer> zeros_count = new ArrayList<>();
    static List<Integer> ones_count = new ArrayList<>();
    public static void main(String[] args) {

        // getInput();
        initTestInput();

        initConsecCountLists();

        calculateMaxOneBitsPossible();
        
        printOutput();
    }

    private static void calculateMaxOneBitsPossible() {
    }

    private static void printOutput() {
        System.out.print("\nOnes:\t");
        printList(ones_count);
        System.out.print("\nZeroes:\t");
        printList(zeros_count);
        System.out.println();
    }

    private static void initConsecCountLists() {
        if (arr[0] == 1) {
            consecutive_ones_count += 1;
            isPreviousElement1 = true;
        } else
            consecutive_zeros_count += 1;

        for (int i = 1; i < n; i++) {
            performCheckForBit(arr[i]);
        }

        zeros_count.add(consecutive_zeros_count);
        ones_count.add(consecutive_ones_count);
    }

    private static void initTestInput() {
        n = 8;
        arr = new int[]{ 1,0,0,1,0,0,0,1};
    }

    private static void getInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();
    }

    private static void performCheckForBit(int num) {
        if (num == 1) {
            if (isPreviousElement1) {
                consecutive_ones_count += 1;
            } else {
                isPreviousElement1 = true;

                zeros_count.add(consecutive_zeros_count);
                ones_count.add(0);

                consecutive_ones_count += 1;
                consecutive_zeros_count = 0;
            }
        } else {
            if (isPreviousElement1) {
                isPreviousElement1 = false;

                zeros_count.add(0);
                ones_count.add(consecutive_ones_count);

                consecutive_ones_count = 0;
                consecutive_zeros_count += 1;
            } else {
                consecutive_zeros_count += 1;
            }
        }
    }

    private static void printList(List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + ", ");
        }
    }
}
