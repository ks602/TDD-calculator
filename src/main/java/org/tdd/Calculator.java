package org.tdd;

public class Calculator {
  public int add(String testString) {
    String[] inputs = testString.split(",");
    return Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1]);
  }
}
