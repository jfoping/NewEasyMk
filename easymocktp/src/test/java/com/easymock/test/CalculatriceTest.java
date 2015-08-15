package com.easymock.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.easymock.Calculatrice;
import com.easymock.myinterface.CalculInterface;

public class CalculatriceTest {
	private Calculatrice calc;
	private CalculInterface calculInterfaceMock;
	
	@Before
	public void setUp() throws Exception{
		calc = new Calculatrice();		
		calculInterfaceMock = EasyMock.createMock(CalculInterface.class);
	}
	 
	@Test
	public void testAddition() {		
		assertEquals("Erreur lors de l'addition ", 10, calc.additionner(4,6));
	}
	
	@Test
	public void testMultiplication(){
		assertEquals("Erreur lors de la multiplication", 15, calc.multiplier(3, 5));
	}
	
	@Test (expected = ArithmeticException.class)
	public void testDivisionParZero1(){
		calc.diviser(2, 0);
	}
	
	@Test
	public void testDivisionParZero2(){
		try{
			calc.diviser(10, 0);
			fail();
		}catch(ArithmeticException e){
			//TODO
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test(timeout = 1)
	public void testSerieOperation() throws InterruptedException{
		calc.additionner(10, 1);
		calc.diviser(12, 4);
		calc.multiplier(2, 3);
		
		calc.additionner(10, 1);
		calc.diviser(12, 4);
		calc.multiplier(2, 3);
		
		calc.additionner(10, 1);
		calc.diviser(12, 4);
		calc.multiplier(2, 3);
		
		calc.additionner(10, 1);
		calc.diviser(12, 4);
		calc.multiplier(2, 3);
		
		calc.additionner(153656, 75856);
		calc.diviser(1653656, 465);
		calc.multiplier(2, 3);
		
		calc.additionner(10, 1);
		calc.diviser(12, 4);
		calc.multiplier(2, 3);
		
		Thread.sleep(1);
	}
	
	@Test
	public void calculerAvecMock(){
	    EasyMock.expect(calculInterfaceMock.calculer(5)).andReturn(25).times(1);
	}
	
}
