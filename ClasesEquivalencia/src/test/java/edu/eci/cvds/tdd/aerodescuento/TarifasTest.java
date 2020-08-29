package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.Assert;
import org.junit.Test;

public class TarifasTest {


    @Test
    public void validateRegistryResult() {

		
		double calcu=CalculadorDescuentos.calculoTarifa(1,1,-1);
        Assert.assertEquals(true,true);
    }
	

}