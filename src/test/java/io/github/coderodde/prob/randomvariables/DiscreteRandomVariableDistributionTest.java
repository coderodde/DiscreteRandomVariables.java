package io.github.coderodde.prob.randomvariables;

import static io.github.coderodde.prob.randomvariables.DiscreteRandomVariableDistribution.binomial;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;

public class DiscreteRandomVariableDistributionTest {
    
    @Test(expected = IllegalArgumentException.class) 
    public void negativeK() {
        DiscreteRandomVariableDistribution.checkLowerBoundK(BigInteger.valueOf(-1));
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void tooLargeK() {
        DiscreteRandomVariableDistribution.checkUpperBound(BigInteger.valueOf(3), BigInteger.valueOf(2));
    }
    
    @Test
    public void goodK() {
        assertEquals(
                BigInteger.valueOf(2), 
                DiscreteRandomVariableDistribution
                        .checkUpperBound(
                                BigInteger.valueOf(2), 
                                BigInteger.valueOf(2)));;
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void successProbability0() {
        DiscreteRandomVariableDistribution
                .checkSuccessProbability(BigDecimal.ZERO);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void successProbability1() {
        DiscreteRandomVariableDistribution
                .checkSuccessProbability(BigDecimal.ONE);
    }
    
    @Test
    public void binomial_1_on_n_0() {
        assertEquals(BigInteger.ONE, binomial(BigInteger.ZERO, BigInteger.ONE));
    }
    
    @Test
    public void binomial_1_on_k_0() {
        assertEquals(BigInteger.ONE, binomial(BigInteger.ONE, BigInteger.ZERO));
    }
}
