package AdventOfCode.Solutions;

import java.util.ArrayList;
import java.util.List;

public class Day3_P2 {

    private static List<String> inputBinaryValues;
    private static List<String> oxygenGeneratorValues = new ArrayList<>();
    private static List<String> co2ScrubberValues = new ArrayList<>();

    public static void main(String[] args) {
        inputBinaryValues = Utilities.getInputStrings();

        initOxygenAndCo2Lists();

        int maxIndex = inputBinaryValues.get(0).length() - 1;

        int index = 1;
        while (oxygenGeneratorValues.size() != 1) {
            applyOxygenGeneratorForCurrBit(index);

            index = (index < maxIndex) ? index + 1 : 0;
        }

        index = 1;
        while (co2ScrubberValues.size() != 1) {
            applyCo2ScrubberForCurrBit(index);

            index = (index < maxIndex) ? index + 1 : 0;
        }

        long oxygenDecimal = Utilities.convertToDecimal(oxygenGeneratorValues.get(0));
        long co2Decimal = Utilities.convertToDecimal(co2ScrubberValues.get(0));
        System.out.println("Oxygen: " + oxygenDecimal);
        System.out.println("CO2: " + co2Decimal);
        System.out.println("Answer: " + oxygenDecimal * co2Decimal);
    }

    private static void initOxygenAndCo2Lists() {
        List<String> onesList = new ArrayList<>();
        List<String> zeroesList = new ArrayList<>();

        splitToOnesListAndZeroesList(0, inputBinaryValues, onesList, zeroesList);

        if (onesList.size() >= zeroesList.size()) {
            oxygenGeneratorValues.addAll(onesList);
            co2ScrubberValues.addAll(zeroesList);
        } else {
            oxygenGeneratorValues.addAll(zeroesList);
            co2ScrubberValues.addAll(onesList);
        }
    }

    private static void applyOxygenGeneratorForCurrBit(int i) {

        List<String> onesList = new ArrayList<>();
        List<String> zeroesList = new ArrayList<>();

        splitToOnesListAndZeroesList(i, oxygenGeneratorValues, onesList, zeroesList);

        oxygenGeneratorValues.clear();
        if (onesList.size() >= zeroesList.size())
            oxygenGeneratorValues.addAll(onesList);
        else
            oxygenGeneratorValues.addAll(zeroesList);
    }

    private static void applyCo2ScrubberForCurrBit(int i) {

        List<String> onesList = new ArrayList<>();
        List<String> zeroesList = new ArrayList<>();

        splitToOnesListAndZeroesList(i, co2ScrubberValues, onesList, zeroesList);

        co2ScrubberValues.clear();
        if (onesList.size() < zeroesList.size())
            co2ScrubberValues.addAll(onesList);
        else
            co2ScrubberValues.addAll(zeroesList);
    }

    private static void splitToOnesListAndZeroesList(int i, List<String> inputList, List<String> onesList,
            List<String> zeroesList) {
        for (String currValue : inputList) {
            if (currValue.charAt(i) == '1')
                onesList.add(currValue);
            else
                zeroesList.add(currValue);
        }
    }
}
