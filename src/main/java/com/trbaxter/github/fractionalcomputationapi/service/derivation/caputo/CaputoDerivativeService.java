package com.trbaxter.github.fractionalcomputationapi.service.derivation.caputo;

import com.trbaxter.github.fractionalcomputationapi.model.Term;
import com.trbaxter.github.fractionalcomputationapi.service.FractionalCalculusService;
import com.trbaxter.github.fractionalcomputationapi.utils.ExpressionParser;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CaputoDerivativeService is a service that computes the Caputo fractional derivative of a
 * polynomial expression. It uses the CaputoDerivativeComputationService to compute the terms and
 * the CaputoDerivativeFormattingService to format the result.
 */
@Service
public class CaputoDerivativeService implements FractionalCalculusService {
  private final CaputoDerivativeComputationService termComputationService;
  private final CaputoDerivativeFormattingService termFormattingService;

  /**
   * Constructs a CaputoDerivativeService with the specified computation and formatting services.
   *
   * @param termComputationService the service for computing the terms of the Caputo derivative.
   * @param termFormattingService the service for formatting the terms of the Caputo derivative.
   */
  @Autowired
  public CaputoDerivativeService(
      CaputoDerivativeComputationService termComputationService,
      CaputoDerivativeFormattingService termFormattingService) {
    this.termComputationService = termComputationService;
    this.termFormattingService = termFormattingService;
  }

  /**
   * Evaluates the Caputo fractional derivative of a polynomial expression with the given
   * coefficients and order alpha.
   *
   * @param terms the list of terms of the polynomial, must not be null.
   * @param alpha the fractional order of the Caputo derivative, must be zero or positive.
   * @return the result of the Caputo fractional derivative computation as a String.
   */
  @Override
  public String evaluateExpression(List<Term> terms, double alpha) {
    List<Term> computedTerms =
        termComputationService.computeTerms(terms, BigDecimal.valueOf(alpha));
    return termFormattingService.formatTerms(computedTerms);
  }

  public String evaluateExpression(String polynomialExpression, double alpha) {
    List<Term> terms = ExpressionParser.parse(polynomialExpression);
    return evaluateExpression(terms, alpha);
  }
}
