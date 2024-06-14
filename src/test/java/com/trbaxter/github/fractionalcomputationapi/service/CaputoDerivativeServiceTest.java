package com.trbaxter.github.fractionalcomputationapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;

import com.trbaxter.github.fractionalcomputationapi.service.derivation.CaputoDerivativeService;
import com.trbaxter.github.fractionalcomputationapi.utils.MathUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CaputoDerivativeServiceTest {

	private CaputoDerivativeService caputoDerivativeService;

	@BeforeEach
	public void setUp() {
		caputoDerivativeService = new CaputoDerivativeService();
	}

	@Test
	public void testComputeDerivative_SimplePolynomial() {
		double[] coefficients = {3.0, 2.0, 1.0};
		double alpha = 0.5;

		try (MockedStatic<MathUtils> utilities = mockStatic(MathUtils.class)) {
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(3))).thenReturn(new BigDecimal("2.0"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(2.5))).thenReturn(new BigDecimal("1.329"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(2))).thenReturn(new BigDecimal("1.0"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(1.5))).thenReturn(new BigDecimal("0.886"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(1))).thenReturn(new BigDecimal("1.0"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(0.5))).thenReturn(new BigDecimal("1.77245385091"));

			String result = caputoDerivativeService.evaluateExpression(coefficients, alpha);
			String expected = "4.515x^1.5 + 2.257x^0.5";

			assertEquals(expected, result);
		}
	}

	@Test
	public void testComputeDerivative_NegativeCoefficients() {
		double[] coefficients = {-3.0, -2.0, -1.0};
		double alpha = 0.5;

		try (MockedStatic<MathUtils> utilities = mockStatic(MathUtils.class)) {
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(3))).thenReturn(new BigDecimal("2.0"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(2.5))).thenReturn(new BigDecimal("1.329"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(2))).thenReturn(new BigDecimal("1.0"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(1.5))).thenReturn(new BigDecimal("0.886"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(1))).thenReturn(new BigDecimal("1.0"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(0.5))).thenReturn(new BigDecimal("1.77245385091"));

			String result = caputoDerivativeService.evaluateExpression(coefficients, alpha);
			String expected = "- 4.515x^1.5 - 2.257x^0.5";

			assertEquals(expected, result);
		}
	}

	@Test
	public void testComputeDerivative_ConstantTerm() {
		double[] coefficients = {3.0};
		double alpha = 0.5;

		String result = caputoDerivativeService.evaluateExpression(coefficients, alpha);
		String expected = "";

		assertEquals(expected, result);
	}

	@Test
	public void testComputeDerivative_PositiveAndNegativeCoefficients() {
		double[] coefficients = {3.0, -2.0, 1.0};
		double alpha = 0.5;

		try (MockedStatic<MathUtils> utilities = mockStatic(MathUtils.class)) {
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(3))).thenReturn(new BigDecimal("2.0"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(2.5))).thenReturn(new BigDecimal("1.329"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(2))).thenReturn(new BigDecimal("1.0"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(1.5))).thenReturn(new BigDecimal("0.886"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(1))).thenReturn(new BigDecimal("1.0"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(0.5))).thenReturn(new BigDecimal("1.77245385091"));

			String result = caputoDerivativeService.evaluateExpression(coefficients, alpha);
			String expected = "4.515x^1.5 - 2.257x^0.5";

			assertEquals(expected, result);
		}
	}

	@Test
	public void testComputeDerivative_ZeroCoefficient() {
		double[] coefficients = {0.0, 2.0, -1.0};
		double alpha = 0.5;

		try (MockedStatic<MathUtils> utilities = mockStatic(MathUtils.class)) {
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(2))).thenReturn(new BigDecimal("1.0"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(1.5))).thenReturn(new BigDecimal("0.886"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(1))).thenReturn(new BigDecimal("1.0"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(0.5))).thenReturn(new BigDecimal("1.77245385091"));

			String result = caputoDerivativeService.evaluateExpression(coefficients, alpha);
			String expected = "2.257x^0.5";

			assertEquals(expected, result);
		}
	}

	@Test
	public void testComputeDerivative_ZeroPolynomial() {
		double[] coefficients = {0.0, 0.0, 0.0};
		double alpha = 0.5;

		String result = caputoDerivativeService.evaluateExpression(coefficients, alpha);
		String expected = "";

		assertEquals(expected, result);
	}

	@Test
	public void testComputeDerivative_DifferentAlpha() {
		double[] coefficients = {3.0, 0.0, 1.0};
		double alpha = 1.5;

		try (MockedStatic<MathUtils> utilities = mockStatic(MathUtils.class)) {
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(3))).thenReturn(new BigDecimal("2.0"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(1.5))).thenReturn(new BigDecimal("0.886"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(1))).thenReturn(new BigDecimal("1.0"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(0.5))).thenReturn(new BigDecimal("1.77245385091"));
			utilities.when(() -> MathUtils.gamma(BigDecimal.valueOf(-0.5)))
					.thenReturn(new BigDecimal("-3.54490770181"));

			String result = caputoDerivativeService.evaluateExpression(coefficients, alpha);
			String expected = "6.772x^0.5";

			assertEquals(expected, result);
		}
	}

	@Test
	public void testIntegerAlpha() {
		double[] coefficients = {1, 2, 3};
		double alpha = 2;

		String result = caputoDerivativeService.evaluateExpression(coefficients, alpha);
		String expected = "2.000";

		assertEquals(expected, result);
	}

	@Test
	public void testNonIntegerAlpha() {
		double[] coefficients = {1, 2, 3};
		double alpha = 0.5;

		try (MockedStatic<MathUtils> mockedMathUtils = mockStatic(MathUtils.class)) {
			mockedMathUtils.when(() -> MathUtils.gamma(any(BigDecimal.class))).thenReturn(BigDecimal.ONE);

			String result = caputoDerivativeService.evaluateExpression(coefficients, alpha);
			assertNotNull(result);
		}
	}

	@Test
	public void testGammaFunctionException() {
		double[] coefficients = {1, 2, 3};
		double alpha = 0.5;

		Logger logger = Logger.getLogger(CaputoDerivativeService.class.getName());
		List<String> logMessages = new ArrayList<>();
		Handler testHandler = new Handler() {
			@Override
			public void publish(LogRecord record) {
				logMessages.add(record.getMessage());
			}

			@Override
			public void flush() {
			}

			@Override
			public void close() throws SecurityException {
			}
		};
		logger.addHandler(testHandler);

		try (MockedStatic<MathUtils> mockedMathUtils = mockStatic(MathUtils.class)) {
			mockedMathUtils.when(() -> MathUtils.gamma(any(BigDecimal.class)))
					.thenThrow(new ArithmeticException("Gamma function error"));

			String result = caputoDerivativeService.evaluateExpression(coefficients, alpha);
			assertNotNull(result);
			// Ensure the logger captured the error
			assertTrue(logMessages.stream().anyMatch(msg -> msg.contains("Gamma function error")));
		} finally {
			logger.removeHandler(testHandler);
		}
	}

	@Test
	public void testFactorialBaseCase() throws Exception {
		java.lang.reflect.Method method = CaputoDerivativeService.class.getDeclaredMethod("factorial", int.class);
		method.setAccessible(true);
		int result = (int) method.invoke(caputoDerivativeService, 1);
		assertEquals(1, result);
	}

	@Test
	public void testFactorialRecursiveCase() throws Exception {
		java.lang.reflect.Method method = CaputoDerivativeService.class.getDeclaredMethod("factorial", int.class);
		method.setAccessible(true);
		int result = (int) method.invoke(caputoDerivativeService, 5);
		assertEquals(120, result);
	}
}
