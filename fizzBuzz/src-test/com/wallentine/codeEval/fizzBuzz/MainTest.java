package com.wallentine.codeEval.fizzBuzz;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MainTest {
	
	@Parameters
	public static Collection<Object[]> getData() {
		Collection<Object[]> data = new ArrayList<Object[]>();
		
		data.add(new Object[] { 1, 3, 5, false, false } );
		data.add(new Object[] { 2, 3, 5, false, false } );
		data.add(new Object[] { 3, 3, 5, true, false } );
		data.add(new Object[] { 4, 3, 5, false, false } );
		data.add(new Object[] { 5, 3, 5, false, true } );
		data.add(new Object[] { 6, 3, 5, true, false } );
		data.add(new Object[] { 14, 3, 5, false, false } );
		data.add(new Object[] { 15, 3, 5, true, true } );
		data.add(new Object[] { 16, 3, 5, false, false } );
		
		data.add(new Object[] { 1, 5, 7, false, false } );
		data.add(new Object[] { 2, 5, 7, false, false } );
		data.add(new Object[] { 3, 5, 7, false, false } );
		data.add(new Object[] { 4, 5, 7, false, false } );
		data.add(new Object[] { 5, 5, 7, true, false } );
		data.add(new Object[] { 6, 5, 7, false, false } );
		data.add(new Object[] { 7, 5, 7, false, true } );
		data.add(new Object[] { 34, 5, 7, false, false } );
		data.add(new Object[] { 35, 5, 7, true, true } );
		data.add(new Object[] { 36, 5, 7, false, false } );
		
		data.add(new Object[] { 1, 2, 7, false, false } );
		data.add(new Object[] { 2, 2, 7, true, false } );
		data.add(new Object[] { 3, 2, 7, false, false } );
		data.add(new Object[] { 4, 2, 7, true, false } );
		data.add(new Object[] { 5, 2, 7, false, false } );
		data.add(new Object[] { 6, 2, 7, true, false } );
		data.add(new Object[] { 7, 2, 7, false, true } );
		data.add(new Object[] { 8, 2, 7, true, false } );
		data.add(new Object[] { 13, 2, 7, false, false } );
		data.add(new Object[] { 14, 2, 7, true, true } );
		data.add(new Object[] { 15, 2, 7, false, false } );

		return data;
	}
	
	private int numToTest;
	private int fizzNum;
	private int buzzNum;
	private boolean isFizz;
	private boolean isBuzz;
	
	public MainTest(final int numToTest, final int fizzNum, final int buzzNum, final boolean isFizz, final boolean isBuzz) {
		this.numToTest = numToTest;
		this.fizzNum = fizzNum;
		this.buzzNum = buzzNum;
		this.isBuzz = isBuzz;
		this.isFizz = isFizz;
	}

	@Test
	public void testIsFizzBuzz() {
		assertEquals("isFizzBuzz is different than expected for fizzNum = " + fizzNum + " buzzNum = " + buzzNum + " and number = " + numToTest,
				isBuzz && isFizz, Main.isFizzBuzz(fizzNum, buzzNum, numToTest));
	}

	@Test
	public void testIsFizz() {
		assertEquals("isFizz is different than expected for fizzNum = " + fizzNum + " and number = " + numToTest,
				isFizz, Main.isFizz(fizzNum, numToTest));
	}

	@Test
	public void testIsBuzz() {
		assertEquals("isBuzz is different than expected for buzzNum = " + buzzNum + " and number = " + numToTest,
				isBuzz, Main.isBuzz(buzzNum, numToTest));
	}
}