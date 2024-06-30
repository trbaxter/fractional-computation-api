package com.trbaxter.github.fractionalcomputationapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** TermTest tests the creation and behavior of Term instances. */
public class TermTest {

  /**
   * Provides valid Term instances for parameterized tests.
   *
   * @return a stream of valid Term arguments.
   */
  private static Stream<Arguments> provideValidTerms() {
    return Stream.of(
        Arguments.of(new BigDecimal("3.5"), new BigDecimal("2.0")),
        Arguments.of(new BigDecimal("0.0"), new BigDecimal("0.0")),
        Arguments.of(new BigDecimal("-1.5"), new BigDecimal("3.0")));
  }

  /**
   * Tests the creation of Term instances with valid inputs.
   *
   * @param coefficient the coefficient of the term.
   * @param power the power of the term.
   */
  @ParameterizedTest
  @MethodSource("provideValidTerms")
  public void testTermRecord(BigDecimal coefficient, BigDecimal power) {
    Term term = new Term(coefficient, power);
    assertEquals(coefficient, term.coefficient());
    assertEquals(power, term.power());
  }

  /** Tests the creation of Term instances with null values. */
  @Test
  public void testTermRecordNullValues() {
    assertThrows(NullPointerException.class, () -> new Term(null, new BigDecimal("2.0")));
    assertThrows(NullPointerException.class, () -> new Term(new BigDecimal("3.5"), null));
  }
}