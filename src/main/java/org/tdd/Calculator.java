package org.tdd;

import java.util.Arrays;

public class Calculator {
  public int add(String testString) {
    String[] inputs = testString.split("[,\n]");
    return Arrays.stream(inputs)
        .map(Integer::parseInt)
        .reduce(0, Integer::sum);
  }
}
