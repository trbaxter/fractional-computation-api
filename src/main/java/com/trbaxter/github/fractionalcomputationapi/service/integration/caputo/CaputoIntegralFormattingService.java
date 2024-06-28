package com.trbaxter.github.fractionalcomputationapi.service.integration.caputo;

import com.trbaxter.github.fractionalcomputationapi.model.Term;
import com.trbaxter.github.fractionalcomputationapi.service.derivation.BaseFormattingService;
import com.trbaxter.github.fractionalcomputationapi.utils.MathUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * CaputoIntegralFormattingService is a service that provides formatting for the results of Caputo
 * fractional integrals. It extends the BaseFormattingService to apply specific rules for Caputo
 * integrals.
 */
@Service
public class CaputoIntegralFormattingService extends BaseFormattingService {

  @Override
  protected boolean shouldSkipTerm(Term term) {
    return false;
  }

  @Override
  protected String getZeroPolynomialResult() {
    return "C";
  }

  public String formatTerms(List<Term> terms, double alpha, int precision) {
    String result = super.formatTerms(terms, precision);

    boolean integerAlpha = BigDecimal.valueOf(alpha).stripTrailingZeros().scale() <= 0;
    int alphaInt = (int) alpha;

    if (integerAlpha) {
      if (alphaInt > 1) {
        result = appendConstantsOfIntegration(result, alphaInt, precision);
      } else if (alphaInt == 1) {
        if (!result.isEmpty()) result += " + ";
        result += "C";
      }
    } else {
      if (!result.isEmpty()) result += " + ";
      result += "C";
    }

    return result;
  }

  private String appendConstantsOfIntegration(String result, int alphaInt, int precision) {
    StringBuilder sb = new StringBuilder(result);
    for (int i = 0; i < alphaInt; i++) {
      if (!sb.isEmpty()) sb.append(" + ");
      char constant = (char) ('C' + i);
      BigDecimal constantCoefficient;

      if (i == 0) {
        constantCoefficient =
            BigDecimal.ONE.divide(
                MathUtils.gamma(BigDecimal.valueOf(alphaInt)), precision, RoundingMode.HALF_UP);
      } else {
        constantCoefficient =
            BigDecimal.ONE.divide(
                MathUtils.gamma(BigDecimal.valueOf(alphaInt - i)), precision, RoundingMode.HALF_UP);
      }

      String coefficientStr =
          constantCoefficient.setScale(precision, RoundingMode.HALF_UP).toPlainString();
      if (coefficientStr.contains(".")) {
        String[] parts = coefficientStr.split("\\.");
        if (parts.length == 2 && parts[1].matches("0{" + precision + "}")) {
          coefficientStr = parts[0];
        }
      }

      // Check if coefficient equals 1 and omit appending it if true
      if (constantCoefficient.compareTo(BigDecimal.ONE) == 0) {
        coefficientStr = "";
      } else {
        sb.append(coefficientStr);
      }
      sb.append(constant);

      int power = alphaInt - i - 1;
      if (power > 0) {
        sb.append("x");
        if (power > 1) {
          sb.append("^").append(power);
        }
      }
    }
    return sb.toString();
  }
}