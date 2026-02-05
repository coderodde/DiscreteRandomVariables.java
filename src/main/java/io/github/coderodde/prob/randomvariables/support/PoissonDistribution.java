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
    
    public PoissonDistribution(BigDecimal lambda) {
        this.lambda = 
                Objects.requireNonNull(
                        lambda, 
                        "The lambda parameter is null.");
        
        checkLambda(lambda);
    }
    
    @Override
    public BigDecimal getProbabilityMass(BigInteger k) {
        BigDecimal term1 = lambda.pow(k.intValue(), MC);
        BigDecimal term2 = 
                BigDecimal.valueOf(Math.exp(lambda.negate().doubleValue()));
        
        BigInteger factorial = extendedFactorial(BigInteger.ONE, k);
        
        return term1.multiply(term2, MC).divide(new BigDecimal(factorial), MC);    
    }

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
