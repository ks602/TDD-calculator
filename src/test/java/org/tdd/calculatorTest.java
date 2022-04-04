package org.tdd;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

  Calculator calculator = new Calculator();

  @Test
  void testAddTwoNumbers() {
    String testString = "1,2";

    var result = calculator.add(testString);

    assertThat(result).isEqualTo(3);
  }

  @Test
  void testAddMultipleNumbers() {
    String testString = "1,2,3,4,5,6,7";

    var result = calculator.add(testString);

    assertThat(result).isEqualTo(28);
  }

  @Test
  void testAddNegativeNumbers() {
    String testString = "-5,5";

    var result = calculator.add(testString);

    assertThat(result).isEqualTo(0);
  }
}