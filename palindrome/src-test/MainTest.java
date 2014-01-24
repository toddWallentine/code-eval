import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class MainTest {
	
	private int num;
	private boolean expectedIsPrime;
	private boolean expectedIsPalindrome;
	
	@Parameters
	public static Collection<Object[]> getData() {
		Collection<Object[]> data = new ArrayList<Object[]>();
		
		data.add(new Object[] { 1, true, true } );
		data.add(new Object[] { 2, true, true } );
		data.add(new Object[] { 3, true, true } );
		data.add(new Object[] { 4, false, true } );
		data.add(new Object[] { 5, true, true } );
		data.add(new Object[] { 10, false, false } );
		data.add(new Object[] { 11, true, true } );
		data.add(new Object[] { 22, false, true } );
		data.add(new Object[] { 33, false, true } );
		data.add(new Object[] { 101, true, true } );
		data.add(new Object[] { 202, false, true } );
		data.add(new Object[] { 929, true, true } );
		data.add(new Object[] { 999, false, true } );
		data.add(new Object[] { 1000, false, false } );
		
		return data;
	}
	
	public MainTest(final int num, final boolean isPrime, final boolean isPalindrome) {
		this.num = num;
		this.expectedIsPrime = isPrime;
		this.expectedIsPalindrome = isPalindrome;
	}

	@Test
	public void testIsPrime() {
		assertEquals("When the isPrime method is given this number (" + num + ") it returns an unexpected value.",
				expectedIsPrime, Main.isPrime(num));
	}

	@Test
	public void testIsPalindrome() {
		assertEquals("When the isPalindrome method is given this number (" + num + ") it returns an unexpected value.",
				expectedIsPalindrome, Main.isPalindrome(num));
	}
}