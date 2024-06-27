package com.trbaxter.github.fractionalcomputationapi.service.derivation.caputo;

import com.trbaxter.github.fractionalcomputationapi.model.Term;
import com.trbaxter.github.fractionalcomputationapi.utils.MathUtils;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 * CaputoDerivativeComputationService provides methods to compute the terms of the Caputo fractional
 * derivative for polynomial expressions.
 */
@Service
public class CaputoDerivativeComputationService {
  private static final Logger logger =
      Logger.getLogger(CaputoDerivativeComputationService.class.getName());

  /**
   * Computes the terms of the Caputo fractional derivative for the given polynomial terms and order
   * alpha.
   *
   * @param terms the list of terms of the polynomial, must not be null.
   * @param alpha the order of the Caputo fractional derivative, must not be null.
   * @return a list of computed terms of the Caputo fractional derivative.
   */
  public List<Term> computeTerms(List<Term> terms, BigDecimal alpha) {
    List<Term> computedTerms = new ArrayList<>();

    if (alpha.compareTo(BigDecimal.ZERO) == 0) {
      computedTerms.addAll(terms);
    } else if (alpha.stripTrailingZeros().scale() <= 0) {
      computeIntegerOrderDerivativeTerms(terms, alpha.intValue(), computedTerms);
    } else {
      computeFractionalOrderDerivativeTerms(terms, alpha, computedTerms);
    }

    computedTerms.sort(Comparator.comparing(Term::power).reversed());
    return computedTerms;
  }

  /**
   * Computes the terms for an integer-order derivative for the given polynomial terms and order
   * intAlpha.
   *
   * @param terms the list of terms of the polynomial, must not be null.
   * @param intAlpha the integer order of the derivative.
   * @param computedTerms the list to which computed terms will be added.
   */
  private void computeIntegerOrderDerivativeTerms(
      List<Term> terms, int intAlpha, List<Term> computedTerms) {
    for (Term term : terms) {
      BigDecimal coefficient = term.coefficient();
      BigDecimal currentDegree = term.power();

      if (coefficient.compareTo(BigDecimal.ZERO) != 0
          && currentDegree.compareTo(BigDecimal.valueOf(intAlpha)) >= 0) {
        BigDecimal newCoefficient = coefficient;
        for (int j = 0; j < intAlpha; j++) {
          newCoefficient = newCoefficient.multiply(currentDegree.subtract(BigDecimal.valueOf(j)));
        }
        BigDecimal newDegree = currentDegree.subtract(BigDecimal.valueOf(intAlpha));
        if (newDegree.compareTo(BigDecimal.ZERO) >= 0) {
          computedTerms.add(new Term(newCoefficient, newDegree));
        }
      }
    }
  }

  /**
   * Computes the terms for a fractional-order derivative for the given polynomial terms and order
   * alpha.
   *
   * @param terms the list of terms of the polynomial, must not be null.
   * @param alpha the fractional order of the derivative, must not be null.
   * @param computedTerms the list to which computed terms will be added.
   */
  private void computeFractionalOrderDerivativeTerms(
      List<Term> terms, BigDecimal alpha, List<Term> computedTerms) {
    for (Term term : terms) {
      BigDecimal coefficient = term.coefficient();
      BigDecimal k = term.power();

      if (coefficient.compareTo(BigDecimal.ZERO) != 0) {
        try {
          BigDecimal gammaNumerator = MathUtils.gamma(k.add(BigDecimal.ONE));
          BigDecimal gammaDenominator = MathUtils.gamma(k.subtract(alpha).add(BigDecimal.ONE));
          logger.info(
              String.format(
                  "Term with power %s: gammaNumerator = %s, gammaDenominator = %s",
                  k, gammaNumerator, gammaDenominator));

          if (gammaDenominator.compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal gammaCoefficient =
                gammaNumerator.divide(gammaDenominator, MathContext.DECIMAL128);
            BigDecimal newCoefficient = coefficient.multiply(gammaCoefficient);
            BigDecimal newPower = k.subtract(alpha);
            logger.info(
                String.format(
                    "Computed Term: newCoefficient = %s, newPower = %s", newCoefficient, newPower));
            computedTerms.add(new Term(newCoefficient, newPower));
          }
        } catch (Exception e) {
          logger.severe(String.format("Error computing term with power %s: %s", k, e.getMessage()));
        }
      }
    }
  }
}
