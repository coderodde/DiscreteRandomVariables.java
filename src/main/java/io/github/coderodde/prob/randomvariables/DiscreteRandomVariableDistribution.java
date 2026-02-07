package io.github.coderodde.prob.randomvariables;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * This interface defines the API for the discrete random variables.
 */
public abstract class DiscreteRandomVariableDistribution {

    /**
     * Computes the probability density of this discrete random variable via
     * {@link java.math.BigInteger} parameter.
     * 
     * @param k the parameter.
     * @return the probability density.
     */
    public abstract BigDecimal getProbabilityMass(BigInteger k);
    
    
    /**
     * Computes the probability density of this discrete random variable via an
     * {@code int} parameter.
     * 
     * @param k the parameter.
     * @return the probability density.
     */
    public BigDecimal getProbabilityMass(int k) {
        return getProbabilityMass(BigInteger.valueOf(k));
    }

    /**
     * Checks that the input provability is within range {@code (0, 1)}.
     * 
     * @param p the success probability to check.
     * 
     * @return the same as input.
     */
    protected static BigDecimal checkSuccessProbability(BigDecimal p) {
        if (p.compareTo(BigDecimal.ZERO) <= 0) {
            String exceptionMessage = 
                String.format(
                    "The input success probability is too small: %f. Must " + 
                    "be whithin range (0, 1).",
                    p);
            
            throw new IllegalArgumentException(exceptionMessage);
        }
        
        if (p.compareTo(BigDecimal.ONE) >= 0) {
            String exceptionMessage = 
                String.format(
                    "The input success probability is too large: %f. Must " + 
                    "be within range (0, 1).",
                    p);
            
            throw new IllegalArgumentException(exceptionMessage);
        }
        
        return p;
    }
    
    /**
     * Checks that {@code k} is no less than zero.
     * 
     * @param k the value to check.
     * 
     * @return {@code k}. 
     */
    protected static BigInteger checkLowerBoundK(BigInteger k) {
        if (k.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException(
                    String.format(
                            "k is negative: %d. Must be at least 0.",
                            k));
        }
        
        return k;
    }
    
    /**
     * Checks that {@code k} is no larger than {@code max}.
     * 
     * @param k   the value to check.
     * @param n the upper bound for {@code k}.
     * 
     * @return {@code k}.
     */
    protected static BigInteger checkUpperBound(BigInteger k, BigInteger n) {
        if (k.compareTo(n) > 0) {
            throw new IllegalArgumentException(
                    String.format(
                            "k is too large: %d. Must be at most %d.",
                            k,
                            n));
        }
        
        return k;
    }
    
    /**
     * Computes the sub-string factorial 
     * {@code lo * (lo + 1) * ... * (hi - 1) * hi}.
     * 
     * @param lo the lower bound.
     * @param hi the upper bound.
     * 
     * @return the factorial {@ (hi)! / (lo - 1)!}. 
     */
    protected static BigInteger extendedFactorial(BigInteger lo, 
                                                  BigInteger hi) {
        
        BigInteger result = BigInteger.ONE;
        
        for (BigInteger i = lo; 
                i.compareTo(hi) <= 0; 
                i = i.add(BigInteger.ONE)) {
            
            result = result.multiply(i);
        }
        
        return result;
    }
    
    /**
     * Computes the binomial {@code n} over {@code k}.
     * 
     * @param n the upper entry.
     * @param k the lower entry.
     * 
     * @return the binomial {@code n} over {@code k}.
     */
    public static BigInteger binomial(BigInteger n, BigInteger k) {
        if (n.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException(
                    String.format(
                            "n (%s) is below zero. Must be at least zero.",
                            n));
        }
        
        if (k.compareTo(BigInteger.ZERO) < 0 || k.compareTo(n) > 0) {
            return BigInteger.ZERO;
        }
        
        if (n.equals(BigInteger.ZERO) || k.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        
        BigInteger a = k;
        BigInteger b = n.subtract(k);
        
        if (a.compareTo(b) < 0) {
            // Once here, k < n - k, (a < b):
            BigInteger numerator = 
                    extendedFactorial(b.add(BigInteger.ONE), n);
            
            BigInteger denominator = extendedFactorial(BigInteger.ONE, a);
            return numerator.divide(denominator);
        } else {
            // Once here, k >= n - k, (a >= b):
            BigInteger numerator = 
                    extendedFactorial(a.add(BigInteger.ONE), n);
            
            BigInteger denominator = extendedFactorial(BigInteger.ONE, b);
            return numerator.divide(denominator);
        }
    }
}
