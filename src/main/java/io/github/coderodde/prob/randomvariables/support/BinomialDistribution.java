package io.github.coderodde.prob.randomvariables.support;

import io.github.coderodde.prob.randomvariables.DiscreteRandomVariableDistribution;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/**
 * This class implements a binomial distribution.
 */
public class BinomialDistribution extends DiscreteRandomVariableDistribution {

    private final BigDecimal p;
    private final BigInteger n;
    
    public BinomialDistribution(BigInteger n, BigDecimal p) {
        Objects.requireNonNull(n, "The input number of trials (n) is null.");
        Objects.requireNonNull(p, "The input success probability (p) is null.");
        this.n = checkNumberOfTrials(n);
        this.p = checkSuccessProbability(p);
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public BigDecimal getProbabilityMass(BigInteger k) {
        checkLowerBoundK(k);
        checkUpperBound(k, n);
        BigDecimal factor = new BigDecimal(binomial(n, k));
        BigDecimal a = p.pow(k.intValue());
        BigDecimal b = (BigDecimal.ONE.subtract(p)).pow(n.intValue() - k.intValue());
        return factor.multiply(a).multiply(b);
    }

    /**
     * Returns the probability of a successful trial.
     * 
     * @return the probability of success. 
     */
    public BigDecimal getSuccessProbability() {
        return p;
    }

    /**
     * Returns the probability of a unsuccessful trial.
     * 
     * @return the probability of failure. 
     */
    public BigDecimal getFailureProbability() {
        return BigDecimal.ONE.subtract(p);
    }
    
    /**
     * Returns the number of considered trials.
     * 
     * @return the number of trials. 
     */
    public BigInteger n() {
        return n;
    }
    
    /**
     * Checks the sanity of the number of trials. Must be at least 1.
     * 
     * @param n the number of trials to check.
     * 
     * @return {@code n}. 
     */
    protected static BigInteger checkNumberOfTrials(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) < 0) {
            throw new IllegalArgumentException(
                String.format("n(%d) is too small. Must be at least 1.", n));
        }
        
        return n;
    }
}
