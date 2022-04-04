package org.tdd;

import java.util.Arrays;

public class Calculator {
  public int add(String numbersString) {
    String[] numbers;
    if (numbersString.startsWith("\\\\")) {
      char delimiter = numbersString.charAt(2);
      numbersString = numbersString.split("\n",2)[1];
      numbers = numbersString.split(String.format("[,\n%c]", delimiter));
    } else
      numbers = numbersString.split("[,\n]");
    return Arrays.stream(numbers)
        .map(Integer::parseInt)
        .reduce(0, Integer::sum);
  }
}
