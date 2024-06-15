package com.trbaxter.github.fractionalcomputationapi.service.derivation.riemann_liouville;

import com.trbaxter.github.fractionalcomputationapi.model.Term;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RiemannLiouvilleFormattingService {

  public String formatTerms(List<Term> terms) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < terms.size(); i++) {
      Term term = terms.get(i);
      BigDecimal coefficient = term.coefficient().setScale(3, RoundingMode.HALF_UP);

      // Check if coefficient has trailing zeros to be stripped
      String coefficientStr = coefficient.stripTrailingZeros().toPlainString();

      if (i > 0) {
        if (coefficient.compareTo(BigDecimal.ZERO) > 0) {
          result.append(" + ");
        } else {
          result.append(" - ");
          coefficientStr = coefficient.abs().stripTrailingZeros().toPlainString();
        }
      } else {
        if (coefficient.compareTo(BigDecimal.ZERO) < 0) {
          result.append("-");
          coefficientStr = coefficient.abs().stripTrailingZeros().toPlainString();
        }
      }

      if (coefficient.abs().compareTo(BigDecimal.ONE) != 0
          || term.power().compareTo(BigDecimal.ZERO) == 0) {
        result.append(coefficientStr);
      }

      // Check if power is zero, and if so, only append the coefficient
      if (term.power().compareTo(BigDecimal.ZERO) != 0) {
        result.append("x");
        if (term.power().compareTo(BigDecimal.ONE) != 0) {
          // Remove the trailing zeros from exponents in output
          String exponent = term.power().stripTrailingZeros().toPlainString();
          result.append("^").append(exponent);
        }
      }
    }
    if (result.isEmpty()) {
      return "0";
    }
    return result.toString();
  }
}
