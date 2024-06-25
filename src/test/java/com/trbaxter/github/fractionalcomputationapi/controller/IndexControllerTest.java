package com.trbaxter.github.fractionalcomputationapi.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trbaxter.github.fractionalcomputationapi.model.ControllerRequest;
import com.trbaxter.github.fractionalcomputationapi.service.derivation.caputo.CaputoDerivativeService;
import com.trbaxter.github.fractionalcomputationapi.service.derivation.riemann_liouville.RiemannLiouvilleDerivativeService;
import com.trbaxter.github.fractionalcomputationapi.service.integration.caputo.CaputoIntegrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * IndexControllerTest is a test class for the IndexController. It uses MockMvc to test the
 * endpoints as defined in that class.
 */
@WebMvcTest(IndexController.class)
public class IndexControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private CaputoDerivativeService caputoDerivativeService;

  @MockBean private RiemannLiouvilleDerivativeService riemannLiouvilleDerivativeService;

  @MockBean private CaputoIntegrationService caputoIntegrationService;

  @Autowired private ObjectMapper objectMapper;

  /** Sets up the test environment before each test. */
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * Tests the computeCaputoDerivative endpoint with valid input.
   *
   * @throws Exception if an error occurs during the test.
   */
  @Test
  public void testComputeCaputoDerivative() throws Exception {
    double[] coefficients = {3.0, 2.0, 1.0};
    double alpha = 0.5;
    ControllerRequest request = new ControllerRequest();
    request.setCoefficients(coefficients);
    request.setOrder(alpha);

    when(caputoDerivativeService.evaluateExpression(coefficients, alpha))
        .thenReturn("4.514x^1.5 + 2.257x^0.5");

    mockMvc
        .perform(
            post("/fractional-calculus-computation-api/derivative/caputo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isOk())
        .andExpect(content().string("4.514x^1.5 + 2.257x^0.5"));
  }

  /**
   * Tests the computeRiemannLiouvilleDerivative endpoint with valid input.
   *
   * @throws Exception if an error occurs during the test.
   */
  @Test
  public void testComputeRiemannLiouvilleDerivative() throws Exception {
    double[] coefficients = {3.0, 2.0, 1.0};
    double alpha = 0.5;
    ControllerRequest request = new ControllerRequest();
    request.setCoefficients(coefficients);
    request.setOrder(alpha);

    when(riemannLiouvilleDerivativeService.evaluateExpression(coefficients, alpha))
        .thenReturn("3.786x^1.5 + 1.893x^0.5");

    mockMvc
        .perform(
            post("/fractional-calculus-computation-api/derivative/riemann-liouville")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isOk())
        .andExpect(content().string("3.786x^1.5 + 1.893x^0.5"));
  }

  /**
   * Tests the computeCaputoIntegral endpoint with valid input.
   *
   * @throws Exception if an error occurs during the test.
   */
  @Test
  public void testComputeCaputoIntegral() throws Exception {
    double[] coefficients = {3.0, 2.0, 1.0};
    double alpha = 0.5;
    ControllerRequest request = new ControllerRequest();
    request.setCoefficients(coefficients);
    request.setOrder(alpha);

    when(caputoIntegrationService.evaluateExpression(coefficients, alpha))
        .thenReturn("4.985x^2.5 + 2.695x^1.5 + 0.886x^0.5");

    mockMvc
        .perform(
            post("/fractional-calculus-computation-api/integral/caputo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isOk())
        .andExpect(content().string("4.985x^2.5 + 2.695x^1.5 + 0.886x^0.5"));
  }

  /**
   * Tests the computeCaputoDerivative endpoint with invalid input.
   *
   * @throws Exception if an error occurs during the test.
   */
  @Test
  public void testInvalidControllerRequest() throws Exception {
    ControllerRequest request = new ControllerRequest();
    request.setCoefficients(null);
    request.setOrder(0.5);

    mockMvc
        .perform(
            post("/fractional-calculus-computation-api/derivative/caputo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isBadRequest());
  }

  /**
   * Tests the computeCaputoDerivative endpoint when an internal server error occurs.
   *
   * @throws Exception if an error occurs during the test.
   */
  @Test
  public void testCaputoDerivativeInternalServerError() throws Exception {
    double[] coefficients = {3.0, 2.0, 1.0};
    double alpha = 0.5;
    ControllerRequest request = new ControllerRequest();
    request.setCoefficients(coefficients);
    request.setOrder(alpha);

    when(caputoDerivativeService.evaluateExpression(coefficients, alpha))
        .thenThrow(new RuntimeException("Internal Server Error"));

    mockMvc
        .perform(
            post("/fractional-calculus-computation-api/derivative/caputo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isInternalServerError())
        .andExpect(content().string("Internal Server Error"));
  }

  /**
   * Tests the computeRiemannLiouvilleDerivative endpoint when an internal server error occurs.
   *
   * @throws Exception if an error occurs during the test.
   */
  @Test
  public void testRiemannLiouvilleDerivativeInternalServerError() throws Exception {
    double[] coefficients = {3.0, 2.0, 1.0};
    double alpha = 0.5;
    ControllerRequest request = new ControllerRequest();
    request.setCoefficients(coefficients);
    request.setOrder(alpha);

    when(riemannLiouvilleDerivativeService.evaluateExpression(coefficients, alpha))
        .thenThrow(new RuntimeException("Internal Server Error"));

    mockMvc
        .perform(
            post("/fractional-calculus-computation-api/derivative/riemann-liouville")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isInternalServerError())
        .andExpect(content().string("Internal Server Error"));
  }

  /**
   * Tests the computeCaputoIntegral endpoint when an internal server error occurs.
   *
   * @throws Exception if an error occurs during the test.
   */
  @Test
  public void testCaputoIntegralInternalServerError() throws Exception {
    double[] coefficients = {3.0, 2.0, 1.0};
    double alpha = 0.5;
    ControllerRequest request = new ControllerRequest();
    request.setCoefficients(coefficients);
    request.setOrder(alpha);

    when(caputoIntegrationService.evaluateExpression(coefficients, alpha))
        .thenThrow(new RuntimeException("Internal Server Error"));

    mockMvc
        .perform(
            post("/fractional-calculus-computation-api/integral/caputo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isInternalServerError())
        .andExpect(content().string("Internal Server Error"));
  }
}
