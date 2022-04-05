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

  @Test
  void testNewLineDelimiter() {
    String testString = "1\n2,3";

    var result = calculator.add(testString);

    assertThat(result).isEqualTo(6);
  }

  @Test
  void testCustomDelimiter() {
    String testString = "\\\\;\n1;2\n3,4";

    var result = calculator.add(testString);

    assertThat(result).isEqualTo(10);
  }

  @Test
  void testNanInput() {
    String testString = "1,a,2";

    assertThatThrownBy(() -> calculator.add(testString))
        .isInstanceOf(NumberFormatException.class);
  }

  @Test
  void testSingleLongDelimiter() {
    String testString = "\\\\[***]\n1,2***3\n4";

    var result = calculator.add(testString);

    assertThat(result).isEqualTo(10);
  }

  @Test
  void testMultipleLongDelimiter() {
    String testString = "\\\\[***][%]\n1,2%3\n4***5,6";

    var result = calculator.add(testString);

    assertThat(result).isEqualTo(21);
  }
}