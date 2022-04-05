package org.tdd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Calculator {
  public int add(String numbersString) {
    String[] numbers;
    if (numbersString.startsWith("\\\\")) {
      numbersString = numbersString.substring(2);
      // split the input into 2 segments, by the first new line character
      var segments = numbersString.split("\n",2);
      var delimiterList = Arrays.stream(segments[0].split("]"))
          .map(d -> d.charAt(0)=='[' ? d.substring(1) : d)
          .filter(d -> d.length() > 0)
          .sorted(Comparator.comparingInt(String::length))
          .collect(Collectors.toList());
      var delimiterString = delimiterList.stream().reduce("[,\n]", (all, d) -> "\\Q" + d + "\\E|" + all);

      numbersString = segments[1];
      numbers = numbersString.split(delimiterString);
    } else
      numbers = numbersString.split("[,\n]");
    return Arrays.stream(numbers)
        .map(Integer::parseInt)
        .reduce(0, Integer::sum);
  }
}
