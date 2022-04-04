package org.tdd;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

  Calculator calculator = new Calculator();

  @org.junit.jupiter.api.Test
  void testAddTwoNumbers() {
    String testString = "1,2";

    var result = calculator.add(testString);

    assertThat(result).isEqualTo(3);
  }
}