# Fractional Calculus Computation API

This is a Java-based API that can produce expressions for derivatives and integrals of
user-submitted expressions of integer or fractional order.


<br/>

## Table of Contents

[Project Status](#project-status)  
[Technologies Used](#technologies-used)  
[Getting Started](#getting-started)
[Endpoint Information](#endpoint-information)  
[Examples](#examples)  
[Calculation Details](#calculation-details)  
[FAQ](#faq)  
[Contributing](#contributing)  
[Changelog](#changelog)  
[Known Issues](#known-issues)  
[License](#license)  
[Acknowledgements](#acknowledgements)  
[Support](#support)  
[Contact Information](#contact-information)


<br/>

## Project Status

This project is in active development with a current version of 1.0.0.  
Upcoming features include:

- Support for other types of expressions (logarithms, trig identities, etc.)

- Support for mixed expressions

- Support for nested functions

- Frontend UI

<br/>

## Technologies Used

### Core Technologies

- **Java**: OpenJDK Version 22.0.1

### Build Tools

- **Maven**: Version 3.9.6

### Frameworks

- **Spring Boot**: Version 3.2.5
- **Spring MVC**: Version 6.1.6

### Testing

- **JUnit**: JUnit 5 (JUnit Jupiter) Version 5.10.2
- **Mockito**: Version 5.11.0

### Libraries

- **Apache Commons Math**: Version 3.6.1
- **Jackson Databind**: Version 2.15.4
- **Logback**: Version 1.4.14
- **SLF4J**: Version 2.0.13
- **Hibernate Validator**: Version 8.0.1.Final

<br/>

## Getting Started

Clone the repository:

```sh
git clone https://github.com/trbaxter/fractional-computation-api.git
```

<br/>


Navigate to the project directory:

```sh
cd fractional-computation-api
```

<br/>


Build the project using Maven:

```sh
mvn clean install
```

<br/>

Start the application using the following command:

```sh
mvn spring-boot:run
```

<br/>

Upon successful start, endpoints may be accessed by using cURL commands or API testing software
(Postman / Insomnia / etc).

<br/>

## Endpoint Information

### 1.) Caputo Fractional Derivative Endpoint

Method: <b>POST</b>

Endpoint URL: `/fractional-calculus-computation-api/derivative/caputo`



Required request body:

```
{
  "coefficients": [],
  "order": 
}
```

Parameters:

```coefficients``` - An array of polynomial coefficients of type double or integer.

```order``` - The derivative order of type double.

Response:

```
{
    "expression": 
}
```

Returns the closed-form expression of the Caputo derivative if successful.

<br/>
<br/>

### 2.) Riemann-Liouville Fractional Derivative Endpoint

Method: <b>POST</b>

Endpoint URL: `/fractional-calculus-computation-api/derivative/riemann-liouville`

Required request body:

```
{
  "coefficients": [],
  "order": 
}
```

Parameters:

```coefficients``` - An array of polynomial coefficients of type double or integer.

```order``` - The derivative order of type double.



Response:

```
{
    "expression": 
}
```

Returns the closed-form expression of the Riemann-Liouville derivative if successful.

<br/>

### 3.) Caputo Fractional Integral Endpoint

Method: <b>POST</b>

Endpoint URL: `/fractional-calculus-computation-api/integral/caputo`

Required request body:

```
{
  "coefficients": [],
  "order": 
}
```

Parameters:

```coefficients``` - An array of polynomial coefficients of type double or integer.

```order``` - The derivative order of type double.

Response:

```
{
    "expression": 
}
```

Returns the closed-form expression of the Caputo integral if successful.

<br/>

## Examples

### Example #1: Caputo Derivative with Non-Zero Integer Coefficients

**Goal**: Obtain an expression for the 0.35th Caputo derivative of $3x^2 + 2x + 1$.

Input:

```
{
  "coefficients": [3,2,1],
  "order": 0.35
}
```

Output:

```
{
  "expression": "4.040x^1.65 + 2.222x^0.65"
}
```

<br/>
<br/>

### Example #2: Caputo Derivative with Zero and Non-Zero Coefficients

**Goal**: Obtain an expression for the 1.23456th Caputo derivative of $14.6x^3 + 16.049x - 12$.

Input:

```
{
  "coefficients": [14.6, 0, 16.049, -12],
  "order": 1.23456
}
```

Output:

```
{
    "expression": "53.778x^1.76544"
}
```

<br/>
<br/>

### Example #3: Riemann-Liouville Derivative with Non-Zero Integer Coefficients

**Goal**: Obtain an expression for the 0.35th Riemann-Liouville derivative of $3x^2 + 2x + 1$.

Input:

```
{
  "coefficients": [3,2,1],
  "order": 0.35
}
```

Output:

```
{
  "expression": "4.040x^1.65 + 2.222x^0.65 + 0.722x^-0.35"
}
```

&nbsp;

<br/>
<br/>

### Example #4: Riemann-Liouville Derivative with Zero and Non-Zero Coefficients

**Goal**: Obtain an expression for the 1.23456th Riemann-Liouville derivative of $14.6x^3 + 16.
049x - 12$.

Input:

```
{
  "coefficients": [14.6, 0, 16.049, -12],
  "order": 1.23456
}
```

&nbsp;

Output:

```
{
  "expression": "53.778x^1.76544 + 13.314x^-0.23456 + 2.335x^-1.23456"
}
```

<br/>
<br/>

### Example #5: Caputo Integral with Non-Zero Integer Coefficients

**Goal**: Obtain an expression for the 0.35th Caputo integral of $3x^2 + 2x + 1$.

Input:

```
{
  "coefficients": [3,2,1],
  "order": 0.35
}
```

Output:

```
{
  "expression": "2.122x^2.35 + 1.662x^1.35 + 1.122x^0.35 + C"
}
```

<br/>

## Calculation Details

<details>
<summary>Caputo Fractional Derivative of $3x^2 + 2x + 1$ with $\alpha = 0.35$ (full derivation process)</summary>&nbsp;<br/>
The Caputo fractional derivative of order $\alpha$ for a function $f(x)$ is defined as:
$${}^{C} D^{\alpha} f(x) = \dfrac{1}{\Gamma(n-\alpha)} \int_{0}^{x} \dfrac{f^{(n)}(t)}{(x-t)^
{(\alpha + 1 - n})}dt $$

Where:  
  
- $n = ⌈\alpha⌉$ (the smallest integer greater than or equal to $\alpha$)
- $\Gamma$ is the Gamma function
- $f^{(n)}(t)$ is the $n$-th derivative of $f(t)$.
- $f(t)$ is the same expression as $f(x)$, except with $t$ substituted for all $x$.

For $\alpha = 0.35$, $⌈0.35⌉ = 1$ and thus, $n = 1$. The definition can then be simplified to:
$${}^{C} D^{0.35} f(x) = \dfrac{1}{\Gamma(0.65)} \int_{0}^{x} \dfrac{f^{(1)}(t)}{(x-t)^
{(0.35)}}dt$$

First, compute the derivative of $f(t)$:

$$\dfrac{d}{dt}(3t^2 + 2t + 1) = 6t + 2$$

Thus, 

$${}^{C} D^{0.35} f(x) = \dfrac{1}{\Gamma(0.65)} \int_{0}^{x} \dfrac{6t + 2}{(x-t)^
{(0.35)}}dt$$

To simplify evaluation of the integral, it can be split into the following two parts: 

$${}^{C} D^{0.35} f(x) = \dfrac{1}{\Gamma(0.65)} \Big(\int_{0}^{x} \dfrac{6t}{(x-t)^
{(0.35)}}dt + \int_{0}^{x} \dfrac{2}{(x-t)^{(0.35)}}dt \Big)$$

For both integral parts, a u-substitution of $t$ will be required. Let $u = \dfrac{t}{x}$
and $du = \dfrac{dt}{x}$.

The lower limit of $t$ is zero. Therefore, the lower limit of $u$ is $\dfrac{0}{x} = 0.$

Similarly, the upper limit of $t$ is $x$. Therefore, the upper limit of $u$ is $\dfrac{x}{x} = 1$. 

With the u-substitution applied, the integral expression now takes the following form: 

$${}^{C} D^{0.35} f(x) = \dfrac{1}{\Gamma(0.65)} \Big(\int_{0}^{1} \dfrac{6(ux)}{(x-(ux))^
{(0.35)}}(x \cdot du) + \int_{0}^{1} \dfrac{2}{(x-(ux))^{(0.35)}}(x \cdot du) \Big)$$

The integrands can be simplified by factoring out the numerical coefficients and factors of $x$:

$${}^{C} D^{0.35} f(x) = \dfrac{1}{\Gamma(0.65)} \Big(6x^2 \int_{0}^{1} \dfrac{u}{(x-ux)^
{(0.35)}}du + 2x\int_{0}^{1} \dfrac{1}{(x-ux)^{(0.35)}}du \Big)$$

Followed by factoring out $x^{0.35}$ from the denominators:

$${}^{C} D^{0.35} f(x) = \dfrac{1}{\Gamma(0.65)} \Big(\dfrac{6x^2}{x^{0.35}} \int_{0}^{1} \dfrac{u}{(1-u)^
{(0.35)}}du + \dfrac{2x}{x^{0.35}} \int_{0}^{1} \dfrac{1}{(1-u)^{(0.35)}}du \Big)$$

Then simplifying the coefficients on both integrals:

$${}^{C} D^{0.35} f(x) = \dfrac{1}{\Gamma(0.65)} \Big(6x^{1.65} \int_{0}^{1} \dfrac{u}{(1-u)^
{(0.35)}}du + 2x^{0.65} \int_{0}^{1} \dfrac{1}{(1-u)^{(0.35)}}du \Big)$$

The integrands can now be rewritten in the following way to match the form of the Beta function: 

$${}^{C} D^{0.35} f(x) = \dfrac{1}{\Gamma(0.65)} \Big(6x^{1.65} \int_{0}^{1} u(1-u)^{0.35}du + 2x^{0.65} \int_{0}^{1} (1-u)^{0.35}du \Big)$$

Where the Beta function has the following form:

$$\beta(p,q) = \int_{0}^{1} t^{p-1}(1-t)^{q-1}dt$$

With the following solution:

$$\beta(p,q) = \dfrac{\Gamma(p) \Gamma(q)}{\Gamma(p+q)}$$

The first integral is equivalent to $\beta(2,0.65)$, and the second integral is equivalent to $\beta(1,0.65)$. Substituting the solutions in:

$${}^{C} D^{0.35} f(x) = \dfrac{1}{\Gamma(0.65)} \Big(6x^{1.65} \dfrac{\Gamma(2) \Gamma(0.65)}{\Gamma(2.65)} + 2x^{0.65} \dfrac{\Gamma(1) \Gamma(0.65)}{\Gamma(1.65)} \Big)$$

Upon canceling like terms:

$${}^{C} D^{0.35} f(x) = \cancel{\dfrac{1}{\Gamma(0.65)}} \Big(6x^{1.65} \dfrac{\Gamma(2) \cancel{\Gamma(0.65)}}{\Gamma(2.65)} + 2x^{0.65} \dfrac{\Gamma(1) \cancel{\Gamma(0.65)}}{\Gamma(1.65)} \Big)$$

Therefore:

$${}^{C} D^{0.35} f(x) = 6x^{1.65} \dfrac{\Gamma(2)}{\Gamma(2.65)} + 2x^{0.65} \dfrac{\Gamma(1)}{\Gamma(1.65)}$$

Using $\Gamma(1) = 1$, $\Gamma(1.65) \approx 0.9001168$, $\Gamma(2) = 1$, and $\Gamma(2.65) \approx 1.4851927$:

$${}^{C} D^{0.35} f(x) \approx \dfrac{6x^{1.65}}{1.4851927} +  \dfrac{2x^{0.65}}{0.9001168}$$

Upon simplifying to three decimal places:

$${}^{C} D^{0.35} f(x) \approx 4.040x^{1.65} + 2.222x^{0.65}$$

This matches the output of the API and verifies the fractional derivative process. 

</details>

<br/>

## FAQ

<details>
    <summary>&nbsp;<i>What is a fractional derivative?</i></summary>&nbsp;<br/>
    A fractional derivative is a generalization of the traditional integer-order derivative extended 
    to include non-integer values.
</details>

<br/>

<details>
    <summary>&nbsp;<i>Why is this important?</i>&nbsp;<br/></summary>&nbsp;<br/>
    This type of analytical technique is particularly useful for investigating or modeling physical phenomena 
    that exhibit memory effects or hereditary properties in its behavior.
</details>


<br/>

<details>
    <summary>&nbsp;<i>What is meant by "memory effects"?</i></summary>&nbsp;<br/>
    "Memory effects" refers to how a system's <i><b>recent</b></i> past influences its present behavior. <br/> 
    In other words, the system "remembers" its recent history. <br/><br/>
    For example, consider a rubber band that's been stretched and released multiple times. 
    The current "stretchiness" of the rubber band not only depends on how it's being stretched right now, but 
    <i><b>also</b></i> on how it was stretched recently.
</details>

<br/>

<details>
    <summary>&nbsp;<i>What about "hereditary properties"?</i></summary>&nbsp;<br/>
    "Hereditary properties" refers to the characteristics of a system that depend on its <i><b>entire</b></i> history. 
    <br/><br/>
    As an example, consider a material that hardens over time, like concrete. The current "hardness" of concrete is a 
    comprehensive function of its entire history - the starting mix ratio of cement and water, the curing conditions, 
    the amount of cumulative elemental exposure - all of these historical factors represent the hereditary properties 
    of the material.
</details>

<br/>

<details>
    <summary>&nbsp;<i>How does all this relate to the Caputo and Riemann-Liouville derivatives?</i></summary>&nbsp;<br/>
    These two derivatives give us an option to select how much of a system's "memory" we wish to consider in 
    the mathematical analysis of a given phenomena. <br/><br/>
    If only a portion of a system's "memory" is needed, then the Caputo derivative is used. <br/>
    If the entire system's "memory" is needed, then the Riemann-Liouville derivative is used. 
</details>

<br/>

<details>
    <summary>&nbsp;<i>There are multiple coefficients in my input, but the output doesn't show the same amount. Why?</i>
    </summary>&nbsp;<br/>
    There are two reasons why this occurs:&nbsp;<br/><br/>
    <details>
        <summary>&nbsp; Fractional Derivatives of Constants</summary>&nbsp;<br/>
        For an array with multiple coefficients, the right-most coefficient represents a constant term, and the 
        fractional derivative of a constant is always zero for a Caputo fractional derivative. <br/><br/>
        If the fractional derivative of a constant is needed, use the Riemann-Liouville option.
    </details> <br/>
    <details>
        <summary>&nbsp; General Behavior of a Caputo Derivative</summary>&nbsp;<br/>
        For a Caputo derivative, if the exponent value of the term minus the order value is a negative number, then that 
        term's calculation will be omitted from the result. This is due to the way in which the Caputo derivative is 
        designed to handle "well-behaved" finite functions. 
        <br/><br/>
        Consider the following example where $f(x) = x$ and $\alpha = 2$: <br/><br/>
        ${}^{C} D^{2}{\text{&nbsp;}}[x] = \dfrac{\Gamma(2)}{\Gamma(2-2)}x^{1-2} = \dfrac{1}{\Gamma(0)}x^{-1}$
        <br/><br/>
        Since $\Gamma(0)$ is undefined, this result would be omitted from the output expression. 
        <br/>
        This applies to negative values of the gamma function as well.
    </details>
</details>

<br/>

<details>
    <summary>&nbsp;<i>Why are there two derivative endpoints, but only one integration endpoint?</i></summary>&nbsp;<br/>
    This is because the Caputo and Riemann-Liouville techniques treat derivatives of constant values differently.
    <br/>
    <br/>
    This distinction is not present in the API integration process, and both methods lead to the same results.<br/>
</details>


<br/>

## Contributing

Contributions towards this project are welcome! If interested, please follow these steps:

1.) Fork the repository

2.) Create a new branch (`git checkout -b feature-branch`)

3.) Commit your changes (`git commit -m 'Add some feature'`)

4.) Push to the branch (`git push origin feature-branch`)

5.) Open a pull request

Remember to update tests if necessary and provide responses to the questions as outlined in the
pull request template.

<br/>

## Changelog

### Version [1.0.0] - Released 2024-06-TBD

- Initial release with Caputo and Riemann-Liouville fractional derivative and Caputo fractional
  integration capabilities


- Includes comprehensive test coverage

<br/>

## Known Issues

- When polynomial coefficients are very large, or very small, numerical precision errors may
  occur.


- The current implementation does not support multi-threading for large-scale computations.

<br/>

## License

This project is licensed under the MIT License. See the LICENSE file for details.

<br/>

## Acknowledgements

- <a href="https://spring.io/projects/spring-boot">Spring Boot</a>


- <a href="https://maven.apache.org/">Maven</a>


- <a href="https://commons.apache.org/proper/commons-math/">Apache Commons Math</a>


- <a href="https://openai.com/">OpenAI GPT-4o</a>

<br/>

## Support

For any questions or assistance, please feel free to reach out to the project creator via email.  
(trb7074@gmail.com)

<br/>

## Contact Information

**Author:** Tyler Baxter

**Email:** trb7074@gmail.com

**GitHub:** trbaxter
