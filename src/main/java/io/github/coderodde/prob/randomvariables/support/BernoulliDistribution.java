package io.github.coderodde.prob.randomvariables.support;

import io.github.coderodde.prob.randomvariables.DiscreteRandomVariableDistribution;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * This class implements a Bernoulli distribution.
 */
public class BernoulliDistribution extends DiscreteRandomVariableDistribution {

    /**
     * The success probability.
     */
    private final BigDecimal p;
    
    /**
     * Constructs this Bernoulli distribution with the success probability of 
     * {@code p}.
     * 
     * @param p the probability of success. 
     */
    public BernoulliDistribution(BigDecimal p) {
        this.p = checkSuccessProbability(p);
    }

    /**
     * Returns the probability of success.
     * 
     * @return the probability of success.
     */
    public BigDecimal getSuccessProbability() {
        return p;
    }

    /**
     * Returns the probability of failure.
     * 
     * @return the probability of failure.
     */
    public BigDecimal getFailureProbability() {
        return BigDecimal.ONE.subtract(p);
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public BigDecimal getProbabilityMass(BigInteger k) {
        checkLowerBoundK(k);
        checkUpperBound(k, BigInteger.ONE);
        
        BigDecimal pSuccess = p.pow(k.intValue());
        BigDecimal pFailure = BigDecimal.ONE.subtract(p).pow(1 - k.intValue());
        
        return pSuccess.multiply(pFailure);
    }
}
