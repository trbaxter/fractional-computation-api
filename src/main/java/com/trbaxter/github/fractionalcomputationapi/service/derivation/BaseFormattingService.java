package com.trbaxter.github.fractionalcomputationapi.service.derivation;

import com.trbaxter.github.fractionalcomputationapi.model.Term;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * BaseFormattingService is an abstract class that provides common functionality for formatting
 * polynomial terms. It includes methods to format the terms, check for zero coefficients, and
 * append terms to a result string.
 */
@SuppressWarnings("RegExpSimplifiable")
public abstract class BaseFormattingService {

  public String formatTerms(List<Term> terms, int precision) {
    if (allZeroCoefficients(terms)) {
      return getZeroPolynomialResult();
    }

    StringBuilder result = new StringBuilder();

    for (Term term : terms) {
      if (shouldSkipTerm(term)) {
        continue;
      }

      String coefficientString = formatCoefficient(term.coefficient(), precision);
      appendTerm(result, term, coefficientString);
    }

    if (result.isEmpty()) {
      return getZeroPolynomialResult();
    }

    return result.toString();
  }

  private boolean allZeroCoefficients(List<Term> terms) {
    return terms.stream().allMatch(term -> term.coefficient().compareTo(BigDecimal.ZERO) == 0);
  }

  protected abstract boolean shouldSkipTerm(Term term);

  protected abstract String getZeroPolynomialResult();

  private String formatCoefficient(BigDecimal coefficient, int precision) {
    BigDecimal scaledCoefficient = coefficient.setScale(precision, RoundingMode.HALF_UP);
    String coefficientString = scaledCoefficient.toPlainString();

    if (coefficientString.contains(".")) {
      String[] parts = coefficientString.split("\\.");
      if (parts.length == 2) {
        String integerPart = parts[0];
        String decimalPart = parts[1];

        // Check the condition for stripping zeros: only strip if decimal part matches "000..." up
        // to precision length
        if (decimalPart.matches("0{" + precision + "}")) {
          return integerPart; // If decimal part is exactly "000" at the specified precision, strip
          // it
        }
      }
    }

    return coefficientString;
  }

  private void appendTerm(StringBuilder result, Term term, String coefficientString) {
    BigDecimal coefficient = new BigDecimal(coefficientString);

    if (coefficient.compareTo(BigDecimal.ZERO) == 0) {
      return; // Skip zero coefficients
    }

    // Handle appending of the term with correct spacing and signs
    if (!result.isEmpty()) {
      if (coefficient.compareTo(BigDecimal.ZERO) > 0) {
        result.append(" + ");
      } else {
        result.append(" - ");
        coefficientString = coefficient.abs().toPlainString();
      }
    }

    // Handling coefficients like 1 or -1 specially, omitting them if they are 1 or -1 respectively
    // with powers
    boolean omitCoefficient =
        coefficient.abs().compareTo(BigDecimal.ONE) == 0
            && term.power().compareTo(BigDecimal.ZERO) != 0;
    if (!omitCoefficient) {
      result.append(coefficientString);
    } else if (coefficient.compareTo(BigDecimal.ONE.negate()) == 0 && result.isEmpty()) {
      result.append("-");
    }

    // Append the variable part
    if (term.power().compareTo(BigDecimal.ZERO) != 0) {
      result.append("x");
      if (term.power().compareTo(BigDecimal.ONE) != 0) {
        result.append("^").append(term.power().stripTrailingZeros().toPlainString());
      }
    }
  }
}
