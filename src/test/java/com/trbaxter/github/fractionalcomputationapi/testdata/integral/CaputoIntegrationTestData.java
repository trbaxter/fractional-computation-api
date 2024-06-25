package com.trbaxter.github.fractionalcomputationapi.testdata.integral;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

/**
 * CaputoIntegrationTestData provides a collection of test data for testing the Caputo integral
 * computations.<br>
 * It includes various combinations of polynomial coefficients and fractional orders.
 */
public final class CaputoIntegrationTestData {

  /** Private constructor to prevent instantiation. */
  private CaputoIntegrationTestData() {
    throw new UnsupportedOperationException("Utility class for test data");
  }

  /**
   * Provides a stream of arguments representing different combinations of polynomial coefficients
   * and fractional orders for testing Caputo integral computations.
   *
   * @return a stream of arguments for parameterized tests.
   */
  public static Stream<Arguments> coefficientCombinations() {
    return Stream.of(

        // Expression: 1
        Arguments.of("1", 0.0, "1"),
        Arguments.of("1", 0.1, "1.051x^0.1 + C"),
        Arguments.of("1", 0.2, "1.089x^0.2 + C"),
        Arguments.of("1", 0.3, "1.114x^0.3 + C"),
        Arguments.of("1", 0.4, "1.127x^0.4 + C"),
        Arguments.of("1", 0.5, "1.128x^0.5 + C"),
        Arguments.of("1", 0.6, "1.119x^0.6 + C"),
        Arguments.of("1", 0.7, "1.101x^0.7 + C"),
        Arguments.of("1", 0.8, "1.074x^0.8 + C"),
        Arguments.of("1", 0.9, "1.040x^0.9 + C"),
        Arguments.of("1", 1.0, "x + C"),
        Arguments.of("1", 1.5, "0.752x^1.5 + C"),
        Arguments.of("1", 2.0, "0.500x^2 + Cx + D"),
        Arguments.of("1", 3.0, "0.167x^3 + 0.5Cx^2 + Dx + E"),
        Arguments.of("1", 5.0, "0.008x^5 + 0.042Cx^4 + 0.167Dx^3 + 0.5Ex^2 + Fx + G"),

        // Expression: -1
        Arguments.of("-1", 0.0, "-1"),
        Arguments.of("-1", 0.1, "-1.051x^0.1 + C"),
        Arguments.of("-1", 0.2, "-1.089x^0.2 + C"),
        Arguments.of("-1", 0.3, "-1.114x^0.3 + C"),
        Arguments.of("-1", 0.4, "-1.127x^0.4 + C"),
        Arguments.of("-1", 0.5, "-1.128x^0.5 + C"),
        Arguments.of("-1", 0.6, "-1.119x^0.6 + C"),
        Arguments.of("-1", 0.7, "-1.101x^0.7 + C"),
        Arguments.of("-1", 0.8, "-1.074x^0.8 + C"),
        Arguments.of("-1", 0.9, "-1.040x^0.9 + C"),
        Arguments.of("-1", 1.0, "-x + C"),
        Arguments.of("-1", 1.5, "-0.752x^1.5 + C"),

        // Expression: x + 1
        Arguments.of("1,1", 0.0, "x + 1"),
        Arguments.of("1,1", 0.1, "0.956x^1.1 + 1.051x^0.1 + C"),
        Arguments.of("1,1", 0.2, "0.908x^1.2 + 1.089x^0.2 + C"),
        Arguments.of("1,1", 0.3, "0.857x^1.3 + 1.114x^0.3 + C"),
        Arguments.of("1,1", 0.4, "0.805x^1.4 + 1.127x^0.4 + C"),
        Arguments.of("1,1", 0.5, "0.752x^1.5 + 1.128x^0.5 + C"),
        Arguments.of("1,1", 0.6, "0.699x^1.6 + 1.119x^0.6 + C"),
        Arguments.of("1,1", 0.7, "0.647x^1.7 + 1.101x^0.7 + C"),
        Arguments.of("1,1", 0.8, "0.596x^1.8 + 1.074x^0.8 + C"),
        Arguments.of("1,1", 0.9, "0.547x^1.9 + 1.040x^0.9 + C"),
        Arguments.of("1,1", 1.0, "0.500x^2 + x + C"),
        Arguments.of("1,1", 1.5, "0.301x^2.5 + 0.752x^1.5 + C"),

        // Expression: -x - 1
        Arguments.of("-1,-1", 0.0, "-x - 1"),
        Arguments.of("-1,-1", 0.1, "-0.956x^1.1 - 1.051x^0.1 + C"),
        Arguments.of("-1,-1", 0.2, "-0.908x^1.2 - 1.089x^0.2 + C"),
        Arguments.of("-1,-1", 0.3, "-0.857x^1.3 - 1.114x^0.3 + C"),
        Arguments.of("-1,-1", 0.4, "-0.805x^1.4 - 1.127x^0.4 + C"),
        Arguments.of("-1,-1", 0.5, "-0.752x^1.5 - 1.128x^0.5 + C"),
        Arguments.of("-1,-1", 0.6, "-0.699x^1.6 - 1.119x^0.6 + C"),
        Arguments.of("-1,-1", 0.7, "-0.647x^1.7 - 1.101x^0.7 + C"),
        Arguments.of("-1,-1", 0.8, "-0.596x^1.8 - 1.074x^0.8 + C"),
        Arguments.of("-1,-1", 0.9, "-0.547x^1.9 - 1.040x^0.9 + C"),
        Arguments.of("-1,-1", 1.0, "-0.500x^2 - x + C"),
        Arguments.of("-1,-1", 1.5, "-0.301x^2.5 - 0.752x^1.5 + C"),

        // Expression: -x + 1
        Arguments.of("-1,1", 0.0, "-x + 1"),
        Arguments.of("-1,1", 0.1, "-0.956x^1.1 + 1.051x^0.1 + C"),
        Arguments.of("-1,1", 0.2, "-0.908x^1.2 + 1.089x^0.2 + C"),
        Arguments.of("-1,1", 0.3, "-0.857x^1.3 + 1.114x^0.3 + C"),
        Arguments.of("-1,1", 0.4, "-0.805x^1.4 + 1.127x^0.4 + C"),
        Arguments.of("-1,1", 0.5, "-0.752x^1.5 + 1.128x^0.5 + C"),
        Arguments.of("-1,1", 0.6, "-0.699x^1.6 + 1.119x^0.6 + C"),
        Arguments.of("-1,1", 0.7, "-0.647x^1.7 + 1.101x^0.7 + C"),
        Arguments.of("-1,1", 0.8, "-0.596x^1.8 + 1.074x^0.8 + C"),
        Arguments.of("-1,1", 0.9, "-0.547x^1.9 + 1.040x^0.9 + C"),
        Arguments.of("-1,1", 1.0, "-0.500x^2 + x + C"),
        Arguments.of("-1,1", 1.5, "-0.301x^2.5 + 0.752x^1.5 + C"),

        // Expression: x - 1
        Arguments.of("1,-1", 0.0, "x - 1"),
        Arguments.of("1,-1", 0.1, "0.956x^1.1 - 1.051x^0.1 + C"),
        Arguments.of("1,-1", 0.2, "0.908x^1.2 - 1.089x^0.2 + C"),
        Arguments.of("1,-1", 0.3, "0.857x^1.3 - 1.114x^0.3 + C"),
        Arguments.of("1,-1", 0.4, "0.805x^1.4 - 1.127x^0.4 + C"),
        Arguments.of("1,-1", 0.5, "0.752x^1.5 - 1.128x^0.5 + C"),
        Arguments.of("1,-1", 0.6, "0.699x^1.6 - 1.119x^0.6 + C"),
        Arguments.of("1,-1", 0.7, "0.647x^1.7 - 1.101x^0.7 + C"),
        Arguments.of("1,-1", 0.8, "0.596x^1.8 - 1.074x^0.8 + C"),
        Arguments.of("1,-1", 0.9, "0.547x^1.9 - 1.040x^0.9 + C"),
        Arguments.of("1,-1", 1.0, "0.500x^2 - x + C"),
        Arguments.of("1,-1", 1.5, "0.301x^2.5 - 0.752x^1.5 + C"),

        // Expression: x + 0
        Arguments.of("1,0", 0.0, "x"),
        Arguments.of("1,0", 0.1, "0.956x^1.1 + C"),
        Arguments.of("1,0", 0.2, "0.908x^1.2 + C"),
        Arguments.of("1,0", 0.3, "0.857x^1.3 + C"),
        Arguments.of("1,0", 0.4, "0.805x^1.4 + C"),
        Arguments.of("1,0", 0.5, "0.752x^1.5 + C"),
        Arguments.of("1,0", 0.6, "0.699x^1.6 + C"),
        Arguments.of("1,0", 0.7, "0.647x^1.7 + C"),
        Arguments.of("1,0", 0.8, "0.596x^1.8 + C"),
        Arguments.of("1,0", 0.9, "0.547x^1.9 + C"),
        Arguments.of("1,0", 1.0, "0.500x^2 + C"),
        Arguments.of("1,0", 1.5, "0.301x^2.5 + C"),

        // Expression: 0x + 1
        Arguments.of("0,1", 0.0, "1"),
        Arguments.of("0,1", 0.1, "1.051x^0.1 + C"),
        Arguments.of("0,1", 0.2, "1.089x^0.2 + C"),
        Arguments.of("0,1", 0.3, "1.114x^0.3 + C"),
        Arguments.of("0,1", 0.4, "1.127x^0.4 + C"),
        Arguments.of("0,1", 0.5, "1.128x^0.5 + C"),
        Arguments.of("0,1", 0.6, "1.119x^0.6 + C"),
        Arguments.of("0,1", 0.7, "1.101x^0.7 + C"),
        Arguments.of("0,1", 0.8, "1.074x^0.8 + C"),
        Arguments.of("0,1", 0.9, "1.040x^0.9 + C"),
        Arguments.of("0,1", 1.0, "x + C"),
        Arguments.of("0,1", 1.5, "0.752x^1.5 + C"),

        // Expression: x^2 + x + 1
        Arguments.of("1,1,1", 0.0, "x^2 + x + 1"),
        Arguments.of("1,1,1", 0.1, "0.910x^2.1 + 0.956x^1.1 + 1.051x^0.1 + C"),
        Arguments.of("1,1,1", 0.2, "0.825x^2.2 + 0.908x^1.2 + 1.089x^0.2 + C"),
        Arguments.of("1,1,1", 0.3, "0.745x^2.3 + 0.857x^1.3 + 1.114x^0.3 + C"),
        Arguments.of("1,1,1", 0.4, "0.671x^2.4 + 0.805x^1.4 + 1.127x^0.4 + C"),
        Arguments.of("1,1,1", 0.5, "0.602x^2.5 + 0.752x^1.5 + 1.128x^0.5 + C"),
        Arguments.of("1,1,1", 0.6, "0.538x^2.6 + 0.699x^1.6 + 1.119x^0.6 + C"),
        Arguments.of("1,1,1", 0.7, "0.480x^2.7 + 0.647x^1.7 + 1.101x^0.7 + C"),
        Arguments.of("1,1,1", 0.8, "0.426x^2.8 + 0.596x^1.8 + 1.074x^0.8 + C"),
        Arguments.of("1,1,1", 0.9, "0.377x^2.9 + 0.547x^1.9 + 1.040x^0.9 + C"),
        Arguments.of("1,1,1", 1.0, "0.333x^3 + 0.500x^2 + x + C"),
        Arguments.of("1,1,1", 1.5, "0.172x^3.5 + 0.301x^2.5 + 0.752x^1.5 + C"),

        // Expression: -x^2 - x - 1
        Arguments.of("-1,-1,-1", 0.0, "-x^2 - x - 1"),
        Arguments.of("-1,-1,-1", 0.1, "-0.910x^2.1 - 0.956x^1.1 - 1.051x^0.1 + C"),
        Arguments.of("-1,-1,-1", 0.2, "-0.825x^2.2 - 0.908x^1.2 - 1.089x^0.2 + C"),
        Arguments.of("-1,-1,-1", 0.3, "-0.745x^2.3 - 0.857x^1.3 - 1.114x^0.3 + C"),
        Arguments.of("-1,-1,-1", 0.4, "-0.671x^2.4 - 0.805x^1.4 - 1.127x^0.4 + C"),
        Arguments.of("-1,-1,-1", 0.5, "-0.602x^2.5 - 0.752x^1.5 - 1.128x^0.5 + C"),
        Arguments.of("-1,-1,-1", 0.6, "-0.538x^2.6 - 0.699x^1.6 - 1.119x^0.6 + C"),
        Arguments.of("-1,-1,-1", 0.7, "-0.480x^2.7 - 0.647x^1.7 - 1.101x^0.7 + C"),
        Arguments.of("-1,-1,-1", 0.8, "-0.426x^2.8 - 0.596x^1.8 - 1.074x^0.8 + C"),
        Arguments.of("-1,-1,-1", 0.9, "-0.377x^2.9 - 0.547x^1.9 - 1.040x^0.9 + C"),
        Arguments.of("-1,-1,-1", 1.0, "-0.333x^3 - 0.500x^2 - x + C"),
        Arguments.of("-1,-1,-1", 1.5, "-0.172x^3.5 - 0.301x^2.5 - 0.752x^1.5 + C"),

        // Expression: -x^2 + x + 1
        Arguments.of("-1,1,1", 0.0, "-x^2 + x + 1"),
        Arguments.of("-1,1,1", 0.1, "-0.910x^2.1 + 0.956x^1.1 + 1.051x^0.1 + C"),
        Arguments.of("-1,1,1", 0.2, "-0.825x^2.2 + 0.908x^1.2 + 1.089x^0.2 + C"),
        Arguments.of("-1,1,1", 0.3, "-0.745x^2.3 + 0.857x^1.3 + 1.114x^0.3 + C"),
        Arguments.of("-1,1,1", 0.4, "-0.671x^2.4 + 0.805x^1.4 + 1.127x^0.4 + C"),
        Arguments.of("-1,1,1", 0.5, "-0.602x^2.5 + 0.752x^1.5 + 1.128x^0.5 + C"),
        Arguments.of("-1,1,1", 0.6, "-0.538x^2.6 + 0.699x^1.6 + 1.119x^0.6 + C"),
        Arguments.of("-1,1,1", 0.7, "-0.480x^2.7 + 0.647x^1.7 + 1.101x^0.7 + C"),
        Arguments.of("-1,1,1", 0.8, "-0.426x^2.8 + 0.596x^1.8 + 1.074x^0.8 + C"),
        Arguments.of("-1,1,1", 0.9, "-0.377x^2.9 + 0.547x^1.9 + 1.040x^0.9 + C"),
        Arguments.of("-1,1,1", 1.0, "-0.333x^3 + 0.500x^2 + x + C"),
        Arguments.of("-1,1,1", 1.5, "-0.172x^3.5 + 0.301x^2.5 + 0.752x^1.5 + C"),

        // Expression: x^2 - x + 1
        Arguments.of("1,-1,1", 0.0, "x^2 - x + 1"),
        Arguments.of("1,-1,1", 0.1, "0.910x^2.1 - 0.956x^1.1 + 1.051x^0.1 + C"),
        Arguments.of("1,-1,1", 0.2, "0.825x^2.2 - 0.908x^1.2 + 1.089x^0.2 + C"),
        Arguments.of("1,-1,1", 0.3, "0.745x^2.3 - 0.857x^1.3 + 1.114x^0.3 + C"),
        Arguments.of("1,-1,1", 0.4, "0.671x^2.4 - 0.805x^1.4 + 1.127x^0.4 + C"),
        Arguments.of("1,-1,1", 0.5, "0.602x^2.5 - 0.752x^1.5 + 1.128x^0.5 + C"),
        Arguments.of("1,-1,1", 0.6, "0.538x^2.6 - 0.699x^1.6 + 1.119x^0.6 + C"),
        Arguments.of("1,-1,1", 0.7, "0.480x^2.7 - 0.647x^1.7 + 1.101x^0.7 + C"),
        Arguments.of("1,-1,1", 0.8, "0.426x^2.8 - 0.596x^1.8 + 1.074x^0.8 + C"),
        Arguments.of("1,-1,1", 0.9, "0.377x^2.9 - 0.547x^1.9 + 1.040x^0.9 + C"),
        Arguments.of("1,-1,1", 1.0, "0.333x^3 - 0.500x^2 + x + C"),
        Arguments.of("1,-1,1", 1.5, "0.172x^3.5 - 0.301x^2.5 + 0.752x^1.5 + C"),

        // Expression: x^2 + x - 1
        Arguments.of("1,1,-1", 0.0, "x^2 + x - 1"),
        Arguments.of("1,1,-1", 0.1, "0.910x^2.1 + 0.956x^1.1 - 1.051x^0.1 + C"),
        Arguments.of("1,1,-1", 0.2, "0.825x^2.2 + 0.908x^1.2 - 1.089x^0.2 + C"),
        Arguments.of("1,1,-1", 0.3, "0.745x^2.3 + 0.857x^1.3 - 1.114x^0.3 + C"),
        Arguments.of("1,1,-1", 0.4, "0.671x^2.4 + 0.805x^1.4 - 1.127x^0.4 + C"),
        Arguments.of("1,1,-1", 0.5, "0.602x^2.5 + 0.752x^1.5 - 1.128x^0.5 + C"),
        Arguments.of("1,1,-1", 0.6, "0.538x^2.6 + 0.699x^1.6 - 1.119x^0.6 + C"),
        Arguments.of("1,1,-1", 0.7, "0.480x^2.7 + 0.647x^1.7 - 1.101x^0.7 + C"),
        Arguments.of("1,1,-1", 0.8, "0.426x^2.8 + 0.596x^1.8 - 1.074x^0.8 + C"),
        Arguments.of("1,1,-1", 0.9, "0.377x^2.9 + 0.547x^1.9 - 1.040x^0.9 + C"),
        Arguments.of("1,1,-1", 1.0, "0.333x^3 + 0.500x^2 - x + C"),
        Arguments.of("1,1,-1", 1.5, "0.172x^3.5 + 0.301x^2.5 - 0.752x^1.5 + C"),

        // Expression: x^2 + x + 0
        Arguments.of("1,1,0", 0.0, "x^2 + x"),
        Arguments.of("1,1,0", 0.1, "0.910x^2.1 + 0.956x^1.1 + C"),
        Arguments.of("1,1,0", 0.2, "0.825x^2.2 + 0.908x^1.2 + C"),
        Arguments.of("1,1,0", 0.3, "0.745x^2.3 + 0.857x^1.3 + C"),
        Arguments.of("1,1,0", 0.4, "0.671x^2.4 + 0.805x^1.4 + C"),
        Arguments.of("1,1,0", 0.5, "0.602x^2.5 + 0.752x^1.5 + C"),
        Arguments.of("1,1,0", 0.6, "0.538x^2.6 + 0.699x^1.6 + C"),
        Arguments.of("1,1,0", 0.7, "0.480x^2.7 + 0.647x^1.7 + C"),
        Arguments.of("1,1,0", 0.8, "0.426x^2.8 + 0.596x^1.8 + C"),
        Arguments.of("1,1,0", 0.9, "0.377x^2.9 + 0.547x^1.9 + C"),
        Arguments.of("1,1,0", 1.0, "0.333x^3 + 0.500x^2 + C"),
        Arguments.of("1,1,0", 1.5, "0.172x^3.5 + 0.301x^2.5 + C"),

        // Expression: x^2 + 1
        Arguments.of("1,0,1", 0.0, "x^2 + 1"),
        Arguments.of("1,0,1", 0.1, "0.910x^2.1 + 1.051x^0.1 + C"),
        Arguments.of("1,0,1", 0.2, "0.825x^2.2 + 1.089x^0.2 + C"),
        Arguments.of("1,0,1", 0.3, "0.745x^2.3 + 1.114x^0.3 + C"),
        Arguments.of("1,0,1", 0.4, "0.671x^2.4 + 1.127x^0.4 + C"),
        Arguments.of("1,0,1", 0.5, "0.602x^2.5 + 1.128x^0.5 + C"),
        Arguments.of("1,0,1", 0.6, "0.538x^2.6 + 1.119x^0.6 + C"),
        Arguments.of("1,0,1", 0.7, "0.480x^2.7 + 1.101x^0.7 + C"),
        Arguments.of("1,0,1", 0.8, "0.426x^2.8 + 1.074x^0.8 + C"),
        Arguments.of("1,0,1", 0.9, "0.377x^2.9 + 1.040x^0.9 + C"),
        Arguments.of("1,0,1", 1.0, "0.333x^3 + x + C"),
        Arguments.of("1,0,1", 1.5, "0.172x^3.5 + 0.752x^1.5 + C"),

        // Expression: 0x^2 + x + 1
        Arguments.of("0,1,1", 0.0, "x + 1"),
        Arguments.of("0,1,1", 0.1, "0.956x^1.1 + 1.051x^0.1 + C"),
        Arguments.of("0,1,1", 0.2, "0.908x^1.2 + 1.089x^0.2 + C"),
        Arguments.of("0,1,1", 0.3, "0.857x^1.3 + 1.114x^0.3 + C"),
        Arguments.of("0,1,1", 0.4, "0.805x^1.4 + 1.127x^0.4 + C"),
        Arguments.of("0,1,1", 0.5, "0.752x^1.5 + 1.128x^0.5 + C"),
        Arguments.of("0,1,1", 0.6, "0.699x^1.6 + 1.119x^0.6 + C"),
        Arguments.of("0,1,1", 0.7, "0.647x^1.7 + 1.101x^0.7 + C"),
        Arguments.of("0,1,1", 0.8, "0.596x^1.8 + 1.074x^0.8 + C"),
        Arguments.of("0,1,1", 0.9, "0.547x^1.9 + 1.040x^0.9 + C"),
        Arguments.of("0,1,1", 1.0, "0.500x^2 + x + C"),
        Arguments.of("0,1,1", 1.5, "0.301x^2.5 + 0.752x^1.5 + C"));
  }
}
