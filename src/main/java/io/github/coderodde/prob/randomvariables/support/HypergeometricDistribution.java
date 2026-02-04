package io.github.coderodde.prob.randomvariables.support;

import io.github.coderodde.prob.randomvariables.DiscreteRandomVariableDistribution;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/**
 * This class implements the hypergeometric distribution.
 */
public class HypergeometricDistribution 
        extends DiscreteRandomVariableDistribution {

    private final BigInteger N;
    private final BigInteger K;
    private final BigInteger n;
    
    public HypergeometricDistribution(BigInteger N,
                                      BigInteger K,
                                      BigInteger n) {
        
        this.N = Objects.requireNonNull(N, "The N parameter is null.");
        this.K = Objects.requireNonNull(K, "The K parameter is null.");
        this.n = Objects.requireNonNull(n, "The k parameter is null.");
        
        checkParameters();
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public BigDecimal getProbabilityMass(BigInteger k) {
        BigInteger numerator1  = binomial(K, k);
        BigInteger numerator2  = binomial(N.subtract(K), n.subtract(k));
        BigInteger denominator = binomial(N, n);
        BigInteger numerator   = numerator1.multiply(numerator2);
        BigInteger result      = numerator.divide(denominator);
        
        return new BigDecimal(result);
    }

    private void checkParameters() {
        if (N.compareTo(BigInteger.ONE) < 0) {
            String exceptionMessage = 
                    String.format("The N parameter is below 1: %s.", N);
            
            throw new IllegalArgumentException(exceptionMessage);
        }
        
        if (K.compareTo(BigInteger.ZERO) < 0) {
            String exceptionMessage = 
                    String.format(
                            "The K parameter is negative: %s. " + 
                            "Must be at least 0.", K);
            
            throw new IllegalArgumentException(exceptionMessage);
        }
        
        if (n.compareTo(BigInteger.ZERO) < 0) {
            String exceptionMessage = 
                    String.format(
                            "The n parameter is negative: %s. " + 
                            "Must be at least 0.", K);
            
            throw new IllegalArgumentException(exceptionMessage);
        }
        
        if (K.compareTo(N) > 0) {
            String exceptionMessage = 
                    String.format("K (%s) is larger than N (%s).",
                                  K,
                                  N);
            
            throw new IllegalArgumentException(exceptionMessage);
        }
        
        if (n.compareTo(N) > 0) {
            String exceptionMessage = 
                    String.format("n (%s) is larger than N (%s).",
                                  n,
                                  N);
            
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
