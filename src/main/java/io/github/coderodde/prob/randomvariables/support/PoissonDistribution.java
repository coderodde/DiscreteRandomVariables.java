package io.github.coderodde.prob.randomvariables.support;

import io.github.coderodde.prob.randomvariables.DiscreteRandomVariableDistribution;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * This class implements the Poisson distribution.
 */
public class PoissonDistribution extends DiscreteRandomVariableDistribution {
    
    private static final MathContext MC 
                   = new MathContext(50, RoundingMode.HALF_UP);
    
    private final BigDecimal lambda;
    
    /**
     * Constructs this Poisson distribution.
     * 
     * @param lambda the distribution parameter.
     */
    public PoissonDistribution(BigDecimal lambda) {
        this.lambda = 
                Objects.requireNonNull(
                        lambda, 
                        "The lambda parameter is null.");
        
        checkLambda(lambda);
    }
    
    /**
     * Constructs this Poisson distribution.
     * 
     * @param lambda the distribution parameter.
     */
    public PoissonDistribution(double lambda) {
        this(BigDecimal.valueOf(lambda));
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public BigDecimal getProbabilityMass(BigInteger k) {
        BigDecimal term1 = lambda.pow(k.intValue(), MC);
        BigDecimal term2 = 
                BigDecimal.valueOf(Math.exp(lambda.negate().doubleValue()));
        
        BigInteger factorial = extendedFactorial(BigInteger.ONE, k);
        
        return term1.multiply(term2, MC).divide(new BigDecimal(factorial), MC);    
    }
    
    /**
     * Returns the {@code lambda} parameter.
     * 
     * @return {@code lambda} parameter.
     */
    public BigDecimal getLambda() {
        return lambda;
    }

    /**
     * Checks the validity of the lambda parameter.
     * 
     * @param lambda the parameter to check. 
     */
    private void checkLambda(BigDecimal lambda) {
        if (lambda.compareTo(BigDecimal.ZERO) <= 0) {
            String exceptionMessage = 
                    String.format(
                            "Lambda parameter is invalid (%s). " + 
                            "Must be positive.", 
                            lambda);
            
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
