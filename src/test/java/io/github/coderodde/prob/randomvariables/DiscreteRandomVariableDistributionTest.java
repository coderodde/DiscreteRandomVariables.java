package io.github.coderodde.prob.randomvariables;

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
}
