package io.github.coderodde.prob.randomvariables.support;

import io.github.coderodde.prob.randomvariables.DiscreteRandomVariableDistribution;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * This class 
 */
public class BinomialDistribution extends DiscreteRandomVariableDistribution {

    private final BigDecimal p;
    private final BigInteger n;
    
    public BinomialDistribution(BigInteger n, BigDecimal p) {
        this.n = checkNumberOfTrials(n);
        this.p = checkSuccessProbability(p);
    }
    
    @Override
    public BigDecimal getProbabilityMass(BigInteger k) {
        checkLowerBoundK(k);
        checkUpperBound(k, n);
        BigDecimal factor = new BigDecimal(binomial(n, k));
        BigDecimal a = p.pow(k.intValue());
        BigDecimal b = (BigDecimal.ONE.subtract(p)).pow(n.intValue() - k.intValue());
        return factor.multiply(a).multiply(b);
    }

    public BigDecimal getSuccessProbability() {
        return p;
    }

    public BigDecimal getFailureProbability() {
        return BigDecimal.ONE.subtract(p);
    }
    
    public BigInteger n() {
        return n;
    }
    
    protected static BigInteger checkNumberOfTrials(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) < 0) {
            throw new IllegalArgumentException(
                String.format("n(%d) is too small. Must be at least 1.", n));
        }
        
        return n;
    }
}
