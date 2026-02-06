package io.github.coderodde.prob.randomvariables.support;

import io.github.coderodde.prob.randomvariables.DiscreteRandomVariableDistribution;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/**
 * This class implements a geometric distribution.
 */
public class GeometricDistribution extends DiscreteRandomVariableDistribution {

    private final BigDecimal p;
    
    public GeometricDistribution(BigDecimal p) {
        Objects.requireNonNull(p, "The input success probability is null.");
        this.p = checkSuccessProbability(p);
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public BigDecimal getProbabilityMass(BigInteger k) {
        checkLowerBoundK(k);
        
        BigDecimal failureProbability = BigDecimal.ONE.subtract(p);
        
        return failureProbability.pow(k.intValue()).multiply(p);
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
}
