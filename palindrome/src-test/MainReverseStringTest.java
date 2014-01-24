import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class MainReverseStringTest {
	
	private String s;
	private String expectedS;
	
	@Parameters
	public static Collection<Object[]> getData() {
		Collection<Object[]> data = new ArrayList<Object[]>();
		
		data.add(new Object[] { "1", "1" });
		data.add(new Object[] { "11", "11" });
		data.add(new Object[] { "111", "111" });
		data.add(new Object[] { "12", "21" });
		data.add(new Object[] { "123", "321" });
		data.add(new Object[] { "1234", "4321" });
		data.add(new Object[] { "1001", "1001" });
		data.add(new Object[] { "010", "010" });
		
		return data;
	}
	
	public MainReverseStringTest(final String s, final String expectedS) {
		this.s = s;
		this.expectedS = expectedS;
	}

	@Test
	public void testReverseString12() {
		assertEquals("The reversed String was diff than expected.", expectedS, Main.reverseString(s));
	}
}